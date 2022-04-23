# 📌 스트림, Stream
- Java 8(JDK 1.8) 버전에서 람다식과 함께 나온 기능
- **배열(컬렉션)의 탐색(조작)** 지원 기술
- 파일 입출력 지원
- 디렉토리 탐색 지원
- 익명 객체가 필요함 ( 람다식 활용)
- 한번 탐색하면 재사용할 수 없다. (일회용)

<br>

### ✅ 스트림 작동 원리
- forEach()
1. stream을 얻어낸 **컬렉션(or 배열)의 요소를 하나씩 가져옴**
2. 가져온 요소를 Consumer의 매개변수로 전달해서 **람다식(accept())을 호출**한다.
```java
List<String> list = Data.getStringList(30); // 문자열 30개 배열
Stream<String> stream = list.stream();
Consumer<String> c1 = (str) -> {System.out.println(str);};

stream.forEach(c1);

// list.stream().forEach(str -> System.out.println(str));
```

<br>

### ✅ 스트림 객체를 얻어오는 방법
**stream()** 메서드 사용

#### 1. 배열
```java
int[] nums1 = {10, 20, 30, 40, 50};
Arrays.stream(nums1).forEach(num -> System.out.println(num));
```

<br>

#### 2. 컬렉션
- ArrayList
```java
ArrayList<Integer> nums2 = new ArrayList<>();

nums2.add(100);
nums2.add(200);
nums2.add(300);

nums2.stream().forEach(num -> System.out.println(num));
```
- HashSet
```java
HashSet<Integer> nums3 = new HashSet<>();
nums3.add(10000);
nums3.add(20000);
nums3.add(30000);

nums3.stream().forEach(num -> System.out.println(num));
```

<br>

#### 3. 숫자 범위
```java
// Stream<Integer> : 범용 스트림
// IntStream       : 전용 스트림

IntStream.range(1, 10).forEach(num -> System.out.println(num));
```

<br>

#### 4. 파일 및 디렉토리
- 스트림을 통해서 파일 읽기 가능 (쓰기 불가)
```java
Path path = Paths.get("data\\number.txt");

try {

// 파일로부터			
Files.lines(path).forEach(line -> System.out.println(line));

Path dir = Paths.get("D:\\suea7\\class\\eclipse");

// 디렉토리로부터 > dir.listFiles()
Files.list(dir).forEach(p -> {
    System.out.println(p.getFileName());
});


} catch (IOException e) {
e.printStackTrace();
}
```

<br>

# 📌 파이프, pipe
- 스트림 객체의 메서드

### ✅ 중간 처리 파이프
- 반환값 : **스트림 객체**
-  e.g. filter(), distinct()

#### 🔻 필터링
- filter()
- 앞의 스트림에서 조건에 맞는 요소만 남아있는 스트림 객체를 반환한다.
```java
List<Integer> list = Data.getIntList(20); // 정수 20개 리스트

// 1. 하나의 조건
// 짝수만 추출
list.stream().filter(num -> num % 2 == 0).forEach(num -> System.out.printf("%4d" , num));

//2. 여러 개의 조건
// 몸무게가 70kg 이상이고 남자 user만 추출
Data.getUserList().stream()
.filter(user -> user.getWeight() >= 70)
.filter(user -> user.getGender() == 1)
.forEach(user -> System.out.println(user));
```

<br>

#### 🔻 중복 제거
- distinct()
- 앞의 스트림에서 중복 요소를 제거 후, 유일한 요소만 남아있는 스트림 객체를 반환한다.
- Set의 성질과 유사
```java
List<Integer> list = Data.getIntList(); // 정수 100개 리스트

// 유일한 요소만 출력
list.stream().distinct().forEach(n -> System.out.printf("%4d", n));

// 객체 중복 검사 시 hashCode(), equals() 재정의 필요
```

<br>

#### 🔻 매핑
- map(), mapXXX()
- 변환 작업에 사용한다. ⭐
- 앞의 스트림을 처리 후 다른 타입의 스트림을 반환한다.
```java
List<String> list = Data.getStringList(10); // 문자열 10개 리스트

// String 스트림 -> Integer 스트림
list.stream().map(word -> word.length()).forEach(s -> System.out.println(s));

List<User> ulist = Data.getUserList(); // 객체 리스트
// 객체 스트림 -> 문자열 스트림
ulist.stream().map(user -> user.getName()).forEach(user -> System.out.println(user));
```

<br>

#### 🔻 정렬
- sorted()
- 배열, 컬렉션의 sort()와 사용법이 동일
    - 단일값 오름차순 > sort()
    - 단일값 내림차순 > sort(구현)
    - 복합값 오름차순, 내림차순 > sort(구현)
- **원본 배열 또는 컬렉션에 영향을 미치지 않는다.**
```java
List<Integer> nums = Data.getIntList(10); // 정수 10개 리스트

// 오름차순 정렬
nums.stream().sorted().forEach(n -> System.out.println(n));

// 내림차순 정렬
nums.stream().sorted((a, b)-> b - a).forEach(n -> System.out.println(n));
```
    
<br>

### ✅ 최종 처리 파이프
- 반환값 : 스트림 객체가 아닌 **void 또는 다른 자료형**
- e.g. forEach

#### 🔻 처리
- forEach()
- 앞의 스트림 요소를 최종 처리하는 메서드
```java
List<Integer> nums = Data.getIntList(10); // 정수 10개 리스트

nums.forEach(n -> System.out.println(n));
```

<br>

#### 🔻 매칭
- allMatch(), anyMatch(), noneMatch()
- 스트림 요소들이 제시하는 조건을 만족하는지 판단
    - boolean allMatch(Predicate) : 모든 요소가 조건을 만족?
    - boolean anyMatch(Predicate) : 일부 요소가 조건을 만족?
    - boolean noneMatch(Predicate) : 모든 요소가 조건을 불만족?

```java
int[] nums = {2, 4, 7, 8, 10};

// allMatch()
System.out.println(Arrays.stream(nums).allMatch(n -> n % 2 == 0));
		
// noneMatch()
System.out.println(Arrays.stream(nums).noneMatch(n -> n % 2 == 0));

// anyMatch() 
System.out.println(Arrays.stream(nums).anyMatch(n -> n % 2 == 0));
```

<br>

#### 🔻 집계
- count(), max(), min(), sum(), avg()
- 요소들을 가공해서 축소하는 작업, 통계값 반환
```java
List<Integer> list = Data.getIntList(); // 정수 100개 리스트

// count()
System.out.println(list.stream().count());

// max(), min()
// Optional 타입으로 반환됨 > null을 가질 수 있는 값형
System.out.println(list.stream().max((a, b) -> a - b));
System.out.println(list.stream().min((a, b) -> a - b));

// sum(), average() > IntStream에만 존재 > mapToInt() 사용
System.out.println(list.stream().mapToInt(n -> n).sum());
System.out.println((list.stream().mapToInt(n -> n).average()).getAsDouble());
```
