# 📌 Subquery, 서브쿼리
- **SQL문 안에 다른 SQL문이 중첩된 쿼리**
- 데이터가 다량일 때, 데이터를 모두 합쳐 연산하는 조인보다 서브쿼리를 사용하는 것이 성능이 더 좋다.

<BR>

### ✅ WHERE절 서브쿼리
- nested subquery
- **조건절에서 비교값으로 사용**한다.
- 단일값 : =, >, <, >=, <=, <>
- 다중값 : IN, NOT IN
```sql
-- 단일값 반환 > 비교 연산자 사용
-- tblInsa 평균 급여보다 많이 받는 직원?
select * from tblInsa where basicpay > (select avg(basicpay) from tblInsa);

-- 다중값 반환 > IN 또는 NOT IN 사용
-- 급여가 250만원 이상인 사람들의 부서와 같은 부서에 속하는 직원?
select * from tblInsa where buseo in (select buseo from tblInsa where basicpay > 2500000);
```

<BR>

### ✅ SELECT절 서브쿼리
- scalar subquery
- 반드시 **결과값이 단일 행, 단일 열의 값**으로 반환되어야 한다.
```SQL
select
    basicpay,
    (select round(avg(basicpay)) from tblInsa) as "평균급여"
from tblInsa;
```

<BR>

### ✅ FROM절 서브쿼리
- inline view
- **기존 테이블로부터 일시적으로 만들어진 가상의 테이블**
```sql
-- 모든 직원의 이름, 부서, 직위를 가져오시오.
select * from (select name, buseo, jikwi from tblInsa);

-- 주의!
-- 서브쿼리에서 컬럼의 alias 지정시, 바깥쪽 메인 쿼리에서 alias로 접근
select name, buseo, position from (select name, buseo, jikwi as position from tblInsa);

-- 서브 쿼리에서 함수를 사용하면 alias를 붙여줘야 한다.
select name, length(name), len from (select name, length(name) as len from tblInsa);
```