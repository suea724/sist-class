# 📌 자바에서 파일 및 디렉토리 조작
- 윈도우 탐색기로 하는 행동을 자바로 구현할 수 있다.
- **파일, 폴더**에 대해 **정보 확인, 새로 만들기, 이름 바꾸기, 이동, 복사**, ...

<br>

### ✅ File 객체
```java
final String PATH = "D:\\class\\java\\file\\data.txt";
File file = new File(PATH);
```
- 자바에서 **외부에 있는 파일에 접근**하기 위해 사용하는 **참조 객체**이다.
- 생성시 매개변수로 **파일 또는 폴더의 경로**를 입력한다.

<br>

### ✅ 메서드
- **파일 정보 관련 메서드**
```java
System.out.println(file.exist()); // 파일 존재 여부
System.out.println(file.getName()); // 파일 이름
System.out.println(file.isFile()); // 파일 여부
System.out.println(file.isDirectory()); // 폴더 여부
System.out.println(file.length()); // 파일 크기 > byte
System.out.println(file.getAbsolutePath()); // 절대 경로
System.out.println(file.getPath()); // 객체 생성 시 입력한 경로 출력
System.out.println(file.lastModified()); // 최근 수정 시각 > tick값(ms)
System.out.println(file.isHidden()); // 숨김 파일 여부
```

<br>

- **파일 생성**
```java
System.out.println(file.createNewFile());
```
파일 생성 여부를 반환한다. 동일한 경로에 같은 이름의 파일이 있으면 `false` 반환

<br>

- **파일명 바꾸기**
```java
File file = new File("D:\\class\\java\\file\\hello.txt"); // 원본 파일 객체
File file2 = new File("D:\\class\\java\\file\\hi.txt"); // 수정할 파일 객체

System.out.println(file.renameTo(file2));
```
같은 경로에 수정할 파일 이름으로 파일 객체를 생성한 후, `renameTo()`로 파일 객체를 수정한다.

<br>

- **파일 이동**
```java
File file = new File("D:\\class\\java\\file\\hello.txt");
File file2 = new File("D:\\class\\java\\move\\hello.txt");

System.out.println(file.renameTo(file2));
```
이동할 파일 경로로 파일 객체를 생성하고, 파일명 바꾸기와 동일하게 `renameTo()`로 파일 객체를 수정한다.

<br>

- **파일 삭제**
```java
System.out.println(file.delete());
```
삭제 성공 여부를 반환한다. 삭제할 파일이 존재하지 않으면 `false`를 반환한다.

<br>

- **폴더 생성**
```java
File dir = new File("D:\\class\\java\\file\\bbb");

System.out.println(dir.mkdir());
// System.out.println(dir.mkdirs());
```
폴더를 생성할 경로로 파일 객체를 만들고, `dir.mkdir()`로 폴더를 생성한다. 폴더의 생성 여부를 반환한다. 여러 폴더를 생성할 때는 `dir.mkdirs()`를 사용한다.

<br>

- **폴더명 바꾸기 및 폴더 이동**
```java
File dir = new File("D:\\class\\java\\file\\todo");
File dir2 = new File("D:\\class\\java\\file\\TODO");
// File dir2 = new File("D:\\class\\java\\move\\todo");

dir.renameTo(dir2);
```

파일과 동일하게 `renameTo()`를 사용한다.

<br>

- **폴더 삭제**
```java
System.out.println(dir.delete());
```
빈 폴더만 삭제할 수 있다. 폴더를 삭제하기 위해서는 폴더 내의 파일을 먼저 삭제해야 한다.