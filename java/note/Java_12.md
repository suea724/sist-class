# 📌 생성자, Constructor

```java
// User 클래스의 생성자 정의부
public User() {
    
    // 초기값 세팅
    this.name = "익명";
    this.age = -1;
    this.flag = true;
}

// User 클래스의 생성자 호출부
User u1 = new User();
```
- 특수한 목적을 가지는 메서드
- **객체 멤버 변수를 초기화**하는 역할 수행
- 일반 메서드처럼 마음대로 호출할 수 없음
- **객체가 생성될 때 딱 한번만 호출**됨
- 클래스의 이름과 동일한 이름을 가짐
- new 키워드(객체 생성 연산자)를 통해 인스턴스가 만들어지고 이때 생성된 인스턴스의 모든 변수값은 null임
- 생성자가 호출될 때서야 값이 초기화값이 입력됨

<br>

### ✅ 기본 생성자, default constructor
```java
public Cup() {
    this.color = "white";
    this.owner = "미정";
}
```
- 개발자가 별도로 작성하지 않으면 자동으로 생성됨
- 즉, 개발자가 별도로 작성하면 자동으로 생성되지 않음
- 기본 생성자 생성 후 일부 멤버를 초기화 하지 않아도 자동으로 초기화 코드가 작성됨
- 결론 => **객체의 멤버 변수는 반드시 초기화 과정을 거침**

<br>

### ✅ 생성자 오버로딩
```java
public Mouse() { // 기본 생성자
    this.model = "M705";
    this.price = 40000;
}

public Mouse(int price) { // 오버로딩
    this.model = "M705";
    this.price = price;
}


public Mouse(String model) { // 오버로딩
    this.model = model;
    this.price = 40000;
}

public Mouse(String model, int price) { // 오버로딩 
    this.model = model;
    this.price = price;
}

```
- 객체의 초기 상태는 상황에 다라 달라질 수 있다.
- 오버로딩(다형성)을 이용해 상황에 따라 다른 생성자를 호출할 수 있다.
- 하지만 위 코드에서 중복이 다량 발생한다.

<br>

> 중복 줄이기
```java
public Developer() {
    this("익명", "없음"); // A 생성자 호출
}

public Developer(String name) {
    this(name, "없음"); // A 생성자 호출
}

// A 생성자
public Developer(String name, String language) {
    this.name = name;
    this.language = language;
}
```
- 생성자는 일반 메서드처럼 사용할 수는 없지만 **생성자 내에서 다른 생성자를 호출**하는 것은 가능하다.
- 이때 **this 키워드**를 사용한다.
