# ๐ ๋ด์ฅ ํจ์, Built-in Function
- ์์ ๋๋ ์์ฑ ์ด๋ฆ์ ์๋ ฅ๊ฐ์ผ๋ก ๋ฐ์ ๋จ์ผ ๊ฐ์ ๊ฒฐ๊ณผ๋ก ๋ฐํํ๋ค.
- SELECT์ , WHERE์ , UPDATE์  ๋ฑ์์ ์ฌ์ฉํ  ์ ์๋ค.

<BR>

### โ ์ง๊ณ ํจ์, Aggregation Function โญ
- **count()**
    - null๊ฐ์ ๊ฐ์ง๋ ํ์ count ๊ฒฐ๊ณผ์ ํฌํจ๋์ง ์๋๋ค.
```sql
-- ์์ผ๋ ์นด๋ ์ฌ์ฉ > ์ผ๋ถ ์ปฌ๋ผ๊ฐ์ด null์ด์ด๋  ๋ชจ๋  ๋ ์ฝ๋ ์ ๋ฐํ
select count(*) from tblCountry;

-- ์ปฌ๋ผ๋ช ์ฌ์ฉ > name์ด null์ธ ํ์ ์ ์ธํ๊ณ  count
select count(name) from tblCountry;
```

<BR>

- **sum()**
    - ์ซ์ํ๋ง ์ ์ฉ ๊ฐ๋ฅ
```sql
select
    sum(basicpay) as "์ง์ถ ๊ธ์ฌ ํฉ",
    sum(sudang) as "์ง์ถ ์๋น ํฉ",
from tblInsa;
```

<BR>


- **avg()**
    - ์ซ์ํ๋ง ์ ์ฉ ๊ฐ๋ฅ
    - sum / count
    - null ๊ฐ์ ๊ฐ์ง๋ ํ์ count์ ํฌํจ๋์ง ์๋๋ค. โญ
```sql
select sum(basicpay)/count(*) from tblInsa;

-- sum(basicpay)/count(basicpay)
select avg(basicpay) from tblInsa;
```

<BR>


- **max(), min()**
    - ์ซ์ํ, ๋ฌธ์ํ, ๋ ์งํ ๋ชจ๋ ์ ์ฉ
```sql
select max(height), min(height) from tblComedian;
select max(name), min(name) from tblInsa;
select max(ibsadate), min(ibsadate) from tblInsa;
```

<br>

#### ๐จ ์ง๊ณ ํจ์ ์ฌ์ฉ์ ์ฃผ์์ 
1. ์ปฌ๋ผ ๋ฆฌ์คํธ์ ์ง๊ณ ํจ์์ ์ผ๋ฐ ์ปฌ๋ผ์ ๋์์ ์ฌ์ฉํ  ์ ์๋ค.
์ค๋ฅ ๋ฉ์ธ์ง : `ORA-00937: not a single-group group function`
<BR>
2. WHERE์ , ORDER BY์ ์๋ ์ง๊ณ ํจ์๋ฅผ ์ฌ์ฉํ  ์ ์๋ค.
์ค๋ฅ ๋ฉ์ธ์ง : `ORA-00934: group function is not allowed here`

<BR>

### โ ์ซ์ ํจ์, Numeric Function
- **round()**
    - `round(์ซ์, ์์์ดํ์๋ฆฟ์)`
    - ๋ฐ์ฌ๋ฆผ ํจ์
```sql
select round(avg(basicpay)) from tblInsa;
```

<BR>

- **abs()**
    - `abs(์ซ์)`
    - ์ ๋๊ฐ ํจ์
```sql
select abs(-78) from dual;
```

<BR>

- **floor()**
    - `floor(์ซ์)`
    - ๋ด๋ฆผ ํจ์, ์ ์ญ ํจ์
```sql
select floor(10/3) from dual; -- 3
```

<BR>
    
- **ceil()**
    - `ceil(์ซ์)`
    - ์ฌ๋ฆผ ํจ์
```sql
select ceil(10/3) from dual; -- 4
```

<BR>

- **mod()**
    - `mod(๋๋ ์, ๋๋๋ ์)`
    - ๋๋จธ์ง ํจ์
```sql
select mod(10, 3) as "๋๋จธ์ง" from dual;
```

<br>

### โ ๋ฌธ์ ํจ์
- **upper(), lower(), initcap()**
    - ๊ฐ๊ฐ ๋๋ฌธ์, ์๋ฌธ์, ์ฒซ๊ธ์๋ง ๋๋ฌธ์๋ก ๋ณํํด์ฃผ๋ ํจ์
```sql
select
    upper('abc'), -- ABC
    lower('ABC'), -- abc
    initcap('abc') -- Abc
from dual;

-- ์ด๋ฆ์ 'an'์ด ํฌํจ๋ ์ง์ > ๋์๋ฌธ์ ๊ตฌ๋ถ์์ด
select first_name from employees where lower(first_name) like '%an%';
```

<BR>

- **substr()**
    - `substr(์ปฌ๋ผ, ์์ ์์น, ๊ฐ์ ธ์ฌ ๋ฌธ์ ๊ฐ์)`
    - `substr(์ปฌ๋ผ, ์์ ์์น)`
    - ๋ฌธ์์ด ์ถ์ถ ํจ์
```sql
select
    substr(name, 1, 1) as "์ฑ",
    substr(name, 2) as "์ด๋ฆ",
from tblInsa;
```

<BR>

- **length()**
    - ๋ฌธ์์ด ๊ธธ์ด ๋ฐํ
```sql
-- ์ปฌ๋ผ ๋ฆฌ์คํธ์์ ์ฌ์ฉ
select name, length(name) from tblCountry;

-- ์กฐ๊ฑด์ ์ ์ฌ์ฉ
select name from tblCountry where length(name) > 3;

-- ์ ๋ ฌ์ ์ฌ์ฉ
select name from tblCountry order by length(name) desc, name;
```

<BR>

- **instr()**
    - `instr(๋ฌธ์, ๊ฒ์์ด)`
    - `instr(๋ฌธ์, ๊ฒ์์ด, ์์์์น)`
    - ๊ฒ์์ด์ ์์น๋ฅผ ๋ฐํ (= indexOf())
    - **๊ฒ์์ด๊ฐ ์กด์ฌํ์ง ์์ผ๋ฉด 0์ ๋ฐํ**
```sql
-- 010์ผ๋ก ์์ํ๋ ์ ํ๋ฒํธ๋ฅผ ๊ฐ์ง ํ์ ์ ๋ณด
select * from tblInsa where instr(tel, '010') = 1;
```

<BR>

- **lpad(), rpad()**
    - left padding, right padding
    - `lpad(๋ฌธ์์ด, ๊ฐ์, ์ง์  ๋ฌธ์)`
```sql
select
    lpad('1', 3, '0'), -- 001
    rpad('1', 3, '0')  -- 100
from dual;
```

<br>

- **trim(), ltrim(), rtrim()**
    -  ๋ฌธ์์ด ์๋ค ๊ณต๋ฐฑ ์ ๊ฑฐ
    - `trim(๋ฌธ์)`
```sql
select
    trim('    ํ๋     ๋      ์        '),  -- 'ํ๋     ๋      ์'
    ltrim('    ํ๋     ๋      ์        '), -- 'ํ๋     ๋      ์        '
    rtrim('    ํ๋     ๋      ์        ')  -- '    ํ๋     ๋      ์'
from dual;
```

<br>

- **replace()**
    - ๋ฌธ์์ด ์นํ
    - `replace(์ปฌ๋ผ, ์ฐพ์ ๋ฌธ์์ด, ๋ฐ๊ฟ ๋ฌธ์์ด)`
```sql
select
    replace('ํ๊ธธ๋', 'ํ', '๊น'),
    replace('ํ๊ธธ๋', '์ด', '๊น'), -- ์๋ฌด๊ฒ๋ ๋ฐ๋์ง ์์
    replace('ํ๊ธธํ', 'ํ', '๊น') -- ๋ค ๋ฐ๊ฟ์ค
from dual;
```

<br>

- **decode()**
    - ๋ฌธ์์ด ์นํ
    - ์ฌ๋ฌ ๋ฌธ์์ด์ ํ๊บผ๋ฒ์ ์นํํ  ๋ replace๋ณด๋ค decode๋ฅผ ์ฌ์ฉํ๋ ๊ฒ์ด ํธ๋ฆฌํ๋ค.
    - ๋ฌธ์์ด์ ์ฐพ์ง ๋ชปํ๋ฉด NULL์ ๋ฐํํ๋ค.
    - `decode(์ปฌ๋ผ, ์ฐพ์ ๋ฌธ์์ด, ๋ฐ๊ฟ ๋ฌธ์์ด [, ์ฐพ์ ๋ฌธ์์ด, ๋ฐ๊ฟ ๋ฌธ์์ด] X N)`
```sql
-- ์ฃผ๋ฏผ๋ฑ๋ก๋ฒํธ ๋ท๋ฒํธ ์์ ์ซ์๊ฐ 1์ด๋ฉด ๋จ์๋ก, 2์ด๋ฉด ์ฌ์๋ก ์นํ
select
    decode(substr(ssn, 8, 1), '1', '๋จ์', '2', '์ฌ์') -- replace๋ฅผ ์ค์ฒฉ์ํค๋ ๊ฒ๋ณด๋ค ๊ฐ๋์ฑ ๋์
from tblInsa;

-- count ํจ์์ ๊ฐ์ด ์ฌ์ฉํ  ์ ์์
select
    count(decode(gender, 'm', '๋จ์')), -- ์ฌ์ null ๊ฐ, count X
    count(decode(gender, 'f', '์ฌ์')) -- ๋จ์ null ๊ฐ, count X
from tblComedian;
```

<br>

### โ ๋ ์ง, ์๊ฐ ํจ์
- ๋ ์งํ(DATE) ๋ฐ์ดํฐ ๊ฐ ์ฐ์ฐํ๊ฑฐ๋, ๋ ์งํ ๋ฐ์ดํฐ์ ๋ฌธ์ํ ๋ฐ์ดํฐ๊ฐ ์ฐ์ฐ์ TO_CHAR ํจ์๋ฅผ ์ฌ์ฉํด ๋ฌธ์ํ ๋ฐ์ดํฐ๋ก ๋ณํ ํ ์ฐ์ฐํ๋ค.

<br>

- **sysdate**
    - DBMS ์์คํ์์ ๋น์ผ ๋ ์ง๋ฅผ DATEํ์ผ๋ก ๋ฐํํ๋ค.

<br>

- **to_date()**
    - `to_date(char, datetime)`
    - ๋ฌธ์ํ ๋ฐ์ดํฐ๋ฅผ ๋ ์งํ ๋ฐ์ดํฐ๋ก ๋ฐํํ๋ค.
```sql
select
    to_date('2022-04-30','yyyy-mm-dd')) -- 2022-04-30
from dual;
```

<br>

- **to_char()**
    - `to_char(date, datetime)`
    - ๋ ์งํ ๋ฐ์ดํฐ๋ฅผ ํ์๋ฌธ์์ด์ ๋ง๋ ๋ฌธ์ํ ๋ฐ์ดํฐ๋ก ๋ฐํํ๋ค.

<br>

- **๋ ์ง ๊ด๋ จ ํ์ ๋ฌธ์์ด ๊ตฌ์ฑ์์**
    - yyyy : 4์๋ฆฌ ์ฐ๋
    - yy : ์ฐ๋ ๋ง์ง๋ง ๋์๋ฆฌ
    - month : ์ ์ด๋ฆ (January ~ December)
    - mon : ์ ์ด๋ฆ ์ฝ์ด (Jan ~ Dec)
    - mm : ์ ์์(01 ~ 12)
    - day : ์์ผ(์์์ผ ~ ์ผ์์ผ)
    - dy : ์์ผ(์ ~ ์ผ)
    - ddd : 1๋ ์ค ๋ ์ง(1 ~ 366)
    - dd : 1๋ฌ ์ค ๋ ์ง(1 ~ 31)
    - d : ์์ผ ์์(1 ~ 7, ์ = 1)
    - hh : 12์๊ฐ (1 ~ 12)
    - hh24 : 24์๊ฐ (0 ~ 23)
```sql
select
    to_char(to_date('2022-04-30','yyyy-mm-dd'),'yyyymmdd') -- '20220430'
from dual;
```

<br>

- **last_day()**
    - `last_day(date)`
    - ๋ ์งํ ๋ฐ์ดํฐ์ ๋ฌ์ ๋ง์ง๋ง ๋ ์ง๋ฅผ DATEํ์ผ๋ก ๋ฐํํ๋ค.
```sql
select
    last_day(to_date('2022-04-15','yyyy-mm-dd')) -- 2022-04-30
from dual;
```

<br>

### โ ๋ ์ง ์ฐ์ฐ
- ์๊ฐ +(-) ์๊ฐ = ์๊ฐ(์ผ)
- ์๊ฐ +(-) ์๊ฐ(์ผ) = ์๊ฐ

<br>

- **์๊ฐ +(-) ์๊ฐ = ์๊ฐ (์ผ)**
```sql
select
    round(sysdate - ibsadate) as "๊ทผ๋ฌด์ผ์",
    round((sysdate - ibsadate) * 24) as "๊ทผ๋ฌด์์",
    round((sysdate - ibsadate) * 24 * 60) as "๊ทผ๋ฌด๋ถ์",
    round((sysdate - ibsadate) * 24 * 60 * 60) as "๊ทผ๋ฌด์ด์"
from tblInsa;

<br>

-- ์ ์๋ฅผ ๋ฐํํ๋ ค๋ฉด months_between() ํจ์๋ฅผ ์ฌ์ฉํ๋ค.
select
    round(months_between(sysdate, ibsadate)) as "๊ทผ๋ฌด์์",
    round(months_between(sysdate, ibsadate) / 12) as "๊ทผ๋ฌด๋์"
from tblInsa;
```
<br>

- **์๊ฐ +(-) ์๊ฐ(์ผ) = ์๊ฐ**
```sql
select
    sysdate - 100 as "100์ผ ํ",
    sysdate + 100 as "100์ผ ์ ",
    sysdate - (2/24) as "2์๊ฐ ์ ",
    sysdate + (3/24) as "3์๊ฐ ํ",
    sysdate + (30 / 60 / 24) as "30๋ถ ํ"
from dual;

-- ์ง์ ํ ์ ์๋ฅผ ์ฐ์ฐํ๋ ค๋ฉด add_months() ํจ์๋ฅผ ์ฌ์ฉํ๋ค.
select
    add_months(sysdate, 10), -- 10๊ฐ์ ๋ค
    add_months(sysdate, -10), -- 10๊ฐ์ ์ 
    add_months(sysdate, 3 * 12) -- 3๋๋ค
from dual;
```

<br>

### โ NVL ํจ์
- **nvl(๊ฐ1, ๊ฐ2)**
    - ๊ฐ1์ด null์ด๋ฉด ๊ฐ2๋ฅผ ๋๋ ค์ค

<br>

- **nvl2(๊ฐ1, ๊ฐ2, ๊ฐ3)**
    - ๊ฐ1์ด null์ด ์๋ ๊ฒฝ์ฐ ๊ฐ2, null์ผ ๊ฒฝ์ฐ ๊ฐ 3d์ ๋๋ ค์ค

```sql
select
    nvl(population, 0) as a,
    nvl2(population, 'ํ์ธ', '๋ฏธํ์ธ') as b
from tblCountry;
```

<br>

### โ ํ๋ณํ ํจ์
- **to_char()**
    - `to_char(์ปฌ๋ผ, [ํ์ ๋ฌธ์์ด])`
    - ์ซ์ ๋ฐ์ดํฐ๋ฅผ ๋ฌธ์ํ ๋ฐ์ดํฐ๋ก ๋ณํ

- **์ซ์ ๊ด๋ จ ํ์๋ฌธ์์ด ๊ตฌ์ฑ์์**
    - 9 : ์ซ์ 1๊ฐ๋ฅผ ๋ฌธ์ 1๊ฐ๋ก ๋ฐ๊พธ๋ ์ญํ . ๋น์๋ฆฌ๋ ์คํ์ด์ค๋ก ์นํ
    - 0 : ์ซ์ 1๊ฐ๋ฅผ ๋ฌธ์ 1๊ฐ๋ก ๋ฐ๊พธ๋ ์ญํ . ๋น์๋ฆฌ๋ 0๋ก ์นํ, ์์ ๊ณต๋ฐฑ์ ๋ถํธ๊ฐ ๋ค์ด๊ฐ ์๋ฆฌ
    - $ : ํตํ๊ธฐํธ ํํ(๋ฌ๋ฌ)
    - L : ํตํ๊ธฐํธ ํํ(๋ก์ปฌ) > ์ค์ ์ ๋ฐ๋ผ ๋ฐ๋
    - . : ์์์  ํ์
    - , : ์๋ฆฟ์ ํ์

```sql
-- ์ถ๋ ฅ๋  ์ซ์์ ์๋ฆฟ์ ์ง์ 
select
    '@' || to_char(weight, '99999') || '@',
    '@' || to_char(weight, '00000') || '@'
from tblComedian;

-- ํตํ ๊ธฐํธ ํํ
select
    to_char(100, '$999'), -- $999
    to_char(100, '999L')  -- 999โฉ
from dual;

-- ์๋ฆฟ์ ๋ฐ ์์์  ํ์
select
    to_char(1234567.89, '9,999,999.9') -- ๋ฐ์ฌ๋ฆผ ๋จ, ์ฝค๋ง ๋ค์ด๊ฐ ์๋ฆฌ ์ง์  ์ง์ 
from dual;

```

<br>

- **to_number()**
    - ๋ฌธ์ํ ๋ฐ์ดํฐ๋ฅผ ์ซ์ ๋ฐ์ดํฐ๋ก ๋ณํ
```sql
select
    to_number('123')
from dual;
```