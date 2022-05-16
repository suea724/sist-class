# 📌 데이터베이스 계정
### ✅ DCL(GRANT, REVOKE)
- 계정 생성, 삭제, 잠금 제어
- 리소스(DB Object) 접근 권한 제어

<br>

### ✅ 사용자 계정 생성
- 시스템 권한을 가지고 있는 계정만 다른 계정을 생성할 수 있다.
- 일반 계정이 계정 생성 권한을 가지고 있다면 가능하다.
```sql
create user 계정명 identified by 암호;   -- 계정 생성
alter user 계정명 identified by 암호;    -- 계정 정보 변경
alter user 계정명 account unlock;        -- 계정 잠금 해제
alter user 계정명 account lock;          -- 계정 잠금 설정
```

<br>

### ✅ 권한 부여 및 회수
- 새로 생성된 계정은 접속 권한을 포함해 아무 권한이 없다.
- 시스템 권한을 가지고 있는 계정이 권한을 부여하거나 회수할 수 있다.
```sql
grant 권한명 [on 테이블명] to 유저명; -- 권한 부여
grant all privileges [on 테이블명] to 유저명 -- 테이블의 모든 권한을 부여

revoke 권한명 from 유저명; -- 권한 회수
```

<br>

### ✅ 권한 종류
- create user
- drop user
- drop any table
- create session
- create table
- create view
- create sequence
- create procedure
```sql
grant create session to hong;   -- hong에게 접속 권한 부여
grant create table to hong;     -- hong에게 테이블 생성 권한 부여
```
<br>

### ✅ 권한의 집합(ROLE)
1. connect : 사용자의 DB 접속 및 기본적 행동에 대한 권한 모음
2. resource : 사용자가 객체를 생성하거나 조작하는 권한 모음
3. dba : 준관리자급 권한 모음
```sql
-- 보통 프로젝트 계정에는 세 가지 role을 모두 부여한다.
grant connect, resource, dba to hong;
```