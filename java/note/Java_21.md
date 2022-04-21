# 📌 HashMap

###  ✅ ArrayList vs HashMap
#### 🔻 ArrayList
- 요소 접근 시 **index** 사용
- **순서가 있는 데이터 집합** > index == 요소의 순서 ⭐
- 스칼라 배열(Scalar Array)
- 식별자가 index이기 때문에, 요소끼리 구분 시 불편하다.
- for문 사용해서 요소 일괄 접근이 가능하다.

<br>

#### 🔻 HashMap
- **키(key)와 값(value)를 한쌍으로 가지는 데이터 구조**이다. ⭐
- **key는 유일**해야 하고, **값은 중복이 허용**된다.
- 요소 접근 시 **key** 사용
- 순서가 없는 데이터 집합 > index X
- 식별자 자체가 의미있는 단어이므로, 요소끼리 구분하기 용이하다.

<br>

### ✅ 사용법
- **요소 추가** : `V put(K key, V value)`
- **요소 개수** : `int size()`
- **요소 읽기** : `V get(K key)`
    - 이때 key의 value가 없으면 null을 반환한다. (에러 X)
- **요소 수정** : `V put(K key, V value)`
    - key가 유일하기 때문에 요소 추가와 같은 메서드를 사용한다.
- **요소 검색** : `boolean containsKey(K key)`, `boolean containsValue(V value)`
- **요소 삭제** : `V remove(K key)`
- **초기화** : `void clear()`

<br>

# 📌 TreeMap
- 이진 트리 구조의 Map
- 자동 정렬 + 범위 검색 (추출) 용이
```java
TreeMap<String, String> map = new TreeMap<>();
		
map.put("white", "하양");
map.put("black", "검정");
map.put("yellow", "노랑");
map.put("red", "빨강");
map.put("green", "초록");

// TreeMap 고유 메서드
System.out.println(map.firstKey());
System.out.println(map.firstEntry()); // 첫 key=value 한쌍

System.out.println(map.lastKey());
System.out.println(map.lastEntry()); // 마지막 key=value 한쌍

System.out.println(map.headMap("m")); // m 이후(포함) entry 가져옴
System.out.println(map.tailMap("m")); // m 이전(미포함) entry 가져옴
System.out.println(map.subMap("r", "y")); // r(포함)과 y(미포함) 사이 entry 가져옴
```