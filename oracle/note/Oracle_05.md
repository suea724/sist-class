# 📌 내장 함수, Built-in Function
- 상수 또는 속성 이름을 입력값으로 받아 단일 값을 결과로 반환한다.
- SELECT절, WHERE절, UPDATE절 등에서 사용할 수 있다.

<BR>

### ✅ 집계 함수, Aggregation Function ⭐
- **count()**
    - null값을 가지는 행은 count 결과에 포함되지 않는다.
```sql
-- 와일드 카드 사용 > 일부 컬럼값이 null이어도  모든 레코드 수 반환
select count(*) from tblCountry;

-- 컬럼명 사용 > name이 null인 행을 제외하고 count
select count(name) from tblCountry;
```

<BR>

- **sum()**
    - 숫자형만 적용 가능
```sql
select
    sum(basicpay) as "지출 급여 합",
    sum(sudang) as "지출 수당 합",
from tblInsa;
```

<BR>


- **avg()**
    - 숫자형만 적용 가능
    - sum / count
    - null 값을 가지는 행은 count에 포함되지 않는다. ⭐
```sql
select sum(basicpay)/count(*) from tblInsa;

-- sum(basicpay)/count(basicpay)
select avg(basicpay) from tblInsa;
```

<BR>


- **max(), min()**
    - 숫자형, 문자형, 날짜형 모두 적용
```sql
select max(height), min(height) from tblComedian;
select max(name), min(name) from tblInsa;
select max(ibsadate), min(ibsadate) from tblInsa;
```

<br>

#### 🚨 집계 함수 사용시 주의점
1. 컬럼 리스트에 집계 함수와 일반 컬럼은 동시에 사용할 수 없다.
오류 메세지 : `ORA-00937: not a single-group group function`
<BR>
2. WHERE절, ORDER BY절에는 집계 함수를 사용할 수 없다.
오류 메세지 : `ORA-00934: group function is not allowed here`

<BR>

### ✅ 숫자 함수, Numeric Function
- **round()**
    - `round(숫자, 소수이하자릿수)`
    - 반올림 함수
```sql
select round(avg(basicpay)) from tblInsa;
```

<BR>

- **abs()**
    - `abs(숫자)`
    - 절댓값 함수
```sql
select abs(-78) from dual;
```

<BR>

- **floor()**
    - `floor(숫자)`
    - 내림 함수, 절삭 함수
```sql
select floor(10/3) from dual; -- 3
```

<BR>
    
- **ceil()**
    - `ceil(숫자)`
    - 올림 함수
```sql
select ceil(10/3) from dual; -- 4
```

<BR>

- **mod()**
    - `mod(나눌 수, 나누는 수)`
    - 나머지 함수
```sql
select mod(10, 3) as "나머지" from dual;
```

<br>

### ✅ 문자 함수
- **upper(), lower(), initcap()**
    - 각각 대문자, 소문자, 첫글자만 대문자로 변환해주는 함수
```sql
select
    upper('abc'), -- ABC
    lower('ABC'), -- abc
    initcap('abc') -- Abc
from dual;

-- 이름에 'an'이 포함된 직원 > 대소문자 구분없이
select first_name from employees where lower(first_name) like '%an%';
```

<BR>

- **substr()**
    - `substr(컬럼, 시작 위치, 가져올 문자 개수)`
    - `substr(컬럼, 시작 위치)`
    - 문자열 추출 함수
```sql
select
    substr(name, 1, 1) as "성",
    substr(name, 2) as "이름",
from tblInsa;
```

<BR>

- **length()**
    - 문자열 길이 반환
```sql
-- 컬럼 리스트에서 사용
select name, length(name) from tblCountry;

-- 조건절에 사용
select name from tblCountry where length(name) > 3;

-- 정렬에 사용
select name from tblCountry order by length(name) desc, name;
```

<BR>

- **instr()**
    - `instr(문자, 검색어)`
    - `instr(문자, 검색어, 시작위치)`
    - 검색어의 위치를 반환 (= indexOf())
    - **검색어가 존재하지 않으면 0을 반환**
```sql
-- 010으로 시작하는 전화번호를 가진 회원 정보
select * from tblInsa where instr(tel, '010') = 1;
```

<BR>

- **lpad(), rpad()**
    - left padding, right padding
    - `lpad(문자열, 개수, 지정 문자)`
```sql
select
    lpad('1', 3, '0'), -- 001
    rpad('1', 3, '0')  -- 100
from dual;
```

<br>

- **trim(), ltrim(), rtrim()**
    -  문자열 앞뒤 공백 제거
    - `trim(문자)`
```sql
select
    trim('    하나     둘      셋        '),  -- '하나     둘      셋'
    ltrim('    하나     둘      셋        '), -- '하나     둘      셋        '
    rtrim('    하나     둘      셋        ')  -- '    하나     둘      셋'
from dual;
```

<br>

- **replace()**
    - 문자열 치환
    - `replace(컬럼, 찾을 문자열, 바꿀 문자열)`
```sql
select
    replace('홍길동', '홍', '김'),
    replace('홍길동', '이', '김'), -- 아무것도 바뀌지 않음
    replace('홍길홍', '홍', '김') -- 다 바꿔줌
from dual;
```

<br>

- **decode()**
    - 문자열 치환
    - 여러 문자열을 한꺼번에 치환할 때 replace보다 decode를 사용하는 것이 편리하다.
    - 문자열을 찾지 못하면 NULL을 반환한다.
    - `decode(컬럼, 찾을 문자열, 바꿀 문자열 [, 찾을 문자열, 바꿀 문자열] X N)`
```sql
-- 주민등록번호 뒷번호 시작 숫자가 1이면 남자로, 2이면 여자로 치환
select
    decode(substr(ssn, 8, 1), '1', '남자', '2', '여자') -- replace를 중첩시키는 것보다 가독성 높음
from tblInsa;

-- count 함수와 같이 사용할 수 있음
select
    count(decode(gender, 'm', '남자')), -- 여자 null 값, count X
    count(decode(gender, 'f', '여자')) -- 남자 null 값, count X
from tblComedian;
```

<br>

### ✅ 날짜, 시간 함수
- 날짜형(DATE) 데이터 간 연산하거나, 날짜형 데이터와 문자형 데이터간 연산시 TO_CHAR 함수를 사용해 문자형 데이터로 변환 후 연산한다.

<br>

- **sysdate**
    - DBMS 시스템상의 당일 날짜를 DATE형으로 반환한다.

<br>

- **to_date()**
    - `to_date(char, datetime)`
    - 문자형 데이터를 날짜형 데이터로 반환한다.
```sql
select
    to_date('2022-04-30','yyyy-mm-dd')) -- 2022-04-30
from dual;
```

<br>

- **to_char()**
    - `to_char(date, datetime)`
    - 날짜형 데이터를 형식문자열에 맞는 문자형 데이터로 반환한다.

<br>

- **날짜 관련 형식 문자열 구성요소**
    - yyyy : 4자리 연도
    - yy : 연도 마지막 두자리
    - month : 월 이름 (January ~ December)
    - mon : 월 이름 약어 (Jan ~ Dec)
    - mm : 월 순서(01 ~ 12)
    - day : 요일(월요일 ~ 일요일)
    - dy : 요일(월 ~ 일)
    - ddd : 1년 중 날짜(1 ~ 366)
    - dd : 1달 중 날짜(1 ~ 31)
    - d : 요일 순서(1 ~ 7, 월 = 1)
    - hh : 12시간 (1 ~ 12)
    - hh24 : 24시간 (0 ~ 23)
```sql
select
    to_char(to_date('2022-04-30','yyyy-mm-dd'),'yyyymmdd') -- '20220430'
from dual;
```

<br>

- **last_day()**
    - `last_day(date)`
    - 날짜형 데이터의 달의 마지막 날짜를 DATE형으로 반환한다.
```sql
select
    last_day(to_date('2022-04-15','yyyy-mm-dd')) -- 2022-04-30
from dual;
```

<br>

### ✅ 날짜 연산
- 시각 +(-) 시각 = 시간(일)
- 시각 +(-) 시간(일) = 시각

<br>

- **시각 +(-) 시각 = 시간 (일)**
```sql
select
    round(sysdate - ibsadate) as "근무일수",
    round((sysdate - ibsadate) * 24) as "근무시수",
    round((sysdate - ibsadate) * 24 * 60) as "근무분수",
    round((sysdate - ibsadate) * 24 * 60 * 60) as "근무초수"
from tblInsa;

<br>

-- 월 수를 반환하려면 months_between() 함수를 사용한다.
select
    round(months_between(sysdate, ibsadate)) as "근무월수",
    round(months_between(sysdate, ibsadate) / 12) as "근무년수"
from tblInsa;
```
<br>

- **시각 +(-) 시간(일) = 시각**
```sql
select
    sysdate - 100 as "100일 후",
    sysdate + 100 as "100일 전",
    sysdate - (2/24) as "2시간 전",
    sysdate + (3/24) as "3시간 후",
    sysdate + (30 / 60 / 24) as "30분 후"
from dual;

-- 지정한 월 수를 연산하려면 add_months() 함수를 사용한다.
select
    add_months(sysdate, 10), -- 10개월 뒤
    add_months(sysdate, -10), -- 10개월 전
    add_months(sysdate, 3 * 12) -- 3년뒤
from dual;
```

<br>

### ✅ NVL 함수
- **nvl(값1, 값2)**
    - 값1이 null이면 값2를 돌려줌

<br>

- **nvl2(값1, 값2, 값3)**
    - 값1이 null이 아닐 경우 값2, null일 경우 값 3d을 돌려줌

```sql
select
    nvl(population, 0) as a,
    nvl2(population, '확인', '미확인') as b
from tblCountry;
```

<br>

### ✅ 형변환 함수
- **to_char()**
    - `to_char(컬럼, [형식 문자열])`
    - 숫자 데이터를 문자형 데이터로 변환

- **숫자 관련 형식문자열 구성요소**
    - 9 : 숫자 1개를 문자 1개로 바꾸는 역할. 빈자리는 스페이스로 치환
    - 0 : 숫자 1개를 문자 1개로 바꾸는 역할. 빈자리는 0로 치환, 앞의 공백은 부호가 들어갈 자리
    - $ : 통화기호 표현(달러)
    - L : 통화기호 표현(로컬) > 설정에 따라 바뀜
    - . : 소수점 표시
    - , : 자릿수 표시

```sql
-- 출력될 숫자의 자릿수 지정
select
    '@' || to_char(weight, '99999') || '@',
    '@' || to_char(weight, '00000') || '@'
from tblComedian;

-- 통화 기호 표현
select
    to_char(100, '$999'), -- $999
    to_char(100, '999L')  -- 999₩
from dual;

-- 자릿수 및 소수점 표시
select
    to_char(1234567.89, '9,999,999.9') -- 반올림 됨, 콤마 들어갈 자리 직접 지정
from dual;

```

<br>

- **to_number()**
    - 문자형 데이터를 숫자 데이터로 변환
```sql
select
    to_number('123')
from dual;
```