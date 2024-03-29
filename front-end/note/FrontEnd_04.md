# 📌 자바스크립트
- HTML로는 웹의 구조 작성, CSS로는 웹을 디자인, 자바스크립트로는 웹의 동작을구현한다.
- 자바스크립트는 주로 웹브라우저에서 사용되지만 Node.js와 같은 프레임워크 사용 시 서버 측 프로그래밍에서도 사용할 수 있다.
- 표준 

<br>

### ✅ 자바스크립트의 특징
1. 객체 기반의 스크립트 언어
2. 동적이고, 타입을 명시할 필요가 없는 인터프리터 언어
3. 객체 지향형 프로그래밍과 함수형 프로그래밍을 모두 표현할 수 있음

<br>

### ✅ 자바 vs 자바스크립트
- 두 언어에 직접적인 관련은 없지만 두 언어 모두 C언어 기반으로 만들어졌기 때문에 문법적으로 비슷하다.

|**자바**|**자바스크립트**|
|-|-|
|컴파일 언어|인터프리터 언어|
|타입 검사 엄격|타입을 명시하지 않음|
|클래스 기반의 객체 지향 언어|프로토타입 기반의 객체 지향 언어|

<br>

### ✅ 자바스크립트 활용
1. HTML의 **내용**을 변경할 수 있음
2. HTML의 **속성**을 변경할 수 있음
3. HTML의 **속성값**을 변경할 수 있음

<br>

### ✅ 자바스크립트 적용 방식
1. **인라인 방식**
    - 태그에 직접 기재
    - 모든 태그에 대해 onXXX 속성 제공
```html
<input type="button" value="버튼" onclick="alert('클릭')">
```
2. **임베디드 방식**
    - `<script>`태그를 사용하여 HTML 문서 안에 삽입
```html
<script>
    window.document.all.txt1.value = new Date();
</script>
```
3. **외부 자바스크립트 파일로 적용**
    - HTML 코드로부터 웹의 동작을 구현하는 자바스크립트 코드 분리 -> 가독성, 유지보수성 증가
    - ex02.js
    ```javascript
    alert('외부 자바스크립트');
    ```
    - 활용
    ```html
    <script src="ex02.js"></script>
    ```
