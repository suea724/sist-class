# 📌 WEB
>**개발환경 & 실행환경**
- Server : 웹 서버(Apache Tomcat, Nginix, ...)
- Client : 웹 브라우저(chrome, edge, ...)

<br>

### ✅ URL, Uniform Resource Locator
- 브라우저가 웹서버에 접속하기 위해 지정한 서버측 주소
- 인터넷에서 웹 페이지, 이미지, 비디오 등 리소스의 위치를 나타낸다.
- Client에서 Server의 저장장치에 있는 자원을 요청할 때 사용한다. (WEBAPP 폴더 내 파일)
- 외부 : http://localhost:8090/ClientTest/hello.html
- 내부 : webapp/hello.html
- e.g. http://www.naver.com:80

<br>

#### 👉 http://
- **프로토콜**
- Hyper Text Transfer Protocol
- 서버와 클라이언트 간 웹 페이지를 주고받기 위한 통신 규칙
- HTTPS는 HTTP의 보안이 강화된 버전으로 요즘 웹에서 기본으로 쓰인다.


#### 👉 naver.com
- **호스트**
- Server IP Address 지정
- 서버측 호스트(컴퓨터)를 찾는 주소
- DNS에 의해 도메인이 Server IP Address로 변환된다.

#### 👉 :80
- **포트 번호**
- 웹 서버에서 자원을 접근하기 위한 포트 번호
- 80 : HTTP 프로토콜을 위한 예약 포트 번호
- 443 : HTTPS 프로토콜을 위한 예약 포트 번호

<br>

# 📌 Front-End (HTML, CSS, JS)
### ✅ HTML
- **Hyper Text Markup Language**
- Hyper Text : 단순 텍스트가 아닌 링크를 통해 다른 문서에 접근할 수 있는 문서
- MarkUp Language: 태그를 이용하여 문서 또는 데이터의 구조를 나타내는 언어
- 프로그래밍 언어(X) > 프레젠테이션 언어(O)
- HTML 주관 단체 : [W3C, World Wide Web Consortium](https://w3.org)
- 웹 페이지 **골격** 작성
- HTML 4.01, XHTML 1.0, HTML5
- HTML 4.01 : 가장 대중화된 버전(웹 가장 활성화)
- XHTML 1.0 : XML + HTML > 문법 강력하게 준수
### ✅ CSS
- 웹 페이지 **서식** 작성
### ✅ JavaScript
- 웹 페이지 **기능** 작성
- 프로그래밍 구현

<br>

# 📌 HTML
### ✅ HTML 요소
- **태그(Tag)**
	
    - 예약어(명령어)를 <>로 묶어놓은 요소
    - 웹 페이지의 레이아웃 형성 및 요소 배치 역할
- **속성(Attribute)**
  - 태그의 성질을 정의하는 요소
	
- **텍스트(PCDATA)**
  - Parsed Character Data : 브라우저가 해석하는 영역의 문자열
  
- **엔티티(Entity)**
  - 브라우저와 정해진 약속이 되어있는 표현
  - 약속된 표현 작성 시 브라우저에서 변환되어 출력된다.
  - Built-in Entity
  - `&nbsp;` : 공백
  - `&lt;` : <
  - `&gt;` : >
  - `&#문자코드;`

<br>

# 📌 HTML 태그
### ✅ HTML 문서 기본 태그
```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title></title>
  </head>
<body>
</body>
</html>
```

|태그|설명|
|:-:|-|
|`<!DOCTYPE>`|웹 문서의 유형 지정|
|`<html>`|HTML 문서의 범위 설정|
|`<head>`|브라우저에 전달되는 문서의 정보를 설정<br>`<meta>` : 문서에 대한 부수적인 정보 기술(인코딩, 요약정보 등) <br> `<title>` : 브라우저에 표시되는 문서 제목, 검색 엔진의 수집 대상| 
|`<body>`|브라우저에 출력될 문서의 내용|

<br>

### ✅ 인라인 태그 vs 블럭 태그
- 모든 태그는 두 부류 중 하나
- 렌더링(화면에 출력) 결과가 서로 다름

#### 👉 인라인 태그
- 자신의 내용물과 다른 태그의 내용물을 같은 라인에 출력한다.
- 내용물의 크기가 태그의 영역
- e.g. `<a>`, `<font>`, `<img>`

#### 👉 블럭 태그
- 자신의 내용물과 다른 태그의 내용물을 다른 라인에 출력
- 내용물의 크기와 상관없이 태그의 영역(너비)는 항상 100%. 높이는 내용물의 크기와 동일하다.
- e.g. `<p>`

<br>

### ✅ 제목 및 내용 관련 태그
|태그|설명|
|:-:|-|
|`<h1>, <h2>, ... , <h6>`|제목|
|`<p>`|단락|
|`<br>`|줄바꿈|
|`<blockquote>`|인용문|
|`<strong>`|텍스트 굵게, 중요한 내용일 때|
|`<b>`|텍스트 굵게, 단순히 텍스트를 굵게 표시할 때|
|`<em>`|텍스트 기울이기, 강조할 때|
|`<i>`|텍스트 기울이기, 단순히 텍스트를 기울여 표시할 때|
|`<u>`|텍스트 밑줄|
|`<s>`|텍스트 취소선, <s>obsolute</s>|
|`<code>`|소스 코드|
|`<sub>`|아래 첨자|
|`<sup>`|위 첨자|
|`<ins>`|새로운 내용 삽입|
|`<del>`|기존 내용 삭제|

<br>

### ✅ 목록 태그
```html
<ol>
  <li></li>
  <li></li>
</ol>

<ul>
  <li></li>
  <li></li>
</ul>

<dl>
  <dt></dt>
  <dd></dd>
</dl>
```
|태그|설명|
|:-:|-|
|`<ol>`|순서가 있는 목록 (ordered list) <br> `type="A or 1 or I"` : 영문자, 숫자, 로마 숫자 지정 가능 <br> `start="3"` : 시작 번호 지정 가능 |
|`<ul>`|순서가 있는 목록 (unordered list)|
|`<dl>`|용어와 그에 대한 설명을 나타내는 목록 <br>`<dt>` : 설명할 용어(term) <br> `<dd>` : 설명(description)|

<br>

### ✅ 하이퍼링크 태그
```html
<a href="링크">요소</a>
```
|태그|설명|
|:-:|-|
|`<a>`|하이퍼 링크를 삽입 <br> `href="주소"` : 이동할 링크 지정<br> `target="_self or _blank"` : 현재 탭 또는 새탭에서 열기(내부 링크 or 외부 링크)|

<br>

### ✅ 이미지
```html
<img src="이미지 파일 경로" alt="대체 텍스트">
```
|태그|설명|
|:-:|-|
|`<img>`|`src=` : 이미지 파일 경로 <br> `alt=` : 대체 텍스트 <br> `width=` : 너비 지정(% or px)<br> `height=` : 높이 지정(% or px)|


<br>


### ✅  테이블
```html
<table>
  <tr>
    <th></th>
    <th></th>
  </tr>
  <tr>
    <td></td>
    <td></td>
  </tr>
</table>
```

|태그|설명|
|:-:|-|
|`<table>`|테이블 생성|
|`<th>`|테이블의 헤더|
|`<tr>`|테이블의 행|
|`<td>`|테이블의 열|

<br>

- **테이블 디자인 속성**

|속성|설명|
|:-:|-|
|`border=`|테이블 테두리 두께 설정|
|`bordercolor=`|테이블 테두리 색상|
|`width=`|테이블 가로 길이|
|`hegiht=`|테이블 세로 길이|
|`align=`|가로 정렬|
|`valign=`|세로 정렬|
|`colspan=`|열 병합(가로 병합)|
|`rowspan=`|행 병합(세로 병합)|

<br>

### ✅ Form
클라이언트로부터 입력받은 값을 서버로 전송하는 역할

|속성 및 태그|설명|
|:-:|-|
|`method=`|`GET` : 쿼리 파라미터를 통해 데이터를 전송 (보안X) <br> `POST` : HTTP 메세지를 통해 데이터 전송 (보안O)|
|`action=`|데이터를 수신할 서버측 주소 설정|
|`autocomplete=`|자동 완성 기능 지정(기본값 : on)|
|`<fieldset>`|폼 내부에서 구역을 나눔 <br> `<legend>` : 구역 제목 설정|
  
<br>

### ✅ input
- **input 속성**

|속성|설명|
|:-:|-|
|type|입력 컨트롤 종류 지정|
|size|길이 (문자 개수)|
|maxlength|최대 입력 길이|
|value|서버에 전달되는 입력값|
|readonly|읽기 전용(서버에 전송 O)|
|disabled|비활성화(서버에 전송 X)|
|accesskey|바로가기(Alt + 조합키)|
|autofocus|자동 포커스|
|autocomplete|자동 완성 (기본값 : on)|
|required|필수 입력 필드|
|placeholder|힌트 표시, 내용 입력 시 사라짐|
|checked|체크박스 또는 라디오버튼에서 체크 활성화|
|min|최소값(기본값 0)|
|max|최대값(기본값 100)|
|step|증감치(기본값 1)|


<br>

- **type 속성값 종류**

|속성값|설명|
|:-:|-|
|text|한줄 텍스트|
|password|비밀번호|
|url|url (유효성 검사 O)|
|email|이메일 주소 (유효성 검사 O)|
|tel|전화번호 (유효성 검사 X)|
|checkbox|체크박스|
|radio|라디오버튼|
|number|숫자 스핀 박스|
|range|슬라이드 막대|
|date|연, 월, 일|
|month|연, 월|
|week|연, 주|
|time|시, 분, 초|
|datetime-local|연, 월, 일, 시, 분, 초|
|submit|전송 버튼|
|reset|리셋 버튼|
|file|파일 첨부 버튼|
|hidden|사용자에게 보이지 않는 값 (개발자용)|

<br>

### ✅ input 이외의 주요 태그
|태그|설명|
|:-:|-|
|`<textarea>`|다중 라인 텍스트 영역 <br> `rows=` : 세로 줄 수 <br> `cols=` : 가로 너비|
|`<select>`|드롭다운 목록 <br> `size=` : 항목 개수 <br> `mulitple` : 다중 항목 선택 <br> `<option>` : 옵션|


<br>

[참고](https://yunbinni.tistory.com/63)