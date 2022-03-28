# 📌 상속, Inheritance
- 부모 클래스가 가지는 멤버(변수, 메서드)를 자식에게 물려주는 행동

<br>

### ✅ 상속 이유?
- **코드 재사용** => 비용 절감
- 부모의 멤버를 받아서 그에 더해 **기능을 확장**하기 위함

# 📌 오버라이딩, Overriding
### ✅ 오버로딩 vs 오버라이딩
| |   오버로딩   |    오버라이딩    |
|-|:-------------:|:------------------:|
|정의|같은 이름의 메서드를 인자리스트를 다양하게 하여 여러 개 정의 하는것|상속 관계에서 부모의 메서드를 상속받아 기능을 추가하거나 재정의 하는 것|
|메서드 정의부|매개변수 갯수 또는 자료형이 달라야 함|메서드 정의부가 완전히 일치 해야함 (매개변수까지)|
|클래스 상속 여부|상관 없음|상속 관계에서만 발생함|

<br>

### ✅ 오버라이딩
```java
class OverrideParent {
	
	public String name;
	
	public void hello() {
		System.out.printf("안녕하세요. 저는 %s입니다.\n", this.name);
	}
}

class OverrideChild extends OverrideParent {
	
	@Override
	public void hello() {  
		System.out.printf("안녕! 난 %s\n", this.name);
	}
}
```
- 부모로부터 물려받은 메서드와 동일한 메서드를 **자식 클래스에서 다시 선언**하는 행동
- 자식 클래스에는 부모 메서드와 재정의된 자식 메서드, 2개가 존재하게 된다. > 자식 메서드가 호출됨
- 상속 관계에 있는 클래스가 같은 목적을 가지는 메서드를 구현할 때 메서드의 시그니처를 동일하게 만들어 오버라이딩 하는 것이 좋음

<br>

# 📌Object 클래스
- **모든 클래스의 근원 클래스, root class**
- 사용자가 만드는 모든 클래스는 자동으로 Object 클래스를 상속받는다.
- Object에는 모든 클래스에게 필요한 공통 기능이 구현되어 있다. (e.g. toString(), equals(), getClass(), ..)

<br>

### ✅ Object.ToString()
```java
@Override
public String toString() {
    return String.format("Time [hour=%s, min=%s]", hour, min);
}
```
- 자신이 소유한 **데이터(멤버 변수)의 값을 문자열**로 돌려주는 코드 > 덤프(dump)
- Object의 메서드로, 모든 객체는 toString() 소유
- 자식 클래스에서 그대로 사용하지 않음 (객체의 주솟값만 반환되기 때문) > **반드시 오버라이딩해야함**

<br>

# 📌 Final 키워드
### ✅ 변수에 적용 ⭐
```java
final double PI = 3.14;

// 클래스의 멤버 변수
public static final int NUM = 3; // static 상수
```
- 지역변수 + 멤버변수
- **선언과 초기화를 동시에** 해주는 것이 가독성 측면에서 좋음
- **값을 초기화 이후에 변경할 수 없음**
- 상수의 변수명은 **대문자**로 작성해야함
- 일반적으로 객체 변수로 일반 final 변수를 사용하기 보다는 **공유 변수인 static 변수에 final**을 붙여 사용한다. > 메모리 낭비 X
- 객체 변수에 final을 붙이게 되면 객체가 생성될 때마다 같은 값이 저장되기 위한 메모리 공간이 할당된다. > 메모리 낭비 발생

<br>

### ✅ 메서드에 적용
```java
class FinalParent {
	
	public final void test() {
		System.out.println("메서드");
	}
}

class FinalChild extends FinalParent {
	
	// 오버라이딩 불가
	// @Override
	// public void test() {
	// System.out.println("Overrided");
	// }
}
```
- 메서드를 final로 선언하게 되면 상속 시 자식 클래스에서 **그 메서드를 재정의할 수 없다.**
- 프로그램의 안정성 문제가 있을 때 설정할 수 있다.

<br>

### ✅ 클래스에 적용
```java
final class FinalUser {
	
}

//class FinalUserAdmin extends FinalUser {
//	
//}
```

- final 클래스를 터미널 클래스, Leaf Node라고도 한다.
- **상속이 불가능하다.**