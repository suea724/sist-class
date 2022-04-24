# 📌 Oracle
- 데이터베이스 관리 시스템의 일종(DBMS)
- 데이터베이스 서비스 제공

### ✅ 클라이언트 툴
- SQL Developer > 수업에서 사용
- SQL PLUS > Oracle 설치 시 제공되는 CLI 툴
- DataGrip
- DBeaver
- Orange
- SQLGate
- Toad

<br>

### ✅ 사용 계정
- sys.system : 최고 관리자 계정
- 일반 사용자 계정
    - 직접 생성
    - 오라클이 제공하는 사용자 계정 사용(scott, hr)
```sql
-- HR 계정 사용
alter user hr account unlock; -- 계정 풀기
alter user hr identified by java1234; -- 암호 바꾸기
```

<br>

# 📌 SQL, Structured Query Language
- 구조화된 질의 언어
- **모든 관계형 데이터베이스에서 공통적으로 적용**하기 위해 만들어진 언어이다.
- **DB에서 데이터를 추출**한다.
- DBMS에 직접 입력해서 사용하거나, 자바 또는 C로 작성된 응용프로그램에 삽입하여 사용하는 등, 다양한 방식으로 사용할 수 있다.


### ✅ 종류
- **표준 SQL, ANSI-SQL** : 모든 DBMS에 적용 가능한 SQL
- **각 DBMS 제작사별 SQL** : DBMS별로 다른 문법을 제공하는 확장 SQL
    - 오라클 > PL/SQL

<br>

# 📌 ANSI-SQL 종류
### ✅ DDL, Data Definition Language
- 데이터 정의어
- 테이블, 뷰, 사용자, 인덱스 등의 데이터베이스 오브젝트를 생성/수정/삭제하는 명령어
- 구조를 생성/관리하는 명령어
1. **CREATE** : 생성
2. **DROP** : 삭제
3. **ALTER** : 수정

<br>

### ✅ DML, Data Manipulation Language
- 데이터 조작어
- 데이터베이스의 데이터를 추가/수정/삭제/조회하는 명령어
- 사용 빈도 가장 높음
1. **SELECT** : 조회 ⭐⭐⭐
2. **INSERT** : 추가
3. **UPDATE** : 수정
4. **DELETE** : 삭제

<br>

### ✅ DCL, Data Control Language
- 데이터 제어어
- 계정 권한 관리, 보안 통제, 트랜잭션 처리 등
1. **COMMIT**
2. **ROLLBACK**
3. **GRANT**
4. **REVOKE**
     
<br>     

### ✅ DQL, Data Query Language
- DML중 **SELECT**

<br>

### ✅ TCL, Transaction Control Language
- DCL 중 **COMMIT, ROLLBACK**

<br>

# 📌 RDB, 관계형 데이터베이스
- 가장 많이 사용되는 데이터 모델
- Oracle, SQL Server, MySQL, ...
- 데이터를 **표 형식으로 저장/관리**한다.
- SQL을 사용해서 조작한다. 

### ✅ 구성 요소
- **테이블** : 릴레이션(Relation)
    - 스키마(Scheme) : 테이블의 구조
- **컬럼** : 속성(Attribute)
- **행** : 튜플(Tuple), 레코드(Record), 인스턴스(Instance)