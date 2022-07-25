# 🌱 Spring Framework
- 스프링 프레임워크는 자바 플랫폼을 위한 오픈 소스 애플리케이션 프레임워크
- 전자 정부 표준 프레임 워크로 채택 > https://www.egovframe.go.kr/

<br>

### ✅ 프로젝트 구조
1. **src/main/java**
    - Java  소스 폴더
2. **src/main/resources**
    - Java 소스 이외의 자원 폴더
    - 설정
3. **src/test/java**
    - 테스트용 폴더
4. **src/test/resources**
    - 테스트용 자원 폴더
5. **JRE System Library**
    - JRE jar
6. **Maven Dependencies**
    - 메이븐 (빌드 도구 + 라이브러리 관리 도구 등)
    - 프로젝트 생성 & 유지 관리 & 배포
7. **src**
    - webapp
        - 웹 루트 폴더
    - webapp > resources
        - CSS, JavaScript, Images 등을 저장하는 폴더
    - webapp > WEB-INF ⭐
        - classes : 컴파일된 클래스 파일 저장 폴더
        - spring : 이 폴더 이하에서 모든 스프링 설정
            - appServlet
                - servlet-context.xml                
            - root-context.xml
        - views
            - 뷰 페이지 폴더
        - web.xml
            - 아파치 톰캣 서버 설정 파일

<br>

### ✅ 스프링 프레임워크 구성 요소
1. 의존성 주입 지원(DI)
2. 관점 지향 프로그래밍 지원(AOP)
3. Spring MVC 지원
4. 레이아웃 지원 (Tiles)
5. 데이터베이스 연동 지원
    - JDBC
    - Spring JDBC
    - ORM(JPA)
    - MyBatis

등등..

<br>

# 📌 DI(Dependency Injection) ⭐
- 의존 관계 주입
- 객체를 직접 생성하는 것이 아니라 외부에서 생성한 후 주입시켜주는 방식
- 애플리케이션 실행 시점(런타임)에 실제 의존 관계가 설정됨
- DI를 통해 모듈 간의 결합도가 낮아지고, 유연성이 높아짐
- 스프링 전반에 걸쳐서 DI가 적용되어 있음

<br>

### ✅ 애노테이션을 사용한 생성자 주입
불변, 필수 의존관계에 사용 (권장)
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

### ✅ 애노테이션을 사용한 Setter 주입
선택, 변경 가능성이 있는 의존 관계에 사용
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

### ✅ XML 설정 파일
빈 객체를 생성하여 각 객체에 생성자 인자 또는 Setter 프로퍼티를 설정해준다.
```xml
<!-- 빈 객체 생성 -->
<bean id="pen" name="p1 p2 p3" class="com.test.spring.di02.Pen"></bean>
<bean id="brush" class="com.test.spring.di02.Brush"></bean>


<!-- Spring DI -->
<bean id="hong" class="com.test.spring.di02.Hong">
    <!-- 생성자 인자 -->
    <constructor-arg ref="pen"></constructor-arg>
</bean>

<bean id="lee" class="com.test.spring.di02.Lee">
    <!-- Setter 프로퍼티 -->
    <property name="brush" ref="brush"></property>
</bean>
```

<br>

# 📌 IoC(Inversion of Control) ⭐
- 제어의 역전(역제어)
- 스프링 애플리케이션에서는 오브젝트의 생성과 관계설정, 사용, 제거 등의 작업을 코드 대신 독립된 컨테이너가 담당한다.
- 컨테이너가 코드 대신 오브젝트에 대한 제어권을 가지고 있다. 
- DI 구현 시 자연스럽게 구현된다.
- 의존성을 역전시켜 객체 간의 결합도를 줄이고 유연한 코드를 작성할 수 있게하여 가독성이 높아지고 코드 중복을 줄일 수 있으며 유지 보수를 편리하게 할 수 있다.

<br>

### ✅ IoC 컨테이너 (= 스프링 컨테이너)
- 객체를 생성하고 관리하면서 의존관계를 연결해주는 역할
- 개발자는 직접 객체를 관리하는 대신 비즈니스 로직에 집중할 수 있다.


<br>

# 📌 AOP (Aspect Oriented Programming) ⭐ 
- 관점 지향 프로그래밍
- 주업무와 보조업무(로깅, 인증 등과 관련된 코드)를 **분리**시켜 각각의 업무를 관리하는 기술
- 생산성 및 유지 보수성 향상
- 주요 관심사(Core Concern)로부터 횡단 관심사(Cross-cutting Concern)의 분리를 허용함으로써 모듈성을 증가시키는 것이 목표

<br>

### ✅ AOP 용어
- **조인포인트(Joinpoint)** 
    - 클라이언트가 호출하는 모든 비즈니스 메서드, 포인트컷의 후보
- **포인트컷(Pointcut)**
    - 공통 기능을 수행 시킬 특정 메서드
    - AspectJ 표현식 : 접근 지정자 리턴타입 패키지경로 클래스명 메서드명(매개변수)
    - 표현식 e.g. `<aop:pointcut expression="execution(public void com.test.spring.aop.MemoImpl.add(String))" id="p1"/>`
- **어드바이스(Advice)**
    - 공통 기능을 하는 코드, 독립된 클래스의 메서드로 작성
    - Before : 메서드 실행 전에 동작
    - After : 메서드 실행 전에 동작
    - After-returning : 메서드 실행 전에 동작
    - After-throwing : 예외가 발생한 후에 동작
    - Around : 메서드 호출 이전, 이후, 예외발생 등 모든 시점에서 동작
- **위빙(Weaving)**
    - 어드바이스를 핵심 코드에 적용
    
- **애스팩트(Aspect)**
    - 포인트컷 + 어드바이스
    - 어떤 포인트컷 메서드에 대해 어떤 어드바이스 메서드를 실행할지 결정

<br>



[참고 - IoC 컨테이너와 DI](https://gunju-ko.github.io/toby-spring/2019/03/25/IoC-%EC%BB%A8%ED%85%8C%EC%9D%B4%EB%84%88%EC%99%80-DI.html)

[참고 - AOP](https://sjh836.tistory.com/157)