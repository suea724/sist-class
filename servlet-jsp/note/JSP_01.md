# 📌 JSP, Java Server Pages
- 서블릿에서 화면처리의 어려움을 해결하기 위해 등장한 서버 사이드 스크립트 언어
- HTML 코드에 자바 코드를 넣어 동적인 웹 페이지를 생성한다.

<br>

### ✅ JSP 특징
- 자바 기능을 그대로 사용한다.
- Tomcat(WAS)이 이미 만들어놓은 객체를 사용한다. e.g. request, response, session 등
- 사용자 정의태그를 사용하여 보다 효율적으로 웹사이트를 구성할 수 있다. (JSTL 사용)
- HTML 코드를 작성하기 쉽다.
- Servlet과 다르게 JSP는 수정된 경우 재컴파일 할 필요없이 Tomcat(WAS)이 알아서 처리해준다.

<br>

### ✅ JSP 동작
![](https://mblogthumb-phinf.pstatic.net/20150604_85/islove8587_1433408612779SkNsM_JPEG/4_JSP%C0%C7%B5%BF%C0%DB%B1%B8%C1%B6.jpg?type=w2)
1. JSP가 실행되면 WAS는 내부적으로 JSP 파일을 Java Servlet(.java)으로 변환한다.
2. WAS는 변환한 [Servlet을 동작](./Servlet_01.md)시켜 필요한 기능을 수행한다.
3. 수행 완료 후 생성된 웹 페이지를 클라이언트로 응답한다.

<br>

### ✅ JSP 내장 객체
- 개발자가 직접 생성하지 않아도 Tomcat에서 미리 만들어서 제공하는 객체를 사용할 수 있다.
- request, response, session, pageContext, application, out, config, page, exception


<br>

### ✅ JSP 문법
#### 1️⃣ JSP Expression
- `<%= expression %>`
- JSP Expression요소는 String으로 반환되어 Servlet의 출력에 삽입된다.
- 자바 프로그래밍으로 산출된 값을 HTML 문서의 PCDATA, CSS, JS에서 사용할 수 있다.

<br>

#### 2️⃣ JSP Directive
- `<%@ directive %>`
- JSP 페이지의 전체적인 구조에 영향을 미친다.
1. **page**
    - `<%@ page attribute = "value" %>`
    - page 지시어는 Container에 명령을 제공하는데 사용
    - JSP 컨테이너에게 해당 페이지의 정보를 알려준다.
2. **include**
    - `<%@ include file = "relative_url" %>`
    - 외부 파일의 내용을 현재 JSP에 병합하도록 지시한다.
    - e.g. 웹 페이지의 header와 footer를 각 페이지에 삽입 시 사용
3. **taglib**
    - `<%@ taglib uri = "uri" prefix = "prefixOfTag" %>`
    - JSP API를 사용하면 HTML 태그처럼 보이는 사용자 정의 태그를 정의할 수 있다.

<br>

#### 3️⃣ JSP Scriptlet
- `<% code fragment %>`
- 임의의 자바 코드를 삽입할 수 있는 영역을 제공한다.
- 메서드가 아닌 변수만 선언할 수 있다. (메서드 영역)

<br>

#### 4️⃣ JSP Declaration
- `<%! declaration %>`
- Servlet 클래스에 삽입되는 메서드나 필드를 정의할 수 있다. (클래스 영역)
- 선언된 메서드 또는 필드는 해당 JSP 페이지 내에서 유효하다.
- 일반적으로 자주 사용하지 않고, 메서드를 사용해야 하는 경우 자바 클래스를 import하여 사용한다.

<br>

#### 5️⃣ JSP Comment
- `<% comment %>`
- 주석

<br>

#### 6️⃣ JSP Action
- JSP Action XML 구문 안의 구조들을 사용하여 WAS의 동작을 제어한다.
1. `<jsp:forward>`
    - 다른 리소스(JSP, html 등)로 요청을 전달할 때 사용한다.
2. `<jsp:include>`
    - 현재 JSP 페이지에 다른 리소스를 포함시킬 때 사용한다.
3. `<jsp:useBean>`
    - 해당하는 Bean(자바 객체)이 이미 존재하는지 확인한다.
    - 객체가 없으면 지정된 객체를 생성한다.
4. `<jsp:setProperty>`
    - Bean(자바 객체)의 속성을 설정한다.
5. `<jsp:getProperty>`
    - 주어진 속성값을 가져오는데 사용되며 이를 문자열로 변환하고 동적인 웹 페이지를 생성할 때 해당 내용을 사용할 수 있다.

<br>

> JSP Action 태그를 사용한 자바 빈 접근 예시
```html
<%-- JSP 1.2(old) --%>
<jsp:useBean id="customer" type="beans.Customer" scope="request"> 
</jsp:useBean>

<ul>
  <li>Name: <jsp:getProperty name="customer" property="name" /></li>
  <li>Email: <jsp:getProperty name="customer" property="email" /></li>  
  <li>ID: <jsp:getProperty name="customer" property="id" /></li>
</ul>  
```

<br>

### ✅ JSP EL(Expression Language)
- 객체 Bean에 접근하는 방법 제공
- JSP 2.0의 주요 구성 요소 중 하나
- EL을 사용 시 Java Beans 구성 요소에 저장된 데이터에 쉽게 접근할 수 있다.

<br>

> JSP EL을 사용한 자바 빈 접근 예시
```html
<%-- JSP 2.0(Preferred)  --%>
<ul>
  <li>Name: ${customer.name}</li>
  <li>Email: ${customer.email}</li>  
  <li>ID: ${customer.id}</li>
</ul> 
```

<br>

### ✅ JSTL, JSP Standard Tag Library
- 복잡한 일을 수행하는 임의의 자바 코드를 삽입하는 방법
- 많은 JSP 애플리케이션의 공통적인 핵심 기능을 캡슐화하는 유용한 JSP 태그 모음
- 가장 많이 사용하는 태그 확장 라이브러리
- JSP에 **자바 코드를 직접 작성하는 대신 태그를 사용**하여 프로그래밍 할 수 있도록 하기 위해 도입됨
- 분류
    - Core
    - Formatting tags
    - SQL tags
    - XML tags
    - JSTL Functions
- taglib 지시어를 사용하여 해당 JSP 페이지가 Custom 태그 집합을 사용한다고 선언한다.
- prefix를 설정하여 여러 개의 tag library를 식별한다.

<br>

> JSTL 활용 예시
```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Count to 10 Example (using JSTL)</title>
</head>
<body>
   <c:forEach var="i" begin="1" end="10" step="1">
      <c:out value="${i}"/>
      <br/>
   </c:forEach>
</body>
</html>
```


<br>

[참고](https://gmlwjd9405.github.io/2018/11/03/jsp.html)