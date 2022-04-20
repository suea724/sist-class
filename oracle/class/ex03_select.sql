/*
[SQL, Query(질의)]

- SELECT 문
    - DML, DQL
    - 관계대수 연산 중 셀렉션 작업을 구
    현한 명령어
    - 대상 테이블로부터 원하는 행(튜플)을 추출하는 작업
    
    [WITH <Sub Query>]
    SELECT column_list
    [WHERE search_condition]
    [GROUP BY group_by_expression]
    [HAVING search_condition]
    [ORDER BY order_expresiion [ASC|DESC]]
*/

-- 명령어
-- 1. SQL 명령어 > 기억O
-- 2. SQL Plus 명령어 > 기억X

desc tblCountry; -- 해당 테이블의 스키마 출력 > 컬럼 구조 > SQL Developer에서만 사용 가능

-- 단일 컬럼
select name from tblCountry;
select capital from tblCountry;
select population from tblCountry;

-- 여러 개 > 프로젝션
select name, captial from tblCountry;
select name, capital, population, continent, area from tblCountry;
select * from tblCountry; -- 와일드 카드(*) > 모든 컬럼

-- 프로젝트에서는 가독성을 위해 와일드 카드를 사용하지 않는 것이 좋다. > 스키마를 파악하기 어려움

select name,  length(name) from tblCountry;

-- 컬럼 리스트 지정 순서는 원본 테이블의 컬럼 순서와 무관함
select name, capital from tblCountry;
select capital, name from tblCountry;

-- 여러가지 시스템 정보 확인
-- > 시스템 테이블
-- 1. 사용자 정보
select * from dba_users; -- ORA-00942: table or view does not exist > system 계정으로 로그인 해야 확인 가능

-- 2. 특정 사용자가 소유한 테이블 정보
select * from tabs; -- 현재 접속한 계정이 소유하는 테이블 목록
select * from dba_tables where owner = 'HR'; -- system 계정에서 정보 확인

-- 3. 특정 테이블의 컬럼 정보 > 스키마
select * from dba_tab_columns;


