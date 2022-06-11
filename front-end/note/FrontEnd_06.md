# 📌 함수, Function
### ✅ 함수 호이스팅, Hoisting
- 함수 안에서 선언된 **모든 변수는 함수 전체에 걸쳐 유효**하다.
- 변수가 선언되기 전에도 적용된다.
- 즉, 모든 변수의 선언은 함수의 맨 처음에서 한 것 처럼 동작한다.
> 예시
```javascript
var globalNum = 10; // 전역 변수 초기화

function printNum() {

    document.write("지역 변수 globalNum 선언 전의 globalNum의 값은 " + globalNum + "입니다.<br>"); // undefined (선언만)

    var globalNum = 20; // 지역 변수 초기화

    document.write("지역 변수 globalNum 선언 후의 globalNum의 값은 " + globalNum + "입니다.<br>"); // 20
}

printNum();
```

<br>

### ✅ 매개변수
- 다른 언어와 달리 매개변수의 개수가 함수 정의 시 설정한 매개변수의 개수와 달라도 오류가 나지 않는다.
> 예시
```javascript
function addNum(x, y, z) {
    return x + y + z;
}

addNum(1, 2, 3); // 6
addNum(1, 2);    // NaN
addNum(1);       // NaN
addNum();        // NaN
```

<br>

> 오버로딩 형태로 함수 구현
```javascript
function addNum(x, y, z) {

    if(x === undefined)
        x = 0;       

    if(y === undefined)
        y = 0;         

    if(z === undefined) 
        z = 0;          

    return x + y + z;
}

addNum(1, 2, 3); // 6
addNum(1, 2);    // 3
addNum(1);       // 1
addNum();        // 0
```

<br>

### ✅ 미리 정의된 전역 함수
- **eval()**
    - 문자열로 표현된 자바스크립트 코드 실행
```javascript
var x = 20;
var y = 30;
document.write(eval("x + y")); // 50
```
- **isFinite()**
    - 전달된 값이 유한한 수인지 검사
    - 문자열일 경우 숫자로 변환해서 검사
```javascript
isFinite(123);        // true
isFinite("123");     // true
isFinite("");        // true
isFinite("문자열");  // false
```
- **isNaN()**
    - 전달된 값이 숫자가 아닌지 검사
```javascript
isNaN(123);       // false
isNaN("123");     // false
isNaN("");        // false
isNaN("문자열");  // true
```
- **encodeURI()**
    - URI 전달 시 문제가 없도록 특수문자에 대해 이스케이프 처리하여 인코딩
```javascript
var uri = "http://google.com/search.php?name=홍길동&city=서울";
var enc = encodeURI(uri);
```
- **decodeURI()**
    - encodeURI() 함수나 다른 방법으로 만들어진 URI를 해독
```javascript
var uri = "http://google.com/search.php?name=홍길동&city=서울";

var enc = encodeURI(uri);
var dec = decodeURI(enc);
document.write(dec);
```