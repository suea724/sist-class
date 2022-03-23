# 📌 문자열 (String)
- JDK가 제공하는 문자열 조작 기능을 사용할 수 있음
- 문자열(String)과 문자(char)의 관계? → 문자열은 문자의 집합
- String = char[] (문자 배열로 구성)
- 문자열과 배열을 조작하는 기능이 유사함

<br>

# 📌 문자열 함수
### ✅ length()
- **문자열의 길이를 반환**하는 함수
- 입력받은 문자열의 길이를 체크하는 기능에 사용할 수 있음

```java
String str = "홍길동입니다.";
System.out.println(str.length()); // 6
```
<br>

> 이름 길이 체크
```java
String statement = reader.readLine();

System.out.printf("입력한 문장은 %d개의 문자로 구성되었습니다.\n", statement.length());

if (statement.length() >= 2 && statement.length() <= 5) {
    System.out.printf("이름은 %s\n", statement);
} else {
    System.out.println("이름을 2 ~5자로 입력해주세요");
}
```

<br>

### ✅ indexOf(char c), indexOf(String) ⭐
- 문자열 내에서 **원하는 문자(열)을 검색하여 발견한 위치(index) 반환**
- 자주 사용함!
- 두번째 매개변수로 **검색을 시작할 위치를 지정**할 수 있음
- lastIndexOf(): (오른쪽 -> 왼쪽으로 검색)

```java
String txt = "안녕하세요. 홍길동입니다.";

index = txt.indexOf("홍길동");
System.out.println(index); // 첫번째 문자 위치 반환

txt = "안녕하세요. 홍길동입니다. 반갑습니다. 홍길동입니다.";
index = txt.indexOf("홍길동", 10); // 10 위치부터 찾음

```

<br>

### ✅ charAt(int index)
- **원하는 위치의 문자를 추출**하는 함수
- 인덱스에 (문자열 길이 - 1)를 입력해주면 마지막 요소 반환

> 기본 사용법
```java
String txt = "안녕하세요. 홍길동입니다.";

char c = txt.charAt(3);
System.out.println(c);

c = txt.charAt(txt.length() - 1);
System.out.println(c);
```

<br>

### ✅ trim()
- 문자열의 **시작과 끝에 존재하는 공백 제거**
- 문자열의 공백? whitespace > 스페이스, 탭, 개행
- 사용자가 실수로 입력하거나 불필요하게 들어간 공백을 제거하는 역할
- 검색에서 앞,뒤 공백을 제외한 키워드를 추출할 때 유용

> 기본 사용법
```java
String str = "    하나   둘    셋    넷    다섯     ";
System.out.printf("[%s]", str.trim()); // 하나   둘    셋    넷    다섯
```

<br>

### ✅ toUpperCase(), toLowerCase()
- 문자열의 **대소문자를 변경**할 때 사용
- 대소문자를 구분없이 검색 시 검색어와 대상 문자열 모두 대문자 또는 소문자로 변경해서 비교해야 함
- 대소문자 구분하여 검색 > 정확도 높고, 검색률 낮음
- 대소문자 구분없이 검색 > 정확도 낮고, 검색률 높음

> 대소문자 구분 O
```java
String content = "Java 수업 중입니다.";
String word = "java";

if (content.indexOf(word) > -1) {
    System.out.println("검색 결과 있음");
} else {
    System.out.println("검색 결과 없음");
}
// 검색 결과 없음
```

<br>

> 대소문자 구분 X
```java
if (content.toUpperCase().indexOf(word.toUpperCase()) > -1) {
    System.out.println("검색 결과 있음");
} else {
    System.out.println("검색 결과 없음");
    }
// 검색 결과 있음
```

<br>

### ✅ startsWith(String), endsWith(String)
- **패턴 검색시** 사용
- 매개변수로 입력된 문자열이 처음 또는 끝에 위치하는지 여부 반환

```java
String txt = "자바 프로그래밍";
System.out.println(txt.startsWith("자바")); // true
```

<br>

> 확장자 검사
```java
String path = "C:\\class\\java\\JavaTest\\Ex28_String.java";
		
if (path.endsWith(".java")) {
    System.out.println("O");
} else {
    System.out.println("X");
}
// O
```

<br>

### ✅ substring(begin), substring(begin, end)
- **문자열 추출**
- 검사 시 **begin 인덱스는 포함, end 인덱스는 미포함**
- charAt() 또는 indexOf() 메서드와 함께 사용되는 경우가 많음

```java
String txt = "가나다라마바사아자차카타파하";
System.out.println(txt.substring(3, 7));
// 라마바사
```

<br>

> 확장자 추출
```java
String path = "C:\\class\\JavaTest\\Hello.java";

int index = path.lastIndexOf(".");
String extension = path.substring(index + 1);

System.out.println(extension); // java
```

<br>

### ✅ contains(word)
- **특정 문자열 검색하여 포함 여부를 반환**하는 메서드
- 매개변수로 입력된 문자열이 있으면 true 반환
```java
String txt = "안녕하세요 홍길동입니다.";
		
System.out.println(txt.contains("홍길동")); // true
```

<br>

### ✅ replace(old, new) 
- String replace(String old, String new)
- **문자열의 일부를 다른 문자열로 교체**하는 메서드
- new를 빈 문자열로 지정 시 기존의 문자열을 제거할 수 있음
- 문자열의 모든 공백 지울 때, 마스킹할 때 등 사용
```java
String content = "게시판에 글을 작성합니다. 바보야~!";
String word = "바보";
System.out.println(content.replace(word, "**"));
// 게시판에 글을 작성합니다. **야~!
```

<br>

### ✅ split(String)
- String[] split(String delimiter)
- **문자열을 구분자를 기준으로 쪼개는 메서드**
- 반환형은 배열
```java
String name = "홍길동, 아무개, 하하하, 강호동, 유재석";
		
String[] names = name.split(", ");

for (int i = 0 ; i < names.length ; i ++) {
    System.out.println(names[i]);
}

// 홍길동
// 아무개
// 하하하
// 강호동
// 유재석
```

<br>

---

# 📌문자열 잦은 수정 시 문제점
### ✅ 자바의 자료형
1. **값형**: 값이 변경되어도 공간의 크기는 변하지 않는다. (int타입은 10이던 10억이던 4byte 고정)
2. **참조형**: 값이 변경되면 공간의 크기가 변한다. (가리키는 데이터가 달라짐)

<br>

### ✅ 문자열을 대상으로 피해야하는 행동
1. 문자열의 잦은 수정
2. 큰 문자열의 수정
```java
String str1 = "abc";
String str2 = "def";
String str3 = str1 + str2;
```
- String 타입 연산 시 기존의 문자열에 다른 문자열이 추가되는 것이 아님
- str3는 `"abcdef"`라는 새로운 리터럴을 가리키게 됨
- 이때 기존의 문자열인 str1과 str2는 가리키고 있던 리터럴과의 참조가 끊김
- 참조가 끊기면 `"abc"`와 `"def"`는 메모리에 garbage로 남음
- 이러한 과정이 반복되면 프로그램이 무거워질 수 있음

<br>

### ✅ StringBuilder()
```java
StringBuilder str = new StringBuilder();
```
- String 타입 문자열 연산의 단점을 보완
- `str.append()`를 사용하여 문자열 연산을 하는데 이때 garbage가 발생하지 않는다.
- 기존의 String에 비해 수정하기 용이하며 String 연산보다 매우 빠르다.

<br>

