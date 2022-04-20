# 📌인코딩과 디코딩
### ✅ 인코딩, Encoding

- **문자 코드**(응용 프로그램의 데이터)를 **부호화(1,0)** 시키는 작업
- e.g. 자바 "홍길동" > 텍스트 파일 "1010100010010"

<br>

### ✅ 디코딩, Decoding
- **부호 데이터**(1,0)를 **문자 코드**로 변환하는 작업
- e.g. 텍스트 파일 "1010100010010" > 자바 "홍길동"

<br>

### ✅ 인코딩/디코딩 규칙
저장 장치 또는 네트워크 상에서 데이터를 표현하는 규칙
1. ISO-8859-1
2. EUC-KR
3. ANSI
4. MS949
5. UTF-8
6. UTF-16

<br>

- **ANSI(ISO-8859-1, EUC-KR, MS949)**
    - 영어(숫자, 특수문자, ..): 1byte
    - 한글(한자, 일본어 등 영어가 아닌 문자): 2byte

- **UTF-8** ⭐
    - 국제 표준
    - 영어: 1byte
    - 한글: 3byte

- **UTF-16**
    - 영어: 2byte
    - 한글: 2byte

<br>

# 📌 파일 입출력
- **자바 프로그램과 저장 장치 간 데이터 교환**이 이루어 지는 것
- 파일 입출력을 수행하기 위해서는 **스트림 객체**가 필요하다.

<br>

# 📌 스트림
- 스트림은 디바이스에 독립적으로 일관성있는 입출력을 제공한다.
- 자바는 **입출력이 이루어지는 모든 곳에서 스트림을 사용**한다.
- 입출력이 구현되는 곳: 파일 디스크, 키보드, 마우스, 네트워크, 메모리, ...
- 스트림 사용 시, 필수적으로 **IOException에 대한 예외처리**를 해주어야 한다.
- 스트림은 사용 이후에는 닫아서 **자원을 해제**해주어야 한다. > 해주지 않으면 파일이 잠긴 상태로 남는다. (사용중)
- 스트림을 **한번 사용하면 재사용할 수 없다.** (다시 생성해야 함)

<br>

### ✅ 바이트 단위 스트림
바이트 단위(1byte)로 쓰게 되면 **한글(3byte)은 작성 시 깨지고, 사용이 불편하다**는 단점이 있다. 주로 동영상, 음악 파일, 실행 파일 등의 자료를 읽고 쓸 때 사용한다.

<br>

#### 🔻 FileOutputStream
- **출력 스트림**으로, 자바 프로그램에서 디스크에 파일을 쓸 때 사용한다.
- 스트림 생성자 부분에 두번째 매개변수로 true 값을 넣어주면 append 모드로 실행할 수 있다. (default는 create 모드) 
```java
FileOutputStream fos = new FileOutputStream(file);
// FileOutputStream fos = new FileOutputStream(file, true); > append mode

fos.write(65);
fos.write(66);
fos.write(67);

fos.close(); // 자원 해제 코드
```

<br>

#### 🔻 FileInputStream
- **입력 스트림**으로, 디스크로부터 자바 프로그램으로 파일을 읽어들일 때 사용한다.
```java
FileInputStream fis = new FileInputStream("D:\\class\\java\\file\\data.txt");

int code = -1;

while ((code = fis.read()) != -1) { // 한글자씩 읽음
    System.out.print((char)code);
}

fis.close(); // 자원 해제 코드
```

<br>

### ✅ 문자 단위 스트림

#### 🔻 BufferedReader
- **입력 스트림**으로, 파일을 문자 단위로 읽어들일 때 사용한다.
- FileReader를 감싸 버퍼 기능을 제공하여 속도가 향상된 입력 스트림 기능을 제공한다.
- **readLine()** 메서드를 사용하면 한줄씩 파일을 읽어들일 수 있다.

```java
BufferedReader reader = new BufferedReader(new FileReader("D:\\class\\java\\file\\TODO.txt"));

String line = null;

while((line = reader.readLine()) != null) { // 한줄씩 읽음
System.out.println(line);
}

reader.close(); // 자원 해제 코드
```

<br>

#### 🔻 BufferedWriter
- **출력 스트림**으로 파일에 문자 단위로 출력할때 사용한다.
- FileWriter를 감싸 버퍼 기능을 제공하여 속도가 향상된 출력 스트림 기능을 제공한다.
```java
BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\class\\java\\file\\list.txt"));

writer.write("안녕하세요.");
writer.newLine();
writer.write("홍길동입니다.");

writer.close(); // 자원 해제 코드
```

<br>

### ✅ 파일 수정
```java
// 1. 기존 내용 읽기
BufferedReader reader = new BufferedReader(new FileReader(Data.EDIT));
			
String line = null;

while ((line = reader.readLine()) != null) {
    System.out.println(line);
}

reader.close();

// 2. 수정할 내용 입력받음
Scanner scanner = new Scanner(System.in);
String input = scanner.nextLine();

// 3. 덮어쓰기
BufferedWriter writer = new BufferedWriter(new FileWriter(Data.EDIT));

writer.write(input);
writer.close();

System.out.println("수정 완료");
```

<br>

# 📌 자원의 경로 표현법
### ✅ 절대 경로
- 기준점 : 절대 위치
- e.g. A5열에 앉아있는 사람
- **C:\class:\java\data.txt** > 드라이브로부터 시작
```java
System.out.println(file.getAbsolutePath()); // 절대 경로
```

<br>

### ✅ 상대 경로
- 기준점 : 상대 위치
- e.g. 내 앞에 앉아 있는 사람
- **.\data.txt** > .(현재 위치)으로 시작
- 읽고 쓰는 파일의 위치를 **프로젝트 폴더 내부**에 두면 관리가 용이하다. > 이때 상대경로 사용
```java
System.out.println(file.getPath()); // File 객체 생성 때 입력한 path 그대로 출력
```

<br>

# 📌 데이터 파일로부터 읽어들이기
- Scheme (스키마) : 데이터 파일 구조
- e.g. 1, 홍길동, 20 > 번호, 이름, 나이 > CSV

<br>

### ✅ 스트림 객체를 사용하는 경우
- 스트림은 재사용할 수 없으므로 **파일을 읽을 때마다 스트림 객체를 생성**해주어야 한다.
- 코드 반복이 발생하고, 속도가 매우 느리다. **(CPU, 메모리 <-> HDD)**
```java
// 데이터 파일로부터 읽어들임
BufferedReader reader = new BufferedReader(new FileReader(Data.MEMBER));
			
String line = null;

while((line = reader.readLine()) != null) {
    
    String[] temp = line.split(",");
    System.out.printf("%s. %s(%s세)\n", temp[0], temp[1], temp[2]);
}

// System.out.println(reader.readLine()); // EOF > null (사용 불가)

reader.close();

// 22살 이상 회원만 출력
// 스트림 객체 다시 생성 > 생성 직후 커서는 BOF에 위치
reader = new BufferedReader(new FileReader(Data.MEMBER));

while((line = reader.readLine()) != null) {
    
    String[] temp = line.split(",");
    
    if (Integer.parseInt(temp[2]) >= 22) {
        System.out.printf("%s. %s(%s세)\n", temp[0], temp[1], temp[2]);
    }
    
}
```

<br>

### ✅ 컬렉션을 사용하는 경우
- 파일을 읽을 때마다 스트림 객체를 생성하지 않고, 데이터를 기반으로 객체를 생성해서 컬렉션에 담아두면 **컬렉션의 기능을 사용해 데이터를 편리하게 조작**할 수 있다.
- ArrayList를 사용하면 매우 빠른 시간 안에 데이터에 접근할 수 있다. **(메모리 <-> 메모리)**
- 데이터 파일을 읽어 조작하는 작업이 많은 경우, 컬렉션을 사용하는 것이 훨씬 효율적이다.
```java
BufferedReader reader = new BufferedReader(new FileReader(Data.MEMBER));

String line = null;

while((line = reader.readLine()) != null) {
    
    String[] temp = line.split(",");
    
    String id = temp[0];
    String name = temp[1]; 
    int age = Integer.parseInt(temp[2]);  
    
    User user = new User(id, name, age);
    list.add(user);
}
reader.close();

```



[I/O 스트림 포스팅](https://suaring.tistory.com/82?catㄴegory=911406)