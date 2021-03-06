# ๐ ์คํธ๋ฆผ, Stream
- Java 8(JDK 1.8) ๋ฒ์ ์์ ๋๋ค์๊ณผ ํจ๊ป ๋์จ ๊ธฐ๋ฅ
- **๋ฐฐ์ด(์ปฌ๋ ์)์ ํ์(์กฐ์)** ์ง์ ๊ธฐ์ 
- ํ์ผ ์์ถ๋ ฅ ์ง์
- ๋๋ ํ ๋ฆฌ ํ์ ์ง์
- ์ต๋ช ๊ฐ์ฒด๊ฐ ํ์ํจ ( ๋๋ค์ ํ์ฉ)
- ํ๋ฒ ํ์ํ๋ฉด ์ฌ์ฌ์ฉํ  ์ ์๋ค. (์ผํ์ฉ)

<br>

### โ ์คํธ๋ฆผ ์๋ ์๋ฆฌ
- forEach()
1. stream์ ์ป์ด๋ธ **์ปฌ๋ ์(or ๋ฐฐ์ด)์ ์์๋ฅผ ํ๋์ฉ ๊ฐ์ ธ์ด**
2. ๊ฐ์ ธ์จ ์์๋ฅผ Consumer์ ๋งค๊ฐ๋ณ์๋ก ์ ๋ฌํด์ **๋๋ค์(accept())์ ํธ์ถ**ํ๋ค.
```java
List<String> list = Data.getStringList(30); // ๋ฌธ์์ด 30๊ฐ ๋ฐฐ์ด
Stream<String> stream = list.stream();
Consumer<String> c1 = (str) -> {System.out.println(str);};

stream.forEach(c1);

// list.stream().forEach(str -> System.out.println(str));
```

<br>

### โ ์คํธ๋ฆผ ๊ฐ์ฒด๋ฅผ ์ป์ด์ค๋ ๋ฐฉ๋ฒ
**stream()** ๋ฉ์๋ ์ฌ์ฉ

#### 1. ๋ฐฐ์ด
```java
int[] nums1 = {10, 20, 30, 40, 50};
Arrays.stream(nums1).forEach(num -> System.out.println(num));
```

<br>

#### 2. ์ปฌ๋ ์
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

#### 3. ์ซ์ ๋ฒ์
```java
// Stream<Integer> : ๋ฒ์ฉ ์คํธ๋ฆผ
// IntStream       : ์ ์ฉ ์คํธ๋ฆผ

IntStream.range(1, 10).forEach(num -> System.out.println(num));
```

<br>

#### 4. ํ์ผ ๋ฐ ๋๋ ํ ๋ฆฌ
- ์คํธ๋ฆผ์ ํตํด์ ํ์ผ ์ฝ๊ธฐ ๊ฐ๋ฅ (์ฐ๊ธฐ ๋ถ๊ฐ)
```java
Path path = Paths.get("data\\number.txt");

try {

// ํ์ผ๋ก๋ถํฐ			
Files.lines(path).forEach(line -> System.out.println(line));

Path dir = Paths.get("D:\\suea7\\class\\eclipse");

// ๋๋ ํ ๋ฆฌ๋ก๋ถํฐ > dir.listFiles()
Files.list(dir).forEach(p -> {
    System.out.println(p.getFileName());
});


} catch (IOException e) {
e.printStackTrace();
}
```

<br>

# ๐ ํ์ดํ, pipe
- ์คํธ๋ฆผ ๊ฐ์ฒด์ ๋ฉ์๋

### โ ์ค๊ฐ ์ฒ๋ฆฌ ํ์ดํ
- ๋ฐํ๊ฐ : **์คํธ๋ฆผ ๊ฐ์ฒด**
-  e.g. filter(), distinct()

#### ๐ป ํํฐ๋ง
- filter()
- ์์ ์คํธ๋ฆผ์์ ์กฐ๊ฑด์ ๋ง๋ ์์๋ง ๋จ์์๋ ์คํธ๋ฆผ ๊ฐ์ฒด๋ฅผ ๋ฐํํ๋ค.
```java
List<Integer> list = Data.getIntList(20); // ์ ์ 20๊ฐ ๋ฆฌ์คํธ

// 1. ํ๋์ ์กฐ๊ฑด
// ์ง์๋ง ์ถ์ถ
list.stream().filter(num -> num % 2 == 0).forEach(num -> System.out.printf("%4d" , num));

//2. ์ฌ๋ฌ ๊ฐ์ ์กฐ๊ฑด
// ๋ชธ๋ฌด๊ฒ๊ฐ 70kg ์ด์์ด๊ณ  ๋จ์ user๋ง ์ถ์ถ
Data.getUserList().stream()
.filter(user -> user.getWeight() >= 70)
.filter(user -> user.getGender() == 1)
.forEach(user -> System.out.println(user));
```

<br>

#### ๐ป ์ค๋ณต ์ ๊ฑฐ
- distinct()
- ์์ ์คํธ๋ฆผ์์ ์ค๋ณต ์์๋ฅผ ์ ๊ฑฐ ํ, ์ ์ผํ ์์๋ง ๋จ์์๋ ์คํธ๋ฆผ ๊ฐ์ฒด๋ฅผ ๋ฐํํ๋ค.
- Set์ ์ฑ์ง๊ณผ ์ ์ฌ
```java
List<Integer> list = Data.getIntList(); // ์ ์ 100๊ฐ ๋ฆฌ์คํธ

// ์ ์ผํ ์์๋ง ์ถ๋ ฅ
list.stream().distinct().forEach(n -> System.out.printf("%4d", n));

// ๊ฐ์ฒด ์ค๋ณต ๊ฒ์ฌ ์ hashCode(), equals() ์ฌ์ ์ ํ์
```

<br>

#### ๐ป ๋งคํ
- map(), mapXXX()
- ๋ณํ ์์์ ์ฌ์ฉํ๋ค. โญ
- ์์ ์คํธ๋ฆผ์ ์ฒ๋ฆฌ ํ ๋ค๋ฅธ ํ์์ ์คํธ๋ฆผ์ ๋ฐํํ๋ค.
```java
List<String> list = Data.getStringList(10); // ๋ฌธ์์ด 10๊ฐ ๋ฆฌ์คํธ

// String ์คํธ๋ฆผ -> Integer ์คํธ๋ฆผ
list.stream().map(word -> word.length()).forEach(s -> System.out.println(s));

List<User> ulist = Data.getUserList(); // ๊ฐ์ฒด ๋ฆฌ์คํธ
// ๊ฐ์ฒด ์คํธ๋ฆผ -> ๋ฌธ์์ด ์คํธ๋ฆผ
ulist.stream().map(user -> user.getName()).forEach(user -> System.out.println(user));
```

<br>

#### ๐ป ์ ๋ ฌ
- sorted()
- ๋ฐฐ์ด, ์ปฌ๋ ์์ sort()์ ์ฌ์ฉ๋ฒ์ด ๋์ผ
    - ๋จ์ผ๊ฐ ์ค๋ฆ์ฐจ์ > sort()
    - ๋จ์ผ๊ฐ ๋ด๋ฆผ์ฐจ์ > sort(๊ตฌํ)
    - ๋ณตํฉ๊ฐ ์ค๋ฆ์ฐจ์, ๋ด๋ฆผ์ฐจ์ > sort(๊ตฌํ)
- **์๋ณธ ๋ฐฐ์ด ๋๋ ์ปฌ๋ ์์ ์ํฅ์ ๋ฏธ์น์ง ์๋๋ค.**
```java
List<Integer> nums = Data.getIntList(10); // ์ ์ 10๊ฐ ๋ฆฌ์คํธ

// ์ค๋ฆ์ฐจ์ ์ ๋ ฌ
nums.stream().sorted().forEach(n -> System.out.println(n));

// ๋ด๋ฆผ์ฐจ์ ์ ๋ ฌ
nums.stream().sorted((a, b)-> b - a).forEach(n -> System.out.println(n));
```
    
<br>

### โ ์ต์ข ์ฒ๋ฆฌ ํ์ดํ
- ๋ฐํ๊ฐ : ์คํธ๋ฆผ ๊ฐ์ฒด๊ฐ ์๋ **void ๋๋ ๋ค๋ฅธ ์๋ฃํ**
- e.g. forEach

#### ๐ป ์ฒ๋ฆฌ
- forEach()
- ์์ ์คํธ๋ฆผ ์์๋ฅผ ์ต์ข ์ฒ๋ฆฌํ๋ ๋ฉ์๋
```java
List<Integer> nums = Data.getIntList(10); // ์ ์ 10๊ฐ ๋ฆฌ์คํธ

nums.forEach(n -> System.out.println(n));
```

<br>

#### ๐ป ๋งค์นญ
- allMatch(), anyMatch(), noneMatch()
- ์คํธ๋ฆผ ์์๋ค์ด ์ ์ํ๋ ์กฐ๊ฑด์ ๋ง์กฑํ๋์ง ํ๋จ
    - boolean allMatch(Predicate) : ๋ชจ๋  ์์๊ฐ ์กฐ๊ฑด์ ๋ง์กฑ?
    - boolean anyMatch(Predicate) : ์ผ๋ถ ์์๊ฐ ์กฐ๊ฑด์ ๋ง์กฑ?
    - boolean noneMatch(Predicate) : ๋ชจ๋  ์์๊ฐ ์กฐ๊ฑด์ ๋ถ๋ง์กฑ?

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

#### ๐ป ์ง๊ณ
- count(), max(), min(), sum(), avg()
- ์์๋ค์ ๊ฐ๊ณตํด์ ์ถ์ํ๋ ์์, ํต๊ณ๊ฐ ๋ฐํ
```java
List<Integer> list = Data.getIntList(); // ์ ์ 100๊ฐ ๋ฆฌ์คํธ

// count()
System.out.println(list.stream().count());

// max(), min()
// Optional ํ์์ผ๋ก ๋ฐํ๋จ > null์ ๊ฐ์ง ์ ์๋ ๊ฐํ
System.out.println(list.stream().max((a, b) -> a - b));
System.out.println(list.stream().min((a, b) -> a - b));

// sum(), average() > IntStream์๋ง ์กด์ฌ > mapToInt() ์ฌ์ฉ
System.out.println(list.stream().mapToInt(n -> n).sum());
System.out.println((list.stream().mapToInt(n -> n).average()).getAsDouble());
```
