/*
[연산자, Operator]

1. 산술 연산자
    - +, -, *, /
    - %(없음) > 함수로 제공(mod())

2. 문자열 연산자
    - + (X) > || (O)
    
3. 비교 연산자  
    - >, >=, <, <=
    - =, <>
    - 논리값(boolean) 반환 > 명시적으로 표현 가능한 자료형이 아니다. > 조건이 필요한 상황에서만 내부적으로 사용
        - 컬럼 리스트에서 사용 불가
        - 조건절에서 사용 가능

4. 논리 연산자
    - and, or, not
    - 컬럼 리스트에서 사용 불가
    - 조건절에서 사용 가능

5. 대입 연산자
    - =
    - 컬럼 = 값 대입시 가끔 사용함
    - UPDATE 문에서만 사용함!
    
6. SQL 연산자
    - 자바 : instanceof, typeof 등
    - in, between, like, is 등 (=구, = 절)
*/

select name || capital from tblCountry; -- + 기호 (X)

select * from tblMan;
select * from tblWoman;

-- 컬럼의 별칭 (Alias) 만들기
-- 컬럼명 as 별칭

select name as 남자이름, couple as 여자이름 from tblMan;

-- 가공한 컬럼은 alias를 지정해줘야 후처리 시 에러가 발생하지 않는다.
select name, weight, weight + 5 as 회식후몸무게 from tblMan; 

select name, name from tblMan;

select name as "남자 이름" from tblMan; -- 큰따옴표 > 식별자의 공백, 예약어 등 무효화

-- 테이블 별칭 만들기
select
    tblCountry.name,
    tblCountry.capital,
    tblCountry.population
from hr.tblCountry; -- 다른 계정(권한이 있는 계정)에서 실행할 경우 > 테이블 앞에 계정 명시

-- 테이블 별칭은 테이블 이름을 반복해서 사용할 때 코드량을 줄이기 위해서 사용 > 한글자로
-- 테이블에 alias를 지정하면 컬럼에서 호출할 때도 alias로 호출함
select
    c.name,
    c.capital,
    c.population
from tblCountry c; 