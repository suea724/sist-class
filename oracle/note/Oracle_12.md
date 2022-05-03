# 📌 관계 대수 연산
- **셀렉션(σ)** : 조건에 맞는 튜플 추출
- **프로젝션(Π)** : 조건에 맞는 컬럼 추출 
- **조인(⋈)** : 두 릴레이션의 카티션 프로덕트 결과의 조건에 맞는 튜플 추출
- **합집합(∪)** : 두 릴레이션의 합집합을 구함
- **교집합(∩)** : 두 릴레이션의 교집합을 구함
- **차집합(-)** : 두 릴레이션의 차집합을 구함

<br>

# 📌 집합 연산
- join은 컬럼 간 연산, 집합 연산은 레코드 간 연산이다.
- 집합 연산을 하기 위해서는 두 릴레이션의 **도메인과 컬럼의 순서(스키마)가 동일**해야 한다.


<br>

### ✅ UNION
- 두 테이블의 모든 레코드를 가져와 유일한 레코드만을 반환한다. (중복 제거)
```sql
select * from tblMan
union
select * from tblWoman;
```
- UNION ALL : 중복값을 포함해서 출력한다.
```sql
select * from tblUnionA
union all
select * from tblUnionB;
```

<br>

### ✅ INTERSECT
- 두 테이블의 공통으로 가지는 레코드를 반환한다.
```sql
select * from tblUnionA
intersect
select * from tblUnionB;
```

<br>

### ✅ MINUS
- 첫번째 테이블에는 속하고 두번째 테이블에는 속하지 않는 레코드를 반환한다.
```sql
select * from tblUnionA
minus
select * from tblUnionB;

select * from tblUnionB
minus
select * from tblUnionA;
```