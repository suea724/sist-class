# ๐ EL, Expression Language
- JSP Expression(`<%= %>`) ์ฌ์ฉ ์ ๊ฐ๋์ฑ์ด ๋จ์ด์ง๊ธฐ ๋๋ฌธ์ ์ด๋ฅผ ํด๊ฒฐํ๊ธฐ ์ํด ๋์จ ๋ฌธ๋ฒ
- `${์์ฑ๋ช}`
- ์๋ฐ์ ๊ฐ์ HTML ์์ค์ ์ถ๋ ฅํ๋ ์ญํ ์ ํ๋ค.
- ์ผ๋ฐ ๋ณ์๊ฐ ์๋ pageContext, request, session, application ๊ฐ์ฒด ๋ด ์ ์ฅ์์ ๊ฐ๋ง ์ถ๋ ฅํ  ์ ์๋ค.
- ๊ฐ์ ์ฐพ์ ๋ ์์ Scope์์ ํฐ Scope๋ก ์ฐพ๋๋ค. (pageContext โ request โ session โ application)

<br>

### โ JSP ๋ด์ฅ ๊ฐ์ฒด ์๋ช์ฃผ๊ธฐ
- ์ฃผ๋ก `request`์ `session`์ ํ์ฉํ๋ค. ๋ชจ๋  ์ฌ์ฉ์๊ฐ ๊ณต์ ํ๊ฑฐ๋ ์น ์ ํ๋ฆฌ์ผ์ด์ ์ ์ฒด์์ ํ์๋ก ํ๋ ๊ฒฝ์ฐ `application`์ ์ฌ์ฉํ  ์ ์๋ค.

|๋ด์ฅ๊ฐ์ฒด|์์ฑ|์๋ฉธ|๋ฒ์|
|-|-|-|-|
|page|ํ์ฌ ํ์ด์ง ์๋ธ๋ฆฟ ์คํ ์|์๋ธ๋ฆฟ ์๋ฉธ ๋๋ ์ฌ์์ ์|ํ์ฌ ํ์ด์ง|
|request|ํ์ฌ ํ์ด์ง ์์ฒญ ์|๋ค๋ฅธ ํ์ด์ง๋ก ์ด๋ ์|ํ์ฌ ํ์ด์ง, ํฌ์๋ฉ ํ๋ ๊ฒฝ์ฐ ๋ค์ ํ์ด์ง๊น์ง|
|session|ํด๋ผ์ด์ธํธ๊ฐ ์๋ฒ์ ์ ์ํ  ๋|์ผ์ ์๊ฐ์ด ์ง๋๊ฑฐ๋ ๋ธ๋ผ์ฐ์  ์ข๋ฃ ์|๋์ผ ํด๋ผ์ด์ธํธ, ๋ค๋ฅธ ํ์ด์ง|
|application|์น ์ ํ๋ฆฌ์ผ์ด์ ์์|์น ์ ํ๋ฆฌ์ผ์ด์ ์ข๋ฃ|๋ชจ๋  ํด๋ผ์ด์ธํธ|

<br>

### โ EL ๊ธฐ๋ณธ ๊ฐ์ฒด

#### ๐ ๋ด์ฅ ๊ฐ์ฒด ์ ๊ทผ
๊ฐ์ ์ด๋ฆ์ ์์ฑ์ด ์ ์๋์ด ์์ ๋ ์์ฑ์ ๊ฒ์ ๋ฒ์๋ฅผ ์ง์ ํ  ์ ์๋ค.

- `pageScope` : pageContext๊ฐ์ฒด์ ์ ๊ทผ
- `requestScope` : request๊ฐ์ฒด์ ์ ๊ทผ
- `sessionScope` : session๊ฐ์ฒด์ ์ ๊ทผ
- `applicationScope` : application ๊ฐ์ฒด์ ์ ๊ทผ

<br>

#### ๐ ํ๋ผ๋ฏธํฐ ์ ์ด ๊ฐ์ฒด
- `param` : request.getParameter()
- `paramValues` : request.getParameterValues()

<br>

### โ ์์
> ๊ฐ ์ถ๋ ฅ
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

> ๊ฐ์ฒด ํ๋กํผํฐ ์ถ๋ ฅ
```jsp
<%
    Student s = new Student();

    s.setName("ํ๊ธธ๋");
    s.setKor(100);
    s.setEng(90);
    s.setMath(80);
    
    request.setAttribute("s", s);
%>

<!-- ๊ฐ ํ๋กํผํฐ์ getter ํธ์ถ -->
<div>์ด๋ฆ : ${s.name}</div>
<div>์ด์  : ${s.kor + s.eng + s.math}</div> 
```

<br>

> HashMap ๊ฐ ์ถ๋ ฅ
```jsp
<%
    HashMap<String, String> map = new HashMap<String, String>();

    map.put("name", "ํ๊ธธ๋");
    map.put("age", "20");
    map.put("job", "ํ์");

    pageContext.setAttribute("map", map);
%>

<div>์ด๋ฆ: ${ map.get("name") }</div>
<div>๋์ด: ${ map["age"] }</div>
<div>์ง์: ${ map.job }</div>
```
> 

<br>


# ๐ JSTL, JSP Standard Tag Library
- JSP์์ ์์ฃผ ์ฌ์ฉํ๋ ๊ธฐ๋ฅ(๋ฐ๋ณต๋ฌธ, ์กฐ๊ฑด๋ฌธ, ๋ฐ์ดํฐ ํํ ๋ฑ)์ ๋ฏธ๋ฆฌ ๊ตฌํํด๋์ ์ปค์คํ ํ๊ทธ ๋ผ์ด๋ธ๋ฌ๋ฆฌ ๋ชจ์
- JSTL์ EL์ ์ฌ์ฉํ์ฌ ํํํ๋ค.

<br>

### โ ํ๊ฒฝ์ค์ 
- jstl lib(jstl-1.2.jar) ๋ค์ด ํ `WEB-INF/lib`์ ์ถ๊ฐํด์ผ ์ฌ์ฉํ  ์ ์๋ค.
- ์ง์์ ํ๊ทธ๋ฅผ ํตํด prefix๋ฅผ ์ค์ ํด์ผ ํ๋ค.
    - `<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>`

<br>

### โ JSTL Core ํ๊ทธ
- **<c:set>**
    - ๋ณ์ ์ ์ธ ์ ์ฌ์ฉ
    - ๋ก์ปฌ ๋ณ์๊ฐ ์๋ ์๋ธ๋ฆฟ ๋ณด๊ด์(JspContext, ServletRequest, HttpSession, ServletContext)์ ์ ์ฅ๋๋ค. 
```jsp
<c:set var="a" value="10" />
```
- **<c:if>**
    - ์กฐ๊ฑด๋ฌธ
    - else if, else ๋ฌธ์ ์กด์ฌํ์ง ์๋๋ค.
```jsp
<c:if test="${num > 0}">
    <div>${num}์ ์์์๋๋ค.</div>
</c:if>
```
- **<c:choose>**
    - ๋ค์ค ์กฐ๊ฑด
```jsp
<c:choose>
    <c:when test="${num > 0}">์์</c:when>
    <c:when test="${num < 0}">์์</c:when>
    <c:otherwise>์</c:otherwise>
</c:choose>
```

- **<c:forEach>**
    - ๋ฐ๋ณต ์์์ ์ฌ์ฉ
```jsp
<!-- ๋จ์ ๋ฐ๋ณต๋ฌธ -->
<c:forEach var="i" begin="0" end="9" step="1">
    <div>์์ดํ ${i}</div>
</c:forEach>

<!-- ๋ฐฐ์ด์ ์ฌ์ฉ -->
<%
    String[] names = {"ํ๊ธธ๋", "์๋ฌด๊ฐ", "ํํํ", "ํธํธํธ", "ํํํ"};
    pageContext.setAttribute("names", names);
%>

<ol>
    <c:forEach var="name" items="${names}"> <!-- items์ ๋ฃจํ๋ฅผ ๋๋ฉด์ ๊ฐ ํญ๋ชฉ์ด var์ ๋ด๊ธด๋ค. -->
        <li>${name}</li>
    </c:forEach>
</ol>
```
- **<c:remove>**
    - ๋ณด๊ด์์ ์ ์ฅ๋ ๊ฐ์ ์ ๊ฑฐํ๋ค.
```jsp
<c:remove var="c" />
```
<br>


[์ฐธ๊ณ ](https://creamilk88.tistory.com/117)