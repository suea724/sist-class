/*

ANSI-SQL 자료형 (= 오라클 자료형)
1. 숫자형
    - 정수, 실수
    a. number
        - (유효자리) 38자리 이하의 숫자를 표현하는 자료형
        - 5 ~ 22byte (가변)
        - number
        - number(precision)
        - number(precision, scale)

2. 문자형
    - 문자, 문자열

3. 날짜/시간형

4. 이진 데이터형

*/

-- 오라클은 사용자가 정의한 모든 식별자를 DB에 저장할 때 항상 대문자로 변환해서 저장한다. (**********)
select * from tabs where table_name = 'tblType'; -- X
select * from tabs where table_name = 'TBLTYPE'; -- O

-- 테이블 선언 (생성)
create table tblType (
    num number
);

-- 테이블 삭제
drop table tblType;

-- 확인
select * from tabs; -- 현재 계정이 소유하고 있는 테이블 정보

-- 데이터 추가하기
insert into tblType (num) values (100); -- 정수형 리터럴
insert into tblType (num) values (3.14); -- 실수형 리터럴

-- 데이터 가져오기
select * from tblType;