/*

ANSI-SQL 자료형 (= 오라클 자료형)
1. 숫자형
    - 정수, 실수
    a. number
        - (유효자리) 38자리 이하의 숫자를 표현하는 자료형
        - 5 ~ 22byte (가변)
        - number
        - number(precision) : 전체 자릿수
        - number(precision, scale) : 

2. 문자형
    - 문자, 문자열
    - char + String > 자바의 String과 유사
    - char vs nchar > n의 의미?
    - char vs varchar > var의 의미 > 가변
    
    a. char
        - 고정 자릿수 문자열 > 공간(컬럼)의 크기가 불변
         - char(n) : n자리 문자열, n 바이트
         - 최소 크기 : 1 바이트
         - 최대 크기 : 2000 바이트
         - 주어진 공간을 데이터가 채우지 못하면 나머지 공간을 스페이스로 채운다.
         
    b. nchar
        - n : national > 오라클 인코딩과 상관없이 해당 컬럼을 UTF-16으로 동작하도록 함 > 한 글자당 2byte
        - 고정 자릿수 문자열
        - nchar(n) : n자리 문자열, n (문자수)
        - 최소 크기 : 1글자
        - 최대 크기 : 1000글자
        
    c. varchar2
        - 가변 자릿수 문자열 > 공간의 크기가 가변
        - varchar2(n) : n자리 문자열, n(바이트)
        - 최소 크기 : 1바이트
        - 최대 크기 : 2000바이트
        - 주어진 공간을 데이터가 채우지 못하면 나머지 공간을 버린다. 즉 데이터의 크기가 공간의 크기가 된다.
        
    d. nvarchar2
        -  n : national > 오라클 인코딩과 상관없이 해당 컬럼을 UTF-16으로 동작하도록 함 > 한 글자당 2byte
        - 가변 자릿수 문자열 > 공간의 크기가 가변
        - varchar2(n) : n자리 문자열, n(바이트)
        - 최소 크기 : 1바이트
        - 최대 크기 : 2000글자
        - 주어진 공간을 데이터가 채우지 못하면 나머지 공간을 버린다. 즉 데이터의 크기가 공간의 크기가 된다.
    
    e. clob, nclob
        - 대용량 텍스트 저장
        - 128TB
        - 잘 사용하지 않음, 참조형    

3. 날짜/시간형
    - 자바의 Calendar, Date
     
    a. date
        - 년월일시분초
        - 7byte
    
    b. timestamp
        - 년월일시분초 + 밀리초 + 나노초
    
    c. interval
        - 시간
        - 틱값 저장용
        - 잘 사용하지 않음 > number를 대신 사용

4. 이진 데이터형
    - 비 텍스트 데이터
    - 이미지, 영상, 음악, 파일 등..
    - 잘 사용하지 않음
    - e.g. 게시판(첨부파일), 회원가입(사진) > 파일명(문자열)만 저장 > hong.jpg > 폴더에서 이름으로 파일을 찾음
    
    a. blob
        - 최대 128TB

결론
1. 숫자 > number
2. 문자 > varchar2 + char
3. 날짜 > date   
*/

-- 오라클은 사용자가 정의한 모든 식별자를 DB에 저장할 때 항상 대문자로 변환해서 저장한다. (**********)
select * from tabs where table_name = 'tblType'; -- X
select * from tabs where table_name = 'TBLTYPE'; -- O

-- 테이블 선언 (생성)
create table tblType (
    -- num number
    -- num number(3) -- 정수부 자릿수 지정
    -- num number(4, 2) -- 전체 자릿수 지정
    -- str char(10), -- str1 컬럼에는 최대 10바이트 크기의 문자를 저장 
    -- str2 varchar2(10)
    str nchar(10) 
);

-- 테이블 삭제
drop table tblType;

-- 확인
select * from tabs; -- 현재 계정이 소유하고 있는 테이블 정보

-- 데이터 추가하기
insert into tblType (num) values (100); -- 정수형 리터럴
insert into tblType (num) values (3.14); -- 실수형 리터럴
insert into tblType (num) values (3.123456); -- 실수형 리터럴
insert into tblType (num) values (10000000000000000000);
insert into tblType (num) values (12345678901234567890123456789012345678901234567889);

-- num number(4,2)
insert into tblType (num) values(99.99);
insert into tblType (num) values(-99.99);

insert into tblType (str) values ('A');
insert into tblType (str) values ('ABC');
insert into tblType (str) values ('ABCABCABCAB'); -- overflow
insert into tblType (str) values ('가나다라');

insert into tblType (str, str2) values ('ABC', 'ABC');
insert into tblType (str, str2) values ('ABCABCABCA', 'ABCABCABCA');

-- @ABC       @ : char > 최대 크기에 모자란 길이만큼 스페이스(공백 문자)를 채워 넣는다.
-- @ABC@ : varchar > 최대 크기와 상관없이 데이터에 맞게 공간이 할당된다. > 보다 효율적인 공간 사용

-- nchar(10)
insert into tblType (str) values ('가나다');
insert into tblType (str) values ('가나다라마바사아자차카'); -- overflow
insert into tblType (str) values ('abcdefghijklmnopqrs');

-- 데이터 가져오기
select * from tblType;