# π PL/SQL
- Procedural Language/Structured Query Language
- κΈ°μ‘΄μ ANSI-SQLμ μ μ°¨μ§ν₯ μΈμ΄μ κΈ°λ₯(μ μ΄)μ μΆκ°ν SQL

### β ANSI-SQL
- λΉμ μ°¨μ§ν₯ μΈμ΄λ‘ λ¬Έμ₯μ μμκ° μκ³  μ°μμ μ΄μ§ μλ€.
- λ¬Έμ₯ λ¨μ κ΅¬μ‘°

<br>

### β νλ‘μμ , Procedure
- μμ μμκ° μ ν΄μ§ λλ¦½λ νλ‘κ·Έλ¨μ μν λ¨μ
- PL/SQLμ νλ‘κ·Έλ¨ λ‘μ§μ νλ‘μμ λ‘ κ΅¬ννμ¬ κ°μ²΄ ννλ‘ μ¬μ©νλ€.
- PL/SQL λͺλ Ήμ΄λ λ°λμ νλ‘μμ  λ΄μμλ§ μμ± λ° λμμ΄ κ°λ₯νλ€.
- **μ΅λͺ νλ‘μμ **
    - 1νμ© μ½λ μμ±μ©
- **μ μ₯ νλ‘μμ **
    - μ¬μ¬μ© κ°λ₯ 
    - λ°μ΄ν°λ² μ΄μ€μ μ΄λ¦μ κ°μ§ κ°μ²΄λ‘ μ μ₯λλ€.

<br>

### β νλ‘μμ  λΈλ­ κ΅¬μ‘°
```SQL
declare 
    num number;
    name varchar2(20);
    today date;
begin
    num := 10;
    dbms_output.put_line(num);
    
    name := 'νκΈΈλ';
    dbms_output.put_line(name);
    
    today := sysdate;
    dbms_output.put_line(today);

exception
    -- when μμΈμμ then
    when others then
        dbms_output.put_line('μμΈ μ²λ¦¬');
end;
```
#### 1οΈβ£ DECLARE
- μ μΈλΆ
- νλ‘μμ μμ μ¬μ©ν  λ³μ, κ°μ²΄ λ±μ μ μΈνλ μμ­
- `λ³μλͺ μλ£ν [NOT NULL] [DEFAULT κ°]`
#### 2οΈβ£ BEGIN ~ END
- κ΅¬νλΆ
- κ΅¬νλ μ½λλ₯Ό μμ±νλ μμ­ (λ©μλμ body)
- μλ΅ λΆκ°λ₯
#### 3οΈβ£ EXCEPTION
- μμΈ μ²λ¦¬λΆ
- μ€ν λΆμμ λ°μνλ μμΈλ₯Ό μ²λ¦¬νλ λΈλ­(catch)
- μλ΅ κ°λ₯

<BR>

### β SELECT INTO μ 
``` SQL
declare
    vname varchar2(15);
    vbuseo varchar2(15);
    vjikwi varchar2(15);
begin
    -- vname := (select name from tblInsa where num = 1001);
    select name into vname from tblInsa where num = 1001;
    select name, buseo, jikwi into vname, vbuseo, vjikwi from tblInsa where num = 1001;
    dbms_output.put_line(vname);
end;
```
- λ³μμ SELECT κ²°κ³Όκ°μ λ΄μ μ μλ€.
- PL/SQL λΈλ­ μμλ μ λλ‘ μΌλ° SELECTλ¬Έμ μμ±ν  μ μκ³ , SELECT INTO μ μ μ¬μ©ν΄μΌ νλ€.
- λ³μμ κ°μ λ£μ λ μ»¬λΌμ κ°μ, μμ, μλ£νμ΄ λ³μμ κ°μ, μμ, μλ£νκ³Ό μΌμΉν΄μΌ νλ€.

<BR>

### β νμ μ°Έμ‘°
```sql
declare
    vbuseo tblInsa.buseo%type;
    vrow tblInsa%rowtype;
begin
    select buseo into vbuseo from tblInsa where num = 1001;
    select * into vrow from tblInsa where num = 1001; -- μμΌλ μΉ΄λ μ¬μ©

    dbms_output.put_line(vbuseo);
    dbms_output.put_line(vrow.num);
    dbms_output.put_line(vrow.name);
    dbms_output.put_line(vrow.ssn);
    dbms_output.put_line(vrow.buseo);
    dbms_output.put_line(vrow.basicpay);
end;
```
- λ³μ μ μΈ μ μ¬μ©νλ€.
- μλ³Έ νμ΄λΈμ μ»¬λΌμ΄ λ³κ²½λλ©΄ λ°μλλ€.
- **%type**
    - μ»¬λΌ 1κ°μ μλ£ν, κΈΈμ΄ μ°Έμ‘°
    - μ¬μ©νλ νμ΄λΈμ νΉμ  μ»¬λΌμ μ€ν€λ§λ₯Ό λ³μμ μ μ©νλ€.
- **%rowtype**
    - ν μ μ²΄ μ°Έμ‘°(λͺ¨λ  μ»¬λΌ μ°Έμ‘°)

<br>

### β μ μ΄λ¬Έ
#### π μ‘°κ±΄λ¬Έ
- if-elsif-elseλ¬Έ
```sql
declare
    vnum number := 0;
begin
    if vnum > 0 then
        dbms_output.put_line('μμ');
    elsif vnum < 0 then
        dbms_output.put_line('μμ');
    else
        dbms_output.put_line('0');
    end if;
end;
```
- caseλ¬Έ
```sql
declare
    vcontinent tblCountry.continent%type;
    vresult varchar2(30);
begin
    -- caseλ¬Έ (λ€μ€ ifλ¬Έκ³Ό λΉμ·)
    case
        when vcontinent = 'AS' then vresult := 'μμμ';
        when vcontinent = 'EU' then vresult := 'μ λ½';
        when vcontinent = 'AF' then vresult := 'μνλ¦¬μΉ΄';
        else vresult := 'κΈ°ν';
    end case;
    
    dbms_output.put_line(vresult);
    
    
    -- caseλ¬Έ (μλ°μ switchλ¬Έκ³Ό λΉμ·) 
    case vcontinent
        when 'AS' then vresult := 'μμμ';
        when 'EU' then vresult := 'μ λ½';
        when 'AF' then vresult := 'μνλ¦¬μΉ΄';
        else vresult := 'κΈ°ν';
    end case;
    
    dbms_output.put_line(vresult);
    
end;
```

#### π λ°λ³΅λ¬Έ
- loop : λ¨μ λ°λ³΅
```sql
declare
    vnum number := 1;
begin
    loop
        dbms_output.put_line(to_char(sysdate, 'hh24:mi:ss'));
        vnum := vnum + 1;
        exit when vnum > 10; -- μ‘°κ±΄ λ§μ‘± μ Loop νμΆ
    end loop;
end;
```
- for loop : νμ λ°λ³΅
```sql
begin
    for i in 1..10 loop
        dbms_output.put_line(i);
    end loop;
end;
```
- while loop : μ‘°κ±΄ λ°λ³΅
```sql
declare
    vnum number := 1;
begin
    while vnum <= 10 loop
        dbms_output.put_line(vnum);
        vnum := vnum + 1;
    end loop;
end;
```

<br>

### β CURSOR
- SQLλ¬Έμ μ€ν κ²°κ³Όμ λ μ½λκ° Nκ°μΌ λ μ¬μ©
- loop μ¬μ©
```SQL
declare
    cursor vcursor is select name from tblInsa; -- μ»€μ μ μΈ
    vname tblInsa.name%type; -- λ³μ μ μΈ
begin
    open vcursor; -- μ»€μ μ΄κΈ°
        loop
            fetch vcursor into vname; -- ν νμ© λ³μμ λμ
            exit when vcursor%notfound; -- νμ΄ μ‘΄μ¬νμ§ μμ λ LOOP νμΆ
            dbms_output.put_line(vname);
        end loop;
    close vcursor; -- μ»€μ λ«κΈ°
end;
```
- forloop μ¬μ©
```sql
declare
    cursor vcursor is select * from tblInsa;
begin
    for vrow in vcursor loop -- loop + fetch into + vrow μ μΈ + exit when
        dbms_output.put_line(vrow.name);
    end loop;
end;
```

<br>

### β μ μ₯ νλ‘μμ , Stored Procedure
```sql
-- 1. μ μ₯ νλ‘μμ  μ μΈ
create or replace procedure procTest
is
    vnum number;
begin
    vnum := 100;
    dbms_output.put_line(vnum);
end;

-- 2. μ μ₯ νλ‘μμ  νΈμΆ
begin -- μ΅λͺ λΈλ­ νμ
    procTest; -- νλ‘μμ  μ€ν(νΈμΆ)
end;
```
- μ€λΌν΄ μλ²μ μ»΄νμΌ λ νλ‘μμ κ° μ μ₯λ¨
- μ μ₯λμ΄ μλ νλ‘μμ λ₯Ό νΈμΆ μ, κ΅¬λ¬Έ λΆμ λ° μ»΄νμΌ μμμ μλ΅ν  μ μκΈ° λλ¬Έμ λΉμ©μ΄ μ κ°λλ€.
- μ²«λ²μ§Έ μ€ν λΉμ© > μ¬μ€ν λΉμ©

<br>

#### π λ§€κ°λ³μκ° μλ νλ‘μμ 
- μ«μν λ§€κ°λ³μ
```sql
create or replace procedure procTest(
    width number,
    height number
)
is
    vresult number;
begin
    vresult := width * height;
    dbms_output.put_line(vresult);
end procTest;
begin
    procTest(10, 20); -- 200
end;
```
- λ¬Έμν λ§€κ°λ³μ
    - νλ‘μμ μ λ§€κ°λ³μμλ κΈΈμ΄μ not nullμ ννν  μ μλ€.
```sql
create or replace procedure procTest(
    name varchar2
)
is
begin
    dbms_output.put_line('μλνμΈμ. ' || name || 'λ');
end procTest;


begin
    procTest('νκΈΈλ');
end;
```

<br>

#### π λ§€κ°λ³μ λͺ¨λ
- λ§€κ°λ³μκ° κ°μ μ λ¬νλ λ°©μ
- **inλͺ¨λ(κΈ°λ³Έ)** : νλ‘μμ  λ΄λΆμμ μ¬μ©νκΈ° μν λ³μ
- **out λͺ¨λ** : νλ‘μμ  μΈλΆλ‘ λ°ννκΈ° μν λ³μ
- **λ¨μΌκ°**μ λ°ννλ Out νλΌλ―Έν°
```sql
create or replace procedure procTest (
    pnum1 in number,
    pnum2 in number,
    presult1 out number, -- λ³μ μμ²΄λ₯Ό λ§€κ°λ³μλ‘ λ°μ > μ£Όμκ°μ λ°μμ΄ > λ°νκ° μ­ν 
    presult2 out number,
    presult3 out number
)
is
begin
    presult1 := pnum1 + pnum2;
    presult2 := pnum1 - pnum2;
    presult3 := pnum1 * pnum2;
    dbms_output.put_line('νλ‘μμ  μ€ν μλ£');
end;


declare
    vresult1 number;
    vresult2 number;
    vresult3 number;
begin
    procTest(10, 20, vresult1, vresult2, vresult3);
    dbms_output.put_line(vresult1);
    dbms_output.put_line(vresult2);
    dbms_output.put_line(vresult3);
end;
```
- **λ€μ€κ°**μ λ°ννλ Out νλΌλ―Έν° > cursor μ¬μ©
```sql
create or replace procedure procBuseo(
    pbuseo in varchar2,
    pcursor out sys_refcursor -- μ»€μλ₯Ό λ°νκ°μΌλ‘ μ¬μ©ν  λ μλ£ν
)
is
begin
    open pcursor 
    for
    select * from tblInsa where buseo = pbuseo; -- μ»€μ μ μ
end procBuseo;

declare
    vcursor sys_refcursor; -- μ»€μ μ°Έμ‘° λ³μ
    vrow tblInsa%rowtype;
begin
    procBuseo('μμλΆ', vcursor);
    loop
        fetch vcursor into vrow;
        exit when vcursor%notfound;
        dbms_output.put_line(vrow.name);
    end loop;
end;
```

<br>

### β μ μ₯ ν¨μ, Stored Function
```sql
-- λ μμ ν© λ°ννλ μ μ₯ ν¨μ
-- 1. μ μΈ
create or replace function fnSum (
    pnum1 in number,
    pnum2 in number    
) return number
is
begin
    return pnum1 + pnum2;
end fnSum;

-- 2. νΈμΆ
declare
    vresult number;
begin
    vresult := fnSum(10, 20);
    dbms_output.put_line(vresult);
end;
```
- μ μ₯ νλ‘μμ μ μ μ¬νλ€.
- **λ°νκ°μ΄ λ°λμ μ‘΄μ¬**νλ€. (out νλΌλ―Έν°κ° μλ return λ¬Έ μ¬μ©)
- μ£Όλ‘ ANSI-SQLμμ λ°λ³΅λλ μμμ μ€μ΄κΈ° μν΄ μ¬μ©νλ€. β­
- νλ‘μμ (PL/SQL) vs ν¨μ(ANSI-SQL)

<br>

#### π ν¨μ μ¬μ© vs λ―Έμ¬μ©
```sql
-- μ΄λ¦, λΆμ, μ§μ, μ±λ³(λ¨μ, μ¬μ)

create or replace function fnGender(
    pssn varchar2
) return varchar2
is 
begin
    return case
        when substr(pssn, 8,1) = '1' then 'λ¨μ'
        when substr(pssn, 8,1) = '2' then 'μ¬μ'
    end;
end;

-- ν¨μ λ―Έμ¬μ©
    -- μμ° κ³ λΉμ©
    -- νΈμΆ κ³ λΉμ©
    -- κ°λ°μ κ°λμ± + μ‘°μμ± μ ν > μ μ§λ³΄μμ± μ ν
    -- νμμ bad
select
    name, buseo, jikwi,
    case
        when substr(ssn, 8,1) = '1' then 'λ¨μ'
        when substr(ssn, 8,1) = '2' then 'μ¬μ'
    end
from tblInsa;


-- ν¨μ μ¬μ©
    -- μμ° μ λΉμ©
    -- νΈμΆ μ λΉμ©
    -- κ°λ°μ κ°λμ± + μ‘°μμ± ν₯μ > μ μ§λ³΄μμ± ν₯μ
    -- νμμ good
select
    name, buseo, jikwi,fnGender(ssn)
from tblInsa;
```

<br>

### β νΈλ¦¬κ±°, Trigger
```sql
create or replace trigger νΈλ¦¬κ±°λͺ
    before|after
    insert|update|delete on νμ΄λΈλͺ
    [for each row]
declare
    μ μΈλΆ;
begin
    μ€νλΆ;
exception
    μμΈμ²λ¦¬λΆ;
end;
```
- νλ‘μμ μ ν μ’λ₯λ‘, λ―Έλ¦¬ μ§μ ν μ΄λ²€νΈ λ°μ μ μλμΌλ‘ μ€νλλ€.
- νΉμ  νμ΄λΈμμ **insert, update λλ delete λ°μ μ, μ§μ ν νΈλ¦¬κ±°κ° μ€ν**λλ€. (μ€λΌν΄μ΄ νΉμ  νμ΄λΈμ κ°μ
- **λΆνκ° λ°μ**νλ€λ λ¨μ μ΄ μλ€.
- νΉμ  νμ΄λΈμ μ¬λ¬ κ°μ νΈλ¦¬κ±°κ° μ μ©λμ΄ μμΌλ©΄ κ΄λ¦¬κ° μ΄λ €μ°λ―λ‘ μ¬μ©νμ§ μλ νΈλ¦¬κ±°λ μ­μ ν΄μ£Όλ κ²μ΄ μ’λ€.

<br>

#### π before νΈλ¦¬κ±°
- **νΈλ¦¬κ±° μ€ν ν, μΏΌλ¦¬κ° μ€ν**λλ€.
- μΏΌλ¦¬λ₯Ό μ¬μ μ κ²μ¬νμ¬ μ‘°κ±΄μ λ°λΌ μΏΌλ¦¬ μ€ν μ λ¬΄λ₯Ό ν΅μ ν  μ μλ€.
```sql
create or replace trigger trgInsa
    before delete on tblInsa
begin
    -- μμμΌμλ ν΄μ¬κ° λΆκ°λ₯
    if to_char(sysdate, 'dy') = 'μ' then
    
        -- νμ¬ μ§ννλ €λ μλ¬΄ (delete μ€ν μ ) > μ·¨μ > κ°μ λ‘ μμΈ λ°μ
        -- throw new Exception()
        -- -20000 ~ -29999
        raise_application_error(-20001, 'μμμΌμλ ν΄μ¬κ° λΆκ°λ₯ν©λλ€.');
    end if;
end;

delete from tblInsa where num = 1005;
```

<br>

#### π after νΈλ¦¬κ±°
- **μΏΌλ¦¬ μ€ν ν, νΈλ¦¬κ±°κ° μ€ν**λλ€.
- μ£Όλ‘ νμ²λ¦¬ μμ μ μ¬μ©λλ€. e.g. λ‘κ·Έ
```sql
-- μΏΌλ¦¬λ¬Έ μ€νν  λλ§λ€ λ‘κ·Έ νμ΄λΈμ κΈ°λ‘
create or replace trigger trgLogMan
    after
    insert or update or delete -- μΈ κ°μ§ μ‘°μμ λν νΈλ¦¬κ±°
    on tblMan
declare
    vmessage varchar2(1000);
begin
    -- insert or update or delete κ΅¬λΆ
    if inserting then 
        vmessage := 'μλ‘μ΄ ν­λͺ©μ΄ μΆκ°λμμ΅λλ€.';
    elsif updating then
        vmessage := 'μλ‘μ΄ ν­λͺ©μ΄ μμ λμμ΅λλ€.';
    elsif deleting then
        vmessage := 'κΈ°μ‘΄ ν­λͺ©μ΄ μ­μ λμμ΅λλ€.';
    end if;
    
    insert into tblLogMan values (seqLogMan.nextVal, vmessage, default);
end;

insert into tblMan values ('νμ€νΈ', 22, 175, 60, null);
update tblMan set weight = 65 where name = 'νμ€νΈ';
delete from tblMan where name = 'νμ€νΈ';
```

<br>

#### π for each now
- νΈλ¦¬κ±°μ μ΅μ
- **μ¬μ©νμ§ μμ κ²½μ°**
    - λ¬Έμ₯(Query) λ¨μ νΈλ¦¬κ±°
    - μ¬κ±΄μ΄ μ μ©λλ λ μ½λμ κ°μμ μκ΄μμ΄ νΈλ¦¬κ±°λ 1ν νΈμΆλλ€.
    - μ μ©λ λ μ½λμ μ λ³΄κ° μ€μνμ§ μμ κ²½μ° (μ¬κ±΄ μμ²΄κ° μ€μ)
- **μ¬μ©νλ κ²½μ°**
    - ν(Record) λ¨μ νΈλ¦¬κ±°
    - μ¬κ±΄μ΄ μ μ©λλ λ μ½λμ κ°μλ§νΌ νΈλ¦¬κ±°κ° λ°λ³΅ νΈμΆλλ€.
    - μ μ©λ λ μ½λμ μ λ³΄κ° μ€μν κ²½μ°
- **μκ΄ κ΄κ³(:old, :new)λ₯Ό μ¬μ©**νλ€. > μΌμ’μ κ°μ λ μ½λ
    - insert > :new (λ°©κΈ μΆκ°λ ν μ°Έμ‘°)
    - update > :old (μμ λκΈ° μ  ν μ°Έμ‘°), :new (μμ λ ν ν μ°Έμ‘°)
    - delete > :old (μ­μ λκΈ° μ  ν μ°Έμ‘°)
```sql
-- update νΈλ¦¬κ±° μκ΄ κ΄κ³ μ¬μ©
create or replace trigger trgMan
    after update on tblMan for each row
begin
    dbms_output.put_line('λ μ½λλ₯Ό μμ νμ΅λλ€. - ' || :old.name);
    dbms_output.put_line('μμ νκΈ° μ  λμ΄ - ' || :old.age);
    dbms_output.put_line('μμ ν ν λμ΄ - ' || :new.age);
end;

update tblMan set age = age + 1 where couple is not null;


-- μ§μ ν΄μ¬ μ  λ΄λΉ νλ‘μ νΈ μλ μμ
create or replace trigger trgDeleteStaff
    before delete on tblStaff for each row -- μ§μ νμ΄λΈμμ ν΄μ¬ μ μ ν΄λΉ μ§μ μ λ³΄
begin
    update tblProject set
        staff_seq = 4
            where staff_seq = :old.seq; -- μ­μ λλ μ§μμ seqκ°
end;

delete from tblStaff where seq = 2;
```







