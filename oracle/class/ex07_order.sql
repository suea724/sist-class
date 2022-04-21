/*

SELECT 컬럼리스트
FROM 테이블명 > 테이블 지정
WHERE 조건
ORDER BY 기준;

[ORDER BY]
- 정렬, Sort
- order by 절
- order by 정렬 기준
- order by 정렬할 기준 컬럼명, asc | desc
- 다중 정렬 지원
    - order by 컬럼명 asc, 컬럼명 asc > 앞 기준을 동시에 만족하면, 뒤의 조건으로 정렬

실행 순서
1. FROM 테이블명
2. WHERE 조건
3. SELECT 컬럼리스트
4. ORDER BY 기준

*/

-- 관계형 데이터베이스는 물리적으로 저장된 행의 순서가 중요하지 않다.

-- 문자열 정렬
select * from tblCountry order by name asc; -- asc default > 생략 가능
select * from tblCountry order by name desc;

-- 숫자 정렬
select * from tblCountry order by area asc;
select * from tblInsa order by basicpay;

-- 날짜 정렬
select * from tblInsa order by ibsadate; 

-- 실행 순서
select name, jikwi            -- 3.
from tblInsa                   -- 1.
where buseo = '기획부'     -- 2.
order by name asc;         -- 4. 

select name, buseo, jikwi, basicpay from tblInsa order by buseo asc;
select name, buseo, jikwi, basicpay from tblInsa order by buseo asc, jikwi desc; -- 1차 정렬 (부서) 후, 2차 정렬 (직위)
select name, buseo, jikwi, basicpay from tblInsa order by buseo asc, jikwi desc, name asc; -- 1차 정렬 (부서) 후, 2차 정렬 (직위), 3차 정렬 (이름)
select name, buseo, jikwi, basicpay from tblInsa order by 2 asc, 3 desc, 1 asc; -- 컬럼 순서로 지정할 수 있음 (권장X >  유지보수 취약, 가독성 낮음)

-- **가공(조작)한 값도 정렬의 대상이 된다.**
select * from tblInsa order by basicpay + sudang desc; -- 급여 + 수당

-- **** 더욱 더 가공
-- 부장 > 과장 > 대리 > 사원 순으로 정렬
-- 임의의 컬럼 생성

-- 직원명을 가져오시오. > 직위 정렬
select
    name, jikwi,
    case
        when jikwi = '부장' then 4
        when jikwi = '과장' then 3
        when jikwi = '대리' then 2
        when jikwi = '사원' then 1
    end jikwiseq
from tblInsa
order by jikwiseq desc;

-- jikwiseq도 하나의 컬럼 > orderby에 기준 행으로 추가할 수 있음
select
    name, jikwi
from tblInsa
order by case
        when jikwi = '부장' then 4
        when jikwi = '과장' then 3
        when jikwi = '대리' then 2
        when jikwi = '사원' then 1
    end desc;
    
-- 기획부 > 성별 별로 정렬 > 남자, 여자 순으로
select * from tblInsa
where buseo = '기획부'
order by case
    when ssn like '______-1%' then 1
    when ssn like '______-2%' then 2
end asc;
