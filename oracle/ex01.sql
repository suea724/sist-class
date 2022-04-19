-- .sql > 스크립트 파일, 워크 시트

-- 단일라인 주석

/*
1. 오라클(데이터베이스)
- UI x 화면 x
- 서비스 프로그램
- 데이터베이스 서비스 제공

2. SQL Developer(클라이언트툴)
- 인코딩 > UTF-8로 설정
- SQL Developer -> (접속) -> Oracle

접속 > Name : localhost.system
      사용자 이름 : system
      비밀번호 : java1234
      호스트이름 : "localhost" (= 내 컴퓨터) > 오라클이 설치된 컴퓨터(IP, 도메인) : cmd > ipconfig
      포트 : "1521" 네트워크 프로그램이 운영체제 내/외부를 통과하는 통신 회로(경로, 통로) > 65535개 > 프로그램 독점
      SID : "xe" 한 컴퓨터에 오라클 여러개 설치 가능 > 설치된 오라클 구분 ID

 사용 계정
 - sys.system > 최고 관리자 계정
 - 일반 사용자 계정
    a. 직접 생성
    b. 공부(수업) > 오라클이 제공하는 사용자 계정(scott, hr)
 - 수업(hr) > 프로젝트(직접 생성)
 
 아이디: hr
 암호: hr
 
 HR 계정 사용
 1. 계정 풀기 (unlock)
 2. 암호 바꾸기

*/

alter user hr account unlock; -- 계정 풀기
alter user hr identified by java1234; -- 암호 바꾸기

-- 독립적인 문장 > 실행 ctrl + enter
select * from tabs;
select sysdate from dual;

-- HR이 소유한 테이블 목록
select * from tabs;
 
select * from employees; -- 직원 정보
select * from jobs; -- 직원들의 직업 정보
select * from departments; -- 직원들의 부서 정보
select * from locations; -- 부서가 위치한 지역 정보
select * from countries; -- 지역이 속한 국가 정보
select * from regions; -- 국가가 속한 대륙 정보
select * from job_history; -- 직원들의 이직 이력
 
 /*
 Oracle
 1. 회사명
 2. 제품명
 
[SQL, Structured Query Language : 구조화된 질의 언어]
 - 오라클 데이터베이스 <-> 클라이언트 툴 <-> 사람
 - DBMS 조작하기 위한 언어
 
오라클 > DBMS
 - 데이터베이스(Database) : 데이터 집합 (= 저장소)
 - 데이터베이스 관리 시스템(DBMS)
 
 오라클 + SQL 누가 공부?
 1. DB 관리자, DBA 
 2. DB 개발자
 3, 응용 프로그램 개발자, 자바 개발자
    - 전부 사용 or 일부만 사용

[클라이언트 프로그램] > 다양함
 1. SQL Developer > 따로 설치
 2. SQL Plus > 오라클과 함께 설치 > 콘솔에서 사용
 3. DataGrip
 4. DBeaver
 5. Orange
 6. SQLGate
 7. Toad

[오라클 서비스]
 - 화면 출력X
 - 오라클 상태 확인 > Window + R > "services.msc"
 - OracleXXX
 - OracleServiceXE > 오라클 데이터 서버
 - OracleXETNSListener > 오라클이 클라이언트 툴에 접속을 받아들이는 기능
 
[관계형 데이터베이스, Relational DB > RDBMS]
 - 데이터를 표 형식으로 저장/관리한다.
 - SQL을 사용해서 조작한다.

[SQL]
1. DBMS 제작사와 독립적이다.
 - 모든 관계형 데이터베이스에 공통적으로 적용하기 위해 만들어진 언어
 - DBMs 제작사에서 SQL이라는 언어를 자신의 제품에 적용

2. 표준 SQL, ANSI-SQL
 - 모든 DBMS에 적용 가능한 SQL
 - 버전업 중
 - SQL-86 > SQL89, SQL92, SQL99, ..

3. 대화식 언어
 - 비절차지향
 - 질문 > 답변 > 질문 > 답변 * N

4. 종류
 a. 표준 SQL (ANSI)
   - 모든 DBMS에서 공통적인 문법 사용

 b. 각 DBMS 제작사별 SQL > 확장 SQL
   - DBMS 별로 문법 서로 다름
   - 오라클 > PL/SQL
 
오라클(100) = ANSI-SQL(5~60) + PL/SQL(20~30) + 설계,기타(10)

[ANSI-SQL 종류]
 1. DDL, Data Definition Language
    - 데이터 정의어
    - 테이블, 뷰, 사용자, 인덱스 등의 데이터베이스 오브젝트를 생성/수정/삭제하는 명령어
    - 구조를 생성/관리하는 명령어
    a. CREATE : 생성
    b. DROP : 삭제
    c. ALTER : 수정
    => 데이터베이스 관리자, 담당자, 프로그래머(일부)가 사용
    
 2. DML, Data Manipulation Language
    - 데이터 조작어
    - 데이터베이스의 데이터를 추가/수정/삭제/조회하는 명령어
    - 사용 빈도가 가장 높음
    a. SELECT > 조회 (R) (**********************************) > 가장 많이 사용!!
    b. INSERT > 추가 (C)
    c. UPDATE > 수정 (U)
    d. DELETE > 삭제 (D)
    => 데이터베이스 관리자, 담당자, 프로그래머 (***********)
    
 3. DCL, Data Control Language  
    - 데이터 제어어
    - 계정 권한 관리, 보안 통제, 트랜잭션 처리 등
    a. COMMIT
    b. ROLLBACK
    c. GRANT
    d. REVOKE
    => 데이터베이스 관리자, 담당자, 프로그래머(일부)
    
 4. DQL, Data Query Language
    - DML 중 SELECT

 5. TCL, Transaction Control Language
    - DCL 중 COMMIT, ROLLBACK
    
[오라클 인코딩]
 - 설정 > 변경 가능
 - 1.0 ~ 8i : EUC-KR
 - 9i, 10g, 11g, 12c, 18c, 19c, 20c... ~ 현재 : UTF-8
 
 Express Edition
 - 무료 버전
 - 11g
 - 18c
 */
 
 -- 파란색 : 키워드 > SQL의 키워드(명령어)는 대소문자를 구분하지 않음
 -- tabs : 객체(식별자) > SQL의 식별자는 대소문자를 구분하지 않음
 select * from tabs;
 SELECT * FROM tabs;
 
 select * from tabs where table_name = 'JOBS'; -- 데이터의 대소문자는 구분함 (****)
 select * from tabs where table_name = 'jobs';
 
 -- 자주 사용하는 스타일
 -- 1. 키워드 >대문자
 -- 2. 식별자 > 소문자
 SELECT * FROM tabs;
 
 -- 우리가 사용할 스타일
 -- 1. 키워드 > 소문자
 -- 2. 식별자 > 캐멀 표기법
 select * from tabs;
 
 -- DB Object 생성시 식별자 주의점 > 식별자 길이는 30 byte가 넘으면 안됨 (영어 30글자)
 create table aaa (
    num number
 );
 
 /*
[관계형 데이터베이스 모델]
 - 릴레이션(Relation)  == 테이블(Table)
 
[테이블]
 - 테이블의 구조 > Scheme > 컬럼의 집합
 
[컬럼]
 - 속성(Attribute)
 
[행]
 - 튜플(Tuble)
 - 행(Row), 레코드(Record)
 - 인스턴스(Instance)
 
학생 릴레이션
 - 학생 (번호, 이름, 나이, 성별) > 릴레이션 스키마 표기
    - 번호 : 1 이상의 정수
    - 이름 : 2~5자 이내의 한글
    - 나이 : 14~16세 이내의 정수
    - 성별 : M/F 1문자 택일
    
 - 차수 : 4 > 속성의 개수
 - 카디날리티 > 행의 개수
 - 릴레이션 간에는 연산이 가능하다.
 
 */
 
 
 