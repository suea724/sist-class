
/*

    자바
    - 클래스(객체) = 멤버 변수 + 멤버 메서드
    - 클래스가 소유하는 함수를 메서드라고 부른다.
    
    일반적인 언어에서는 함수는 독립적인 선언과 실행이 가능하다.
    
    [함수, Function]
    - 함수 역시 계정에 소속된다, HR
    1. 내장형 함수(Built-in Function)
    2. 사용자 정의 함수(User Function) > PL/SQL
    
    - 함수의 특징
        - input > 처리 > output
    
    [집계함수, Aggregation Function] *******************
    - 통계값
    1. count()
    2. sum()
    3. avg()
    4. max()
    5. min()
    
    1. count()
    - 결과 테이블의 레코드 수를 반환한다. > select 결과의 레코드 수를 반환한다.
    - number count(컬럼명) : 매개변수의 컬럼은 최대 1개
    
*/

select name from tblCountry;
select count(name) from tblCountry;

select name from tblCountry where continent = 'AS';
select count(name) from tblCountry where continent = 'AS';

select count(*) from tblCountry; -- 14
select count(name) from tblCountry; -- 14
select count(capital) from tblCountry; -- 14
select count(population) from tblCountry; -- 13 (Null 값 제외)

select count(*) from tblCountry; -- 일부 컬럼값이 null이어도 다른 컬럼에 값이 있기 때문에 모든 레코드 수 반환

select count(*) from tblTodo where completedate is null; -- 8
select count(*) from tblTodo where completedate is not null; -- 12

select
    count(*) as "전체 할일의 개수",
    count(completedate) as "한 일의 개수",
    count(*) - count(completedate) as "안한 일의 개수"
from tblTodo;

-- tblInsa 총 직원 수, 연락처가 있는 직원 수, 연락처가 없는 직원ㅅ ㅜ
select 
    count(*) as "총 직원 수",
    count(tel) as "연락처가 있는 직원 수",
    count(*) - count(tel) as "연락처가 없는 직원 수"
from tblInsa;

-- tblInsa 몇개의 부서?
select count(distinct buseo) from tblInsa;

-- tblComdeian 남자수? 여자수?
select count(*) from tblComedian where gender = 'm';
select count(*) from tblComedian where gender = 'f';

-- **** 자주 사용하는 패턴!! > 기억하세요
-- 조건을 만족하는 컬럼 카운트
select
    count(
    case
        when gender = 'm' then gender -- 조건을 만족하지 않으면 null 반환
    end) as "남자 수",
    count(
    case
        when gender = 'f' then gender -- 조건을 만족하지 않으면 null 반환
    end) as "여자 수"
from tblComedian;

-- 대륙별 나라 수?
select count(distinct continent) from tblCountry;

select count(*) from tblCountry where continent = 'AS';
select count(*) from tblCountry where continent = 'AF';
select count(*) from tblCountry where continent = 'EU';

select
    count(case
        when continent = 'AS' then 1
    end) as "아시아",
    count(case
        when continent = 'AF' then 1
    end) as "아프리카",
    count(case
        when continent = 'EU' then 1
    end) as "유럽"
from tblCountry;

/*
    2. sum()
    - 해당 컬럼의 합을 구한다.
    - number sum(컬럼명)
    - 숫자형만 적용 가능
*/

select sum(height) from tblComedian;

select
    sum(basicpay) as "지출 급여 합",
    sum(sudang) as "지출 수당 합",
    sum(basicpay) + sum(sudang) as "총 지출",
    sum(basicpay + sudang) as "총 지출"
from tblInsa;

/*
    3. avg()
    - 해당 컬럼값의 평균을 구한다.
    - number avg(컬럼명)
    - 숫자형만 적용 가능
    - null 제외 ********
*/

-- 평균 급여
select sum(basicpay)/count(*) from tblInsa;
select avg(basicpay) from tblInsa;

-- 모든 국가의 평균 인구수? > 주의**
select avg(population) from tblCountry; -- 15588.6153846153846153846153846153846154
select sum(population)/count(*) from tblCountry; -- 14475.1428571428571428571428571428571429 > 모든 레코드 수 count
select sum(population) / count(population) from tblCountry; -- 15588.6153846153846153846153846153846154 > null 값 count X

-- 회사 성과급 지급 > 성과급 출처 > 팀1의 공로
-- 1. 균등 지급 : 총 지급액 / 모든 팀원 수 = sum() / count(*)
-- 2. 차등 지급 : 총 지급액  / 참여 팀원 수 = sum() / count(참여 인원) > avg()

/*
    
    4. max()
        - object max(컬럼명)
        - 최댓값 반환
        
    5. min()
        - object min(컬럼명)
        - 최솟값 반환
    
    - 숫자형, 문자형, 날짜형 모두 적용
    
*/

select max(height), min(height) from tblComedian;
select max(name), min(name) from tblInsa;
select max(ibsadate), min(ibsadate) from tblInsa;

select
    count(*) as "영업부 직원수",
    sum(basicpay) as "영업부 급여 합",
    avg(basicpay) as "영업부 평균 급여",
    max(basicpay) as "영업부 최고 급여",
    min(basicpay) as "영업부 최저 급여"
from tblInsa
where buseo = '영업부';


-- 집계 함수 사용 주의점 !!

-- 1. ORA-00937: not a single-group group function
-- 컬럼 리스트에 집계 함수와 일반 컬럼은 동시에 사용할 수 없다.
-- 집계 함수 반환값(집합 값, 공용 데이터), 컬럼(개인 값, 객체 데이터)

select count(*) from tblInsa; -- 직원 수
select name from tblInsa; -- 직원명

select count(*), name from tblInsa; -- 집계 컬럼과 일반 컬럼 > X
select count(*), sum(sudang) from tblInsa; -- 집계 컬럼끼리 > O

-- 2. ORA-00934: group function is not allowed here
-- where절에는 집계 함수를 사용할 수 없다. **** + orderby에도 사용 불가
-- where절에는 개인 데이터에 대한 조건을 다루는 영역이기 때문에

select avg(basicpay) from tblInsa;

select * from tblInsa where basicpay >= avg(basicpay);
