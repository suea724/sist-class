# 📌 익명 객체, Anonymous Object
- 이름 없는 클래스(객체)
- 반드시 **인터페이스가 필요**함 (자바 특성)
- 자신의 멤버를 만들지 않고, **인터페이스의 추상 메서드만을 재정의하여 사용**
```java
AAA a = new AAA() { // 2. 익명 객체 생성
    @Override
    public void aaa() {
        System.out.println("익명 클래스의 추상 메서드 구현");
    }
}
a.aaa(); // 3. 익명 객체 사용

interface AAA { // 1. 인터페이스 선언
    void aaa();
}
```

<br>

### ✅ 사용 이유
- 모든 코드를 통틀어 **단 1개의 객체**가 필요한 경우에 사용함
- 객체 N개를 생성해야 할 때 클래스를 선언하는 것이 좋음

<br>

# 📌 Sort
- 배열 또는 ArrayList 정렬 시 **JDK에서 제공하는 기능**을 이용해 정렬할 수 있다.
- **Comparator 구현 객체**를 사용해 compare 메서드를 재정의하여 정렬 기준을 설정할 수 있다.

<br>

### ✅ Integer 배열 오름차순 정렬
- sort() 함수를 사용하면 기본적으로 오름차순으로 정렬된다.
```java
Integer[] arr = {1,5,3,6,7,10,2};
Arrays.sort(arr);
```

<br>

### ✅ Integer 배열 내림차순 정렬
- 내림차순으로 정렬하기 위해서는 sort 함수의 두번째 매개변수에 **Comparator를 구현한 객체**를 넣어주어야 한다.
- Comparator 구현 객체는 재사용하지 않기 때문에 **익명 객체**를 만드는 것이 좋다.
```java
Arrays.sort(arr, new Comparator<Integer>() {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1; 
        // return o1 - o2 > 오름차순
    }
});
```

<br>

### ✅ String 배열 정렬
```java
String[] names = {"가가가", "아무개", "하하하", "다다다", "나나나"};

// 오름차순
Arrays.sort(names);

// 내림차순
Arrays.sort(names, new Comparator<String>() {

    @Override
    public int compare(String o1, String o2) { 
        return o2.compareTo(o1);
    }
    
});
```

<br>

### ✅ Calendar 배열 정렬
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

Arrays.sort(dates); // 오름차순 정렬
Arrays.sort(dates, new Comparator<Calendar>() { // 내림차순 정렬

    @Override
    public int compare(Calendar o1, Calendar o2) {
        
        // o2가 더 늦으면 양수 반환
        return o2.compareTo(o1);
    }
    
});
```

<br>

### ✅ ArrayList 정렬
```java
ArrayList<Integer> nums = new ArrayList<>();
		
nums.add(1);
nums.add(6);
nums.add(4);
nums.add(9);
nums.add(2);

// Collections 클래스 메서드 사용
Collection.sort(nums); // 오름차순 정렬
Collections.sort(nums, new Comparator<Integer>() { // 내림차순 정렬

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
    
});

// ArrayList의 메서드 사용 > 오름차순 또는 내림차순 정렬 모두 Comparator 객체 필요
nums.sort(new Comparator<Integer>() {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
    
});
```