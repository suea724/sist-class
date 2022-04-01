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
- key는 유일해야 하고, 값은 중복이 허용된다.
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