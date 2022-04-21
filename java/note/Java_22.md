# 📌 HashSet
- Set 인터페이스 기반 클래스 중 가장 사용빈도가 높은 클래스이다.
- **식별자가 따로 없어 각 요소를 구분할 수 없다.**
- Set은 **데이터의 중복을 허용하지 않는 자료구조**이다. ⭐

<br>

### ✅ 사용법
- **요소 추가** : `boolean add(T value)`
    - 중복된 요소 추가 시 입력되지 않음
- **요소 개수** : `int size()`
- **요소 삭제** : `boolean remove(T value)`

<br>

### ✅ 요소 탐색
Set에는 요소를 조회하는 식별자가 따로 존재하지 않는다. 따라서 요소를 조회하는 메서드가 없기 때문에 **Iterator 객체**를 사용한다.

```java
// set의 모든 요소 출력
Iterator<String> itr = set.iterator();
		
    while(itr.hasNext()) {
        System.out.println(itr.next());
    }
```

<br>

### ✅ Set의 중복값 체크
```java
set.add(new Person("홍길동", 20)); // 1번
set.add(new Person("아무개", 25));
set.add(new Person("김김김", 28));
set.add(new Person("홍길동", 20)); // 2번
```
- Set은 기본적으로 객체의 **hashCode값**을 사용해서 **equals()** 메서드를 통해 중복을 체크한다.
- hashCode값은 메모리 주솟값을 암호화한 값으로, **다른 객체라면 서로 다른 값을 반환**한다.
- 위 코드에서 1번과 2번은 상태는 일치하지만, **서로 다른 객체**이므로 (new 연산자 2번 사용) 두 객체 모두 입력된다.

<br>

### ✅ hashCode()와 equals() 오버라이딩
```java
@Override
public int hashCode() {
        
    // p1 > "홍길동", 20 > "홍길동20" > 100 
    // p2 > "아무개", 25 > "아무개25" > 200 
    // p3 > "홍길동", 20 > "홍길동20" > 100
    // => 같은 문자열일 때, 문자열의 hashCode값은 같음 (문자열 리터럴은 유일)
    
    return (name + age).hashCode();
}	

@Override
public boolean equals(Object obj) {
    
    // 문자열의 hashCode값 비교
    return (this.hashCode() == obj.hashCode());
}


```
- 만약 객체 자체로 비교하는 것이 아니라, **객체의 상태(값)로 비교**하기 위해서는 <b>hashCode()와 equals()를 오버라이딩</b> 해주어야 한다.
- hashCode값이 메모리 주솟값이 아니라, **상태로 구분**될 수 있도록 해야한다.
- 위 코드에서는 **문자열 리터럴이 유일**하다는 특성을 사용해서 hashCode값을 설정했다.
- hashCode값은 다른 방식으로도 구현해줄 수 있다.
    - e.g. hashCode를 유일해야 하는 id로 설정

<br>

# 📌 TreeSet
- 이진 트리 구조
- 자동으로 정렬됨
```java
TreeSet<Integer> set = new TreeSet<>();

set.add(50);
set.add(30);
set.add(40);
set.add(10);
set.add(20);

// TreeSet 고유 메서드
System.out.println(set.first()); // 첫번째 요소
System.out.println(set.last()); // 마지막 요소

System.out.println(set.headSet(30)); // 미포함
System.out.println(set.tailSet(70)); // 포함
System.out.println(set.subSet(30, 70)); // 포함, 미포함
```