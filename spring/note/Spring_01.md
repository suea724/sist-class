# ๐ฑ Spring Framework
- ์คํ๋ง ํ๋ ์์ํฌ๋ ์๋ฐ ํ๋ซํผ์ ์ํ ์คํ ์์ค ์ ํ๋ฆฌ์ผ์ด์ ํ๋ ์์ํฌ
- ์ ์ ์ ๋ถ ํ์ค ํ๋ ์ ์ํฌ๋ก ์ฑํ > https://www.egovframe.go.kr/

<br>

### โ ํ๋ก์ ํธ ๊ตฌ์กฐ
1. **src/main/java**
    - Java  ์์ค ํด๋
2. **src/main/resources**
    - Java ์์ค ์ด์ธ์ ์์ ํด๋
    - ์ค์ 
3. **src/test/java**
    - ํ์คํธ์ฉ ํด๋
4. **src/test/resources**
    - ํ์คํธ์ฉ ์์ ํด๋
5. **JRE System Library**
    - JRE jar
6. **Maven Dependencies**
    - ๋ฉ์ด๋ธ (๋น๋ ๋๊ตฌ + ๋ผ์ด๋ธ๋ฌ๋ฆฌ ๊ด๋ฆฌ ๋๊ตฌ ๋ฑ)
    - ํ๋ก์ ํธ ์์ฑ & ์ ์ง ๊ด๋ฆฌ & ๋ฐฐํฌ
7. **src**
    - webapp
        - ์น ๋ฃจํธ ํด๋
    - webapp > resources
        - CSS, JavaScript, Images ๋ฑ์ ์ ์ฅํ๋ ํด๋
    - webapp > WEB-INF โญ
        - classes : ์ปดํ์ผ๋ ํด๋์ค ํ์ผ ์ ์ฅ ํด๋
        - spring : ์ด ํด๋ ์ดํ์์ ๋ชจ๋  ์คํ๋ง ์ค์ 
            - appServlet
                - servlet-context.xml                
            - root-context.xml
        - views
            - ๋ทฐ ํ์ด์ง ํด๋
        - web.xml
            - ์ํ์น ํฐ์บฃ ์๋ฒ ์ค์  ํ์ผ

<br>

### โ ์คํ๋ง ํ๋ ์์ํฌ ๊ตฌ์ฑ ์์
1. ์์กด์ฑ ์ฃผ์ ์ง์(DI)
2. ๊ด์  ์งํฅ ํ๋ก๊ทธ๋๋ฐ ์ง์(AOP)
3. Spring MVC ์ง์
4. ๋ ์ด์์ ์ง์ (Tiles)
5. ๋ฐ์ดํฐ๋ฒ ์ด์ค ์ฐ๋ ์ง์
    - JDBC
    - Spring JDBC
    - ORM(JPA)
    - MyBatis

๋ฑ๋ฑ..

<br>

# ๐ DI(Dependency Injection) โญ
- ์์กด ๊ด๊ณ ์ฃผ์
- ๊ฐ์ฒด๋ฅผ ์ง์  ์์ฑํ๋ ๊ฒ์ด ์๋๋ผ ์ธ๋ถ์์ ์์ฑํ ํ ์ฃผ์์์ผ์ฃผ๋ ๋ฐฉ์
- ์ ํ๋ฆฌ์ผ์ด์ ์คํ ์์ (๋ฐํ์)์ ์ค์  ์์กด ๊ด๊ณ๊ฐ ์ค์ ๋จ
- DI๋ฅผ ํตํด ๋ชจ๋ ๊ฐ์ ๊ฒฐํฉ๋๊ฐ ๋ฎ์์ง๊ณ , ์ ์ฐ์ฑ์ด ๋์์ง
- ์คํ๋ง ์ ๋ฐ์ ๊ฑธ์ณ์ DI๊ฐ ์ ์ฉ๋์ด ์์

<br>

### โ ์ ๋ธํ์ด์์ ์ฌ์ฉํ ์์ฑ์ ์ฃผ์
๋ถ๋ณ, ํ์ ์์กด๊ด๊ณ์ ์ฌ์ฉ (๊ถ์ฅ)
```java
@Component
public class OrderServiceImpl implements OrderService {

     private final MemberRepository memberRepository;
     private final DiscountPolicy discountPolicy;
 
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
         this.memberRepository = memberRepository;
         this.discountPolicy = discountPolicy;
        }
}
```

<br>

### โ ์ ๋ธํ์ด์์ ์ฌ์ฉํ Setter ์ฃผ์
์ ํ, ๋ณ๊ฒฝ ๊ฐ๋ฅ์ฑ์ด ์๋ ์์กด ๊ด๊ณ์ ์ฌ์ฉ
```java
@Component
public class OrderServiceImpl implements OrderService {

     private MemberRepository memberRepository;
     private DiscountPolicy discountPolicy;

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
    	this.discountPolicy = discountPolicy;
    }
}
```

<br>

### โ XML ์ค์  ํ์ผ
๋น ๊ฐ์ฒด๋ฅผ ์์ฑํ์ฌ ๊ฐ ๊ฐ์ฒด์ ์์ฑ์ ์ธ์ ๋๋ Setter ํ๋กํผํฐ๋ฅผ ์ค์ ํด์ค๋ค.
```xml
<!-- ๋น ๊ฐ์ฒด ์์ฑ -->
<bean id="pen" name="p1 p2 p3" class="com.test.spring.di02.Pen"></bean>
<bean id="brush" class="com.test.spring.di02.Brush"></bean>


<!-- Spring DI -->
<bean id="hong" class="com.test.spring.di02.Hong">
    <!-- ์์ฑ์ ์ธ์ -->
    <constructor-arg ref="pen"></constructor-arg>
</bean>

<bean id="lee" class="com.test.spring.di02.Lee">
    <!-- Setter ํ๋กํผํฐ -->
    <property name="brush" ref="brush"></property>
</bean>
```

<br>

# ๐ IoC(Inversion of Control) โญ
- ์ ์ด์ ์ญ์ (์ญ์ ์ด)
- ์คํ๋ง ์ ํ๋ฆฌ์ผ์ด์์์๋ ์ค๋ธ์ ํธ์ ์์ฑ๊ณผ ๊ด๊ณ์ค์ , ์ฌ์ฉ, ์ ๊ฑฐ ๋ฑ์ ์์์ ์ฝ๋ ๋์  ๋๋ฆฝ๋ ์ปจํ์ด๋๊ฐ ๋ด๋นํ๋ค.
- ์ปจํ์ด๋๊ฐ ์ฝ๋ ๋์  ์ค๋ธ์ ํธ์ ๋ํ ์ ์ด๊ถ์ ๊ฐ์ง๊ณ  ์๋ค. 
- DI ๊ตฌํ ์ ์์ฐ์ค๋ฝ๊ฒ ๊ตฌํ๋๋ค.
- ์์กด์ฑ์ ์ญ์ ์์ผ ๊ฐ์ฒด ๊ฐ์ ๊ฒฐํฉ๋๋ฅผ ์ค์ด๊ณ  ์ ์ฐํ ์ฝ๋๋ฅผ ์์ฑํ  ์ ์๊ฒํ์ฌ ๊ฐ๋์ฑ์ด ๋์์ง๊ณ  ์ฝ๋ ์ค๋ณต์ ์ค์ผ ์ ์์ผ๋ฉฐ ์ ์ง ๋ณด์๋ฅผ ํธ๋ฆฌํ๊ฒ ํ  ์ ์๋ค.

<br>

### โ IoC ์ปจํ์ด๋ (= ์คํ๋ง ์ปจํ์ด๋)
- ๊ฐ์ฒด๋ฅผ ์์ฑํ๊ณ  ๊ด๋ฆฌํ๋ฉด์ ์์กด๊ด๊ณ๋ฅผ ์ฐ๊ฒฐํด์ฃผ๋ ์ญํ 
- ๊ฐ๋ฐ์๋ ์ง์  ๊ฐ์ฒด๋ฅผ ๊ด๋ฆฌํ๋ ๋์  ๋น์ฆ๋์ค ๋ก์ง์ ์ง์คํ  ์ ์๋ค.


<br>

# ๐ AOP (Aspect Oriented Programming) โญ 
- ๊ด์  ์งํฅ ํ๋ก๊ทธ๋๋ฐ
- ์ฃผ์๋ฌด์ ๋ณด์กฐ์๋ฌด(๋ก๊น, ์ธ์ฆ ๋ฑ๊ณผ ๊ด๋ จ๋ ์ฝ๋)๋ฅผ **๋ถ๋ฆฌ**์์ผ ๊ฐ๊ฐ์ ์๋ฌด๋ฅผ ๊ด๋ฆฌํ๋ ๊ธฐ์ 
- ์์ฐ์ฑ ๋ฐ ์ ์ง ๋ณด์์ฑ ํฅ์
- ์ฃผ์ ๊ด์ฌ์ฌ(Core Concern)๋ก๋ถํฐ ํก๋จ ๊ด์ฌ์ฌ(Cross-cutting Concern)์ ๋ถ๋ฆฌ๋ฅผ ํ์ฉํจ์ผ๋ก์จ ๋ชจ๋์ฑ์ ์ฆ๊ฐ์ํค๋ ๊ฒ์ด ๋ชฉํ

<br>

### โ AOP ์ฉ์ด
- **์กฐ์ธํฌ์ธํธ(Joinpoint)** 
    - ํด๋ผ์ด์ธํธ๊ฐ ํธ์ถํ๋ ๋ชจ๋  ๋น์ฆ๋์ค ๋ฉ์๋, ํฌ์ธํธ์ปท์ ํ๋ณด
- **ํฌ์ธํธ์ปท(Pointcut)**
    - ๊ณตํต ๊ธฐ๋ฅ์ ์ํ ์ํฌ ํน์  ๋ฉ์๋
    - AspectJ ํํ์ : ์ ๊ทผ ์ง์ ์ ๋ฆฌํดํ์ ํจํค์ง๊ฒฝ๋ก ํด๋์ค๋ช ๋ฉ์๋๋ช(๋งค๊ฐ๋ณ์)
    - ํํ์ e.g. `<aop:pointcut expression="execution(public void com.test.spring.aop.MemoImpl.add(String))" id="p1"/>`
- **์ด๋๋ฐ์ด์ค(Advice)**
    - ๊ณตํต ๊ธฐ๋ฅ์ ํ๋ ์ฝ๋, ๋๋ฆฝ๋ ํด๋์ค์ ๋ฉ์๋๋ก ์์ฑ
    - Before : ๋ฉ์๋ ์คํ ์ ์ ๋์
    - After : ๋ฉ์๋ ์คํ ์ ์ ๋์
    - After-returning : ๋ฉ์๋ ์คํ ์ ์ ๋์
    - After-throwing : ์์ธ๊ฐ ๋ฐ์ํ ํ์ ๋์
    - Around : ๋ฉ์๋ ํธ์ถ ์ด์ , ์ดํ, ์์ธ๋ฐ์ ๋ฑ ๋ชจ๋  ์์ ์์ ๋์
- **์๋น(Weaving)**
    - ์ด๋๋ฐ์ด์ค๋ฅผ ํต์ฌ ์ฝ๋์ ์ ์ฉ
    
- **์ ์คํฉํธ(Aspect)**
    - ํฌ์ธํธ์ปท + ์ด๋๋ฐ์ด์ค
    - ์ด๋ค ํฌ์ธํธ์ปท ๋ฉ์๋์ ๋ํด ์ด๋ค ์ด๋๋ฐ์ด์ค ๋ฉ์๋๋ฅผ ์คํํ ์ง ๊ฒฐ์ 

<br>



[์ฐธ๊ณ  - IoC ์ปจํ์ด๋์ DI](https://gunju-ko.github.io/toby-spring/2019/03/25/IoC-%EC%BB%A8%ED%85%8C%EC%9D%B4%EB%84%88%EC%99%80-DI.html)

[์ฐธ๊ณ  - AOP](https://sjh836.tistory.com/157)