# π Statement
- JDBCμμ μ κ³΅λλ ν΄λμ€λ‘, μλ°μμ μμ±ν SQLλ¬Έμ μ€λΌν΄ μλ²μμ μ€ννλ μ­ν μ νλ€.
- executeUpdtate() μ€ν μ 0 λλ 1μ, executeQuery() μ€ν μ ResultSetμ λ°ννλ€.
- executeXXX() μ¬μ© μ Autocommitμ΄ μλ°λλ€.
### β Statement
- μ μ  μΏΌλ¦¬λ₯Ό μμ±ν  λ μ¬μ©νλ€.
#### π executeUpdate()
```java
// insert, delete, update, DDL μν μ μ¬μ©
// SQL μμ±
String sql = "insert into tblAddress values (seqAddress.nextVal, 'μλ¬΄κ°', 25, 'm', '010-5555-5555', 'μμΈμ κ°λ¨κ΅¬ λμΉλ', default)";

// μ°κ²° κ°μ²΄λ‘λΆν° Statement κ°μ²΄ κ°μ Έμ€κΈ°
Statement stmt = conn.createStatement();

// μΏΌλ¦¬ μ€ν
int result = stmt.executeUpdate(sql);

if (result == 1) {
    System.out.println("λ±λ‘ μ±κ³΅");
} else {
    System.out.println("λ±λ‘ μ€ν¨");
}

// μμ ν΄μ 
stmt.close();
```
<br>

#### π executeQuery()
- κ²°κ³Ό λ μ½λκ° νμ€μΌλ
```java
Statement stmt = conn.createStatement();

String sql = "select name, age, tel, address from tblAddress where seq = 22";

// ResultSet λ°ν
ResultSet rs = stmt.executeQuery(sql);

if (rs.next()) {
    System.out.println("μ΄λ¦ : " + rs.getString("name"));
    System.out.println("λμ΄ : " + rs.getString("age"));
    System.out.println("μ νλ²νΈ : " + rs.getString("tel"));
    System.out.println("μ£Όμ : " + rs.getString("address"));
} else {
    System.out.println("λ°μ΄ν°κ° μμ΅λλ€.");
}

rs.close();
stmt.close();
conn.close();
```

<br>

- κ²°κ³Ό λ μ½λκ° μ¬λ¬μ€μΌλ
```java
Statement stmt = conn.createStatement();

String sql = "select name, jikwi, city, basicpay from tblInsa where buseo = 'μ΄λ¬΄λΆ'";
ResultSet rs = stmt.executeQuery(sql);

while (rs.next()) {
    
    // μ§μ νλͺμ©
    System.out.printf("%s\t%s\t%s\t%,10dμ\n"
                        , rs.getString("name")
                        , rs.getString("jikwi")
                        , rs.getString("city")
                        , rs.getInt("basicpay"));
}

rs.close();
stmt.close();
conn.close();
```


<br>

### β PreparedStatement
- λμ  μΏΌλ¦¬λ₯Ό μμ±ν  λ μ¬μ©νλ€.
- λ§€κ°λ³μ μ²λ¦¬μ νΉνλμ΄ μλ€. 
- λ§€κ°λ³μμ λΆμ μ ν κ°(e.g. μμ λ°μ΄ν('))μ΄ μμΌλ©΄ μλ μ΄μ€μΌμ΄ν μ²λ¦¬
- Statementλ₯Ό μ¬μ©νλ κ²λ³΄λ€ μμ μ± λ° κ°λμ±μ΄ λλ€.
- μ½λλμ΄ μ¦κ°νλ€λ λ¨μ μ΄ μλ€.
```java
String sql = "insert into tblAddress values (seqAddress.nextVal, ?, ?, ?, ?, ?, default)";
					
PreparedStatement pstmt = conn.prepareStatement(sql); // PreparedStatement μμ±μ λ―Έλ¦¬ SQL λμ
pstmt.setString(1, name);
pstmt.setString(2, age);
pstmt.setString(3, gender);
pstmt.setString(4, tel);
pstmt.setString(5, address);

result = pstmt.executeUpdate();
```

<br>


### β CallableStatement
- νλ‘μμ  νΈμΆ μ μ© Statementμ΄λ€.
- PreparedStatementμ μ μ¬νλ€.
#### π μΈμκ° X, λ°νκ° X νλ‘μμ  νΈμΆ
- νλ‘μμ  μ μΈ
```sql
create or replace procedure procM1
is
begin
    insert into tblAddress 
        values (seqAddress.nextVal, 'νκΈΈλ', 20, 'm', '010-1234-5678', 'μμΈμ κ°λ¨κ΅¬ μ­μΌλ νλλΉλ©', default);
end;
```

<br>

- νλ‘μμ  νΈμΆ
```java
String sql = "{ call procM1 }";
			
CallableStatement cstmt = conn.prepareCall(sql);

int result = cstmt.executeUpdate();
System.out.println(result);
```

<br>

#### π μΈμκ° O, λ°νκ° X νλ‘μμ  νΈμΆ
- νλ‘μμ  μ μΈ
```sql
create or replace procedure procM2(
    pname tblAddress.name%type,
    page tblAddress.age%type,
    pgender tblAddress.gender%type,
    ptel tblAddress.tel%type,
    paddress tblAddress.address%type
)
is
begin
    insert into tblAddress 
    values (seqAddress.nextVal, pname, page, pgender, ptel, paddress, default);
end;
```

<br>

- νλ‘μμ  νΈμΆ
```java
String sql = "{ call procM2(?,?,?,?,?) }";

cstmt = conn.prepareCall(sql);
cstmt.setString(1, "νκΈΈμ");
cstmt.setString(2, "26");
cstmt.setString(3, "f");
cstmt.setString(4, "010-3333-4444");
cstmt.setString(5, "κ²½κΈ°λ");

int result = cstmt.executeUpdate();
System.out.println(result);

cstmt.close();
```

<br>

#### π μΈμκ° X, λ°νκ° O νλ‘μμ  νΈμΆ
- νλ‘μμ  μ μΈ
```sql
create or replace procedure procM3 (
    pcount out number
)
is
begin
    select count(*) into pcount from tblAddress;
end;
```

<br>

- νλ‘μμ  νΈμΆ
```java	
String sql = "{ call procM3(?) }";

cstmt = conn.prepareCall(sql);

// out λ§€κ°λ³μ μ€μ 
cstmt.registerOutParameter(1, OracleTypes.NUMBER);
cstmt.executeQuery(); // rs X

int count = cstmt.getInt(1); // Out Parameter κ°μ Έμ€λ μ­ν 
System.out.println(count);
```

<br>

#### π μΈμκ° O, λ°νκ° O νλ‘μμ  νΈμΆ
- νλ‘μμ  μ μΈ
```sql
create or replace procedure procM4 (
    pnum in number,
    pname out varchar,
    pbuseo out varchar,
    pjikwi out varchar,
    pcity out varchar
)
is
begin
    select 
        name, buseo, jikwi, city into pname, pbuseo, pjikwi, pcity
    from tblInsa
    where num = pnum;
end;
```

<br>

- νλ‘μμ  νΈμΆ
```java
String sql = "{call procM4(?,?,?,?,?)}";
			
cstmt = conn.prepareCall(sql);

// in νλΌλ―Έν° μ€μ 
cstmt.setString(1, "1001");

// out νλΌλ―Έν° μ€μ 
cstmt.registerOutParameter(2, OracleTypes.VARCHAR);
cstmt.registerOutParameter(3, OracleTypes.VARCHAR);
cstmt.registerOutParameter(4, OracleTypes.VARCHAR);
cstmt.registerOutParameter(5, OracleTypes.VARCHAR);

// μΏΌλ¦¬ μ€ν
cstmt.executeQuery();

// κ° κ°μ Έμ€κΈ°
System.out.println("μ΄λ¦ : " + cstmt.getString(2));
System.out.println("λΆμ : " + cstmt.getString(3));
System.out.println("μ§μ : " + cstmt.getString(4));
System.out.println("μ§μ­ : " + cstmt.getString(5));
```

<br>

#### π μ»€μ μ¬μ©ν΄μ λ€μ€ν, λ€μ€μ΄ κ°μ Έμ€κΈ°
- νλ‘μμ  μ μΈ
```sql
create or replace procedure procM5 (
    pbuseo in varchar2,
    pcursor out sys_refcursor
)
is
begin
    open pcursor for
    select name, jikwi, basicpay from tblInsa where buseo = pbuseo;
end procM5;

```

<br>

- νλ‘μμ  νΈμΆ
```java
String sql = "{ call procM5(?,?) }";
			
CallableStatement cstmt = conn.prepareCall(sql);

cstmt.setString(1, "κ°λ°λΆ");
cstmt.registerOutParameter(2, OracleTypes.CURSOR);

cstmt.executeQuery();

// μ€λΌν΄ μ»€μλ μλ° ResultSetλ‘ μ°Έμ‘° > *****
rs = (ResultSet)cstmt.getObject(2);

while(rs.next()) {
    
    System.out.println(rs.getString("name"));
    System.out.println(rs.getString("jikwi"));
    System.out.println(rs.getString("basicpay"));
    System.out.println();
}
```