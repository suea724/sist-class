# 📌 계층형 쿼리, Hierarchical Query
- <b>레코드의 관계가 상하 수직 구조(트리 구조)</b>일 때 저장된 데이터를 계층형 구조로 반환하는 쿼리
- 오라클 전용 쿼리
- e.g. 카테고리, 답변형 게시판, 조직도 등

<br>

### ✅ 문법
#### 👉 START WITH
- 계층 탐색의 시작 지점(루트)을 지정한다.
#### 👉 CONNECT BY
- 부모 행(PRIOR)과 자식 행을 연결한다.
- 탐색의 방향을 지정할 수 있다.
```sql
connect by prior 자식컬럼 = 부모컬럼 -- 부모 → 자식
connect by prior 부모컬럼 = 자식컬럼 -- 자식 → 부모
```
#### 👉 LEVEL
- 트리 구조의 깊이(depth)를 나타내는 의사 컬럼
- 루트 행의 LEVEL = 1
#### 👉 PRIOR
- 자신과 연관된 부모 레코드를 참조하는 의사 컬럼

<br>

### ✅ 예시
- 컴퓨터 부품을 계층 형태로 나타냄 (레벨에 따라 들여쓰기)
```sql
select
    seq as "번호",
    lpad(' ', (level - 1) * 5) || name as "부품명",
    prior name,
    level
from tblComputer
    -- start with seq = 1 -- 결과셋의 최상위 노드 지정
    start with pseq is null
        connect by prior seq = pseq; -- 레코드와 부모를 연결하는 조건(부모 → 자식)

-- 부품명 컬럼
컴퓨터
     본체
          메인보드
          그래픽카드
          랜카드
          CPU
          메모리
     모니터
          보호필름
          모니터암
     프린터
          A4용지
          잉크카트리지
```