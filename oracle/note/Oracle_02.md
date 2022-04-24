### 📌 ANSI-SQL 자료형 (= Oracle 자료형)
- 논리형(boolean)은 존재하지 않음

<br>

### ✅ 정수, 실수
- **number**
    - (유효자리) 38자리 이하의 숫자를 표현하는 자료형
    - 5 ~ 22byte (가변)
    - number
    - number(precision) : 전체 자릿수 지정
    - number(precision, scale) : 전체 자릿수, 소수점 이하 자릿수 지정

<br>

### ✅ 문자, 문자열
- **char**
    - 고정 자릿수 문자열
    - char(n) : n자리 문자열, n바이트
    - 최소 크기 : 1 바이트
    - 최대 크기 : 2000 바이트
    - 주어진 공간을 데이터가 채우지 못하면 나머지 공간을 공백으로 채운다.
- **nchar**
    - n(national) : 오라클 인코딩과 상관없이 해당 컬럼을 UTF-16으로 동작하도록 함(한 글자당 2byte)
    - 고정 자릿수 문자열
    - 최소 크기 : 1 글자
    - 최대 크기 : 1000 글자
- **varchar2**
    - 가변 자릿수 문자열
    - varchar2(n) : n자리(바이트) 문자열
    - 최소 크기 : 1 바이트
    - 최대 크기 : 2000 바이트
    - 주어진 공간을 데이터가 채우지 못하면 나머지 공간을 버린다. 데이터의 크기가 즉 공간의 크기가 된다.

- **nvarchar2**
    - n(national) : 오라클 인코딩과 상관없이 해당 컬럼을 UTF-16으로 동작하도록 함(한 글자당 2byte)
   - varchar2(n) : n자리(바이트) 문자열
   - 최소 크기 : 1 바이트
   - 최대 크기 : 2000 바이트
    - 주어진 공간을 데이터가 채우지 못하면 나머지 공간을 버린다. 데이터의 크기가 즉 공간의 크기가 된다.
- **clob, nclob**
    - 대용량 텍스트 저장
    - 128TB
    - 잘 사용하지 않음, 참조형

<br>

### ✅ 날짜, 시간형
- **date**
    - 년월일시분초
    - 7byte

- **timestamp**
    - 년월일시분초 + 밀리초 + 나노초

- **interval**
    - 시간
    - 틱값 저장용
    - 잘 사용하지 않음(number를 대신 사용)

    <br>

### ✅ 이진 데이터형
- 비 텍스트 데이터
- 이미지, 영상, 음악, 파일 등
- 잘 사용하지 않음
- e.g. 게시판(첨부파일), 회원가입(사진) > 파일명(문자열)만 저장해두고 폴더에서 이름으로 파일을 찾는 방식을 많이 사용

<br>

# 📌 연산자, Operator
### ✅ 산술 연산자
- +, -, *, /
- % 없음 > 함수로 제공(mod())

<br>

### ✅ 문자열 연산자
- + (X) > || (O)

<br>

### ✅ 비교 연산자
- >, >=, <, <=
- =, <>

<br>

### ✅ 논리 연산자
- and, or, not
- 컬럼 리스트에서 사용 불가
- 조건절에서 사용 가능

<br>

### ✅ 대입 연산자
- =
- UPDATE 문에서만 사용 (컬럼에 값 대입 시 사용)

<br>

### ✅ SQL 연산자
- in, between, like, is 등

