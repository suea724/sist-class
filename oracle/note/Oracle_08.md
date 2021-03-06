# ๐ Subquery, ์๋ธ์ฟผ๋ฆฌ
- **SQL๋ฌธ ์์ ๋ค๋ฅธ SQL๋ฌธ์ด ์ค์ฒฉ๋ ์ฟผ๋ฆฌ**
- ๋ฐ์ดํฐ๊ฐ ๋ค๋์ผ ๋, ๋ฐ์ดํฐ๋ฅผ ๋ชจ๋ ํฉ์ณ ์ฐ์ฐํ๋ ์กฐ์ธ๋ณด๋ค ์๋ธ์ฟผ๋ฆฌ๋ฅผ ์ฌ์ฉํ๋ ๊ฒ์ด ์ฑ๋ฅ์ด ๋ ์ข๋ค.

<BR>

### โ WHERE์  ์๋ธ์ฟผ๋ฆฌ
- nested subquery
- **์กฐ๊ฑด์ ์์ ๋น๊ต๊ฐ์ผ๋ก ์ฌ์ฉ**ํ๋ค.
- ๋จ์ผ๊ฐ : =, >, <, >=, <=, <>
- ๋ค์ค๊ฐ : IN, NOT IN
```sql
-- ๋จ์ผ๊ฐ ๋ฐํ > ๋น๊ต ์ฐ์ฐ์ ์ฌ์ฉ
-- tblInsa ํ๊ท  ๊ธ์ฌ๋ณด๋ค ๋ง์ด ๋ฐ๋ ์ง์?
select * from tblInsa where basicpay > (select avg(basicpay) from tblInsa);

-- ๋ค์ค๊ฐ ๋ฐํ > IN ๋๋ NOT IN ์ฌ์ฉ
-- ๊ธ์ฌ๊ฐ 250๋ง์ ์ด์์ธ ์ฌ๋๋ค์ ๋ถ์์ ๊ฐ์ ๋ถ์์ ์ํ๋ ์ง์?
select * from tblInsa where buseo in (select buseo from tblInsa where basicpay > 2500000);
```

<BR>

### โ SELECT์  ์๋ธ์ฟผ๋ฆฌ
- scalar subquery
- ๋ฐ๋์ **๊ฒฐ๊ณผ๊ฐ์ด ๋จ์ผ ํ, ๋จ์ผ ์ด์ ๊ฐ**์ผ๋ก ๋ฐํ๋์ด์ผ ํ๋ค.
```SQL
select
    basicpay,
    (select round(avg(basicpay)) from tblInsa) as "ํ๊ท ๊ธ์ฌ"
from tblInsa;
```

<BR>

### โ FROM์  ์๋ธ์ฟผ๋ฆฌ
- inline view
- **๊ธฐ์กด ํ์ด๋ธ๋ก๋ถํฐ ์ผ์์ ์ผ๋ก ๋ง๋ค์ด์ง ๊ฐ์์ ํ์ด๋ธ**
```sql
-- ๋ชจ๋  ์ง์์ ์ด๋ฆ, ๋ถ์, ์ง์๋ฅผ ๊ฐ์ ธ์ค์์ค.
select * from (select name, buseo, jikwi from tblInsa);

-- ์ฃผ์!
-- ์๋ธ์ฟผ๋ฆฌ์์ ์ปฌ๋ผ์ alias ์ง์ ์, ๋ฐ๊นฅ์ชฝ ๋ฉ์ธ ์ฟผ๋ฆฌ์์ alias๋ก ์ ๊ทผ
select name, buseo, position from (select name, buseo, jikwi as position from tblInsa);

-- ์๋ธ ์ฟผ๋ฆฌ์์ ํจ์๋ฅผ ์ฌ์ฉํ๋ฉด alias๋ฅผ ๋ถ์ฌ์ค์ผ ํ๋ค.
select name, length(name), len from (select name, length(name) as len from tblInsa);
```