# 📌 JSP 내장 객체
- JSP가 서블릿 코드로 변환될 때 JSP 컨테이너가 제공하는 객체
- 별도의 선언 없이 사용 가능
- pageContext, request, session, application은 객체 내부에 사용자 정의 데이터를 저장하는 컬렉션을 가지고 있다.

<br> 

#### 👉 종류
|내장 객체|리턴 타입|설명|
|-|-|-|
|request|javax.servlet.http.HttpServletRequest|웹 브라우저의 요청 정보를 저장하고 있는 객체|
|response|javax.servlet.http.HttpServletRequest|웹 브라우저의 요청에 대한 응답 정보를 저장하고 있는 객체|
|out|javax.servlet.jsp.jsp.jspWriter|JSP 페이지에 출력할 내용을 가지고 있는 출력 스트림 객체|
|session|javax.servlet.http.HttpSession|웹 페이지에서 사용자의 정보를 유지하기 위한 세션 정보를 저장하고 있는 객체|
|application|javax.servlet.ServletContext|웹 어플리케이션 Context의 정보를 저장하고 있는 객체|
|pageContext|javax.servlet.jsp.PageContext|다른 내장 객체의 참조나 forward에 사용|
|page|java.lang.Object|현재 JSP 문서 정보 처리, 현재 페이지의 서블릿 객체를 가리킴|
|config|javax.servlet.ServletConfig|JSP 페이지에 대한 설정 정보를 저장하고 있는 객체|
|exception|java.lang.Throwable|JSP 페이지에서 예외가 발생한 경우 사용되는 객체|

<br>

### ✅ request 객체
클라이언트에서 서버로 서블릿이나 jsp 요청 시 생성된다.

<br>

#### 👉 주요 기능
- 웹 서버의 기본적인 사용자 인증
- 폼 입력 데이터 접근
- 요청 URL을 비롯한 경로 정보
- HTTP 헤더 정보 참조
- 속성 저장 및 참조

<br>

#### 👉 메서드
|메서드|설명|
|-|-|
|request.getRequestURI()|요청 URL|
|request.getServerName()|요청 서버 도메인|
|request.getQueryString()|요청 쿼리 스트링|
|request.getRemoteAddr()|클라이언트 주소|
|request.getMethod()|요청 메서드(GET, POST)|
|request.getContextPath()|컨텍스트 경로|
|request.getHeader(String name)|특정한 요청 헤더|
|request.getHeaderNames()|요청 헤더 내의 모든 이름|


[API DOC](https://docs.oracle.com/javaee/7/api/javax/servlet/http/HttpServletRequest.html)

<br>

### ✅ response 객체
request 객체와 마찬가지로 클라이언트에서 서버로 서블릿이나 jsp 요청 시 생성된다.

<br>

#### 👉 주요 기능
- 쿠키 설정
- 응답 헤더 설정 및 참조
- 상태정보 및 에러 전달
- 페이지 리다이렉션

<br>

#### 👉 메서드
|메서드|설명|
|-|-|
|response.addCookie()|쿠키 객체 등록|
|response.setContentType()|응답의 콘텐츠 유형 설정 e.g. text/html|
|response.getWriter()|PrintWriter 객체를 가져옴|
|response.setCharacterEncoding("UTF-8")|반환할 페이지의 인코딩 설정|
|response.setHeader(String name, String value)|응답 헤더에 속성과 값 추가|
|response.setStatus(int sc)|상태 코드 설정|
|response.sendError(int sc, String msg)|상태 코드와 에러 메세지를 설정하여 오류 응답을 보냄|
|response.sendRedirect(String location)|지정된 주소로 이동|

[API DOC](https://docs.oracle.com/javaee/7/api/javax/servlet/http/HttpServletResponse.html)

<br>

### ✅ pageContext
다른 내장 객체들(request, response, session, application 등)에 접근하기 위한 객체
|메서드|설명|
|-|-|
|pageContext.forward()|다른 페이지로 이동과 동시에 데이터를 전달|

[API DOC](https://docs.oracle.com/javaee/7/api/javax/servlet/jsp/PageContext.html)

<br>

#### 💡 pageContext.forward()와 response.sendRedirect()의 차이
![](https://i2sec.github.io/images/2017-03-30/2.png)
- `pageContext.forward()`
    - **서버 내부**에서 발생하는 호출이다.
    - 이동한 URL로 요청 정보를 그대로 전달한다.
    - URL을 비롯한 요청 정보의 변화가 없다.
    - 현재 실행 중인 페이지와 forward에 의해 호출될 페이지는 **request와 response 객체를 공유**한다.
    - URL의 변화가 없다.
- `response.sendRedirect()`
    - redirect 명령이 들어오면 서버는 **웹 브라우저**에게 다른 페이지로 이동하라고 명령을 내린다.
    - 웹 브라우저는 새로운 URL로 다시 요청을 보낸다.
    - 새로운 페이지에서는 **request와 response 객체가 새롭게 생성**된다.

[참고](https://kotlinworld.com/329)


<br>

### ✅ session
HTTP 프로토콜은 **비연결형 구조**를 사용하기 때문에 페이지의 요청과 응답이 완료되면 연결이 유지되지 않는다. 세션은 클라이언트와 서버 간 정보를 전달하기 위해 사용하는 객체이다. 사용자가 웹 서버에 접속할 때마다 생성되며, 일정시간 또는 브라우저 종료 전까지 유지된다. 로그인 유지, 장바구니 등에서 다양하게 사용된다. 세션을 생성하면 메모리의 공간을 차지하므로 최소한의 정보만 담아야 한다.

<br>

#### 👉 주요 기능
- 세션 정보 참조
- 세션 유효 시간 설정
- 속성 저장 및 참조

<br>

#### 👉 메서드
|메서드|설명|
|-|-|
|session.getCreationTime()|세션 생성 시간의 tick값을 가져옴|
|session.getId()|각 세션을 구분하는 ID를 가져옴|
|session.getLastAccessedTime()|클라이언트가 이 세션과 관련된 요청을 마지막으로 보낸 시간을 tick값으로 가져옴|
|session.MaxInactiveInterval()|세션 유효 시간을 가져옴(기본 1800초, 30분)|
|session.invalidate()|세션을 무효화|
|session.isNew()|새로 생성된 세션인지 여부|

[API DOC](https://docs.oracle.com/javaee/7/api/javax/servlet/http/HttpSession.html)

<br>

### ✅ application
웹 애플리케이션이 시작될 때 함께 생성되며 현재 웹 애플리케이션의 상태나 서버 관련 정보 처리에 사용한다.

<br>

#### 👉 주요 기능
- 서버 버전 정보
- 서버 로그 생성
- 서블릿, 필터, 리스너 등록
- 속성 저장 및 참조