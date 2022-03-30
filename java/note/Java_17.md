# 📌 제네릭, Generic
```java
// 제네릭 클래스 객체 생성
Item<String> i1 = new Item<String>();
Item<Integer> i2 = new Item<Integer>();

// 제네릭 클래스 선언
class Item<T> { 

    public T a;
}
```
- 다양한 자료형으로 공통적인 로직을 구현하고 싶을 때 사용한다.
- 자료형이 컴파일 타임에 결정되는 것이 아니라, **런타임에 결정**된다.
- 제네릭 클래스의 객체를 생성할 때는 각 자료형의 **WrapperClass**를 적어주어야 한다.
- `T` : 타입 변수
    - **자료형을 저장하는 변수**
    - 모든 알파벳이 들어올 수 있고, 이때 보통 대문자로 한글자만 적는다.
- `<>` : 인자 리스트 역할
    - 보통 인자는 1개 또는 2개를 사용한다.

<br>

### ✅ 제네릭 클래스 vs Object 클래스
```java
// Object 클래스
Object o1 = 20;
System.out.println((int)o1 * 2);

// 제네릭 클래스
Item<Integer> i1 = 20;
System.out.println(i1 * 20)
```
- Object형 변수에 저장된 값을 사용하려면 다운 캐스팅 작업이 필요하다.
- 제네릭 클래스는 값을 사용할 때 다운 캐스팅 작업이 필요하지 않다.
- 제네릭 클래스는 범용 클래스 역할을 하면서 각 자료형 별 전용 클래스의 편리한 사용법을 제공한다.