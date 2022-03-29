# 📌 StereoType
- 추상적인 자료형 (실체화하지 못하는 자료형)
- **Interface, Abstract Class**

<br>

# 📌 인터페이스, Interface
```java
interface Mouse {

	public void click();
}
```

- 서로 비슷한 부류의 객체들의 **사용법을 물리적으로 통일시키는 방법**
- 하나의 인터페이스를 구현하는 모든 클래스는 객체를 만들게 되면 공통 메서드가 존재 (강제)
- 인터페이스는 객체를 만들 수 없다. > <u>**추상 멤버(추상 메서드)를 가지고 있기 때문에 실체화 할 수 없음**</u> ⭐
- 제품의 규격을 정의

<br>

### ✅ 인터페이스 멤버 선언
- **추상 메서드** 또는 상수(자바만)를 멤버로 가진다. ⭐
    - 추상 메서드: **메서드의 구현부(body)가 없는 메서드**
- 멤버 변수 또는 멤버 메서드를 가질 수 없음

<br>

### ✅ 인터페이스를 구현하는 클래스
```java
class G304 implements Mouse {
	
	@Override
	public void click() {
		System.out.println("G304 클릭");
	}
}

class G102 implements Mouse {
	
	@Override
	public void click() {
		System.out.println("G102 클릭");
	}
}
```

- 인터페이스를 구현하는 클래스는 모두 **추상 메서드를 구현해줘야 한다.**
- 추상 메서드 구현을 강제하기 때문에, 같은 인터페이스를 구현하는 객체들의 **사용법 표준화**를 해줄 수 있다.

<br>

# 📌다중 상속
- 상속 관계에서 부모 클래스를 두 개 이상 가지는 경우
- 자식 클래스가 매우 복잡해지고, 모호성이 발생할 수 있음 ([Diamond problem](https://suaring.tistory.com/49))
- 자바에서는 클래스간 다중 상속을 허용하지 않음
- 인터페이스에 한해서는 **하나의 클래스가 여러 인터페이스를 구현할 수 있음**

<br>

### ✅ 인터페이스 여러 개를 구현
```java
class Person implements Man, Father, CafeOwner {

    @Override
    // ...
}
```
- 인터페이스는 하나의 클래스가 수행해야할 **역할**을 명시한 것
- **하나의 클래스는 여러 역할을 수행할 수 있다.**
- 또 같은 역할을 하는 객체는 그 **역할을 수행하는 방법이 다를 수 있다.** > 각 객체의 성격이 다를 수 있다.
- 다른 객체끼리의 협력에도 인터페이스가 필요하다. > 혼동 막고 사용법을 표준화해줌

<br>

# 📌 추상 클래스, Abstract class
```java
abstract class KeyBoard {

private int price;
public String color;

// 추상 멤버 > abstract 키워드 생략 불가능
public abstract void charge();
```
- 클래스처럼 **구현된 멤버**와 인터페이스처럼 **추상 메서드**가 **같이 존재**하는 클래스의 일종
- 추상 메서드를 가지므로 실체화가 불가능 > 객체 생성 불가
- 인터페이스처럼 **상속을 할 때 사용함**
- 상속 시 추상 메서드와 함께 **멤버 변수까지 상속**한다.
- 추상 멤버는 `abstract` 키워드를 명시적으로 붙여줘야 한다.