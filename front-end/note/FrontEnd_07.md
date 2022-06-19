# 📌 객체
- 이름(key)과 값(value)으로 구성된 프로퍼티의 집합
- 프로퍼티의 값으로 함수가 올때 이 함수를 메서드라고 함
- 프로퍼티를 참조할 때는 `객체이름.프로퍼티이름` 또는 `객체이름["프로퍼티이름"]`으로 한다.

> 예시
```javascript
var person = {
    name: "홍길동",      
    birthday: "030219",  
    pId: "1234567",     
    fullId: function() { 
        return this.birthday + this.pId;
    }
};

person.name
person.fullId();
```

<br>

# 📌 프로토타입
- 클래스 기반의 객체지향 언어들과 달리 자바스크립트는 **프로토타입 기반의 객체지향 언어**이다.
- 자바스크립트는 현재 존재하는 객체를 프로토타입으로 사용하여 해당 객체를 **복제하여 재사용**한다.
- 모든 객체는 최소 하나 이상의 프로토타입 객체를 가지고 있으며, 프로토타입으로부터 프로퍼티와 메서드를 상속받는다.
- 자바스크립트의 모든 객체는 Object.prototype 객체를 프로토타입으로 상속받는다.
> 예시
```javascript
function Dog(color, name, age) { 
    this.color = color;          
    this.name = name;            
    this.age = age;              
}

var myDog = new Dog("흰색", "마루", 1); // 프로토타입: Dog

document.write("우리 집 강아지는 " + myDog.name + "라는 이름의 " + myDog.color + " 털이 매력적인 강아지입니다.");
```

<br>

### ✅ 객체에 프로퍼티 및 메서드 추가
```javascript
function Dog(color, name, age) {
    this.color = color;
    this.name = name;
    this.age = age;
}

var myDog = new Dog("흰색", "마루", 1);

myDog.family = "시베리안 허스키"; // 프로퍼티 추가
myDog.breed = function() {       // 프로퍼티 추가
    return this.color + " " + this.family;
}

document.write("우리 집 강아지는 " + myDog.breed() + "입니다.");
```

<br>

### ✅ 프로토타입에 프로퍼티 및 메서드 추가
```javascript
function Dog(color, name, age) {
    this.color = color;
    this.name = name;
    this.age = age;
}

Dog.prototype.family = "시베리안 허스키";   // Dog 프로토타입에 프로퍼티 추가
Dog.prototype.breed = function() { // Dog 프로토타입에 프로퍼티 추가
    return this.color + " " + this.family;
};

var myDog = new Dog("흰색", "마루", 1);
var hisDog = new Dog("갈색", "콩이", 3);

document.write("우리 집 강아지는 " + myDog.family + "이고, 친구네 집 강아지도 " + hisDog.family + "입니다.");
document.write("우리 집 강아지의 품종은 " + myDog.breed() + "입니다.<br>");
```

<br>

### ✅ 객체 프로퍼티 삭제
- 프로퍼티 값뿐만 아니라 프로퍼티 그 자체가 삭제된다.
```javascript
delete 객체이름.프로퍼티이름;
```

<br>

### ✅ 객체 프로퍼티 순회
- **Object.keys()** : 해당 객체가 가진 고유 프로퍼티 중 열거할 수 있는 프로퍼티의 이름을 배열에 담아 반환한다.
- **Object.getOwnPropertyNames()** : 해당 객체가 가진 모든 고유 프로퍼티의 이름을 배열에 담아 반환한다.

<br>

# 📌 객체 메서드
모든 자바스크립트 객체는 Object 객체와 Object.prototype 객체의 모든 프로퍼티와 메서드를 상속받음
- **hasOwnProperty()** 
    - 특정 프로퍼티가 해당 객체에 존재하는지 검사
    - 직접 선언된 프로퍼티만 검사, 상속받은 프로퍼티는 false 반환
- **propertyIsEnumerable()** 
    - 특정 프로퍼티가 해당 객체에 존재하고, 열거할 수 있는 프로퍼티인지 검사
- **isPrototypeOf()**
    - 특정 객체의 프로토타입 체인에 현재 객체가 존재하는지 검사
- **isExtensible()**
    - 객체에 새로운 프로퍼티를 추가할 수 있는지 여부를 반환
- **toString()**
    - 호출한 객체의 값을 문자열로 반환
- **valueOf()**
    - 특정 객체의 원시 타입의 값을 반환
    - 원시 타입의 값을 가지고 있지 않는 경우 객체 자신을 반환

<br>

# 📌 표준객체
### ✅ Math 객체
#### 👉 메서드
|메서드|설명|
|:-:|-|
|Math.min()|최솟값 반환|
|Math.max()|최댓값 반환|
|Math.random()|0과 1 사이의 랜덤 숫자 반환|
|Math.round()|소수점 첫번째 자리에서 반올림|
|Math.floor()|소수점 첫번째 자리에서 올림|
|Math.ceil()|소수점 첫번째 자리에서 버림|
|Math.pow(n, power)|n을 power번 거듭 제곱한 값 반환|

<br>

### ✅ Date 객체
#### 👉 Date 객체 초기화
|호출|설명|
|:-:|-|
|new Date()|인자 없이 호출 시 현재 날짜와 시간이 저장된 객체 반환|
|new Date(milliseconds)|1970년 1월 1일 0시 0분 0초에서 milliseconds 밀리초(1/1000 초) 후의 시점이 저장된 Date 객체 반환|
|new Date(datestring)|형태에 따라 특정 날짜와 시간을 가리키는 Date 객체 반환|
|new Date(year, month, date, hours, minutes, seconds, ms)|주어진 인수를 조합해 만들 수 있는 날짜가 저장된 객체 반환|

<br>

#### 👉 메서드
|메서드|설명|
|:-:|-|
|now()|1970년 1월 1일부터 현재까지의 밀리초 반환|
|getDate()|날짜 중 일자를 숫자로 반환함. (1 ~ 31)|
|getDay()|날짜 중 요일을 숫자로 반환함. (일요일 : 0 ~ 토요일 : 6)|
|getFullYear()|날짜 중 연도를 4자리 숫자로 반환함. (yyyy)|
|getMonth()|날짜 중 월을 숫자로 반환함. (1월 : 0 ~ 12월 : 11)|
|getTime()|1970년 1월 1일부터 현재까지의 시간을 밀리초(millisecond) 단위의 숫자로 반환함.|
|getHours()|시간 중 시를 숫자로 반환함. (0 ~ 23)|
|getMinutes()|시간 중 분을 숫자로 반환함. (0 ~ 59)|
|getSeconds()|시간 중 초를 숫자로 반환함. (0 ~ 59)|
|getMilliseconds()|	시간 중 초를 밀리초(millisecond) 단위의 숫자로 반환함. (0 ~ 999)|

<br>

### ✅ String 객체
#### 👉 메서드
|메서드|설명|
|:-:|-|
|indexOf(), lastIndexOf()|특정 문자나 문자열이 처음으로 등장하는 위치나 마지막으로 등장하는 위치를 반환, 찾을 수 없는 경우 -1 반환|
|charAt(), charCodeAt()|전달받은 인덱스에 위치한 문자나 문자 코드를 반환|
|slice(), substr(), substring()|전달받은 시작 인덱스부터 종료 인덱스 바로 앞까지의 문자열만을 추출하여 만든 새로운 문자열을 반환|
|split()|구분자(separator)를 기준으로 나눈 후, 나뉜 문자열을 하나의 배열로 반환|
|concat()|문자열을 결합한 새로운 문자열을 반환|
|toUpperCase(), toLowerCase()|모든 문자를 대문자나 소문자로 변환한 새로운 문자열을 반환|
|trim()|양 끝에 존재하는 모든 공백과 줄 바꿈 문자를 제거한 새로운 문자열을 반환|
|replace()|인수로 전달받은 패턴에 맞는 문자열을 대체 문자열로 변환한 새 문자열을 반환|
|startsWith(), endsWith()|인수로 전달받은 문자나 문자열로 시작되는지 또는 끝나는지를 검사한 후 그 결과를 불리언 값으로 반환|
|includes()|인수로 전달받은 문자나 문자열이 포함되어 있는지를 검사한 후 그 결과를 불리언 값으로 반환|


<br>

### ✅ Array 객체
#### 👉 JavaScript에서 Array의 특징
- 배열 요소 타입 고정 X, 같은 배열에 있는 배열 요소들의 타입이 다를 수 있음
- 배열 요소의 인덱스가 연속적이지 않아도 되며 특정 배열 요소가 비어있을 수 있음
- 가변 배열

<br>

#### 👉 선언 및 초기화
```javascript
// 선언
let arr = new Array();
let arr = [];

// 초기화
let fruits = ["사과", "오렌지", "자두"];
```

<br>

#### 👉 메서드
|메서드|설명|
|:-:|-|
|arr.push(...items)|맨 끝에 요소 추가|
|arr.pop()|맨 끝 요소 제거|
|arr.shift()|맨 앞 요소 제거|
|arr.unshift(...items)|맨 앞에 요소 추가|
|arr.splice(index[, deleteCount, elem1, ..., elemN])|index 위치부터 삭제할 요소의 개수 지정하고, 대체할 요소를 지정할 수 있음|
|arr.slice([start], [end])|start 인덱스부터 end 바로 앞 인덱스까지의 요소를 복사한 새로운 배열을 반환|
|arr.concat(arg1, arg2...)|기존 배열의 요소를 사용해 새로운 배열을 만들거나 기존 배열에 요소를 추가하고자 할 때 사용|
|arr.forEach(function())|주어진 함수를 배열 요소 각각에 대해 실행|
|arr.find(function())|특정 조건에 부합하는 요소 하나 반환|
|arr.filter(function())|특정 조건에 부합하는 모든 요소 반환|
|arr.map(function())|배열 요소 전체를 대상으로 함수를 호출하고, 함수 호출 결과를 배열로 반환|
|arr.sort()|배열의 요소를 문자열로 취급하여 정렬, 배열 자체가 정렬됨|
|arr.reverse()|배열의 요소를 역순으로 정렬|
|Array.isArray(arr)|arr이 배열인지 여부를 판단함|

<br>

#### 👉 배열 메서드에 화살표 함수 적용
```javascript
const list = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
const names = ['홍길동', '아무개', '호호호'];

// forEach()
list.forEach(n => console.log(n));
list.forEach((item, index) => console.log(item, index));

// map()
list.map(n => n % 2 == 0 ? '짝수' : '홀수').forEach(str => console.log(str));

names.map(name => { // 이름을 받아 객체로 반환
    return {
        name: name,
        age: 20,
        address: '서울시'
    };
});

// filter()
list.filter(item => item > 5).forEach(n => console.log(n));

// find()
let result = list.find(item => item == 5);
console.log(result);
```