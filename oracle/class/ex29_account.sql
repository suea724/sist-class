
/*

    [DCL, Data Control Language] > 사용자 관련
    - 계정 생성, 삭제, 잠금 제어
    - 리소스(DB Object) 접근 권한 제어
    
    
    [사용자 계정 생성]
    - 시스템 권한을 가지고 있는 계정만 가능하다. > 관리자급
    - 계정 생성 권한을 가지고 있는 일반 계정도 가능
    - create user 계정명 identified by 암호;   -- 계정 생성
    - alter user 계정명 identified by 암호;    -- 계정 정보 변경
    - alter user 계정명 account unlock;        -- 계정 잠금 해제
    - alter user 계정명 account lock;          -- 계정 잠금 설정
    
    - 새로 생성된 계정은 아무 권한이 없다. > 접속할 권한조차도 없다.
    
    [사용자에게 권한 부여]
    - 시스템 권한을 가지고 있는 계정만 가능하다. > 관리자급
    - grant 권한명 to 유저명
    
    [사용자로부터 권한 제거]
    - revoke 권한명 from 유저명
    
    
    [권한 종류]
    - create user
    - drop user
    - drop any table
    - create session
    - create table
    - create view
    - create sequence
    - create procedure
    
    
    [권한의 집합] > Role
    - 프로젝트 계정 > connect + resource + dba
    
    1. connect : 사용자 DB 접속 + 기본적 행동 > 권한 모음
    2. resource : 사용자가 객체를 생성하거나 조작하는 권한 모음
    3. dba : 준관리자급 권한 모음
    

*/

show user;

create user hong identified by java1234;

grant create session to hong;   -- hong에게 접속 권한 부여
grant create table to hong;     -- hong에게 테이블 생성 권한 부여

create table tblData(
    seq number primary key,
    data varchar2(100) not null
);

