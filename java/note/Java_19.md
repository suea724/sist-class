# 📌 컬렉션 프레임워크, Collection Framework
- 다량의 데이터를 관리하는 **자료구조**를 편리하게 사용할 수 있도록 다양한 클래스를 제공하는 프레임워크
- 기존 순수 배열의 성능 향상시키고(입출력), 사용법을 개량해서 클래스로 만들어놓았다.
- 내부에 순수 배열을 가지고 있다.
- 순수 배열과 달리 **길이를 변경할 수 있다.**

<br>

### ✅ 종류
 1. **List 계열**
	- ArrayList
	- LinkedList
	- Queue
	- Stack
	- ~~Vector~~ (legacy)
		
2. **Set 계열**
	- HashSet
	- TreeSet
 
3. **Map 계열**
	- HashMap
	- TreeMap
	- ~~Properties~~ (legacy)
	- ~~HashTable~~ (legacy)

<br>

# 📌 ArrayList
```java
ArrayList<T> list = new ArrayList<T>();
```
- `ArrayList(C) -> List(I) -> Collection(I)`
- 순수 배열과 구조가 가장 유사하다. > **인덱스를 사용해서 요소에 접근**
- 컬렉션 프레임워크의 클래스 중 사용 빈도가 가장 높다.

<br>

### ✅ 사용법
- **요소 추가**
    - 배열의 **마지막 위치에 추가**한다. > append mode
```java
// boolean add(T value)
list.add("귤");
list.add("바나나");
list.add("사과");
list.add("체리");
list.add("딸기");
list.add("파인애플");
```

- **요소 개수**
```java
// nt size()
list.size()
```
- **요소 접근**
```java
// T get(int index)
list.get(0)
```
- **요소의 수정**
```java
// T set(int index, T newValue)
list.set(2, "파인애플");
```
- **요소의 삭제**
    - 값으로 삭제할 때 중복되는 값이 있으면 처음으로 만나는 요소를 삭제한다.
    - **삭제된 방 이후의 모든 요소는 left shift가 발생**한다. ⭐
```java
// boolean add(T value)
list.remove("파인애플");
list.remove(2);
```
- **요소 추가**
    - 배열의 **원하는 위치에 요소를 추가**한다. > insert mode
    - **삽입된 방 이후의 모든 요소 right shift 발생**한다. ⭐
```java
// void add(int index, T value)
list.add(2, "망고");
```
- **요소 검색**
```java
// int indexOf(T value)
// int lastIndexOf(T value)
// boolean contains(T value)
list.indexOf("체리");
list.contains("체리");
```
- **모든 요소 삭제 (초기화)**
```java
void clear()
list.clear();
```

- **빈 배열 확인**
```java
// boolean isEmpty()
list.isEmpty()
```

<br>

### ✅ ArrayList 문제점 (Collection 공통 적용)
#### 문제 1️⃣

- ArrayList는 생성 시 기본적으로 **길이가 10으로 할당**된다.
- 기본적으로 배열의 길이는 불변이므로, ArrayList는 10개 이상의 값이 들어오면 **2배 길이의 새로운 배열**에 기존 요소들을 복사하고, 새로운 값을 추가한다.
- 이를 반복적으로 수행하게 되면 **참조가 끊긴 배열들이 가비지**로 남게 되고, 이렇게 되면 프로그램이 무거워질 수 있다. 

#### 💡 해결방법
→ ArrayList 생성 시 **초기 길이를 지정**한다. **(생성자 매개변수 입력)**

<br>


#### 문제 2️⃣

- 값이 배열의 길이를 초과하면 **배열의 길이가 무조건 더블링** 된다.
- **배열의 남는 공간**이 생길 수 있다. > **메모리 낭비**

#### 💡 해결방법
→ 데이터 개수에 맞게 **배열의 길이를 조정**한다. **(trimToSize() 메서드 사용)**

