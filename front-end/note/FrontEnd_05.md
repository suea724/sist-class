# 📌 자바스크립트 타입
- **number** : 숫자
    - 정수와 실수를 구분하지 않음
- **string** : 문자열
    - 큰따옴표("")나 작은따옴표('')로 둘러싸인 문자의 집합
- **boolean** : 불리언
- **symbol** : 심볼(ES6부터 제공)
    - 유일하고 변경할 수 없는 타입, 객체의 프로퍼티를 위한 식별자로 사용
- **undefined**
    - 타입이 정해지지 않은 데이터 (초기화되지 않은 변수 또는 존재하지 않는 값)
- **객체 타입**
    - 여러 프로퍼티(property)나 메소드(method)를 같은 이름으로 묶어놓은 일종의 집합체

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
|**메서드**|**설명**|
|-|-|
|getDate()|날짜 중 일자를 숫자로 반환함. (1 ~ 31)|
|getDay()|날짜 중 요일을 숫자로 반환함. (일요일 : 0 ~ 토요일 : 6)|
|getFullYear()|날짜 중 연도를 4자리 숫자로 반환함. (yyyy)|
|getMonth()|날짜 중 월을 숫자로 반환함. (1월 : 0 ~ 12월 : 11)|
|getTime()|1970년 1월 1일부터 현재까지의 시간을 밀리초(millisecond) 단위의 숫자로 반환함.|
|getHours()|시간 중 시를 숫자로 반환함. (0 ~ 23)|
|getMinutes()|시간 중 분을 숫자로 반환함. (0 ~ 59)|
|getSeconds()|시간 중 초를 숫자로 반환함. (0 ~ 59)|
|getMilliseconds()|	시간 중 초를 밀리초(millisecond) 단위의 숫자로 반환함. (0 ~ 999)|
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