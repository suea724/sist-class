
/*

    [동의어, Synonym]
    - Alias와 같이 데이터베이스 객체의 이름을 줄여주는 역할
    - 다른 계정의 객체(테이블, 시퀀스 등)를 참조할 때 많이 사용한다.    
    - 다른 계정의 객체에 접근할 때 계정명.객체명으로 참조하는데, 이때 이를 감춰 DB의 보안성을 유지한다.

*/


-- system 계정 > 다른 계정의 자원에 접근할 권한이 있는 계정
select * from tblInsa; -- 오류

-- 다른 계정의 자원 접근 시 계정명.자원명으로 접근
select * from hr.tblInsa; 
select hr.fnSum(10, 20) from dual;

-- 계정 만들기 > scott
create user scott identified by java1234;
grant connect, resource to scott;

-- scott > 다른 계정의 자원 접근 불가
select * from hr.tblInsa;

-- system > scott에게 hr.tblInsa를 접근할 수 있는 권한 부여
grant select, update, delete, insert on hr.tblInsa to scott;

-- scott > hr.tblInsa 접근 가능
select * from hr.tblInsa;

update hr.tblInsa set basicpay = 3000000 where num = '1001'; -- PK > 인덱스 (조건절에 PK를 사용하는 것이 좋음)

-- system > scott으로부터 권한 회수
revoke update, delete, insert on hr.tblInsa from scott;

-- 영구적으로 hr의 tblInsa를 scott 계정에서 접근해야 하는 경우

-- 시노님
-- create synonym 시노님 for 계정명.객체명;
create synonym insa for hr.tblInsa;

select * from hr.tblInsa;
select * from insa; -- 소유주 명시 X



