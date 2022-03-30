# 📌 예외, Exception
- 프로그램 자체 문제 또는 외부 환경에 의해 발생하는 문제이다.
- 예외는 컴파일 타임이 아닌, **런타임**에 발견된다.

<br>

### ✅ 예외 처리, Exception Handling
#### 🔻 if문 사용
```javas
if (num != 0) {
// 비즈니스 코드
System.out.printf("100 / %d = %d\n", num, 100 / num);
} else {
// 예외 처리 코드
System.out.println("0은 입력할 수 없습니다.");
}
```
- 제어문 사용 (조건문)
- 일반적으로 참 블럭에 비즈니스 코드를 작성한다. > 가독성
- 코드 실행 전 **조건을 검사**해서, **예외가 발생하지 않는 로직을 실행**한다.

#### 🔻 try-catch문 사용
```java
try {
    System.out.println(100 / num);
} catch(Exception e) {
    System.out.println("0은 입력할 수 없습니다");
}
```
- try-catch(-finally)문 사용
- try문에 비즈니스 코드, catch문에 예외처리 코드를 작성한다.
- **일단 실행 후, 예외가 발생하면 예외 처리 로직을 실행**한다.

<br>

### ✅ Exception 클래스
- 예외가 발생하면 각 상황에 맞는 **예외 객체가 생성**된다.
- e.g. `ArithmeticException`,`ArrayIndexOutOfBoundsException`, ...
- `Exception` 클래스는 모든 예외 객체의 최상위 클래스이다.

<br>

### ✅ try-catch문 작동 방식
```java
try {

} catch(ArithmeticException e) {

} catch(ArrayIndexOutOfBoundsException e) {
    
} catch(Exception e) {

}
```
- 예외가 발생하지 않으면 catch문은 실행하지 않는다.
- try문에서 예외가 발생하면 남아있는 코드 실행을 중단하고, 예외 객체를 생성해서 **catch문으로 제어가 이동**된다.
- e.g. `throw new ArithmeticException`
- 생성된 예외 객체가 각 catch문의 매개변수 타입과 일치하는지 차례대로 비교한다.
- 타입이 일치할 경우 그 catch문의 예외 처리문이 실행된다.
- 마지막 catch문의 매개변수 타입을 Exception로 설정하면 **명시되지 않은 예외가 발생했을 때 한번에 예외 처리**를 해줄 수 있다.

<br>

### ✅ 예외 미루기
```java
private static void m4() throws Exception {

}
```
- 해당 영역에서 예외 처리를 할만한 상황이 안되면 **호출하는 곳에 예외처리의 책임을 떠넘길 수 있다.**
- 예외를 미루면, 호출하는 쪽에 예외 처리의 책임이 전가된다.
- 각 메서드에서 예외처리를 할지, 메인 메서드에서 발생하는 모든 예외를 한꺼번에 받아 처리할지 결정할 수 있다.

<br>

### ✅ 예외 던지기
```java
if (num % 2 != 0) { 
    throw new Exception("홀수를 입력하면 안됩니다."); 
}
```
- 강제로 예외를 발생시킬 수 있다.
- 이때 매개변수로 오류메세지를 넣어줄 수 있다.