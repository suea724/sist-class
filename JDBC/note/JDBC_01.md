# ๐ JDBC, Java DataBase Connectivity
- **์๋ฐ ํ๋ก๊ทธ๋จ๊ณผ DB๋ฅผ ์ฐ๊ฒฐ**ํ๊ธฐ ์ํด ํ์ํ **๋ผ์ด๋ธ๋ฌ๋ฆฌ**์ด๋ค.
- ์์ JDBC๋ ์ค๋๋ ๊ธฐ์ ๋ก ์ ์ฌ์ฉ๋์ง ์๋ ๊ธฐ์ ์ด๋ฉฐ, ์์ฆ์ Spring-JDBC, Mybatis์ ๊ฐ์ ํ๋ ์์ํฌ๋ฅผ ๋ง์ด ์ฌ์ฉํ๋ค.

<br>

### โ JDBC ์ค์ 
1. **jarํ์ผ**๋ก ์ ๊ณต๋๋ JDBC๋ฅผ ๊ฐ DBMS ํํ์ด์ง์์ ๋ค์ด๋ก๋ ๋ฐ๋๋ค. (Oracle์ ์ค์น ์ ๊ฐ์ด ์ค์น๋๋ค.)
2. **ํ๋ก์ ํธ ํด๋ ์ฐํด๋ฆญ > build path > configure build path > add JARs > JDBC ์ถ๊ฐ**

<br>

### โ JDBC ์ ๊ณต ํด๋์ค
- **Connection** : DB ์๋ฒ์ ์ ์, ์ ์ ํด์  ์ ์ฌ์ฉํ๋ค.
- **Statement** : ์ฟผ๋ฆฌ๋ฅผ ์์ฑํ์ฌ DB ์๋ฒ๋ก ๋ณด๋ผ ๋ ์ฌ์ฉํ๋ค.
- **ResultSet** : select ๊ฒฐ๊ณผ๋ฅผ ๋ฐํ๋ฐ์ ๋ ์ฌ์ฉํ๋ค.

<br>

### โ ์๋ฐ ํ๋ก๊ทธ๋จ๊ณผ DB ์ฐ๋
- DB ์ฐ๋ ์์๋ ์ธ๋ถ ์์ถ๋ ฅ์ด ๋ฐ์ํ๋ ๊ฒ์ด๋ฏ๋ก **try-catch๋ฌธ**์ ์ฌ์ฉํด์ **์์ธ์ฒ๋ฆฌ**๋ฅผ ๋ฐ๋์ ํด์ค์ผ ํ๋ค.

#### 1๏ธโฃ Connection ๊ฐ์ฒด, ์๋ฒ, ๊ณ์  ์ ์ธ
```java
Connection conn = null;
		
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String id = "hr";
String pw = "java1234";
```
#### 2๏ธโฃ JDBC ๋๋ผ์ด๋ฒ ๋ก๋ฉ
```java
Class.forName("oracle.jdbc.driver.OracleDriver");
```
#### 3๏ธโฃ Connection ๊ฐ์ฒด ์์ฑ ๋ฐ ์ค๋ผํด ์๋ฒ ์ ์
- conn ๊ฐ์ฒด๊ฐ ์ค๋ผํด ์ ์ ์ ๋ณด๋ฅผ ๊ฐ์ง๊ณ  ์๋ค.
```java
conn = DriverManager.getConnection(url, id, pw);
```
#### 4๏ธโฃ ์๋ฌด์ฝ๋ ์์ฑ
```java
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("select * from tblInsa");

while(rs.next()) {
    System.out.println(rs.getString(1) + rs.getString(2));
}
```

#### 5๏ธโฃ ์ ์ ์ข๋ฃ
```java
conn.close();
```