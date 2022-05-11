# 📌 Statement
- JDBC에서 제공되는 클래스로, 자바에서 작성한 SQL문을 오라클 서버에서 실행하는 역할을 한다.
- executeUpdtate() 실행 시 0 또는 1을, executeQuery() 실행 시 ResultSet을 반환한다.
- executeXXX() 사용 시 Autocommit이 수반된다.
### ✅ Statement
- 정적 쿼리를 작성할 때 사용한다.
#### 👉 executeUpdate()
```java
// insert, delete, update, DDL 수행 시 사용
// SQL 작성
String sql = "insert into tblAddress values (seqAddress.nextVal, '아무개', 25, 'm', '010-5555-5555', '서울시 강남구 대치동', default)";

// 연결 객체로부터 Statement 객체 가져오기
Statement stmt = conn.createStatement();

// 쿼리 실행
int result = stmt.executeUpdate(sql);

if (result == 1) {
    System.out.println("등록 성공");
} else {
    System.out.println("등록 실패");
}

// 자원 해제
stmt.close();
```
<br>

#### 👉 executeQuery()
- 결과 레코드가 한줄일때
```java
Statement stmt = conn.createStatement();

String sql = "select name, age, tel, address from tblAddress where seq = 22";

// ResultSet 반환
ResultSet rs = stmt.executeQuery(sql);

if (rs.next()) {
    System.out.println("이름 : " + rs.getString("name"));
    System.out.println("나이 : " + rs.getString("age"));
    System.out.println("전화번호 : " + rs.getString("tel"));
    System.out.println("주소 : " + rs.getString("address"));
} else {
    System.out.println("데이터가 없습니다.");
}

rs.close();
stmt.close();
conn.close();
```

<br>

- 결과 레코드가 여러줄일때
```java
Statement stmt = conn.createStatement();

String sql = "select name, jikwi, city, basicpay from tblInsa where buseo = '총무부'";
ResultSet rs = stmt.executeQuery(sql);

while (rs.next()) {
    
    // 직원 한명씩
    System.out.printf("%s\t%s\t%s\t%,10d원\n"
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

### ✅ PreparedStatement
- 동적 쿼리를 작성할 때 사용한다.
- 매개변수 처리에 특화되어 있다. 
- 매개변수에 부적절한 값(e.g. 작은 따옴표('))이 있으면 자동 이스케이프 처리
- Statement를 사용하는 것보다 안정성 및 가독성이 높다.
- 코드량이 증가한다는 단점이 있다.
```java
String sql = "insert into tblAddress values (seqAddress.nextVal, ?, ?, ?, ?, ?, default)";
					
PreparedStatement pstmt = conn.prepareStatement(sql); // PreparedStatement 생성시 미리 SQL 대입
pstmt.setString(1, name);
pstmt.setString(2, age);
pstmt.setString(3, gender);
pstmt.setString(4, tel);
pstmt.setString(5, address);

result = pstmt.executeUpdate();
```

<br>


### ✅ CallableStatement
- 프로시저 호출 전용 Statement이다.
- PreparedStatement와 유사하다.
#### 👉 인자값 X, 반환값 X 프로시저 호출
- 프로시저 선언
```sql
create or replace procedure procM1
is
begin
    insert into tblAddress 
        values (seqAddress.nextVal, '홍길동', 20, 'm', '010-1234-5678', '서울시 강남구 역삼동 한독빌딩', default);
end;
```

<br>

- 프로시저 호출
```java
String sql = "{ call procM1 }";
			
CallableStatement cstmt = conn.prepareCall(sql);

int result = cstmt.executeUpdate();
System.out.println(result);
```

<br>

#### 👉 인자값 O, 반환값 X 프로시저 호출
- 프로시저 선언
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

- 프로시저 호출
```java
String sql = "{ call procM2(?,?,?,?,?) }";

cstmt = conn.prepareCall(sql);
cstmt.setString(1, "홍길순");
cstmt.setString(2, "26");
cstmt.setString(3, "f");
cstmt.setString(4, "010-3333-4444");
cstmt.setString(5, "경기도");

int result = cstmt.executeUpdate();
System.out.println(result);

cstmt.close();
```

<br>

#### 👉 인자값 X, 반환값 O 프로시저 호출
- 프로시저 선언
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

- 프로시저 호출
```java	
String sql = "{ call procM3(?) }";

cstmt = conn.prepareCall(sql);

// out 매개변수 설정
cstmt.registerOutParameter(1, OracleTypes.NUMBER);
cstmt.executeQuery(); // rs X

int count = cstmt.getInt(1); // Out Parameter 가져오는 역할
System.out.println(count);
```

<br>

#### 👉 인자값 O, 반환값 O 프로시저 호출
- 프로시저 선언
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

- 프로시저 호출
```java
String sql = "{call procM4(?,?,?,?,?)}";
			
cstmt = conn.prepareCall(sql);

// in 파라미터 설정
cstmt.setString(1, "1001");

// out 파라미터 설정
cstmt.registerOutParameter(2, OracleTypes.VARCHAR);
cstmt.registerOutParameter(3, OracleTypes.VARCHAR);
cstmt.registerOutParameter(4, OracleTypes.VARCHAR);
cstmt.registerOutParameter(5, OracleTypes.VARCHAR);

// 쿼리 실행
cstmt.executeQuery();

// 값 가져오기
System.out.println("이름 : " + cstmt.getString(2));
System.out.println("부서 : " + cstmt.getString(3));
System.out.println("직위 : " + cstmt.getString(4));
System.out.println("지역 : " + cstmt.getString(5));
```

<br>

#### 👉 커서 사용해서 다중행, 다중열 가져오기
- 프로시저 선언
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

- 프로시저 호출
```java
String sql = "{ call procM5(?,?) }";
			
CallableStatement cstmt = conn.prepareCall(sql);

cstmt.setString(1, "개발부");
cstmt.registerOutParameter(2, OracleTypes.CURSOR);

cstmt.executeQuery();

// 오라클 커서는 자바 ResultSet로 참조 > *****
rs = (ResultSet)cstmt.getObject(2);

while(rs.next()) {
    
    System.out.println(rs.getString("name"));
    System.out.println(rs.getString("jikwi"));
    System.out.println(rs.getString("basicpay"));
    System.out.println();
}
```