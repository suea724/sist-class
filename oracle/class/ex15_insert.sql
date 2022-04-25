

/*
    
    INSERT INTO 테이블명(컬럼리스트) VALUES(값리스트);
    
    [INSERT]
    - DML
    - 테이블에 데이터를 추가하는 명령어(행 추가)
    
    
    
*/

drop table tblMemo;


create table tblMemo(
    
    seq number(3) primary key,      
    name varchar2(30) default '익명',  
    memo varchar2(1000), 
    regdate date default sysdate not null        
    
);

drop sequence seqMemo;
create sequence seqMemo;

-- 1. 표준 : 원본 테이블에 정의된 컬럼 순서대로 컬럼 리스트와 값 리스트를 구성하는 방법
insert into tblMemo(seq, name, memo, regdate) values(seqMemo.nextVal, '홍길동', '메모', sysdate);


-- 2. 컬럼 리스트의 순서와 값 리스트의 순서와 개수가 일치해야 한다. *****
--      원본 테이블 컬럼 순서와는 상관없지만 맞추는 것이 관리에 용이하다.
insert into tblMemo(name, memo, regdate, seq) values('홍길동', '메모', sysdate, seqMemo.nextVal);

-- ORA-00947: not enough values
insert into tblMemo(seq, name, memo, regdate) values('홍길동', '메모', sysdate);

-- ORA-00913: too many values
insert into tblMemo(name, memo, regdate) values(seqMemo.nextVal, '홍길동', '메모', sysdate);


-- 3. null 컬럼 조작
--      a. null 상수 사용 > 사용자 명시적 의지 표현 > default 동작 안함
insert into tblMemo(seq, name, memo, regdate) values(seqMemo.nextVal, '홍길동', null, sysdate);

--      b. 컬럼 생략
insert into tblMemo(seq, name) values(seqMemo.nextVal, '홍길동');

select * from tblMemo;


-- 4. default 컬럼 조작
--      a. 컬럼 생략
insert into tblMemo(seq, memo, regdate) values(seqMemo.nextVal, '메모', sysdate);
insert into tblMemo(seq, memo) values(seqMemo.nextVal, '메모');

--      b. default 상수 사용
insert into tblMemo(seq, name, memo, regdate) values(seqMemo.nextVal, default, '메모', sysdate);

-- 5. 단축
-- 컬럼리스트를 생략할 수 있다. > 원본 테이블의 컬럼 리스트와 순서와 개수가 동일한 경우
insert into tblMemo values(seqMemo.nextVal, '홍길동', '메모', sysdate);

-- null, default 조작
insert into tblMemo values(seqMemo.nextVal, '메모', sysdate); -- X
insert into tblMemo values(seqMemo.nextVal, null, '메모', sysdate); -- O

-- 6. 테이블 복사

create table tblMemoCopy (
    
    seq number(3) primary key,      
    name varchar2(30) default '익명',  
    memo varchar2(1000), 
    regdate date default sysdate not null        
    
);

 -- subquery 사용
insert into tblMemoCopy select * from tblMemo;
select * from tblMemoCopy;

-- 테이블 생성 + 데이터 복사 > NOT NULL을 제외한 제약 사항은 복사하지 않는다.
-- 개발자들이 더미 데이터를 만드는 용도로 사용한다.
create table tblMemoCopy2 as select * from tblMemo;

desc tblMemoCopy2;

insert into tblMemoCopy2(seq, name, memo, regdate) values(12, default, '메모', sysdate);

select * from tblMemoCopy2;