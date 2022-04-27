# 📌 SELECT
- DML, DQL
- 관계대수 연산 중 셀렉션 작업을 구현한 명령어
- 대상 테이블로부터 **원하는 행(튜플)을 추출**하는 작업
```sql
-- 단일 컬럼
select name from tblCountry;

-- 여러 컬럼 > 프로젝션
select name, capital from tblCountry;

-- 모든 컬럼 > 와일드 카드 사용
select * from tblCountry;
```
<BR>

### ✅ WHERE 절 조건 검색
#### 🔍 between
- 범위 조건
- `컬럼명 between 최솟값 and 최댓값`
- 조건을 and로 묶는 것보다 가독성이 높지만, 비교적 속도가 느리다는 단점이 있다.
```sql
-- 1. 숫자형
select * from tblComedian where weight between 60 and 70;

-- 2. 문자형 > 문자 코드 비교
select * from tblInsa where name between '박' and '유';
 
-- 3. 날짜형
select * from tblInsa where ibsadate between '2010-01-01' and '2020-12-31';
```

<br>

#### 🔍 in
- 열거형 조건
- `컬럼명 in (값, 값, 값, ...)`
- 제시된 값들 중 하나와 일치하면 만족
- or로 조건을 연결하는 것보다 간편하고 가독성이 높다.
```sql
select * from tblInsa where buseo in ('홍보부', '개발부', '총무부');
```

<br>

#### 🔍 like
- 패턴 비교
- `컬럼명 like '패턴 문자열'`
```sql
-- 1. _ : 임의의 문자 1개
select name from tblInsa where name like '김__'; -- 김씨 직원

-- 2. % : 임의의 문자 N개 ( 0 ~ 무한대 ) 
select * from employees where first_name like 'S%'; -- S로 시작하는 이름을 가진 직원
select * from tblInsa where SSN like '%-2%'; -- 여자 직원
```

<br>

#### 🔍 is, is not
- RDBMS에서의 NULL은 연산의 대상이 될 수 없음 (연산자 사용 불가)
- null값 여부 조건 적용시 사용
- `컬럼명 is null`

```sql
-- 인구수가 기재되지 않은 나라
select * from tblCountry where population is null;

-- 연락처가 기재되어 있는 직원
select * from tblInsa where tel is not null;
```

<BR>

# 📌 컬럼 연산
### ✅ distinct
- 컬럼 리스트에서 사용
- **행의 중복값 제거**
```sql
-- 대륙의 종류
select distinct continent from tblCountry;
```

<br>

### ✅ case
- **조건을 적용**하여 컬럼값을 조작할 때 사용
- 모든 조건에 불일치하면 null 반환 ⭐
- `case when 조건 then 결과 end`
- 다중 조건 설정 가능
```sql
-- m이면 남자, f이면 여자 출력
select
    last || first as name,
    case
        when gender = 'f' then '여자'
        when gender = 'm' then '남자'
    end as gender
from tblComedian;
```

<br>

# 📌 ORDER BY
- 레코드 정렬에 사용
- `order by 정렬할 기준 컬럼명 [asc|desc], [컬럼명 [asc|desc]]`
- 다중 정렬 지원 : 앞의 기준을 동시에 만족 시 뒤의 조건으로 정렬


<br>

### ✅ 활용 
- **기본 자료형 컬럼**을 기준으로 정렬
```sql
-- 문자열 정렬
select * from tblCountry order by name asc;
select * from tblCountry order by name desc;

-- 숫자 정렬
select * from tblCountry order by area asc;
select * from tblInsa order by basicpay;

-- 날짜 정렬
select * from tblInsa order by ibsadate; 
```
- **임의로 정렬 기준을 설정** > case문 활용
```sql
-- 직위 정렬
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
```

<br>

# 📌 GROUP BY
- `GROUP BY 컬럼명 [, 컬럼명]`
- 레코드들을 특정 속성값으로 그룹을 만든다.
- 나누어진 각각의 그룹에 대해 **집계 함수(SUM, AVG, MIN, MAX, COUNT)를 사용**하기 위해 사용 ⭐
- SELECT절에는 **GROUP BY에서 적용한 컬럼과 집계 함수**만 나올 수 있다.
```SQL
-- 부서별로 부서명과 평균급여를 가져오시오.
select
    buseo,
    round(avg(basicpay)) as "부서별 평균급여" 
from tblInsa
     group by buseo;
```



<BR>

### ✅ HAVING
- GROUP BY절의 조건절 역할을 한다.
- **반드시 GROUP BY와 같이 사용**한다. (단독 사용 X)
```SQL
-- 평균 급여가 150만원이 넘는 부서의 이름과 평균 급여를 가져오시오.
select                                 
    buseo,
    round(avg(basicpay))
from tblInsa                            
    group by buseo  
    having avg(basicpay) >= 1500000; 
```

<BR>

# 📌 실행 순서 ⭐
1. **FROM** 테이블
2. **WHERE** 조건
3. **GROUP BY** 기준
4. **HAVING** 조건
5. **SELECT** 컬럼리스트
6. **ORDER BY** 기준
