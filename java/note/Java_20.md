# 📌 Abstract Data Type, 추상 자료형
- 기능의 **구현 부분은 은닉**하고, **핵심적인 기능의 사용법**만 제공(캡슐화)
- Stack, Queue, ...

# 📌 Stack
- **LIFO**
- e.g. 되돌리기(ctrl + z), 다시하기(ctrl + y), 웹 뒤로가기, ...

### ✅ 사용법
- `T push(T value)` : 요소 추가
- `int size` : 요소 개수
- `T pop()` : top 위치의 요소 꺼내서 조회 (remove O)
- `boolean isEmpty()` : 비어있는지 확인
- `T peek()` : top 위치의 요소 조회 (remove X)

<br>

# 📌 Queue
- **FIFO**
- e.g. 줄서기
### ✅ 사용법
- `boolean add(T value)` : 요소 추가 (enqueue)
- `int size` : 요소 개수
- `T poll()` : 0번째 위치 요소 꺼내서 조회 (dequeue)
- `boolean isEmpty()` : 비어있는지 확인
- `T peek()` : 0번째 위치의 요소 조회
- `void clear()` : 초기화