# ๐ MyBatis
- ๊ฐ์ฒด์งํฅ ์ธ์ด์ธ ์๋ฐ์ ๊ด๊ณํ ๋ฐ์ดํฐ๋ฒ ์ด์ค ํ๋ก๊ทธ๋๋ฐ์ ์ข ๋ ์ฝ๊ฒ ํ  ์ ์๊ฒ ๋์์ฃผ๋ ๊ฐ๋ฐ ํ๋ ์์ํฌ
- ๋ณต์กํ JDBC ์ฝ๋ ๋์  ๊น๋ํ ์ฝ๋๋ฅผ ์ ์งํ  ์ ์๋ค.
- ์๋ฐ ๊ฐ์ฒด์ SQL ์ฌ์ด์์ ์๋ ๋งคํ์ ๋์์ฃผ๋ ํ๋ ์์ํฌ

<br>

### โ JDBC VS MyBatis
- ์ ํต์ ์ธ JSBC ํ๋ก๊ทธ๋จ
    - ์ง์  Connection ๊ฐ์ฒด๋ฅผ ์์ฑ ํ ๋ง์ง๋ง์ close()
    - PreparedStatement ์ง์  ์์ฑ ๋ฐ ์ฒ๋ฆฌ
    - Select์ ๊ฒฝ์ฐ ResultSet ์ง์  ์ฒ๋ฆฌ
- MyBatis
    - ์๋์ผ๋ก Connection close() ์ํ
    - MyBatis ๋ด๋ถ์ ์ผ๋ก PreparedStatement ์ฒ๋ฆฌ(์บก์ํ)
    - #{prop}๊ณผ ๊ฐ์ด ์์ฑ์ ์ง์ ํ์ฌ ์ฒ๋ฆฌ
    - ๋ฆฌํด ํ์์ ์ง์ ํ๋ ๊ฒฝ์ฐ ์๋์ผ๋ก ๊ฐ์ฒด ์์ฑ ๋ฐ ResultSet ์ฒ๋ฆฌ

<br>

# ๐ MyBatis 
### โ SqlSession
- MyBatis์์ ๊ฐ์ฅ ํต์ฌ์ ์ธ ๊ฐ์ฒด
- Connection ์์ฑ, ์ํ๋ SQL ์ ๋ฌ ํ ๊ฒฐ๊ณผ๋ฅผ ๋ฆฌํด ๋ฐ๋๋ค.


<br>

### โ SqlSessionTemplate
- MyBatis Spring ์ฐ๋ ๋ชจ๋์ ํต์ฌ
- SqlSession์ ๊ตฌํํ๊ณ  ์ฝ๋์์ SqlSession์ ๋์ฒดํ๋ ์ญํ 
- ์ฌ๋ฌ ๊ฐ์ DAO๋ ๋งคํผ์์ ๊ณต์ ํ  ์ ์๋ค.


<br>

# ๐ MyBatis ์ค์ 
### 1๏ธโฃ ๋ผ์ด๋ธ๋ฌ๋ฆฌ ์ถ๊ฐ
> pom.xml
```xml
<!-- ๋ง์ด๋ฐํฐ์ค ๋ผ์ด๋ธ๋ฌ๋ฆฌ -->
 <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.10</version>
</dependency>

<!-- ๋ง์ด๋ฐํฐ์ค ์คํ๋ง ์ฐ๋ ๋ชจ๋ ๋ผ์ด๋ธ๋ฌ๋ฆฌ -->
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis-spring</artifactId>
    <version>2.0.7</version>
</dependency>

<!-- ํธ๋์ญ์ ์ฒ๋ฆฌ -->
<!-- https://mvnrepository.com/artifact/org.springframework/spring-tx -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-tx</artifactId>
    <version>${org.springframework-version}</version>
</dependency>

<!-- ๋ฐ์ดํฐ๋ฒ ์ด์ค ์ฒ๋ฆฌ (Spring ๋ฒ์ ๊ณผ ๋์ผํด์ผ ํจ) -->
<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>${org.springframework-version}</version>
</dependency>

<!-- ์ปค๋ฅ์ ํ ๋ผ์ด๋ธ๋ฌ๋ฆฌ ์ค์  -->        
<!-- https://mvnrepository.com/artifact/commons-dbcp/commons-dbcp -->
<dependency>
    <groupId>commons-dbcp</groupId>
    <artifactId>commons-dbcp</artifactId>
    <version>1.4</version>
</dependency>

<!-- query log๋ฅผ ์ถ๋ ฅํ๋ ๋ผ์ด๋ธ๋ฌ๋ฆฌ -->
<!-- https://mvnrepository.com/artifact/org.lazyluke/log4jdbc-remix -->
<dependency>
    <groupId>org.lazyluke</groupId>
    <artifactId>log4jdbc-remix</artifactId>
    <version>0.2.7</version>
</dependency>
```

<br>

### 2๏ธโฃ SQLSessionFactory ์ค์ 
> root-context.xml (applicationContext.xml)
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd">
	
	<!-- DBCP ์ ์ -->	
	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
      <property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"></property>
      <property name="url" value="jdbc:oracle:thin:@172.16.11.215:1521:xe"></property>
      <property name="username" value="hr"></property>
      <property name="password" value="java1234"></property>
   </bean>
   
   <!-- ์ฟผ๋ฆฌ ๋ก๊ทธ๋ฅผ ๋จ๊ธฐ๊ธฐ ์ํ log4j ์ค์  -->
   <bean id="log4j" class="net.sf.log4jdbc.Log4jdbcProxyDataSource">
      <constructor-arg ref="dataSource"></constructor-arg>
      <property name="logFormatter">
         <bean class="net.sf.log4jdbc.tools.Log4JdbcCustomFormatter">
            <property name="loggingType" value="MULTI_LINE"></property>
            <property name="sqlPrefix" value="[SQL] "></property>
         </bean>
      </property>
   </bean>

    <!-- MyBatis์ Spring ์ฐ๋ ์ค์  -->
	<bean id="sessionfactory" class="org.mybatis.spring.SqlSessionFactoryBean">
      <property name="dataSource" ref="log4j"></property>
      <property name="mapperLocations" value="classpath*:com/test/spring/mapper/*.xml"></property>
      <!-- MyBatis ์ค์  ํ์ผ -->
      <property name="configLocation" value="/WEB-INF/mybatis.xml"></property>
   </bean>		
   
   <!-- MyBatis + Spring ์ฐ๋ ์ ๊ฐ๋ฐ ์์ฐ์ฑ์ ์ํด SqlSessionTemplate ํด๋์ค๋ฅผ ์ด์ฉ SqlSessionTemplate์ ์ ์ธ์  ๋ฐฉ์์ ํธ๋์ญ์ ์ ์ด๋ฅผ ์ง์ (= AOP ๊ธฐ๋ฐ Transaction ์ ์ด)-->
   <bean class="org.mybatis.spring.SqlSessionTemplate">
      <constructor-arg ref="sessionfactory"></constructor-arg>
   </bean>
</beans>
```

<br>

### 3๏ธโฃ MyBatis ์ค์ 
> mybatis.xml
```xml
<configuration>
	<typeAliases>
        <!-- parameterType ๋๋ resultType์์ ์ฌ์ฉ๋  ๊ฐ์ฒด์ alias ์ง์  ๊ฐ๋ฅ -->
		<typeAlias type="com.test.spring.FileDTO" alias="fdto"/>
		<typeAlias type="com.test.spring.BoardDTO" alias="bdto"/>
	</typeAliases>
</configuration>
```

<br>

### 4๏ธโฃ ๋งคํผ ์ค์ 
```xml
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- ํ์ฌ ํ์ผ๊ณผ ๋์ผํ ์ด๋ฆ์ผ๋ก ์ค์ ํ๋๊ฒ ์ข์ -->
<mapper namespace="test">
    
    <insert id="m1">
    insert into tblMyBatis (seq, item, price, regdate) values (seqMyBatis.nextVal, '๋ณธ์ฒด', '500000', default)
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
    
    <!-- ๋ฐํ๋๋ ๋ ์ฝ๋์ ๊ฐ์์ ์๊ด์์ด resultType์ ํญ์ ๋ ์ฝ๋ 1๊ฐ์ ์๋ฃํ์ผ๋ก๋ง ์์ฑํ๋ค. -->
    <select id="m7" resultType="String">
    select item from tblMyBatis
    </select>
    
    <select id="m8" resultType="dto">
    select * from tblMyBatis
    </select>
    
    <!-- ๋ฌธ์์ด์ ๋ฐ์ดํ๋ฅผ ๋ถ์ด์ง ์๊ณ  ์ฟผ๋ฆฌ ์์ฑ (๋ฐ์ดํฐ X, ์๋ณ์ O) -->
    <select id="m9" parameterType="String" resultType="Integer">
    select count(*) from ${table}
    </select>
    
    <select id="m10" parameterType="String" resultType="dto">
    select * from tblMyBatis where item like '%${word}%'
    </select>
    
    <select id="m11" parameterType="String" resultType="String">
        
        <!-- ์กฐ๊ฑด๋ฌธ ์ฌ์ฉ -->
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

### 5๏ธโฃ DAOImpl
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
		
        // namespace + ๋งคํผ์์ ์ค์ ํ id
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

[์ฐธ์กฐ - Spring, MyBatis ์ฐ๋](https://velog.io/@msriver/Spring-MyBatis-%EC%97%B0%EB%8F%99) <br>
[์ฐธ์กฐ - MyBatis ๊ฐ๋ ๋ฐ ํต์ฌ ์ ๋ฆฌ](https://khj93.tistory.com/entry/MyBatis-MyBatis%EB%9E%80-%EA%B0%9C%EB%85%90-%EB%B0%8F-%ED%95%B5%EC%8B%AC-%EC%A0%95%EB%A6%AC)