# 📌 객체
- 이름과 값으로 구성된 프로퍼티의 집합
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
- 자바스크립트는 현재 존재하는 객체를 프로토타입으로 사용하여 해당 객체를 복제하여 재사용한다.
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
- 모든 자바스크립트 객체는 Object 객체와 Object.prototype 객체의 모든 프로퍼티와 메서드를 상속받음
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

### ✅ 표준객체 메서드
- [Math 객체](http://www.tcpschool.com/javascript/js_standard_math)
- [Date](http://www.tcpschool.com/javascript/js_standard_dateMethod)
- [String 객체](http://www.tcpschool.com/javascript/js_standard_stringMethod)
- [Array 객체](http://www.tcpschool.com/javascript/js_standard_arrayMethod)