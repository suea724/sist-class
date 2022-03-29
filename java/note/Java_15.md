# 📌 형변환, Type Casting

### ✅ 값형(Value type) 형변환
- 값형끼리 형변환 (boolean 제외)
- 더 작은 자료형에서 더 큰 자료형으로 형변환

<br>

### ✅ 참조형(Reference type) 형변환
- 참조형끼리(클래스간) 형변환
- 상속관계의 클래스간 형변환 > 직계끼리만 가능 (형제지간 X)

<br>

# 📌 참조형 형변환
### ✅ 업 캐스팅, Up Casting
```java
Parent p;
Child c = new Child();

p = c;
// p = (Parent)c;
```
- 암시적인 형변환
- 자식 클래스 → 부모 클래스
- 100% 가능, **매우 안전**

<br>

### ✅ 다운 캐스팅, Down Casting
```java
Parent p;
Child c = new Child();
p = c; // 업 캐스팅

Child c2 = (Child)p; // 다시 본인 타입으로 다운 캐스팅
```
- 명시적인 형변환
- 부모 클래스 → 자식 클래스
- 100% 불가능, **런타임 오류** 발생
- 업 캐스팅 후 다시 본인의 타입으로 형변환 하는 경우에만 가능
- 부모 타입으로 **형변환한 후 자식 타입의 고유한 기능을 사용해야 할때**, 부모 타입 참조 변수로는 접근이 불가능하므로 다운 캐스팅을 사용

<br>

### ✅ instanceof 연산자
- `A instanceof B`
- 2항 연산자
- A 객체가 B 클래스형의 객체인지 확인하여 true/false 반환
- **A를 B로 형변환할 수 있는가?**

<br>

# 📌 Object 클래스로의 형변환

```java
Object o1 = new Date();
Object o2 = Calendar.getInstance();
Object o3 = new int[4];
```

### ✅ Object 타입 변수
- **모든  객체는 Object 객체로 업 캐스팅 할 수 있다.** (큰 장점)
- 그러나 Object 타입으로 업캐스팅하게 되면 종종 다운 캐스팅이 필요하고, 이에 필요한 **자료형 유추가 어렵다.**
- 따라서 Object 타입 변수의 값을 수정하는 경우 같은 데이터형으로만 수정하는 것이 좋다.
- Object 변수에 저장하게 되면 비용이 비싸다 (오버헤드 발생) 

<br>

### ✅ 값형 변수를 Object 타입 변수에 넣을때
```java
Object o = 100;
System.out.println(o.getClass()); // Integer
```
- 원래 주솟값을 저장하는 변수에는 주솟값만, 값을 저장하는 변수에는 값만 저장해야 한다.
- Object 타입의 변수에 리터럴을 입력하게 되면 타입에 따라 **Wrapper 클래스가 리터럴을 감싸 객체를 생성**한다. **(Boxing)**
- e.g. `int` 타입의 값이 입력되는 경우 `new Integer(10)`으로 참조형 변수에 값이 입력된다.
- 이때 참조형 변수에 들어가는 값은 **Wrapper 객체의 주솟값**이다.
- Boxing된 값을 원래 자료형처럼 다루려면 다운 캐스팅 작업이 필요하다. **(Unboxing)**
