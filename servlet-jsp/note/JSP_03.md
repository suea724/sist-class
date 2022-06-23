# 📌 EL, Expression Language
- JSP Expression(`<%= %>`) 사용 시 가독성이 떨어지기 때문에 이를 해결하기 위해 나온 문법
- `${속성명}`
- 자바의 값을 HTML 소스에 출력하는 역할을 한다.
- 일반 변수가 아닌 pageContext, request, session, application 객체 내 저장소의 값만 출력할 수 있다.
- 값을 찾을 때 작은 Scope에서 큰 Scope로 찾는다. (pageContext → request → session → application)

<br>

### ✅ JSP 내장 객체 생명주기
- 주로 `request`와 `session`을 활용한다. 모든 사용자가 공유하거나 웹 애플리케이션 전체에서 필요로 하는 경우 `application`을 사용할 수 있다.

|내장객체|생성|소멸|범위|
|-|-|-|-|
|page|현재 페이지 서블릿 실행 시|서블릿 소멸 또는 재시작 시|현재 페이지|
|request|현재 페이지 요청 시|다른 페이지로 이동 시|현재 페이지, 포워딩 하는 경우 다음 페이지까지|
|session|클라이언트가 서버에 접속할 때|일정시간이 지나거나 브라우저 종료 시|동일 클라이언트, 다른 페이지|
|application|웹 애플리케이션 시작|웹 애플리케이션 종료|모든 클라이언트|

<br>

### ✅ EL 기본 객체

#### 👉 내장 객체 접근
같은 이름의 속성이 정의되어 있을 때 속성의 검색 범위를 지정할 수 있다.

- `pageScope` : pageContext객체에 접근
- `requestScope` : request객체에 접근
- `sessionScope` : session객체에 접근
- `applicationScope` : application 객체에 접근

<br>

#### 👉 파라미터 제어 객체
- `param` : request.getParameter()
- `paramValues` : request.getParameterValues()

<br>

### ✅ 예시
> 값 출력
```jsp
<%
    pageContext.setAttribute("a", 20);
    request.setAttribute("b", 30);
    session.setAttribute("c", 40);
%>

<div>b: ${b}</div>
<div>c: ${c}</div>
<div>d: ${d}</div>
```

<br>

> 객체 프로퍼티 출력
```jsp
<%
    Student s = new Student();

    s.setName("홍길동");
    s.setKor(100);
    s.setEng(90);
    s.setMath(80);
    
    request.setAttribute("s", s);
%>

<!-- 각 프로퍼티의 getter 호출 -->
<div>이름 : ${s.name}</div>
<div>총점 : ${s.kor + s.eng + s.math}</div> 
```

<br>

> HashMap 값 출력
```jsp
<%
    HashMap<String, String> map = new HashMap<String, String>();

    map.put("name", "홍길동");
    map.put("age", "20");
    map.put("job", "학생");

    pageContext.setAttribute("map", map);
%>

<div>이름: ${ map.get("name") }</div>
<div>나이: ${ map["age"] }</div>
<div>직업: ${ map.job }</div>
```
> 

<br>


# 📌 JSTL, JSP Standard Tag Library
- JSP에서 자주 사용하는 기능(반복문, 조건문, 데이터 표현 등)을 미리 구현해놓은 커스텀 태그 라이브러리 모음
- JSTL은 EL을 사용하여 표현한다.

<br>

### ✅ 환경설정
- jstl lib(jstl-1.2.jar) 다운 후 `WEB-INF/lib`에 추가해야 사용할 수 있다.
- 지시자 태그를 통해 prefix를 설정해야 한다.
    - `<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>`

<br>

### ✅ JSTL Core 태그
- **<c:set>**
    - 변수 선언 시 사용
    - 로컬 변수가 아닌 서블릿 보관소(JspContext, ServletRequest, HttpSession, ServletContext)에 저장된다. 
```jsp
<c:set var="a" value="10" />
```
- **<c:if>**
    - 조건문
    - else if, else 문은 존재하지 않는다.
```jsp
<c:if test="${num > 0}">
    <div>${num}은 양수입니다.</div>
</c:if>
```
- **<c:choose>**
    - 다중 조건
```jsp
<c:choose>
    <c:when test="${num > 0}">양수</c:when>
    <c:when test="${num < 0}">음수</c:when>
    <c:otherwise>영</c:otherwise>
</c:choose>
```

- **<c:forEach>**
    - 반복 작업에 사용
```jsp
<!-- 단순 반복문 -->
<c:forEach var="i" begin="0" end="9" step="1">
    <div>아이템 ${i}</div>
</c:forEach>

<!-- 배열에 사용 -->
<%
    String[] names = {"홍길동", "아무개", "하하하", "호호호", "후후후"};
    pageContext.setAttribute("names", names);
%>

<ol>
    <c:forEach var="name" items="${names}"> <!-- items의 루프를 돌면서 각 항목이 var에 담긴다. -->
        <li>${name}</li>
    </c:forEach>
</ol>
```
- **<c:remove>**
    - 보관소에 저장된 값을 제거한다.
```jsp
<c:remove var="c" />
```
<br>


[참고](https://creamilk88.tistory.com/117)