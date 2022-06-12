# 📌 DOM, Document Object Model
- XML이나 HTML문서에 접근하기 위한 일종의 인터페이스
- W3C의 표준 객체 모델
- 문서 내의 모든 요소를 **계층으로 표현**하고, 각 **요소에 접근하는 방법**을 제공하여 생성, 변형, 삭제 할 수 있도록 한다.

> DOM 계층 구조

![](./img_js_htmldom.png)

<br>

### ✅ DOM의 종류
W3C DOM 표준은 세가지 모델로 구분된다.
1. **Core DOM** : 모든 문서 타입을 위한 DOM 모델
2. **HTML DOM** : HTML 문서를 위한 DOM 모델
3. **XML DOM** : XML 문서를 위한 DOM 모델

<br>

# 📌 Document 객체
- 웹 페이지 그 자체
- 웹 페이지에 존재하는 HTML 요소에 접근하려면 Document 객체부터 시작해야 한다.

<br>

### ✅ Document 메서드
- **HTML 요소의 선택**
    - `document.getElementsByTagName(태그이름)` : 해당 태그 이름의 요소를 모두 선택
    - `document.getElementById(아이디)` : 해당 아이디의 요소를 선택
    - `document.getElementsByClassName(클래스이름)` : 해당 클래스에 속한 요소를 모두 선택
    - `document.getElementsByName(name속성값)` : 해당 name 속성값을 가지는 요소를 모두 선택
    - `document.querySelectorAll(선택자)` : 해당 선택자로 선택되는 요소를 모두 선택

    <br>


- **HTML 요소의 생성**
    - `document.createElement(HTML요소)` : 지정된 HTML 요소를 생성
    - `document.write(텍스트)` : HTML 출력 스트림을 통해 텍스트를 출력

    <br>


- **HTML 이벤트 핸들러 추가**
    - `document.getElementById(아이디).onclick = function() {실행할 코드}` : 마우스 클릭 이벤트와 연결될 이벤트 핸들러 코드를 추가

    <br>

- **HTML 객체의 선택**
    - `document.body` : body 요소를 반환
    - `document.images` : img 요소를 모두 반환함
    - [더보기](http://www.tcpschool.com/javascript/js_dom_document)

