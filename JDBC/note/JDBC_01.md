# 📌 JDBC, Java DataBase Connectivity
- **자바 프로그램과 DB를 연결**하기 위해 필요한 **라이브러리**이다.
- 순수 JDBC는 오래된 기술로 잘 사용되지 않는 기술이며, 요즘은 Spring-JDBC, Mybatis와 같은 프레임워크를 많이 사용한다.

<br>

### ✅ JDBC 설정
1. **jar파일**로 제공되는 JDBC를 각 DBMS 홈페이지에서 다운로드 받는다. (Oracle은 설치 시 같이 설치된다.)
2. **프로젝트 폴더 우클릭 > build path > configure build path > add JARs > JDBC 추가**

<br>

### ✅ JDBC 제공 클래스
- **Connection** : DB 서버에 접속, 접속 해제 시 사용한다.
- **Statement** : 쿼리를 작성하여 DB 서버로 보낼 때 사용한다.
- **ResultSet** : select 결과를 반환받을 때 사용한다.

<br>

### ✅ 자바 프로그램과 DB 연동
- DB 연동 작업도 외부 입출력이 발생하는 것이므로 **try-catch문**을 사용해서 **예외처리**를 반드시 해줘야 한다.

#### 1️⃣ Connection 객체, 서버, 계정 선언
```java
Connection conn = null;
		
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String id = "hr";
String pw = "java1234";
```
#### 2️⃣ JDBC 드라이버 로딩
```java
Class.forName("oracle.jdbc.driver.OracleDriver");
```
#### 3️⃣ Connection 객체 생성 및 오라클 서버 접속
- conn 객체가 오라클 접속 정보를 가지고 있다.
```java
conn = DriverManager.getConnection(url, id, pw);
```
#### 4️⃣ 업무코드 작성
```java
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("select * from tblInsa");

while(rs.next()) {
    System.out.println(rs.getString(1) + rs.getString(2));
}
```

#### 5️⃣ 접속 종료
```java
conn.close();
```