# ๐ View, ๋ทฐ
- ์ค์  ํ์ด๋ธ์ฒ๋ผ ์ฌ์ฉํ  ์ ์๋ **๊ฐ์์ ํ์ด๋ธ**๋ก, ๋ฐ์ดํฐ๋ฒ ์ด์ค ๊ฐ์ฒด ์ค ํ๋ (DDL ์ฌ์ฉ)
- **์ฟผ๋ฆฌ์ ์์ ์ค์ด๊ธฐ ์ํด ์ฌ์ฉ**ํ๋ค. <br>โ ๋ฐ๋ณต๋ SELECT ๋๋ ๊ธด SELECT์ ์ฌ์ฉ
- ๋ทฐ๋ **์ฟผ๋ฆฌ๋ฌธ(SQL)์ ์ ์ฅํ ๊ฐ์ฒด**์ด๋ค. (๋ฐ์ดํฐ ์ ์ฅ X) <br> โ ์๋ณธ ํ์ด๋ธ์ ๋ณ๊ฒฝ ๋ฐ์ ์ ๋ฐ์๋จ
- ๋ทฐ๋ **์ฝ๊ธฐ ์ ์ฉ ํ์ด๋ธ**๋ก SELECT ์ธ ๋ค๋ฅธ DML์ ์ฌ์ฉํ์ง ์๋๋ค.

<br>

### โ ๋ทฐ ์์ฑ ๋๋ ์์ 
```sql
CREATE (OR REPLACE) VIEW ๋ทฐ ์ด๋ฆ
AS
SELECT ๋ฌธ;
```

<br>

- ๋ทฐ ์์ฑ
```SQL
create view vwInsa
as
select * from tblInsa;
```

<br>

- ๋ทฐ ์์ 
```sql
create or replace view vwInsa
as
select * from tblInsa where buseo = '์์๋ถ';

select * from vwInsa;
```


<br>

### โ ๋ทฐ ์ญ์ 
```sql
DROP VIEW ๋ทฐ ์ด๋ฆ;
```

<br>

### โ ๋ทฐ ํ์ฉ

- ๋ณต์กํ ์ฟผ๋ฆฌ์ ์ฌ์ฉ
```sql
-- ๋ชจ๋  ํ์์ ๋ฐ๋ฉ ์ฌ๋ถ๋ฅผ ํ์ธํ  ์ ์๋ ๋ทฐ ์์ฑ
create or replace view "๋์ฌ ์ฒดํฌ"
as
select
    m.name as mname,
    v.name as vname,
    to_char(r.rentdate, 'yyyy-mm-dd') as rentdate,
    case
        when r.retdate is not null then '์๋ฃ'
        else '๋ฏธ์๋ฃ'
    end as state
from tblRent r
    inner join tblVideo v
        on v.seq = r.video
            inner join tblMember m
                on m.seq = r.member;

select * from "๋์ฌ ์ฒดํฌ";
```

<br>

- ๊ณ์ ๋ณ๋ก ๊ฐ์ฒด์ ๋ํด ์ ๊ทผ/์กฐ์์ ํต์ 
```sql
create or replace view ์ ์์ ์ฉ
as
select num, name, ssn, city from tblInsa;

select * from tblInsa;   -- ์ ์. tblInsa ์ ๊ทผ ๊ถํ X
select * from ์ ์์ ์ฉ;  -- ์ ์. view ์ ๊ทผ ๊ถํ O
```