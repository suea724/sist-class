# ๐ DML - INSERT, DELETE, UPDATE
### โ INSERT
- ํ์ด๋ธ์ ๋ฐ์ดํฐ๋ฅผ ์ถ๊ฐ(ํ ์ถ๊ฐ)ํ๋ ๋ช๋ น์ด
```sql
INSERT INTO ํ์ด๋ธ๋ช(์ปฌ๋ผ๋ฆฌ์คํธ) VALUES(๊ฐ๋ฆฌ์คํธ);
```
- ์์
```sql
-- ์ปฌ๋ผ๋ฆฌ์คํธ์ ๊ฐ๋ฆฌ์คํธ์ ์์์ ๊ฐ์๊ฐ ์ผ์นํด์ผ ํ๋ค.
insert into tblMemo(seq, name, memo, regdate) values(seqMemo.nextVal, 'ํ๊ธธ๋', '๋ฉ๋ชจ', sysdate);

-- null, default ์กฐ์
-- 1) null ์์ ๋ช์ > default ๋์ X
insert into tblMemo(seq, name, memo, regdate) values(seqMemo.nextVal, 'ํ๊ธธ๋', null, sysdate);

-- 2) ์ปฌ๋ผ ์๋ต > default ๋์ O
insert into tblMemo(seq, name) values(seqMemo.nextVal, 'ํ๊ธธ๋'); -- regdate์ sysdate(default๊ฐ) ์๋ ฅ

-- 3) default ์์ ๋ช์
insert into tblMemo(seq, name, memo, regdate) values(seqMemo.nextVal, default, '๋ฉ๋ชจ', sysdate);  -- name์ '์ต๋ช'(default๊ฐ) ์๋ ฅ

-- ์ปฌ๋ผ๋ฆฌ์คํธ ์๋ต ๊ฐ๋ฅ > ์๋ณธ ํ์ด๋ธ์ ์ปฌ๋ผ๋ฆฌ์คํธ์ ์์์ ๊ฐ์๊ฐ ๋์ผํ ๊ฒฝ์ฐ
insert into tblMemo values(seqMemo.nextVal, 'ํ๊ธธ๋', '๋ฉ๋ชจ', sysdate);

-- ํ์ด๋ธ ๋ณต์ฌ > subquery ์ฌ์ฉ
insert into tblMemoCopy select * from tblMemo;
```

<br>

### โ UPDATE
- ์ํ๋ ํ์ ์์ฑ ๊ฐ์ ์์ ํ๋ ๋ช๋ น์ด
```sql
UPDATE ํ์ด๋ธ๋ช SET ์ปฌ๋ผ๋ช = ๊ฐ [,์ปฌ๋ผ๋ช = ๊ฐ] [WHERE์ ]
```
- ์์
```SQL
-- ๋ํ๋ฏผ๊ตญ์ ์๋๋ฅผ ์ธ์ข์ผ๋ก ๋ณ๊ฒฝ
update tblCountry set capital = '์ธ์ข' where name = '๋ํ๋ฏผ๊ตญ';

-- ์ ์ธ๊ณ ์ธ๊ตฌ์ 10% ์ฆ๊ฐ
update tblCountry set population = population * 1.1;
```

<br>

### โ DELETE
- ์ํ๋ ํ์ ์ญ์ ํ๋ ๋ช๋ น์ด
```sql
DELETE FROM ํ์ด๋ธ๋ช [WHERE์ ]
```
- ์์
```SQL
-- basicpay 180~200๋ง์์ธ ์ฌ๋ ์ ๊ฑฐ
delete from tblInsa where basicpay between 1800000 and 2000000;
```


