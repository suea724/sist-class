# 📌 함수, Function
### ✅ 함수 생성
- 함수 선언문
```javascript
function f1() {
    console.log('f1');
}
```

<br>

- 익명 함수 사용
```javascript
 // 익명 함수는 보통 생성과 동시에 변수에 저장한 뒤 나중에 변수를 통해서 호출한다.
let b2 = function () {
    console.log('a2');
};

b2();

// 이벤트 전용 함수 사용시 안정성 향상 > 이벤트 함수 정의와 동시에 연결
document.getElementById('btn').onmousedown = function() {
    alert(event.buttons);
}
```

<br>

### ✅ 함수 활용
- 함수를 **변수**에 저장할 수 있다.
```javascript
function f1() {
    console.log('f1');
}

n1 = f1; // 함수가 정의된 주소값을 복사
n1(); // 함수 호출
```

<br>

- 함수를 **매개변수**에 전달할 수 있다.
```javascript
function a4() {
    console.log('a4');
}

function a5(func) {
    console.log('a5');
    func();
}

// 함수의 매개변수로 함수 전달
a5(a4);
```

<br>

- 함수를 **반환값**으로 사용할 수 있다.
```javascript
function a6() {
    console.log('a6');
}

function a7() {
    return a6; // 함수 자체를 반환값으로 사용
}

a7()(); // == a6();
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

<br>

### ✅ 화살표 함수, Arrow Function
함수 표현식보다 단순하고 간결한 문법으로 함수를 생성하는 방식이다.
```javascript
let func = function(arg1, arg2, ...argN) {
  return expression;
};
```

<br>

> 본문이 여러 줄인 화살표 함수
```javascript
let sum = (a, b) => {  // 중괄호는 본문 여러 줄로 구성되어 있음을 나타냄
    let result = a + b;
    return result; // 중괄호를 사용했다면 결과값 반환 필요
};

alert(sum(1, 2));
```

<br>

> 실행문이 한줄일 때 실행 블럭(중괄호) 생략 가능
```javascript
let f1 = () => console.log('f1'); // 중괄호 생략
f1();
```

<br>

> 매개변수 하나일 때는 괄호 생략 가능
```javascript
let f2 = num => console.log(num);
let f3 = (a, b) => console.log(a + b); // 매개변수 2개일 때 생략 불가
```

<br>

> 반환값 return 문 한줄일 때는 괄호와 return 키워드 생략 가능
```javascript
let f4 = () => {return 100;}; // return문 명시
let f5 = () => 200; // return문 생략
```