# ๐ ์ต๋ช ๊ฐ์ฒด, Anonymous Object
- ์ด๋ฆ ์๋ ํด๋์ค(๊ฐ์ฒด)
- ๋ฐ๋์ **์ธํฐํ์ด์ค๊ฐ ํ์**ํจ (์๋ฐ ํน์ฑ)
- ์์ ์ ๋ฉค๋ฒ๋ฅผ ๋ง๋ค์ง ์๊ณ , **์ธํฐํ์ด์ค์ ์ถ์ ๋ฉ์๋๋ง์ ์ฌ์ ์ํ์ฌ ์ฌ์ฉ**
```java
AAA a = new AAA() { // 2. ์ต๋ช ๊ฐ์ฒด ์์ฑ
    @Override
    public void aaa() {
        System.out.println("์ต๋ช ํด๋์ค์ ์ถ์ ๋ฉ์๋ ๊ตฌํ");
    }
}
a.aaa(); // 3. ์ต๋ช ๊ฐ์ฒด ์ฌ์ฉ

interface AAA { // 1. ์ธํฐํ์ด์ค ์ ์ธ
    void aaa();
}
```

<br>

### โ ์ฌ์ฉ ์ด์ 
- ๋ชจ๋  ์ฝ๋๋ฅผ ํตํ์ด **๋จ 1๊ฐ์ ๊ฐ์ฒด**๊ฐ ํ์ํ ๊ฒฝ์ฐ์ ์ฌ์ฉํจ
- ๊ฐ์ฒด N๊ฐ๋ฅผ ์์ฑํด์ผ ํ  ๋ ํด๋์ค๋ฅผ ์ ์ธํ๋ ๊ฒ์ด ์ข์

<br>

# ๐ Sort
- ๋ฐฐ์ด ๋๋ ArrayList ์ ๋ ฌ ์ **JDK์์ ์ ๊ณตํ๋ ๊ธฐ๋ฅ**์ ์ด์ฉํด ์ ๋ ฌํ  ์ ์๋ค.
- **Comparator ๊ตฌํ ๊ฐ์ฒด**๋ฅผ ์ฌ์ฉํด compare ๋ฉ์๋๋ฅผ ์ฌ์ ์ํ์ฌ ์ ๋ ฌ ๊ธฐ์ค์ ์ค์ ํ  ์ ์๋ค.

<br>

### โ Integer ๋ฐฐ์ด ์ค๋ฆ์ฐจ์ ์ ๋ ฌ
- sort() ํจ์๋ฅผ ์ฌ์ฉํ๋ฉด ๊ธฐ๋ณธ์ ์ผ๋ก ์ค๋ฆ์ฐจ์์ผ๋ก ์ ๋ ฌ๋๋ค.
```java
Integer[] arr = {1,5,3,6,7,10,2};
Arrays.sort(arr);
```

<br>

### โ Integer ๋ฐฐ์ด ๋ด๋ฆผ์ฐจ์ ์ ๋ ฌ
- ๋ด๋ฆผ์ฐจ์์ผ๋ก ์ ๋ ฌํ๊ธฐ ์ํด์๋ sort ํจ์์ ๋๋ฒ์งธ ๋งค๊ฐ๋ณ์์ **Comparator๋ฅผ ๊ตฌํํ ๊ฐ์ฒด**๋ฅผ ๋ฃ์ด์ฃผ์ด์ผ ํ๋ค.
- Comparator ๊ตฌํ ๊ฐ์ฒด๋ ์ฌ์ฌ์ฉํ์ง ์๊ธฐ ๋๋ฌธ์ **์ต๋ช ๊ฐ์ฒด**๋ฅผ ๋ง๋๋ ๊ฒ์ด ์ข๋ค.
```java
Arrays.sort(arr, new Comparator<Integer>() {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1; 
        // return o1 - o2 > ์ค๋ฆ์ฐจ์
    }
});
```

<br>

### โ String ๋ฐฐ์ด ์ ๋ ฌ
```java
String[] names = {"๊ฐ๊ฐ๊ฐ", "์๋ฌด๊ฐ", "ํํํ", "๋ค๋ค๋ค", "๋๋๋"};

// ์ค๋ฆ์ฐจ์
Arrays.sort(names);

// ๋ด๋ฆผ์ฐจ์
Arrays.sort(names, new Comparator<String>() {

    @Override
    public int compare(String o1, String o2) { 
        return o2.compareTo(o1);
    }
    
});
```

<br>

### โ Calendar ๋ฐฐ์ด ์ ๋ ฌ
```java
Calendar[] dates = new Calendar[5];

for(int i = 0 ; i < dates.length ; i ++) {
    dates[i] = Calendar.getInstance();
}

dates[0].add(Calendar.DATE, 7);
dates[1].add(Calendar.DATE, 2);
dates[2].add(Calendar.DATE, 1);
dates[3].add(Calendar.DATE, 5);
dates[4].add(Calendar.DATE, 4);

Arrays.sort(dates); // ์ค๋ฆ์ฐจ์ ์ ๋ ฌ
Arrays.sort(dates, new Comparator<Calendar>() { // ๋ด๋ฆผ์ฐจ์ ์ ๋ ฌ

    @Override
    public int compare(Calendar o1, Calendar o2) {
        
        // o2๊ฐ ๋ ๋ฆ์ผ๋ฉด ์์ ๋ฐํ
        return o2.compareTo(o1);
    }
    
});
```

<br>

### โ ArrayList ์ ๋ ฌ
```java
ArrayList<Integer> nums = new ArrayList<>();
		
nums.add(1);
nums.add(6);
nums.add(4);
nums.add(9);
nums.add(2);

// Collections ํด๋์ค ๋ฉ์๋ ์ฌ์ฉ
Collection.sort(nums); // ์ค๋ฆ์ฐจ์ ์ ๋ ฌ
Collections.sort(nums, new Comparator<Integer>() { // ๋ด๋ฆผ์ฐจ์ ์ ๋ ฌ

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
    
});

// ArrayList์ ๋ฉ์๋ ์ฌ์ฉ > ์ค๋ฆ์ฐจ์ ๋๋ ๋ด๋ฆผ์ฐจ์ ์ ๋ ฌ ๋ชจ๋ Comparator ๊ฐ์ฒด ํ์
nums.sort(new Comparator<Integer>() {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
    
});
```