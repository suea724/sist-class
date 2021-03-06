# π DML - SELECT
- κ΄κ³λμ μ°μ° μ€ μλ μ μμμ κ΅¬νν λͺλ Ήμ΄
- λμ νμ΄λΈλ‘λΆν° **μνλ ν(νν)μ μΆμΆ**νλ μμ
```sql
-- λ¨μΌ μ»¬λΌ
select name from tblCountry;

-- μ¬λ¬ μ»¬λΌ > νλ‘μ μ
select name, capital from tblCountry;

-- λͺ¨λ  μ»¬λΌ > μμΌλ μΉ΄λ μ¬μ©
select * from tblCountry;
```
<BR>

### β WHERE μ  μ‘°κ±΄ κ²μ
#### π between
- λ²μ μ‘°κ±΄
- `μ»¬λΌλͺ between μ΅μκ° and μ΅λκ°`
- μ‘°κ±΄μ andλ‘ λ¬Άλ κ²λ³΄λ€ κ°λμ±μ΄ λμ§λ§, λΉκ΅μ  μλκ° λλ¦¬λ€λ λ¨μ μ΄ μλ€.
```sql
-- 1. μ«μν
select * from tblComedian where weight between 60 and 70;

-- 2. λ¬Έμν > λ¬Έμ μ½λ λΉκ΅
select * from tblInsa where name between 'λ°' and 'μ ';
 
-- 3. λ μ§ν
select * from tblInsa where ibsadate between '2010-01-01' and '2020-12-31';
```

<br>

#### π in
- μ΄κ±°ν μ‘°κ±΄
- `μ»¬λΌλͺ in (κ°, κ°, κ°, ...)`
- μ μλ κ°λ€ μ€ νλμ μΌμΉνλ©΄ λ§μ‘±
- orλ‘ μ‘°κ±΄μ μ°κ²°νλ κ²λ³΄λ€ κ°νΈνκ³  κ°λμ±μ΄ λλ€.
```sql
select * from tblInsa where buseo in ('νλ³΄λΆ', 'κ°λ°λΆ', 'μ΄λ¬΄λΆ');
```

<br>

#### π like
- ν¨ν΄ λΉκ΅
- `μ»¬λΌλͺ like 'ν¨ν΄ λ¬Έμμ΄'`
```sql
-- 1. _ : μμμ λ¬Έμ 1κ°
select name from tblInsa where name like 'κΉ__'; -- κΉμ¨ μ§μ

-- 2. % : μμμ λ¬Έμ Nκ° ( 0 ~ λ¬΄νλ ) 
select * from employees where first_name like 'S%'; -- Sλ‘ μμνλ μ΄λ¦μ κ°μ§ μ§μ
select * from tblInsa where SSN like '%-2%'; -- μ¬μ μ§μ
```

<br>

#### π is, is not
- RDBMSμμμ NULLμ μ°μ°μ λμμ΄ λ  μ μμ (μ°μ°μ μ¬μ© λΆκ°)
- nullκ° μ¬λΆ μ‘°κ±΄ μ μ©μ μ¬μ©
- `μ»¬λΌλͺ is null`

```sql
-- μΈκ΅¬μκ° κΈ°μ¬λμ§ μμ λλΌ
select * from tblCountry where population is null;

-- μ°λ½μ²κ° κΈ°μ¬λμ΄ μλ μ§μ
select * from tblInsa where tel is not null;
```

<BR>

# π μ»¬λΌ μ°μ°
### β distinct
- μ»¬λΌ λ¦¬μ€νΈμμ μ¬μ©
- **νμ μ€λ³΅κ° μ κ±°**
```sql
-- λλ₯μ μ’λ₯
select distinct continent from tblCountry;
```

<br>

### β case
- **μ‘°κ±΄μ μ μ©**νμ¬ μ»¬λΌκ°μ μ‘°μν  λ μ¬μ©
- λͺ¨λ  μ‘°κ±΄μ λΆμΌμΉνλ©΄ null λ°ν β­
- `case when μ‘°κ±΄ then κ²°κ³Ό end`
- λ€μ€ μ‘°κ±΄ μ€μ  κ°λ₯
```sql
-- mμ΄λ©΄ λ¨μ, fμ΄λ©΄ μ¬μ μΆλ ₯
select
    last || first as name,
    case
        when gender = 'f' then 'μ¬μ'
        when gender = 'm' then 'λ¨μ'
    end as gender
from tblComedian;
```

<br>

# π ORDER BY
- λ μ½λ μ λ ¬μ μ¬μ©
- `order by μ λ ¬ν  κΈ°μ€ μ»¬λΌλͺ [asc|desc], [μ»¬λΌλͺ [asc|desc]]`
- λ€μ€ μ λ ¬ μ§μ : μμ κΈ°μ€μ λμμ λ§μ‘± μ λ€μ μ‘°κ±΄μΌλ‘ μ λ ¬


<br>

### β νμ© 
- **κΈ°λ³Έ μλ£ν μ»¬λΌ**μ κΈ°μ€μΌλ‘ μ λ ¬
```sql
-- λ¬Έμμ΄ μ λ ¬
select * from tblCountry order by name asc;
select * from tblCountry order by name desc;

-- μ«μ μ λ ¬
select * from tblCountry order by area asc;
select * from tblInsa order by basicpay;

-- λ μ§ μ λ ¬
select * from tblInsa order by ibsadate; 
```
- **μμλ‘ μ λ ¬ κΈ°μ€μ μ€μ ** > caseλ¬Έ νμ©
```sql
-- μ§μ μ λ ¬
select
    name, jikwi,
    case
        when jikwi = 'λΆμ₯' then 4
        when jikwi = 'κ³Όμ₯' then 3
        when jikwi = 'λλ¦¬' then 2
        when jikwi = 'μ¬μ' then 1
    end jikwiseq
from tblInsa
order by jikwiseq desc;
```

<br>

# π GROUP BY
- `GROUP BY μ»¬λΌλͺ [, μ»¬λΌλͺ]`
- λ μ½λλ€μ νΉμ  μμ±κ°μΌλ‘ κ·Έλ£Ήμ λ§λ λ€.
- λλμ΄μ§ κ°κ°μ κ·Έλ£Ήμ λν΄ **μ§κ³ ν¨μ(SUM, AVG, MIN, MAX, COUNT)λ₯Ό μ¬μ©**νκΈ° μν΄ μ¬μ© β­
- SELECTμ μλ **GROUP BYμμ μ μ©ν μ»¬λΌκ³Ό μ§κ³ ν¨μ**λ§ λμ¬ μ μλ€.
```SQL
-- λΆμλ³λ‘ λΆμλͺκ³Ό νκ· κΈμ¬λ₯Ό κ°μ Έμ€μμ€.
select
    buseo,
    round(avg(basicpay)) as "λΆμλ³ νκ· κΈμ¬" 
from tblInsa
     group by buseo;
```



<BR>

### β HAVING
- GROUP BYμ μ μ‘°κ±΄μ  μ­ν μ νλ€.
- **λ°λμ GROUP BYμ κ°μ΄ μ¬μ©**νλ€. (λ¨λ μ¬μ© X)
```SQL
-- νκ·  κΈμ¬κ° 150λ§μμ΄ λλ λΆμμ μ΄λ¦κ³Ό νκ·  κΈμ¬λ₯Ό κ°μ Έμ€μμ€.
select                                 
    buseo,
    round(avg(basicpay))
from tblInsa                            
    group by buseo  
    having avg(basicpay) >= 1500000; 
```

<BR>

# π μ€ν μμ β­
1. **FROM** νμ΄λΈ
2. **WHERE** μ‘°κ±΄
3. **GROUP BY** κΈ°μ€
4. **HAVING** μ‘°κ±΄
5. **SELECT** μ»¬λΌλ¦¬μ€νΈ
6. **ORDER BY** κΈ°μ€
