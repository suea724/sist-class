
/*

    ANSI-SQL 중요한 기술 Top 2
    1. SubQuery
    2. Join
    
    [Main Query, 일반 쿼리]
    - 하나의 문장안에 하나의 SELECT(INSERT,UPDATE,DELETE)로 되어 있는 쿼리
    
    [Sub Query, 서브 쿼리, 부속 질의]
    - 하나의 문장안에 또 다른 문장이 들어있는 쿼리
    - 하나의 SELECT문 안에 또 다른 SELECT문이 들어있는 쿼리
    - 메인 쿼리에서 값으로 사용한다.

*/

-- tblCountry 인구수가 가장 많은 나라의 이름?
select * from tblCountry;

select max(population) from tblCountry;

select name
from tblCountry
where population = (select max(population) from tblCountry); 


-- tblComedian 체중이 가장 많이 나가는 사람의 이름?
select * from tblComedian where weight = (select max(weight) from tblComedian);


-- tblInsa 급여를 가장 많이 받는 직원?
select * from tblInsa where basicpay = (select max(basicpay) from tblInsa);


-- tblInsa 평균 급여보다 많이 받는 직원?
select * from tblInsa where basicpay > (select avg(basicpay) from tblInsa);


-- 서브쿼리 삽입 위치
-- 1. 조건절 > 비교값으로 사용
--      1. 반환값이 1행 1열 > 단일 값 반환 > 상수 취급 > 값 1개로 사용
--      2. 반환값이 N행 1열 > 다중 값 반환 > 값 N개로 사용 > 열거형 비교 > in 사용
--      3. 반환값이 1행 N열 > 다중 값 반환 > 그룹 비교 > N컬럼:N컬럼 비교
--      4. 반환값이 N행 N열 > 다중 값 반환 > 1 + 3 > in + 그룹 비교

-- 급여를 250만원 이상 받는 직원이 근무하는 부서의 직원 명단
select * from tblInsa where buseo = (select buseo from tblInsa where basicpay >= 2650000);

-- in 대신 '='를 사용하는 경우 > ORA-01427: single-row subquery returns more than one row
select * from tblInsa where buseo in (select buseo from tblInsa where basicpay > 2500000);

-- '홍길동'과 같은 지역, 같은 부서인 직원 명단을 가져오시오.
select * from tblInsa where name = '홍길동';

-- 순서 중요!
select * from tblInsa where (city,buseo) = (select city, buseo from tblInsa where name = '홍길동');


-- 급여가 260만원 이상 받는 직원과 같은 부서, 같은 지역에 있는 직원들을 모두 가져오시오.
    -- 기획부에서 근무하면서 서울에 있는 직원들과,
    -- 총무부에서 근무하면서 경남에 있는 직원들을 모두 가져오시오.
select buseo, city from tblInsa where basicpay >= 2600000;

select * from tblInsa where (buseo, city) in (select buseo, city from tblInsa where basicpay >= 2600000);


-- 2. 컬럼 리스트에서 사용
--      - 반드시 결과값이 1행 1열이어야 한다. (******************) > 스칼라 쿼리
--      - 다른 컬럼과 관계있는 값을 반환해야 한다. (하나의 레코드의 모든 컬럼은 서로 연관이 있어야 한다.)

--      1. 정적 쿼리 > 모든 행에 동일한 값을 적용 > 사용 빈도 낮음
--      2. 상관 서브 쿼리 (*******) > 서브 쿼리의 값과 바깥쪽 메인 쿼리의 값을 서로 연결 > 사용 빈도 높음!

select
    name,
    buseo,
    basicpay,
    (select round(avg(basicpay)) from tblInsa) as "평균급여"
from tblInsa;


select
    name,
    buseo,
    basicpay,
    (select jikwi from tblInsa where name = '홍길동') as jikwi
from tblInsa;



select
    name,
    buseo,
    basicpay,
    (select round(avg(basicpay)) from tblInsa) as "전체 평균 급여",
    (select round(avg(basicpay)) from tblInsa where buseo = a.buseo) as "소속 부서 평균 급여"
from tblInsa a
    order by buseo;
    

select * from tblMan;
select * from tblWoman;

-- 남자의 이름, 키, 몸무게와 여자친구의 이름, 키, 몸무게를 가져오시오.
select
    name as "남자 이름",
    height as "남자 키",
    weight as "남자 몸무게",
    couple as "여자 이름",
    (select height from tblWoman where name = tblMan.couple) as "여자 키",
    (select weight from tblWoman where name = tblMan.couple) as "여자 몸무게"
from tblMan;

-- 3. FROM절에서 사용
--      - 인라인 뷰(Inline View)
--      1. 서브쿼리의 결과 셋을 또 하나의 테이블이라고 생각하고 또 다른 SELECT의 FROM절에 사용이 가능

-- select 실행 > 결과 테이블(Result Table), 결과 셋(Result Set) > 임시 테이블
select * from (select name, buseo, jikwi from tblInsa);

select * from (select * from (select name, buseo, jikwi from tblInsa));




-- 주의!
-- 메인쿼리 > tblInsa(X), 서브쿼리(O)
select name, buseo, jikwi, basicpay from (select name, buseo from tblInsa);

-- from 서브쿼리가 별칭 사용 > 바깥쪽 메인 쿼리는 alias를 원래 컬럼명으로 인식
select name, buseo, position from (select name, buseo, jikwi as position from tblInsa);

-- 서브 쿼리에서 함수를 사용하면 alias를 붙여줘야 한다.
select name, length(name), len from (select name, length(name) as len from tblInsa);

-- ORA-00960: ambiguous column naming in select list
select name, height, couple,
        (select height from tblWoman where tblMan.couple = name) as height2
from tblMan
    order by height2 asc;