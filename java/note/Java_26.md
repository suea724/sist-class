# π λλ€μ, Lambda Expression
- ν¨μν νλ‘κ·Έλλ° λ°©μμ μ§μνλ ννμ
- λλ€μμ μ¬μ©νλ©΄ μ½λκ° κ°κ²°ν΄μ§λ€.
- μλ°μμλ **μ»¬λ μ(or λ°°μ΄) μ‘°μ**μ μν΄ μ κ³΅νλ€.
- λλ€λ λ§€κ°λ³μλ₯Ό κ°μ§λ μ½λ λΈλ­μ΄λ€. (= λ©μλ)
- μλ°μ λλ€μμ **μΈν°νμ΄μ€λ₯Ό μ¬μ©**ν΄μ λ§λ λ€. β­
- μλ°μ λλ€μμ **μ΅λͺ κ°μ²΄λ₯Ό λ§λλ λ°©λ²μ κ°μν**μν¨ κΈ°μ  β­

<br>

### β λλ€μ νμ
- μΈν°νμ΄μ€ λ³μ = λλ€μ;
- e.g. **MyInterface m1 = (λ§€κ°λ³μ) -> {μ€νμ½λ};**
    - (λ§€κ°λ³μ) : λ©μλμ λ§€κ°λ³μ λ¦¬μ€νΈμ λμΌ
    - -> (νμ΄ν) : μ½λλΈλ­ νΈμΆ μ­ν 
    - {μ€νμ½λ} : λ©μλμ κ΅¬νλΆμ λμΌ
```java
MyInterface m = () -> {System.out.println("λλ€μμΌλ‘ λ§λ  κ°μ²΄μμ κ΅¬νν λ©μλ");};
m.test();

interface MyInterface {
	void test();
}
```

<br>

# π λλ€μ μ’λ₯
- μ΅λͺ κ°μ²΄μ μΆμ λ©μλ νμμ λ°λΌ λλλ€.

### β λ§€κ°λ³μ X, λ°νκ° X
```java
NoParameterNoReturn pr1 = () -> {System.out.println("pr1");};
pr1.call();
		
// μ€ν λΈλ­ λ΄μ λ¬Έμ₯μ΄ νμ€μ΄λ©΄ μ€κ΄νΈ μλ΅ κ°λ₯
NoParameterNoReturn pr2 = () -> System.out.println("pr2");
pr2.call();

interface NoParameterNoReturn {
	void call();
}
```

<br>

### β λ§€κ°λ³μ O, λ°νκ° X
```java
ParameterNoReturn pr1 = (int num) -> {System.out.println(num);};
pr1.call(100);

// λ§€κ°λ³μκ° νλμ΄λ©΄ μλ£νκ³Ό κ΄νΈλ₯Ό μλ΅ κ°λ₯
ParameterNoReturn pr2 = num -> System.out.println(num);
pr2.call(100);

interface ParameterNoReturn {
	void call(int num);
}
```

<br>

### β λ§€κ°λ³μ μ¬λ¬ κ°, λ°νκ° X
```java
MultiParameterNoReturn pr1 = (String name, int age) -> System.out.println(name + "," + age);
pr1.call("μμ", 26);
		
// μλ£ν μλ΅ κ°λ₯
MultiParameterNoReturn pr2 = (name, age) -> System.out.println(name + "," + age);
pr2.call("μμ", 26);

interface MultiParameterNoReturn {
	void call(String name, int age);
}
```

<br>

### β λ§€κ°λ³μ X, λ°νκ° O
```java
NoParameterReturn pr1 = () -> {return 10;};
System.out.println(pr1.call());

// μ€νλ¬Έμ returnλ¬Έ νλλ§ μ‘΄μ¬νλ©΄ μ€κ΄νΈμ return ν€μλ μλ΅ κ°λ₯
NoParameterReturn pr2 = () -> 20;
System.out.println(pr2.call());

interface NoParameterReturn {
	int call();
}
```

<br>

# π λλ€μ νμ©
- λλ€μμΌλ‘ Comparatorλ₯Ό νΈλ¦¬νκ² κ΅¬νν΄μ€ μ μλ€.

### β Integerνμ ArrayList μ λ ¬
```java
ArrayList<Integer> nums = new ArrayList<>();

// Integer κ° μ μ₯

nums.sort((o1, o2) -> o1 - o2); // μ€λ¦μ°¨μ μ λ ¬
nums.sort((o1, o2) -> o2 - o1); // λ΄λ¦Όμ°¨μ μ λ ¬
```

<br>

### β κ°μ²΄ λ°°μ΄ μ λ ¬
```java
ArrayList<User> list = new ArrayList<>();

// User κ°μ²΄ μ μ₯

// λμ΄ λ΄λ¦Όμ°¨μ μ λ ¬
list.sort((u1, u2) -> u2.getAge() - u1.getAge()); 

// μ΄λ¦ μ€λ¦μ°¨μ μ λ ¬
list.sort((u1, u2) -> u1.getName().compareTo(u2.getName())); 

// λ μ§ μ€λ¦μ°¨μ μ λ ¬
list.sort((u1, u2) -> u1.getHireDate().compareTo(u2.getHireDate())); 

// μ§κΈ μ λ ¬ > μ§μ  λΉκ΅ν΄μ return κ° μ€μ 
list.sort((u1, u2) -> {
   if (u1.getPosition().equals("λΆμ₯") && u2.getPosition().equals("μ°¨μ₯")) {
      return -1;
   } else if (u1.getPosition().equals("λΆμ₯") && u2.getPosition().equals("κ³Όμ₯")) {
      return -1;
   } else if (u1.getPosition().equals("λΆμ₯") && u2.getPosition().equals("λλ¦¬")) {
      return -1;
   } else if (u1.getPosition().equals("λΆμ₯") && u2.getPosition().equals("μ¬μ")) {
      return -1;
}};
```

<br>

# π ν¨μν μΈν°νμ΄μ€, Functional Interface
- λλ€μμ μ¬μ©νκΈ° μν΄μλ **μΈν°νμ΄μ€κ° νμ**ν¨ 
- λλ€μμ μ¬μ©νκΈ° μν΄ **JDKμμ μ κ³΅νλ μΈν°νμ΄μ€**
- μ€μ§ **λλ€μμ μ μ₯νλ μ©λ**λ‘λ§ μ¬μ©

<br>

### β μ¬μ©μ μ μ ν¨μν μΈν°νμ΄μ€
- λλ€μμ μ μ₯νκΈ° μν΄ λ§λλ μΈν°νμ΄μ€μ΄λ€.
- ν¨μν μΈν°νμ΄μ€λ **μΆμ λ©μλλ₯Ό λ± 1κ°**λ§ κ°μ§λ€. <br>
β μ΄ μΆμ λ©μλκ° κ³§ λλ€μ(μ΅λͺ λ©μλ)μ΄ λκΈ° λλ¬Έ (λͺ¨νΈμ± λ°©μ§)
- ν¨μν μΈν°νμ΄μ€ **@FunctionalInterface μ λΈνμ΄μ**μ μ¬μ©νμ¬ μ­ν μ λͺμνκ³  μ»΄νμΌ μλ¬λ₯Ό λ°©μ§ν  μ μλ€.

```java
@FunctionalInterface
interface MyConsumer {
	void test(int num);
}
```

<br>

### β νμ€ API ν¨μν μΈν°νμ΄μ€
- μΆμ λ©μλμ νΉμ§μ λ°λΌ λΆλ₯ν  μ μλ€.

#### 1. Consumer > λ§€κ°λ³μ O, λ°νκ° X
- λ§€κ°λ³μλ₯Ό λ°μμ μλΉνλ μλ¬΄λ₯Ό κ΅¬ν
- Consumer<T>
- BiConsumer<T, U>
- andThen() λ©μλ μ‘΄μ¬
- **acceptXXX()** μΆμ λ©μλ μ κ³΅
```java
Consumer<Integer> c1 = num -> System.out.println(num * num);
c1.accept(3);

// λ§€κ°λ³μ 2κ°λ₯Ό λ°λ Consumer
BiConsumer<String, Integer> bc1 = (name, age) -> {
   System.out.printf("μ΄λ¦: %s, λμ΄: %dμΈ\n", name, age);
};

bc1.accept("νκΈΈλ", 25);
```

<br>

#### 2. Supplier > λ§€κ°λ³μ X, λ°νκ° O
- λ§€κ°λ³μ μμ΄ λ°νκ°μ λλ €μ£Όλ μλ¬΄
- Supplier<T>
- getXXX() μΆμ λ©μλ μ κ³΅
```java
Supplier<Integer> s1 = () -> 100;
System.out.println(s1.get());
```

<br>

#### 3. Function > λ§€κ°λ³μ O, λ°νκ° O
- λ§€κ°λ³μλ₯Ό μ λ¬νλ©΄ μ²λ¦¬ ν λ°νκ°μ λλ €μ£Όλ μλ¬΄λ₯Ό κ΅¬ν
- Operator, Predicateμ μμ μ
- Function<T, R>
- BiFunction<T, U, R>
- andThen() λ©μλ μ‘΄μ¬
- compose() λ©μλ μ‘΄μ¬
- **applyXXX()** μΆμ λ©μλ μ κ³΅
```java
Function<Integer, Boolean> f1 = num -> num > 0;
System.out.println(f1.apply(10));

Function<String, Integer> f2 = str -> str.length();
System.out.println(f2.apply("νκΈΈλ"));

// BiFunction<μ²«λ²μ§Έ λ§€κ°λ³μ, λλ²μ§Έ λ§€κ°λ³μ, λ°νκ°>
BiFunction<Integer, Integer, String> bf1 = (a, b) -> a > b ? "ν¬λ€" : "μλ€";
bf1.apply(10, 5);
```

<br>

#### 4. Operator > λ§€κ°λ³μ O, λ°νκ° O
- λ§€κ°λ³μλ₯Ό μ λ¬νλ©΄ μ²λ¦¬ ν λ°νκ°μ λλ €μ£Όλ μλ¬΄λ₯Ό κ΅¬ν
- μΆμ λ©μλμ λ§€κ°λ³μμ λ°νκ°μ νμμ΄ λμΌνλ€.
- Functionμ νμ μ (λΆλΆμ§ν©)
- BinaryOperator<T>
- **applyXXX()** μΆμ λ©μλ μ κ³΅
```java
BinaryOperator<Integer> bo1 = (a, b) -> a * b;
System.out.println(bo1.apply(10, 20));
```

<br>


#### 5. Predicate > λ§€κ°λ³μ O, λ°νκ° O
- λ§€κ°λ³μλ₯Ό λΌλ¦¬ μ°μ° ν boolean νμ κ° λ°ν
- Functionμ νμ μ (λΆλΆμ§ν©)
- Predicate<T>
- BiPredicate<T, U>
- and()
- or()
- isEqual()
- negate()
- **testXXX()** μΆμ λ©μλ μ κ³΅
```java
// Function<Integer, Boolean> f1 = num -> num > 0;
// System.out.println(f1.apply(10));

Predicate<Integer> p1 = num -> num > 0;
System.out.println(p1.test(10));

BiPredicate<String, String> p2 = (s1, s2) -> s1.length() > s2.length();
System.out.println(p2.test("νκΈΈλ", "νμλ¬΄κ°"));
```

<br>

### β andThen()
- Consumer
```java
Consumer<User> c1 = user -> System.out.println(user.getName());
Consumer<User> c2 = user -> System.out.println(user.getAge());

// c1 + c2
Consumer<User> c3 = c1.andThen(c2);
c3.accept(hong); // c1κ³Ό c2μ accpept() λμμ μ€ν, μμ μν₯ O
```
- Function
```java
Function<Integer, Boolean> f1 = num -> num > 0;
Function<Boolean, String> f2 = result -> result ? "μ±κ³΅" : "μ€ν¨"; 

// f1 + f2 = f3
// f1 λ°νκ°μ νμκ³Ό f2 λ§€κ°λ³μ νμμ΄ κ°μμΌ ν¨, μμ μν₯O
Function<Integer, String> f3 = f1.andThen(f2);
System.out.println(f3.apply(10));
```

<br>

### β andThen() vs compose()
- compose()μ μ€ν μμλ andThen()κ³Ό λ°λ
```java
Function<Integer, String> f4 = num -> num > 0 ? "μμ" : "0 λλ μμ";
Function<String,Integer> f5 = str -> str.length();

Function<Integer, Integer> f6 = f4.andThen(f5); // f4 λ€μ f5 μ€ν
Function<Integer, Integer> f7 = f5.compose(f4); // f4 λ€μ f5 μ€ν

System.out.println(f8.apply(10));
System.out.println(f9.apply(10));
```

<br>

### β Predicate λ©μλ
- and()
```java
Predicate<Integer> p1 = num -> num % 2 == 0; // 2μ λ°°μ
Predicate<Integer> p2 = num -> num % 3 == 0; // 3μ λ°°μ

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