# ๐ ROWNUM
- ํ๋ฒํธ๋ฅผ ๋ํ๋ด๋ ์์ฌ ์ปฌ๋ผ(Pseudo Column)
- **from์ ์ด ์คํ๋  ๋ ๊ฐ ๋ ์ฝ๋์ rownum์ ํ ๋น**ํ๋ค. 
- **where์ ์ ์ํฅ์ ๋ฐ์ reindexing**์ ํ๋ค.
- rownum ์ฌ์ฉ ์ **์๋ธ ์ฟผ๋ฆฌ๋ฅผ ์์ฃผ ์ฌ์ฉ**ํ๋ค.

<br>

### โ ํ์ฉ
- rownum์ ํ์ฉํ ๊ฒฐ๊ณผ๋ **rownum = 1์ธ ํ์ ํฌํจ**ํด์ผ ํ๊ณ , **์์ฐจ์ **์ผ๋ก ๊ฐ์ ธ์์ผ ํ๋ค.
```sql
select name, buseo, rownum from tblInsa where rownum = 1;
-- select name, buseo, rownum from tblInsa where rownum = 10; -- ๊ฒฐ๊ณผX

select name, buseo, rownum from tblInsa where rownum <= 5;
-- select name, buseo, rownum from tblInsa where rownum > 5; -- ๊ฒฐ๊ณผX
```

<br>

### โ ์ฟผ๋ฆฌ๋ฌธ ์คํ ์์
```sql
select rownum, custid, name, phone
from Customer
where rownum <= 2
order by name;
```
1. **from Customer** : ํ์ด๋ธ์ ์ฝ์ด๋ค์ (rownum ์์ฑ)
2. **where rownum <= 2** : ๋ ์ฝ๋ ๋ ๊ฐ ์ ํ (rownum ์กฐ๊ฑด)
3. **select rownum, custid, name, phone** : ์ปฌ๋ผ ์ ํ (rownum ์๋น)
4. **order by name** : ์ด๋ฆ ์ ์ ๋ ฌ
- **์ฃผ์ โ** : <u>์ปฌ๋ผ์ ์ ํ ํ ์ ๋ ฌ</u>ํ๋ค. > ์ ๋ ฌ๋ ํ์ด๋ธ์์ ํํ์ ๊ฐ์ ธ์ค๋ ๊ฒ์ด ์๋!

<br>

### โ ์ ๋ ฌ ํ rownum ์์ฑ
- rownum์ ์ ๋ ฌ ํ ์ํ๋ ํ์ ๊ฐ์ ธ์ค๊ธฐ ์ํด์๋ **์๋ธ์ฟผ๋ฆฌ๋ฅผ ์ฌ์ฉ**ํด์ผ ํ๋ค.
```sql
-- basicpay๋ฅผ ๋ด๋ฆผ์ฐจ์์ผ๋ก ์ ๋ ฌํ ํ์ด๋ธ์ 3๋ฒ์งธ ~ 5๋ฒ์งธ ํ
select
    name, buseo, basicpay, rnum, rownum
from (select -- rownum์ ๊ณ ์ ์ํค๊ธฐ ์ํด ์ฌ์ฉํ ์๋ธ์ฟผ๋ฆฌ
         a.*, rownum as rnum -- rownum์ alias ํ์
      from (
         select 
            name, buseo, basicpay
         from tblInsa
         order by basicpay desc
    ) a)
where rnum between 3 and 5;
```

<br>

- ์์ฃผ ์ฌ์ฉํ๋ ์ฟผ๋ฆฌ๋ **๋ทฐ**๋ก ๋ง๋ค์ด์ ํ์ฉํ  ์ ์๋ค.
```sql
create or replace view vwAddressBook
as
select a.*, rownum as rnum from (select * from tblAddressBook order by name asc) a;


select * from vwAddressBook 
    where rnum between 31 and 40;
```