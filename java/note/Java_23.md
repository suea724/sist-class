# ๐ ์๋ฐ์์ ํ์ผ ๋ฐ ๋๋ ํ ๋ฆฌ ์กฐ์
- ์๋์ฐ ํ์๊ธฐ๋ก ํ๋ ํ๋์ ์๋ฐ๋ก ๊ตฌํํ  ์ ์๋ค.
- **ํ์ผ, ํด๋**์ ๋ํด **์ ๋ณด ํ์ธ, ์๋ก ๋ง๋ค๊ธฐ, ์ด๋ฆ ๋ฐ๊พธ๊ธฐ, ์ด๋, ๋ณต์ฌ**, ...

<br>

### โ File ๊ฐ์ฒด
```java
final String PATH = "D:\\class\\java\\file\\data.txt";
File file = new File(PATH);
```
- ์๋ฐ์์ **์ธ๋ถ์ ์๋ ํ์ผ์ ์ ๊ทผ**ํ๊ธฐ ์ํด ์ฌ์ฉํ๋ **์ฐธ์กฐ ๊ฐ์ฒด**์ด๋ค.
- ์์ฑ์ ๋งค๊ฐ๋ณ์๋ก **ํ์ผ ๋๋ ํด๋์ ๊ฒฝ๋ก**๋ฅผ ์๋ ฅํ๋ค.

<br>

### โ ๋ฉ์๋
- **ํ์ผ ์ ๋ณด ๊ด๋ จ ๋ฉ์๋**
```java
System.out.println(file.exist()); // ํ์ผ ์กด์ฌ ์ฌ๋ถ
System.out.println(file.getName()); // ํ์ผ ์ด๋ฆ
System.out.println(file.isFile()); // ํ์ผ ์ฌ๋ถ
System.out.println(file.isDirectory()); // ํด๋ ์ฌ๋ถ
System.out.println(file.length()); // ํ์ผ ํฌ๊ธฐ > byte
System.out.println(file.getAbsolutePath()); // ์ ๋ ๊ฒฝ๋ก
System.out.println(file.getPath()); // ๊ฐ์ฒด ์์ฑ ์ ์๋ ฅํ ๊ฒฝ๋ก ์ถ๋ ฅ
System.out.println(file.lastModified()); // ์ต๊ทผ ์์  ์๊ฐ > tick๊ฐ(ms)
System.out.println(file.isHidden()); // ์จ๊น ํ์ผ ์ฌ๋ถ
```

<br>

- **ํ์ผ ์์ฑ**
```java
System.out.println(file.createNewFile());
```
ํ์ผ ์์ฑ ์ฌ๋ถ๋ฅผ ๋ฐํํ๋ค. ๋์ผํ ๊ฒฝ๋ก์ ๊ฐ์ ์ด๋ฆ์ ํ์ผ์ด ์์ผ๋ฉด `false` ๋ฐํ

<br>

- **ํ์ผ๋ช ๋ฐ๊พธ๊ธฐ**
```java
File file = new File("D:\\class\\java\\file\\hello.txt"); // ์๋ณธ ํ์ผ ๊ฐ์ฒด
File file2 = new File("D:\\class\\java\\file\\hi.txt"); // ์์ ํ  ํ์ผ ๊ฐ์ฒด

System.out.println(file.renameTo(file2));
```
๊ฐ์ ๊ฒฝ๋ก์ ์์ ํ  ํ์ผ ์ด๋ฆ์ผ๋ก ํ์ผ ๊ฐ์ฒด๋ฅผ ์์ฑํ ํ, `renameTo()`๋ก ํ์ผ ๊ฐ์ฒด๋ฅผ ์์ ํ๋ค.

<br>

- **ํ์ผ ์ด๋**
```java
File file = new File("D:\\class\\java\\file\\hello.txt");
File file2 = new File("D:\\class\\java\\move\\hello.txt");

System.out.println(file.renameTo(file2));
```
์ด๋ํ  ํ์ผ ๊ฒฝ๋ก๋ก ํ์ผ ๊ฐ์ฒด๋ฅผ ์์ฑํ๊ณ , ํ์ผ๋ช ๋ฐ๊พธ๊ธฐ์ ๋์ผํ๊ฒ `renameTo()`๋ก ํ์ผ ๊ฐ์ฒด๋ฅผ ์์ ํ๋ค.

<br>

- **ํ์ผ ์ญ์ **
```java
System.out.println(file.delete());
```
์ญ์  ์ฑ๊ณต ์ฌ๋ถ๋ฅผ ๋ฐํํ๋ค. ์ญ์ ํ  ํ์ผ์ด ์กด์ฌํ์ง ์์ผ๋ฉด `false`๋ฅผ ๋ฐํํ๋ค.

<br>

- **ํด๋ ์์ฑ**
```java
File dir = new File("D:\\class\\java\\file\\bbb");

System.out.println(dir.mkdir());
// System.out.println(dir.mkdirs());
```
ํด๋๋ฅผ ์์ฑํ  ๊ฒฝ๋ก๋ก ํ์ผ ๊ฐ์ฒด๋ฅผ ๋ง๋ค๊ณ , `dir.mkdir()`๋ก ํด๋๋ฅผ ์์ฑํ๋ค. ํด๋์ ์์ฑ ์ฌ๋ถ๋ฅผ ๋ฐํํ๋ค. ์ฌ๋ฌ ํด๋๋ฅผ ์์ฑํ  ๋๋ `dir.mkdirs()`๋ฅผ ์ฌ์ฉํ๋ค.

<br>

- **ํด๋๋ช ๋ฐ๊พธ๊ธฐ ๋ฐ ํด๋ ์ด๋**
```java
File dir = new File("D:\\class\\java\\file\\todo");
File dir2 = new File("D:\\class\\java\\file\\TODO");
// File dir2 = new File("D:\\class\\java\\move\\todo");

dir.renameTo(dir2);
```

ํ์ผ๊ณผ ๋์ผํ๊ฒ `renameTo()`๋ฅผ ์ฌ์ฉํ๋ค.

<br>

- **ํด๋ ์ญ์ **
```java
System.out.println(dir.delete());
```
๋น ํด๋๋ง ์ญ์ ํ  ์ ์๋ค. ํด๋๋ฅผ ์ญ์ ํ๊ธฐ ์ํด์๋ ํด๋ ๋ด์ ํ์ผ์ ๋จผ์  ์ญ์ ํด์ผ ํ๋ค.