# 📌 서블릿, Servlet
- **동적인 웹 페이지**를 만들 때 사용되는 자바 기반의 웹 애플리케이션 프로그래밍 기술
- 웹 요청과 응답의 흐름을 간단한 메서드 호출만으로 체계적으로 다룰 수 있게 해준다.
![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbu3HKI%2Fbtq7BerRpgq%2FiI82e9Zf9XLSwklFLjsXpk%2Fimg.png)

개발자는 웹 애플리케이션을 생성하기 위한 소스 파일(.java)을 작성하고, 이를 컴파일한 파일(.class)을 메모리에 올려 Servlet 객체를 만든다.
이 Servlet 객체는 서버에서 실행되다가 브라우저로부터 요청이 들어오면 쓰레드가 생성되고, 요청에 알맞은 동작을 수행한 뒤 웹 브라우저에 HTML 형식으로 응답한다.

<br>

### 💡 참고: Thread의 역할
#### Thread
-  운영체제로부터 시스템 자원을 할당받는 작업의 단위
- Servlet Program에서 thread가 수행할 메서드가 지정/할당되면
    - thread는 생성 후 즉시 해당 메서드만 열심히 수행한다.
    - 해당 메서드가 return하면 thread는 종료되고 제거된다.
    - 즉, 실제로 thread의 역할: Servlet의 doGet() 또는 doPost()를 호출하는 것이다.
- Web Container(Servlet Container)는 thread의 생성과 제거를 담당한다.
    - 하지만 thread의 생성과 제거의 반복은 큰 오버헤드를 만든다.
    - 이를 위해 Tomcat(WAS)은 “Thread Pool”(미리 thread를 만들어 놓음) 이라는 적절한 메커니즘을 사용하여 오버헤드를 줄인다.

<br>

### ✅ 서블릿의 주요 특징
- 클라이언트의 요청에 대해 동적으로 작동하는 웹 애플리케이션 컴포넌트
- HTML을 사용하여 응답
- Java의 Thread를 이용하여 동작
- MVC 패턴에서 컨트롤러로 사용된다.
- HTTP 프로토콜 서비스를 지원하는 javax.servlet.http.HttpServlet 클래스를 상속받는다.
- UDP보다 속도가 느리다.
- HTML 변경 시 Servlet을 재컴파일 해야 한다는 단점이 있다.

<br>


### ✅ 서블릿 동작 과정 ⭐

![](https://gmlwjd9405.github.io/images/web/servlet-program.png)
1. 사용자가 URL을 입력하면 HTTP 요청을 서블릿 컨테이너로 전송한다.
2. 요청을 받은 서블릿 컨테이너는 HttpServletRequest, HttpServletResponse 객체를 생성한다.
3. web.xml(설정 파일)을 기반으로 요청한 URL이 어느 서블릿에 대한 요청인지 찾는다.
4. 해당 서블릿에서 service() 메서드를 호출한 후, 요청의 HTTP 메서드(GET, POST)에 따라 doGet() 또는 doPost()를 호출한다.
5. doGet() 또는 doPost() 메서드는 동적 페이지를 생성한 후 HttpServletResponse 객체에 응답을 보낸다.
6. 응답 이후 HttpServletRequest, HttpServletResponse 객체를 소멸시킨다.


<br>


# 📌 서블릿 컨테이너, Servlet Container
- **서블릿을 관리**해주는 컨테이너
- 클라이언트의 요청을 처리하고 응답을 반환하기 위해 웹서버와 소켓으로 통신한다.
- e.g. Tomcat

<br>

### ✅ 서블릿 컨테이너 역할
#### 1️⃣ 웹서버와의 통신 지원
- 서블릿과 웹서버가 손쉽게 통신할 수 있도록 API를 제공하여 복잡한 과정을 생략할 수 있다.
- 개발자는 통신을 하기 위한 코드 외에 비즈니스 로직에 대해서만 초점을 맞출 수 있다.
#### 2️⃣ 서블릿 생명주기 관리
- 서블릿 클래스를 로딩하여 인스턴스화
- 초기화 메서드 호출
- 요청 발생 시 적절한 서블릿 메서드 호출
- 서블릿이 종료되면 가비지 컬렉션
#### 3️⃣ 멀티쓰레드 지원 및 관리
- 서블릿 컨테이너는 요청이 오면 미리 생성해놓은 쓰레드를 담고 있는 쓰레드 풀에서 꺼내 사용
- 동시에 여러 요청이 들어와도 멀티스레딩 환경으로 동시 작업 관리 가능 

<br>

### 📌 서블릿 생명주기
![](https://gmlwjd9405.github.io/images/web/servlet-life-cycle.png)
#### 1️⃣ init()
- 서블릿이 처음으로 요청될 때 초기화를 하는 메서드
- 초기화 된 서블릿은 싱글톤으로 관리되어 다음에 해당 서블릿 클래스를 호출하면 기존의 서블릿을 호출

<br>
    
#### 2️⃣ service()
- 요청을 처리하고 응답을 반환하는 메서드
- 서블릿 인터페이스를 구현한 HttpServlet 클래스의 doGet, doPost와 같은 메서드가 호출됨
- 여러 클라이언트가 동시에 요청을 하더라도 멀티쓰레드가 지원되기 때문에 수행 속도가 빠름

#### 3️⃣ destroy()
- 더 이상 사용되지 않는 서블릿 클래스는 주기적으로 서블릿 컨테이너가 제거
- 제거된 클래스를 다시 사용하기 위해서는 init()을 다시 해주어야 함

<br>

### ✅ 서블릿 설정 파일(web.xml)
```xml
<servlet> //서블릿 클래스를 서블릿으로 등록
    <servlet-name>myServlet</servlet-name> //해당 서블릿을 참조할 때 사용할 이름
    <servlet-class>controller.MyServlet</servlet-class> //서블릿으로 사용할 서블릿 클래스의 FullName
</servlet>

<servlet-mapping>
    <servlet-name>myServlet</servlet-name> //매핑할 서블릿의 이름
    <url-pattern>/myServlet</url-pattern> //매핑할 URL 패턴
</servlet-mapping>
```
- 서블릿을 경로와 매핑
- WAS는 이 설정파일로부터 매핑 정보를 읽어서 요청을 알맞은 서블릿에 전달할 수 있다.

<br>

[참고 자료 1](https://coding-factory.tistory.com/742) <br>
[참고 자료 2](https://mangkyu.tistory.com/14) <br>
[참고 자료 3](https://gmlwjd9405.github.io/2018/10/28/servlet.html)