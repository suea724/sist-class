

/*

    [GROUP BY]
    - GROUP BY 컬럼명 [, 컬럼명]
    - 레코드들을 특정 컬럼값(1~N)으로 그룹을 나누는 역할
    - 그룹을 왜 나누는지? > 각각의 나눠진 그룹을 대상으로 집계 함수를 적용하기 위해서 (************)

    SELECT 컬럼리스트
    FROM 테이블
    WHERE 조건
    GROUP BY 기준
    ORDER BY 기준

    [실행 순서] **********
    1. FROM 테이블
    2. WHERE 조건
    3. GROUP BY 기준
    4. SELECT 컬럼리스트
    5. ORDER BY 기준

*/

-- tblInsa. 부서별 평균 급여

select * from tblInsa;

select round(avg(basicpay)) from tblInsa; -- 총 인원의 평균 급여 155만원

select * from tblInsa group by buseo; -- 에러! 

-- group by 사용 시 집계 함수 또는 group by 기준(컬럼) 사용해야 함
select buseo, round(avg(basicpay)) as "부서별 평균급여" from tblInsa group by buseo;

select
    buseo,
    count(*) as "부서별 인원수",
    sum(basicpay) as "부서별 지급액",
    round(avg(basicpay)) as "부서별 평균급여",
    max(ibsadate) as "부서별 막내 입사일",
    min(ibsadate) as "부서별 최고참 입사일"
from tblInsa group by buseo;



-- 성별별 인원수
select * from tblComedian;

select
    count(decode(gender, 'm',1)) as "남자 수",
    count(decode(gender, 'f',1)) as "여자 수"
from tblComedian;


select
    gender,
    count(*)
from tblComedian
    group by gender;


-- 지역별 인원수
select
    city,
    count(*)
from tblInsa
    group by city
        order by count(*) desc;
        
-- 대륙별 나라수, 인구수        
select 
    continent,
    count(*) as "대륙별 나라수",
    sum(population) as "대륙별 인구수"
from tblCountry
    group by continent;
    

-- 성별별 키, 몸무게
select
    gender,
    max(height),
    min(height),
    max(weight),
    min(weight)
from tblComedian
    group by gender;
    

-- group by의 기준으로 여러 컬럼이 올 때
select 
    buseo,
    jikwi,
    city,
    count(*)
from tblInsa    
    group by buseo, jikwi, city
        order by buseo, jikwi;

        
-- 급여별 그룹
-- 100만원 이하
-- 200만원 이하
-- 300만원 이하

select
    floor(basicpay / 1000000) + 1 || '00 만원 이하',
    count(*)
from tblInsa
    group by floor(basicpay / 1000000)
        order by floor(basicpay / 1000000);
        

-- tblTodo 할일의 개수? 안한일의 개수? > 그룹 기준? 일의 완료 유무
select
    case
        when completedate is not null then 'O'
        else 'X'
    end as iscompleted,
    count(*)
from tblTodo
    group by case
                when completedate is not null then 'O'
                else 'X'
             end;
  
  
             
-- 지역별 인원수?
select distinct city from tblInsa;

-- 모든 지역을 수동으로 작성해주어야 함
-- 새로운 데이터 / 데이터 수정에 취약함 > 정적인 데이터에 적합
select
    count(decode(city, '서울', 1)) as "서울", 
    count(decode(city, '인천', 1)) as "인천",
    count(decode(city, '경기', 1)) as "경기"
from tblInsa;
    
-- 새로운 데이터 / 데이터 수정에 강함 > 정적/동적 데이터 모두 적합
select
    city,
    count(*)
from tblInsa
    group by city;
    
    
/*

    [Having]
    - 반드시 GROUP BY와 같이 사용 (단독 사용 X)
    - GROUP BY의 조건절 역할
    
    SELECT 컬럼리스트
    FROM 테이블
    WHERE 조건
    GROUP BY 기준
    HAVING 조건
    ORDER BY 기준
    
    [실행 순서] **********
    1. FROM 테이블
    2. WHERE 조건
    3. GROUP BY 기준
    4. HAVING 조건
    5. SELECT 컬럼리스트
    6. ORDER BY 기준
    
*/

-- 부서별 평균 급여 150만원이 넘는 부서?

select                                  -- 4. 평균 급여 출력 > 사전 조건 (150만원 이상인 사람들)
    buseo,
    round(avg(basicpay))
from tblInsa                            -- 1. 60명의 데이터를 가져온다.
    where basicpay >= 1500000            -- 2. 60명을 대상으로 조건 검사
        group by buseo;                 -- 3. 2번에서 통과한 사람들을 대상으로 그룹 형성
        
select                                 -- 4. 컬럼 구성
    buseo,
    round(avg(basicpay))
from tblInsa                            -- 1. 60명의 데이터를 가져온다.
    group by buseo                      -- 2. 60명을 대상으로 그룹 형성
    having avg(basicpay) >= 1500000;    -- 3. 그룹을 대상으로 조건 검사

select                                           -- 5. 컬럼 구성
    buseo,
    round(avg(basicpay))
from tblInsa                                      -- 1. 60명 데이터를 가져온다.
    where basicpay >= 1500000                      -- 2. 27명만 남긴다. (개인 탈락)
        group by buseo                             -- 3. 27명을 가지고 그룹 형성
        having avg(basicpay) >= 2200000          -- 4. 4부서만 남긴다. (부서 탈락)
        order by 2;                         -- 6. 정렬


-- 서울 직원 > 남녀 그룹 > 그룹별 평균 급여 155만원 이상인 각 그룹의 인원 수
select
    substr(ssn, 8, 1),
    count(*)
from tblInsa 
    where city = '서울'
    group by substr(ssn, 8, 1)
    having avg(basicpay) >= 1550000;
    

-- 문제
-- tblCountry > 대륙별 최대 인구수, 최소 인구수, 평균 인구수를 가져오시오.
select
    continent,
    max(population),
    min(population),
    round(avg(population))
from tblCountry
group by continent;


-- employees > 직업별(job_id) 직원 수를 가져오시오.
select
    job_id,
    count(*)
from employees
    group by job_id;


-- tblInsa > 부서별 인원수, 최고 급여, 최저 급여, 평균 급여 가져오시오.
select
    buseo,
    count(*),
    max(basicpay),
    min(basicpay),
    round(avg(basicpay))
from tblInsa
    group by buseo;


-- tblInsa > 부서별 직급의 인원수를 가져오시오.
-- [부서명]    [총인원]      [부장]     [과장]      [대리]      [사원]
select
    buseo as "부서명",
    count(*) as "총인원",
    count(decode(jikwi, '부장', 1)) as "부장",
    count(decode(jikwi, '과장', 1)) as "과장",
    count(decode(jikwi, '대리', 1)) as "대리",
    count(decode(jikwi, '사원', 1)) as "사원"
from tblInsa
    group by buseo;
    
select
    buseo,
    jikwi,
    count(*)
from tblInsa
    group by buseo, jikwi
    order by buseo;
    
/*
    
    group by + having + rollup + cube
    
    rollup()
    - group by의 결과에서 집계 결과를 좀 더 자세하게 반환
    - 그룹별 중간 통계를 내고자 할 때 사용
    
*/

select
    buseo,
    count(*),
    round(avg(basicpay))
from tblInsa
    group by rollup(buseo);
    
select
    buseo,
    jikwi,
    count(*),
    round(avg(basicpay))
from tblInsa
    group by rollup(buseo, jikwi); -- 순서 바뀌면 결과도 달라짐
    
    
/*

    cube()
    - rollup의 결과에서 집계 결과를 더 자세하게 반환
    - 그룹별 중간 통계를 내고 싶을 때 사용

*/

select
    buseo,
    jikwi,
    count(*),
    round(avg(basicpay))
from tblInsa
    group by cube(buseo, jikwi); -- 순서와 상관없이 모든 경우에 수에 대해 중간 통계 산출
