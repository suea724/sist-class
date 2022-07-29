# 📌 MyBatis
- 객체지향 언어인 자바의 관계형 데이터베이스 프로그래밍을 좀 더 쉽게 할 수 있게 도와주는 개발 프레임워크
- 복잡한 JDBC 코드 대신 깔끔한 코드를 유지할 수 있다.
- 자바 객체와 SQL 사이에서 자동 매핑을 도와주는 프레임워크

<br>

### ✅ JDBC VS MyBatis
- 전통적인 JSBC 프로그램
    - 직접 Connection 객체를 생성 후 마지막에 close()
    - PreparedStatement 직접 생성 및 처리
    - Select의 경우 ResultSet 직접 처리
- MyBatis
    - 자동으로 Connection close() 수행
    - MyBatis 내부적으로 PreparedStatement 처리(캡슐화)
    - #{prop}과 같이 속성을 지정하여 처리
    - 리턴 타입을 지정하는 경우 자동으로 객체 생성 및 ResultSet 처리

<br>

# 📌 MyBatis 
### ✅ SqlSession
- MyBatis에서 가장 핵심적인 객체
- Connection 생성, 원하는 SQL 전달 후 결과를 리턴 받는다.


<br>

### ✅ SqlSessionTemplate
- MyBatis Spring 연동 모듈의 핵심
- SqlSession을 구현하고 코드에서 SqlSession을 대체하는 역할
- 여러 개의 DAO나 매퍼에서 공유할 수 있다.


<br>

# 📌 MyBatis 설정
### 1️⃣ 라이브러리 추가
> pom.xml
```xml
<!-- 마이바티스 라이브러리 -->
 <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.10</version>
</dependency>

<!-- 마이바티스 스프링 연동 모듈 라이브러리 -->
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis-spring</artifactId>
    <version>2.0.7</version>
</dependency>

<!-- 트랜잭션 처리 -->
<!-- https://mvnrepository.com/artifact/org.springframework/spring-tx -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-tx</artifactId>
    <version>${org.springframework-version}</version>
</dependency>

<!-- 데이터베이스 처리 (Spring 버전과 동일해야 함) -->
<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>${org.springframework-version}</version>
</dependency>

<!-- 커넥션 풀 라이브러리 설정 -->        
<!-- https://mvnrepository.com/artifact/commons-dbcp/commons-dbcp -->
<dependency>
    <groupId>commons-dbcp</groupId>
    <artifactId>commons-dbcp</artifactId>
    <version>1.4</version>
</dependency>

<!-- query log를 출력하는 라이브러리 -->
<!-- https://mvnrepository.com/artifact/org.lazyluke/log4jdbc-remix -->
<dependency>
    <groupId>org.lazyluke</groupId>
    <artifactId>log4jdbc-remix</artifactId>
    <version>0.2.7</version>
</dependency>
```

<br>

### 2️⃣ SQLSessionFactory 설정
> root-context.xml (applicationContext.xml)
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd">
	
	<!-- DBCP 정의 -->	
	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
      <property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"></property>
      <property name="url" value="jdbc:oracle:thin:@172.16.11.215:1521:xe"></property>
      <property name="username" value="hr"></property>
      <property name="password" value="java1234"></property>
   </bean>
   
   <!-- 쿼리 로그를 남기기 위한 log4j 설정 -->
   <bean id="log4j" class="net.sf.log4jdbc.Log4jdbcProxyDataSource">
      <constructor-arg ref="dataSource"></constructor-arg>
      <property name="logFormatter">
         <bean class="net.sf.log4jdbc.tools.Log4JdbcCustomFormatter">
            <property name="loggingType" value="MULTI_LINE"></property>
            <property name="sqlPrefix" value="[SQL] "></property>
         </bean>
      </property>
   </bean>

    <!-- MyBatis와 Spring 연동 설정 -->
	<bean id="sessionfactory" class="org.mybatis.spring.SqlSessionFactoryBean">
      <property name="dataSource" ref="log4j"></property>
      <property name="mapperLocations" value="classpath*:com/test/spring/mapper/*.xml"></property>
      <!-- MyBatis 설정 파일 -->
      <property name="configLocation" value="/WEB-INF/mybatis.xml"></property>
   </bean>		
   
   <!-- MyBatis + Spring 연동 시 개발 생산성을 위해 SqlSessionTemplate 클래스를 이용 SqlSessionTemplate은 선언적 방식의 트랜잭션 제어를 지원 (= AOP 기반 Transaction 제어)-->
   <bean class="org.mybatis.spring.SqlSessionTemplate">
      <constructor-arg ref="sessionfactory"></constructor-arg>
   </bean>
</beans>
```

<br>

### 3️⃣ MyBatis 설정
> mybatis.xml
```xml
<configuration>
	<typeAliases>
        <!-- parameterType 또는 resultType에서 사용될 객체의 alias 지정 가능 -->
		<typeAlias type="com.test.spring.FileDTO" alias="fdto"/>
		<typeAlias type="com.test.spring.BoardDTO" alias="bdto"/>
	</typeAliases>
</configuration>
```

<br>

### 4️⃣ 매퍼 설정
```xml
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- 현재 파일과 동일한 이름으로 설정하는게 좋음 -->
<mapper namespace="test">
    
    <insert id="m1">
    insert into tblMyBatis (seq, item, price, regdate) values (seqMyBatis.nextVal, '본체', '500000', default)
    </insert>
    
    <update id="m2" parameterType="String">
    update tblMyBatis set price = price * 1.2 where seq = #{seq}
    </update>
    
    <delete id="m3" parameterType="String">
    delete from tblMyBatis where seq = #{seq}
    </delete>
    
    <insert id="m4" parameterType="dto">
    insert into tblMyBatis values (seqMyBatis.nextVal, #{item}, #{price}, default)
    </insert>
    
    <select id="m5" parameterType="String" resultType="Integer">
    select price from tblMyBatis where seq = #{seq}
    </select>
    
    <select id="m6" parameterType="String" resultType="dto">
    select * from tblMyBatis where seq = #{seq}
    </select>
    
    <!-- 반환되는 레코드의 개수와 상관없이 resultType은 항상 레코드 1개의 자료형으로만 작성한다. -->
    <select id="m7" resultType="String">
    select item from tblMyBatis
    </select>
    
    <select id="m8" resultType="dto">
    select * from tblMyBatis
    </select>
    
    <!-- 문자열에 따옴표를 붙이지 않고 쿼리 생성 (데이터 X, 식별자 O) -->
    <select id="m9" parameterType="String" resultType="Integer">
    select count(*) from ${table}
    </select>
    
    <select id="m10" parameterType="String" resultType="dto">
    select * from tblMyBatis where item like '%${word}%'
    </select>
    
    <select id="m11" parameterType="String" resultType="String">
        
        <!-- 조건문 사용 -->
	    <if test="type == 1">
	    select distinct buseo from tblInsa
	    </if>
	    
	    <if test="type == 2">
	    select distinct jikwi from tblInsa
	    </if>
    
    </select>
</mapper>
```

<br>

### 5️⃣ DAOImpl
```java
@Repository
@Qualifier("dao")
public class MyBatisDAOImpl implements MyBatisDAO {
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public void test() {
		System.out.println("3." + (template == null));
	}

	@Override
	public void m1() {
		
        // namespace + 매퍼에서 설정한 id
		template.insert("test.m1");
	}

	@Override
	public int m2(String seq) {
		return template.update("test.m2", seq);
	}
	
	@Override
	public int m3(String seq) {
		return template.delete("test.m3", seq);
	}
	
	@Override
	public int m4(MyBatisDTO dto) {
		return template.insert("test.m4", dto);
	}
	
	@Override
	public int m5(String seq) {
		return template.selectOne("test.m5", seq);
	}
	
	@Override
	public MyBatisDTO m6(String seq) {
		return template.selectOne("test.m6", seq);
	}
	
	@Override
	public List<String> m7() {
		return template.selectList("test.m7");
	}
	
	@Override
	public List<MyBatisDTO> m8() {
		return template.selectList("test.m8");
	}
	
	@Override
	public int m9(String table) {
		return template.selectOne("test.m9", table);
	}
	
	@Override
	public List<MyBatisDTO> m10(String word) {
		return template.selectList("test.m10", word);
	}
	
	@Override
	public List<String> m11(String type) {
		return template.selectList("test.m11", type);
	}

}
```

<br>

[참조 - Spring, MyBatis 연동](https://velog.io/@msriver/Spring-MyBatis-%EC%97%B0%EB%8F%99) <br>
[참조 - MyBatis 개념 및 핵심 정리](https://khj93.tistory.com/entry/MyBatis-MyBatis%EB%9E%80-%EA%B0%9C%EB%85%90-%EB%B0%8F-%ED%95%B5%EC%8B%AC-%EC%A0%95%EB%A6%AC)