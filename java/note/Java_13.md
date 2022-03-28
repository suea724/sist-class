# 📌 static 키워드
- <b>클래스 멤버(멤버 변수, 멤버 메서드)</b>에 붙이는 키워드 ⭐
- 클래스에도 붙일 수 있지만 자주 사용하지는 않는다.

<br>

### ✅ 메모리
- 스택: 지역 변수 저장
- 힙: 참조 변수가 가리키는 인스턴스가 저장되는 곳
- **static 영역**: static 키워드가 붙은 모든 멤버가 생성되는 곳

<br>

### ✅ 클래스 로딩, Class Loading
- 해당 프로그램을 실행하기 전에 클래스의 정의를 미리 읽어서 메모리에 얹는 작업
- 메인 메서드 실행 전에 일어난다.
- **클래스 로딩 과정에서 발견되는 모든 static 멤버는 메모리에 구현된다**. => 정적 멤버 로딩 (클래스 이름) ⭐

<br>

# 📌 클래스 멤버 변수
- **객체 변수**
    - 객체가 각자 저장할 데이터를 저장하는 변수
- **정적 변수**
    - 하나의 클래스로부터 만들어진 모든 객체가 공통으로 가지는 데이터를 저장하는 변수
    - static 변수, 클래스 변수, 공유 변수
```java
// static 변수 선언
private static String school; 

// static 변수의 getter, setter > static 메서드 사용
public static String getSchool() {
    return school;
}

public static void setSchool(String school) {
    Student.school = school; // 접근 시 클래스명 사용
}
```