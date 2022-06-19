# 📌 변수와 상수
### ✅ 변수 선언 키워드
- **let**
    - 변수 선언 키워드.
    - 같은 이름의 변수는 한번만 선언 가능. 여러 번 선언 시 에러 발생
    - 블록 레벨 스코프가 적용됨
    - 블록 밖에서 변수 사용 불가
- **const** 
    - 상수 선언 키워드.
    - 값을 변경할 수 없음
- **var**
    - 오래된 변수 선언 키워드.
    - 변수 선언 키워드 생략 시 기본적으로 var로 선언된다.
    - 같은 이름의 변수를 여러번 선언해도 에러가 발생하지 않음
    - 함수 레벨 스코프가 적용됨
    - 블록 밖에서 변수 사용 가능

<br>

### ✅ let과 var의 차이
변수는 크게 `선언 -> 초기화 -> 할당`의 단계를 가진다.

![](https://noah0316.github.io/static/9edccb0975ba87abf535462e3b31c02d/3c492/var.png)
- var로 선언된 변수는 **선언과 초기화가 동시**에 진행된다.
- 선언 시 할당하지 않았을 때 var 변수의 초기값은 **undefined**

<br>

![](https://noah0316.github.io/static/0d6208436219e3b022a6c152572d803c/3c492/let.png)
- let으로 선언된 변수는 **선언과 초기화가 분리**되어  그 사이에 TDZ가 생성된다.
- 이때 변수에 접근 시 ReferenceError가 발생한다.

<br>

> 변수 재선언
```javascript
let message = "This";
let message = "That"; // SyntaxError: 'message' has already been declared

var user = "Pete";
var user = "John"; // 재선언 하지 않음, 할당문만 실행됨

alert(user); // John
```

<br>

> 스코프
```javascript
if (true) {
  var test = true; // var
}

alert(test); // true(if 문이 끝났어도 변수에 여전히 접근할 수 있음)

// let
if (true) {
  let test = true; // let
}

alert(test); // Error: test is not defined
```



<br>

# 📌 자바스크립트 타입
|종류|설명|
|:-:|-|
|숫자형|정수 및 실수 표현, Infinity, NaN과 같은 특수 숫자 값 포함|
|BigInt|일반 숫자형은 표현할 수 있는 수에 제약이 있는 반면, 길이에 상관없이 정수를 나타낼 수 있음|
|문자형|큰따옴표("")나 작은따옴표('') 또는 백틱(``)로 둘러싸인 문자의 집합, 백틱 사용 시 `${}`안에 변수나 표현식을 쉽게 넣어줄 수 있음|
|boolean|true 또는 false 값|
|null|존재하지 않는(nothing) 값, 비어있는(empty) 값, 알수없는(unknown) 값|
|undefined|값이 할당되지 않은 상태 표현|
|symbol|유일하고 변경할 수 없는 타입, 객체의 프로퍼티를 위한 식별자로 사용|
|객체|여러 프로퍼티(property)나 메소드(method)를 같은 이름으로 묶어놓은 일종의 집합체|

<br>

### ✅ null과 undefined
- null : 개발자가 의도적으로 입력한 값
- undefined : 초기화되지 않은 변수 또는 존재하지 않는 값
```javascript
// == : 자료형 비교(X), 값만 비교(O)
// === : 자료형 비교(O) + 값 비교(O)
null ==  undefined; // true
null === undefined; // false
```

<br>

### ✅ typeOf
현재 변수나 상수의 자료형을 확인하는 연산자
```javascript
console.log(typeof 100);
console.log(typeof 3.14);
console.log(typeof num);
console.log(typeof name);
console.log(typeof flag);
```

<br>

# 📌 타입 변환
자바스크립트는 타입 검사가 매우 유연하므로 같은 변수에 다른 타입의 값을 대입할 수 있다.

### ✅ 묵시적 타입 변환
특정 타입의 값을 기대하는 곳에 다른 타입의 값이 오면 자동으로 타입을 변환해준다.
```javascript
10 + "문자열"; // 문자열 연결을 위해 숫자 10이 문자열로 변환됨.
"3" * "5";     // 곱셈 연산을 위해 두 문자열이 모두 숫자로 변환됨.
1 - "문자열";  // NaN
```

### ✅ 명시적 타입 변환
자바스크립트는 명시적 타입 변환을 위한 전역함수를 제공한다.
1. **Number()**
2. **String()**
3. **Boolean()**
4. **Object()**
5. **parseInt()**
6. **parseFloat()**

```javascript
Number("10"); // 숫자 10
String(true); // 문자열 "true"
Boolean(0);   // 불리언 false
Object(3);    // new Number(3)와 동일한 결과로 숫자 3
```

<br>

### ✅ 날짜를 문자열 또는 숫자로 변환
```javascript
String(Date());        // Mon May 16 2016 19:35:25 GMT+0900
Date().toString();     // Mon May 16 2016 19:35:25 GMT+0900
var date = new Date(); // Date 객체 생성
date.getFullYear();    // 2016
date.getTime();        // 1463394925632 -> 1970년 1월 1일부터 현재까지의 시간을 밀리초 단위의 숫자로 반환함. 
```

<br>

### ✅ 문자열을 숫자로 변환
1. parseInt()
2. parseFloat()
```javascript
var size = '1.5em';
console.log(parseInt(size)); // 1
console.log(parseFloat(size)); // 1.5
```