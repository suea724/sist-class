# 📌 람다식, Lambda Expression
- 함수형 프로그래밍 방식을 지원하는 표현식
- 람다식을 사용하면 코드가 간결해진다.
- 자바에서는 **컬렉션(or 배열) 조작**을 위해 제공한다.
- 람다는 매개변수를 가지는 코드 블럭이다. (= 메서드)
- 자바의 람다식은 **인터페이스를 사용**해서 만든다. ⭐
- 자바의 람다식은 **익명 객체를 만드는 방법을 간소화**시킨 기술 ⭐

<br>

### ✅ 람다식 형식
- 인터페이스 변수 = 람다식;
- e.g. **MyInterface m1 = (매개변수) -> {실행코드};**
    - (매개변수) : 메서드의 매개변수 리스트와 동일
    - -> (화살표) : 코드블럭 호출 역할
    - {실행코드} : 메서드의 구현부와 동일
```java
MyInterface m = () -> {System.out.println("람다식으로 만든 객체에서 구현한 메서드");};
m.test();

interface MyInterface {
	void test();
}
```

<br>

# 📌 람다식 종류
- 익명 객체의 추상 메서드 형식에 따라 나뉜다.

### ✅ 매개변수 X, 반환값 X
```java
NoParameterNoReturn pr1 = () -> {System.out.println("pr1");};
pr1.call();
		
// 실행 블럭 내에 문장이 한줄이면 중괄호 생략 가능
NoParameterNoReturn pr2 = () -> System.out.println("pr2");
pr2.call();

interface NoParameterNoReturn {
	void call();
}
```

<br>

### ✅ 매개변수 O, 반환값 X
```java
ParameterNoReturn pr1 = (int num) -> {System.out.println(num);};
pr1.call(100);

// 매개변수가 하나이면 자료형과 괄호를 생략 가능
ParameterNoReturn pr2 = num -> System.out.println(num);
pr2.call(100);

interface ParameterNoReturn {
	void call(int num);
}
```

<br>

### ✅ 매개변수 여러 개, 반환값 X
```java
MultiParameterNoReturn pr1 = (String name, int age) -> System.out.println(name + "," + age);
pr1.call("수아", 26);
		
// 자료형 생략 가능
MultiParameterNoReturn pr2 = (name, age) -> System.out.println(name + "," + age);
pr2.call("수아", 26);

interface MultiParameterNoReturn {
	void call(String name, int age);
}
```

<br>

### ✅ 매개변수 X, 반환값 O
```java
NoParameterReturn pr1 = () -> {return 10;};
System.out.println(pr1.call());

// 실행문에 return문 하나만 존재하면 중괄호와 return 키워드 생략 가능
NoParameterReturn pr2 = () -> 20;
System.out.println(pr2.call());

interface NoParameterReturn {
	int call();
}
```

<br>

# 📌 람다식 활용
- 람다식으로 Comparator를 편리하게 구현해줄 수 있다.

### ✅ Integer타입 ArrayList 정렬
```java
ArrayList<Integer> nums = new ArrayList<>();

// Integer 값 저장

nums.sort((o1, o2) -> o1 - o2); // 오름차순 정렬
nums.sort((o1, o2) -> o2 - o1); // 내림차순 정렬
```

<br>

### ✅ 객체 배열 정렬
```java
ArrayList<User> list = new ArrayList<>();

// User 객체 저장

// 나이 내림차순 정렬
list.sort((u1, u2) -> u2.getAge() - u1.getAge()); 

// 이름 오름차순 정렬
list.sort((u1, u2) -> u1.getName().compareTo(u2.getName())); 

// 날짜 오름차순 정렬
list.sort((u1, u2) -> u1.getHireDate().compareTo(u2.getHireDate())); 

// 직급 정렬 > 직접 비교해서 return 값 설정
list.sort((u1, u2) -> {
   if (u1.getPosition().equals("부장") && u2.getPosition().equals("차장")) {
      return -1;
   } else if (u1.getPosition().equals("부장") && u2.getPosition().equals("과장")) {
      return -1;
   } else if (u1.getPosition().equals("부장") && u2.getPosition().equals("대리")) {
      return -1;
   } else if (u1.getPosition().equals("부장") && u2.getPosition().equals("사원")) {
      return -1;
}};
```

<br>

# 📌 함수형 인터페이스, Functional Interface
- 람다식을 사용하기 위해서는 **인터페이스가 필요**함 
- 람다식을 사용하기 위해 **JDK에서 제공하는 인터페이스**
- 오직 **람다식을 저장하는 용도**로만 사용

<br>

### ✅ 사용자 정의 함수형 인터페이스
- 람다식을 저장하기 위해 만드는 인터페이스이다.
- 함수형 인터페이스는 **추상 메서드를 딱 1개**만 가진다. <br>
→ 이 추상 메서드가 곧 람다식(익명 메서드)이 되기 때문 (모호성 방지)
- 함수형 인터페이스 **@FunctionalInterface 애노테이션**을 사용하여 역할을 명시하고 컴파일 에러를 방지할 수 있다.

```java
@FunctionalInterface
interface MyConsumer {
	void test(int num);
}
```

<br>

### ✅ 표준 API 함수형 인터페이스
- 추상 메서드의 특징에 따라 분류할 수 있다.

#### 1. Consumer > 매개변수 O, 반환값 X
- 매개변수를 받아서 소비하는 업무를 구현
- Consumer<T>
- BiConsumer<T, U>
- andThen() 메서드 존재
- **acceptXXX()** 추상 메서드 제공
```java
Consumer<Integer> c1 = num -> System.out.println(num * num);
c1.accept(3);

// 매개변수 2개를 받는 Consumer
BiConsumer<String, Integer> bc1 = (name, age) -> {
   System.out.printf("이름: %s, 나이: %d세\n", name, age);
};

bc1.accept("홍길동", 25);
```

<br>

#### 2. Supplier > 매개변수 X, 반환값 O
- 매개변수 없이 반환값을 돌려주는 업무
- Supplier<T>
- getXXX() 추상 메서드 제공
```java
Supplier<Integer> s1 = () -> 100;
System.out.println(s1.get());
```

<br>

#### 3. Function > 매개변수 O, 반환값 O
- 매개변수를 전달하면 처리 후 반환값을 돌려주는 업무를 구현
- Operator, Predicate의 상위 셋
- Function<T, R>
- BiFunction<T, U, R>
- andThen() 메서드 존재
- compose() 메서드 존재
- **applyXXX()** 추상 메서드 제공
```java
Function<Integer, Boolean> f1 = num -> num > 0;
System.out.println(f1.apply(10));

Function<String, Integer> f2 = str -> str.length();
System.out.println(f2.apply("홍길동"));

// BiFunction<첫번째 매개변수, 두번째 매개변수, 반환값>
BiFunction<Integer, Integer, String> bf1 = (a, b) -> a > b ? "크다" : "작다";
bf1.apply(10, 5);
```

<br>

#### 4. Operator > 매개변수 O, 반환값 O
- 매개변수를 전달하면 처리 후 반환값을 돌려주는 업무를 구현
- 추상 메서드의 매개변수와 반환값의 타입이 동일하다.
- Function의 하위 셋 (부분집합)
- BinaryOperator<T>
- **applyXXX()** 추상 메서드 제공
```java
BinaryOperator<Integer> bo1 = (a, b) -> a * b;
System.out.println(bo1.apply(10, 20));
```

<br>


#### 5. Predicate > 매개변수 O, 반환값 O
- 매개변수를 논리 연산 후 boolean 타입 값 반환
- Function의 하위 셋 (부분집합)
- Predicate<T>
- BiPredicate<T, U>
- and()
- or()
- isEqual()
- negate()
- **testXXX()** 추상 메서드 제공
```java
// Function<Integer, Boolean> f1 = num -> num > 0;
// System.out.println(f1.apply(10));

Predicate<Integer> p1 = num -> num > 0;
System.out.println(p1.test(10));

BiPredicate<String, String> p2 = (s1, s2) -> s1.length() > s2.length();
System.out.println(p2.test("홍길동", "홍아무개"));
```

<br>

### ✅ andThen()
- Consumer
```java
Consumer<User> c1 = user -> System.out.println(user.getName());
Consumer<User> c2 = user -> System.out.println(user.getAge());

// c1 + c2
Consumer<User> c3 = c1.andThen(c2);
c3.accept(hong); // c1과 c2의 accpept() 동시에 실행, 순서 영향 O
```
- Function
```java
Function<Integer, Boolean> f1 = num -> num > 0;
Function<Boolean, String> f2 = result -> result ? "성공" : "실패"; 

// f1 + f2 = f3
// f1 반환값의 타입과 f2 매개변수 타입이 같아야 함, 순서 영향O
Function<Integer, String> f3 = f1.andThen(f2);
System.out.println(f3.apply(10));
```

<br>

### ✅ andThen() vs compose()
- compose()의 실행 순서는 andThen()과 반대
```java
Function<Integer, String> f4 = num -> num > 0 ? "양수" : "0 또는 음수";
Function<String,Integer> f5 = str -> str.length();

Function<Integer, Integer> f6 = f4.andThen(f5); // f4 다음 f5 실행
Function<Integer, Integer> f7 = f5.compose(f4); // f4 다음 f5 실행

System.out.println(f8.apply(10));
System.out.println(f9.apply(10));
```

<br>

### ✅ Predicate 메서드
- and()
```java
Predicate<Integer> p1 = num -> num % 2 == 0; // 2의 배수
Predicate<Integer> p2 = num -> num % 3 == 0; // 3의 배수

Predicate<Integer> p3 = p1.and(p2);
System.out.println(p3.test(10)); // false
```
- or()
```java
Predicate<Integer> p4 = p1.or(p2);
System.out.println(p4.test(10)); // true
```
- negate()
```java
// !p1 
Predicate<Integer> p5 = p1.negate();
System.out.println(p5.test(10)); // false
```