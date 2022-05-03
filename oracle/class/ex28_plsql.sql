
/*

    [PL/SQL]
    - Oracle's Procedural Language Extension to SQL
    - 기존의 ANSI-SQL에 절차 지향 언어의 기능(제어)을 추가한 SQL
    
    [ANSI-SQL]
    - 비절차지향 언어. 순서가 없고 연속적이지 않다.
    - 문장 단위 구조
    
    [프로시저, Procedure]
    - 메서드, 함수 등..
    - 순서가 있는 명령어들의 집합
    - PL/SQL 명령어는 반드시 프로시저 내에서만 작성 및 동작이 가능하다.
    
    1. 익명 프로시저
        - 1회용 코드 작성용
        
    2. 실명 프로시저
        - 재사용 가능
        - 저장 가능
        - 데이터베이스에 이름을 가진 객체로 저장된다.
        
    [PL/SQL 프로시저 블럭 구조]
    - 4개의 키워드(블럭)으로 구성
        a. DECLARE
        b. BEGIN
        c. EXCEPTIOM
        d. END
    
    1. DECLARE
        - 선언부
        - 프로시저에서 사용할 변수, 객체 등을 선언하는 영역
        - 생략 가능
        
    2. BEGIN
        - 실행부, 구현부
        - BEGIN ~ END
        - 구현된 코드를 보관하는 영역(메서드의 body와 동일)
        - 생략 불가능
        - 핵심
        - PL/SQL + ANSI-SQL 작성
    
    3. EXCEPTIOM
        - 예외처리부
        - catch역할
        - 예외 처리 코드 작성
        - 생략 가능
    
    4. END
        - BEGIN 블럭의 종료 역할
        - 생략 불가능
    
        
    [PL/SQL 자료형]
    - ANSI-SQL과 거의 동일함
    
    [변수 선언]
    - 변수명 자료형 [not null] [default 값];
    - 주로 질의(select)의 결과갓을 저장하는 용도
    - 일반 변수로서의 역할도 동일하게 함
    
    [PL/SQL 연산자]
    - ANSI-SQL과 동일함
    
    [대입 연산자]
    - ANSI-SQL
        e.g. update table set column = '값';
    - PL/SQL
        e.g. 변수 := '값;
        
*/

-- dbms_output.put_line 결과 > default 안보이게 설정

-- 옵션 변경 > 접속할 떄마다 바꿔줘야 함
set serverout on;

declare 
    num number;
    name varchar2(20);
    today date;
begin
    num := 10;
    dbms_output.put_line(num);
    
    name := '홍길동';
    dbms_output.put_line(name);
    
    today := sysdate;
    dbms_output.put_line(today);
end;



declare
    num1 number;
    num2 number;
    num3 number := 30; -- 초기화 가능
    num4 number default 40;
    num5 number not null := 50; -- not null일 때 선언과 동시에 초기화 필요
    num6 number not null default 0; -- 값을 
begin
    num1 := 10;
    dbms_output.put_line(num1);
    dbms_output.put_line(num2); -- 초기화하지 않은 변수 > null
    dbms_output.put_line(num3);
    
    -- 구현부에서 변수 선언 불가
    -- num4 number; 
    
    dbms_output.put_line(num4);
    
    -- PLS-00218: a variable declared NOT NULL must have an initialization assignment
    -- num5 := 50;
    dbms_output.put_line(num5);
    
    num6 := 60;
    dbms_output.put_line(num6);
    
end;

-- select into 절
-- 변수 > select 결과를 담음

declare
    vname varchar2(15);
    vbuseo varchar2(15);
begin
    -- vname := (select name from tblInsa where num = 1001);
    select name into vname from tblInsa where num = 1001;
    select buseo into vbuseo from tblInsa where num = 1001;
    
    dbms_output.put_line(vname);
    dbms_output.put_line(vbuseo);
end;


-- PLS-00428: an INTO clause is expected in this SELECT statement
-- PLS-00201: identifier 'BUSEO' must be declared
begin
    -- PL/SQL 블럭 안에서는 절대로 일반 SQL을 작성할 수 없다.
    -- 반드시 select into 절을 사용해야 한다!
    -- ANSI-SQL의 결과값을 바로 사용하지 못하고 PL/SQL으로 옮겨서 사용이 가능하다.
    select buseo from tblInsa where num = 1001;
    dbms_output.put_line(buseo); -- 가져온 컬럼값을 변수에 넣지 않고 바로 조작(출력)
end;    


create table tblName(
    name varchar2(15)
);


-- select > tblName 추가
-- 1. ANSI-SQL
-- 2. PL/SQL

declare
    vname varchar2(15);
begin
    select name into vname from tblInsa where buseo = '개발부' and jikwi = '부장';
    insert into tblName(name) values(vname);
end;

select * from tblName;

insert into tblName(name) values((select name  from tblInsa where buseo = '개발부' and jikwi = '부장'));


-- select into > 1개의 값을 select > 1개의 PL/SQL 변수에 대입

declare
    vname varchar2(15);
    vbuseo varchar2(15);
    vjikwi varchar2(15);
begin
    
    -- into 주의
    -- 1. 컬럼의 개수와 변수의 개수가 일치해야 함
    -- 2. 컬럼의 순서와 변수의 순서가 일치해야 함
    -- 3. 컬럼과 변수의 자료형이 일치해야 함
    select name, buseo, jikwi into vname, vbuseo, vjikwi from tblInsa where num = 1001;
    
    dbms_output.put_line(vname);
    dbms_output.put_line(vbuseo);
    dbms_output.put_line(vjikwi);
end;


/*

    타입 참조
    - 변수를 선언할 때 사용
    
    1. %type
        - 컬럼 1개 참조
        - 사용하는 테이블의 특정 컬럼의 스키마를 알아내어 변수에 적용한다.
        - 복사되는 정보
            a. 자료형
            b. 길이
     
            
    프로시저에서 select값을 저장하기 위한 변수를 만드는 경우 자료형
    1. vbuseo varchar2(15)
        - 정적으로 설정
    2. vbuseo tblInsa.buseo%type
        - 동적으로 참조 > 원본 테이블의 컬럼 변경 시 반영됨
        
    2. %rowtype
        - 행 전체 참조( 모든 컬럼 참조)

*/


desc tblInsa;


declare
    -- vbuseo varchar2(15);
    vbuseo tblInsa.buseo%type; -- tblInsa 테이블의 buseo 컬럼을 확인해서 동일한 타입과 동일한 길이를 변수에 적용
begin
    select buseo into vbuseo from tblInsa where num = 1001;
    dbms_output.put_line(vbuseo);
end;


declare
    vname tblInsa.name%type;
    vbuseo tblInsa.buseo%type;
    vcity tblInsa.city%type;
    vbasicpay tblInsa.basicpay%type;
begin
    select
        name, buseo, city, basicpay
        into 
        vname, vbuseo, vcity, vbasicpay
    from tblInsa where num = 1001;

    dbms_output.put_line(vname);
    dbms_output.put_line(vbuseo);
    dbms_output.put_line(vcity);
    dbms_output.put_line(vbasicpay);
end;



-- 직원 중 일부에게 보너스 지급 > 내역 저장
-- 보너스 =  basicpay * 1.5
create table tblBonus (
    seq number primary key,
    num number(5) not null references tblInsa(num), -- 직원번호(FK)
    bonus number not null
);

select * from tblInsa where city = '서울' and jikwi = '부장' and buseo = '영업부';


-- 서브 쿼리를 사용하여 insert
insert into tblBonus(seq, num, bonus)
    values (1,
            (select num from tblInsa where city = '서울' and jikwi = '부장' and buseo = '영업부'),
            (select basicpay * 1.5 from tblInsa where city = '서울' and jikwi = '부장' and buseo = '영업부'));
            
            
-- 프로시저 사용하여 insert
declare
    vnum tblInsa.num%type;
    vbasicpay tblInsa.basicpay%type;
begin
    select num, basicpay into vnum, vbasicpay 
    from tblInsa 
    where city = '서울' and jikwi = '부장' and buseo = '영업부';
    
    insert into tblBonus values(1, vnum, vbasicpay * 1.5);
end;

select * from tblBonus;



-- 홍길동의 정보 가져와서 출력 > %rowtype 사용

declare
    vrow tblInsa%rowtype;
begin
--    select
--        -- num, name, buseo, jikwi, ssn, city, basicpay, sudang, ibsadate, tel -- 순서 중요
--        num, name, ssn, ibsadate, city, tel, buseo, jikwi, basicpay, sudang
--        into
--        vrow
--    from tblInsa where num = 1001;

    select * into vrow from tblInsa where num = 1001; -- 와일드 카드 사용
    
    -- dbms_output.put_line(vrow); > 에러
    dbms_output.put_line(vrow.num);
    dbms_output.put_line(vrow.name);
    dbms_output.put_line(vrow.ssn);
    dbms_output.put_line(vrow.buseo);
    dbms_output.put_line(vrow.basicpay);
    
end;


select * from tblMan;
select * from tblWoman;

-- '하하하'씨 성전환 > tblWoman 이동
-- 1. tblMan > select > 정보
-- 2. tblWoman > insert
-- 3. tblMan > delete

declare
    vrow tblMan%rowtype;
begin
    -- 1.
    select * into vrow from tblMan where name = '하하하';
    
    -- 2.
    insert into tblWoman values (vrow.name, vrow.age, vrow.height, vrow.weight, vrow.couple);
    
    -- 3.
    delete from tblMan where name = '하하하';
end;


-- 제어문
-- 1. 조건문
-- 2. 반복문

-- if-else문
declare
    vnum number := -10;
begin
    if vnum > 0 then
        dbms_output.put_line('양수');
    else
        dbms_output.put_line('양수 아님');
    end if;
end;


-- if-elsif-else문
declare
    vnum number := 0;
begin
    if vnum > 0 then
        dbms_output.put_line('양수');
    elsif vnum < 0 then
        dbms_output.put_line('음수');
    else
        dbms_output.put_line('0');
    end if;
end;


-- 직원 1명 선택 > 보너스 지급 > 간부(basicpay * 1.5), 사원(basicpay * 2)
declare
    vnum tblInsa.num%type;
    vbasicpay tblInsa.basicpay%type;
    vjikwi tblInsa.jikwi%type;
    
    vbonus number; -- 계산값을 저장할 변수
begin
    
    -- 1.
    select num, basicpay, jikwi into vnum, vbasicpay, vjikwi from tblInsa where name = '이순신';
    
    -- 2.
    if vjikwi in ('부장', '과장') then
        vbonus := vbasicpay * 1.5;
    elsif vjikwi in ('대리', '사원') then
        vbonus := vbasicpay * 2;
    end if;
    
    -- 3.
    insert into tblBonus values (3,vnum, vbonus);
    
    dbms_output.put_line('완료');
end;


select
    b.*,
    (select name from tblInsa where num = b.num) as name,
    (select jikwi from tblInsa where num = b.num) as jikwi,
    (select basicpay from tblInsa where num = b.num) as basicpay
from tblBonus b;


/*

    [case문]
    - ANSI-SQL의 case와 유사
    - 자바 switch문 or 다중 if문과 유사

*/

declare
    vcontinent tblCountry.continent%type;
    vresult varchar2(30);
begin
    select continent into vcontinent from tblCountry where name = '대한민국';
    
    -- if-elsif-else문
    if vcontinent = 'AS' then
        vresult := '아시아';
    elsif vcontinent = 'EU' then
        vresult := '유럽';
    elsif vcontinent = 'AF' then
        vresult := '아프리카';    
    else
        vresult := '기타';
    end if;
    
    dbms_output.put_line(vresult);
    
    -- case문 (다중 if문과 비슷)
    case
        when vcontinent = 'AS' then vresult := '아시아';
        when vcontinent = 'EU' then vresult := '유럽';
        when vcontinent = 'AF' then vresult := '아프리카';
        else vresult := '기타';
    end case;
    
    dbms_output.put_line(vresult);
    
    
    -- case문 (자바의 switch문과 비슷) 
    case vcontinent
        when 'AS' then vresult := '아시아';
        when 'EU' then vresult := '유럽';
        when 'AF' then vresult := '아프리카';
        else vresult := '기타';
    end case;
    
    dbms_output.put_line(vresult);
    
end;

-- '신숙주'가 대여한 비디오 제목 > '뽀뽀할까요'
select * from tblMember;
select * from tblRent;
select * from tblVideo;

-- 1. 조인
select
    v.name
from tblMember m
    inner join tblRent r
        on m.seq = r.member
            inner join tblVideo v
                on r.video = v.seq
                    where m.name = '신숙주';
             
                    
-- 2. 서브쿼리
select name from tblVideo 
    where seq = (select video from tblRent
                    where member = (select seq from tblMember where name = '신숙주'));


-- 3. 프로시저
declare
    mseq tblMember.seq%type;
    vseq tblRent.seq%type;
    vname tblVideo.name%type;
    
begin
    
    select seq into mseq from tblMember where name = '신숙주';
    
    select video into vseq from tblRent where member = mseq;
    
    select name into vname from tblVideo where seq = vseq;
    
    dbms_output.put_line(vname);
end;
