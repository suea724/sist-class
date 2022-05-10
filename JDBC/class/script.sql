
-- 주소록 테이블
create table tblAddress (
    seq number primary key,                                         -- PK
    name varchar2(10) not null,                                     -- 이름
    age number(3) not null check (age between 0 and 150),           -- 나이
    gender char(1) not null check(gender in('m','f')),              -- 성별(m, f)
    tel varchar2(15) not null,                                     -- 전화번호
    address varchar2(300) not null,                                 -- 주소
    regdate date default sysdate not null
);

create sequence seqAddress;

insert into tblAddress 
    values (seqAddress.nextVal, '홍길동', 20, 'm', '010-1234-5678', '서울시 강남구 역삼동 한독빌딩', default);

-- 커밋 필수!
-- 커밋을 해야 다른 세션에서 데이터 접근 가능 (이클립스 반영)
commit;

select * from tblAddress order by seq;

create sequence seqBonus;

select * from tblInsa;
select * from tblBonus;

select * from tblBonus b inner join tblInsa i on b.num = i.num;

-- Ex06_CallableStatement

-- m1. 인자값(X), 반환값(X) 
create or replace procedure procM1
is
begin
    insert into tblAddress 
        values (seqAddress.nextVal, '홍길동', 20, 'm', '010-1234-5678', '서울시 강남구 역삼동 한독빌딩', default);
end;


-- m2. 인자값(O), 반환값(X)
create or replace procedure procM2(
    pname tblAddress.name%type,
    page tblAddress.age%type,
    pgender tblAddress.gender%type,
    ptel tblAddress.tel%type,
    paddress tblAddress.address%type
)
is
begin
    insert into tblAddress 
    values (seqAddress.nextVal, pname, page, pgender, ptel, paddress, default);
end;

-- 검증 필수!
begin
    procM2('이름', 20, 'm', '010-1111-1111', '주소');
end;


-- m3. 인자값(X), 반환값(O)
create or replace procedure procM3 (
    pcount out number
)
is
begin
    select count(*) into pcount from tblAddress;
end;

set serverout on;

declare
    vcount number;
begin
    procM3(vcount);
    dbms_output.put_line(vcount);
end;


-- 문제
create or replace procedure procM4 (
    pnum in number,
    pname out varchar,
    pbuseo out varchar,
    pjikwi out varchar,
    pcity out varchar
)
is
begin
    select 
        name, buseo, jikwi, city into pname, pbuseo, pjikwi, pcity
    from tblInsa
    where num = pnum;
end;


-- m5.
create or replace procedure procM5 (
    pbuseo in varchar2,
    pcursor out sys_refcursor
)
is
begin
    open pcursor for
    select name, jikwi, basicpay from tblInsa where buseo = pbuseo;
end procM5;


declare
    pcursor sys_refcursor;
    vname tblInsa.name%type;
    vjikwi tblInsa.jikwi%type;
    vbasicpay tblInsa.basicpay%type;
begin
    procM5('개발부', pcursor);
    
    loop
        fetch pcursor into vname, vjikwi, vbasicpay;
        exit when pcursor%notfound;
        
        dbms_output.put_line(vname || ',' || vjikwi || ',' || vbasicpay);
        
    end loop;
    
end;


-- m6
create or replace procedure procM6(
    pbuseo in varchar2,
    pcursor out sys_refcursor
)
is
begin
    -- 1. 부서명으로 직원번호 알아내기    
    -- 2. 직원번호로 보너스 지급 내역 확인
    
    open pcursor for 
        select i.name, b.bonus from tblInsa i
            left outer join tblBonus b
                on i.num = b.num
                    where buseo = pbuseo;
end procM6;


declare
    vname varchar(30);
    vbonus number;
    vcursor sys_refcursor;
begin
    procM6('기획부', vcursor);
    
    loop
        fetch vcursor into vname, vbonus;
        exit when vcursor%notfound;
        
        dbms_output.put_line(vname || ' > ' || vbonus);
    end loop;
end;

    