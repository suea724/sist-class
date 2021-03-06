# ๐ HashMap

###  โ ArrayList vs HashMap
#### ๐ป ArrayList
- ์์ ์ ๊ทผ ์ **index** ์ฌ์ฉ
- **์์๊ฐ ์๋ ๋ฐ์ดํฐ ์งํฉ** > index == ์์์ ์์ โญ
- ์ค์นผ๋ผ ๋ฐฐ์ด(Scalar Array)
- ์๋ณ์๊ฐ index์ด๊ธฐ ๋๋ฌธ์, ์์๋ผ๋ฆฌ ๊ตฌ๋ถ ์ ๋ถํธํ๋ค.
- for๋ฌธ ์ฌ์ฉํด์ ์์ ์ผ๊ด ์ ๊ทผ์ด ๊ฐ๋ฅํ๋ค.

<br>

#### ๐ป HashMap
- **ํค(key)์ ๊ฐ(value)๋ฅผ ํ์์ผ๋ก ๊ฐ์ง๋ ๋ฐ์ดํฐ ๊ตฌ์กฐ**์ด๋ค. โญ
- **key๋ ์ ์ผ**ํด์ผ ํ๊ณ , **๊ฐ์ ์ค๋ณต์ด ํ์ฉ**๋๋ค.
- ์์ ์ ๊ทผ ์ **key** ์ฌ์ฉ
- ์์๊ฐ ์๋ ๋ฐ์ดํฐ ์งํฉ > index X
- ์๋ณ์ ์์ฒด๊ฐ ์๋ฏธ์๋ ๋จ์ด์ด๋ฏ๋ก, ์์๋ผ๋ฆฌ ๊ตฌ๋ถํ๊ธฐ ์ฉ์ดํ๋ค.

<br>

### โ ์ฌ์ฉ๋ฒ
- **์์ ์ถ๊ฐ** : `V put(K key, V value)`
- **์์ ๊ฐ์** : `int size()`
- **์์ ์ฝ๊ธฐ** : `V get(K key)`
    - ์ด๋ key์ value๊ฐ ์์ผ๋ฉด null์ ๋ฐํํ๋ค. (์๋ฌ X)
- **์์ ์์ ** : `V put(K key, V value)`
    - key๊ฐ ์ ์ผํ๊ธฐ ๋๋ฌธ์ ์์ ์ถ๊ฐ์ ๊ฐ์ ๋ฉ์๋๋ฅผ ์ฌ์ฉํ๋ค.
- **์์ ๊ฒ์** : `boolean containsKey(K key)`, `boolean containsValue(V value)`
- **์์ ์ญ์ ** : `V remove(K key)`
- **์ด๊ธฐํ** : `void clear()`

<br>

# ๐ TreeMap
- ์ด์ง ํธ๋ฆฌ ๊ตฌ์กฐ์ Map
- ์๋ ์ ๋ ฌ + ๋ฒ์ ๊ฒ์ (์ถ์ถ) ์ฉ์ด
```java
TreeMap<String, String> map = new TreeMap<>();
		
map.put("white", "ํ์");
map.put("black", "๊ฒ์ ");
map.put("yellow", "๋ธ๋");
map.put("red", "๋นจ๊ฐ");
map.put("green", "์ด๋ก");

// TreeMap ๊ณ ์  ๋ฉ์๋
System.out.println(map.firstKey());
System.out.println(map.firstEntry()); // ์ฒซ key=value ํ์

System.out.println(map.lastKey());
System.out.println(map.lastEntry()); // ๋ง์ง๋ง key=value ํ์

System.out.println(map.headMap("m")); // m ์ดํ(ํฌํจ) entry ๊ฐ์ ธ์ด
System.out.println(map.tailMap("m")); // m ์ด์ (๋ฏธํฌํจ) entry ๊ฐ์ ธ์ด
System.out.println(map.subMap("r", "y")); // r(ํฌํจ)๊ณผ y(๋ฏธํฌํจ) ์ฌ์ด entry ๊ฐ์ ธ์ด
```