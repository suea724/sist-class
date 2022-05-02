# 📌 ROWNUM
- 행번호를 나타내는 의사 컬럼(Pseudo Column)
- **from절이 실행될 때 각 레코드에 rownum을 할당**한다. 
- **where절의 영향을 받아 reindexing**을 한다.
- rownum 사용 시 **서브 쿼리를 자주 사용**한다.

<br>

### ✅ 활용
- rownum을 활용한 결과는 **rownum = 1인 행을 포함**해야 하고, **순차적**으로 가져와야 한다.
```sql
select name, buseo, rownum from tblInsa where rownum = 1;
-- select name, buseo, rownum from tblInsa where rownum = 10; -- 결과X

select name, buseo, rownum from tblInsa where rownum <= 5;
-- select name, buseo, rownum from tblInsa where rownum > 5; -- 결과X
```

<br>

### ✅ 쿼리문 실행 순서
```sql
select rownum, custid, name, phone
from Customer
where rownum <= 2
order by name;
```
1. **from Customer** : 테이블을 읽어들임 (rownum 생성)
2. **where rownum <= 2** : 레코드 두 개 선택 (rownum 조건)
3. **select rownum, custid, name, phone** : 컬럼 선택 (rownum 소비)
4. **order by name** : 이름 순 정렬
- **주의 ❗** : <u>컬럼을 선택 후 정렬</u>한다. > 정렬된 테이블에서 튜플을 가져오는 것이 아님!

<br>

### ✅ 정렬 후 rownum 생성
- rownum을 정렬 후 원하는 행을 가져오기 위해서는 **서브쿼리를 사용**해야 한다.
```sql
-- basicpay를 내림차순으로 정렬한 테이블의 3번째 ~ 5번째 행
select
    name, buseo, basicpay, rnum, rownum
from (select -- rownum을 고정시키기 위해 사용한 서브쿼리
         a.*, rownum as rnum -- rownum의 alias 필요
      from (
         select 
            name, buseo, basicpay
         from tblInsa
         order by basicpay desc
    ) a)
where rnum between 3 and 5;
```

<br>

- 자주 사용하는 쿼리는 **뷰**로 만들어서 활용할 수 있다.
```sql
create or replace view vwAddressBook
as
select a.*, rownum as rnum from (select * from tblAddressBook order by name asc) a;


select * from vwAddressBook 
    where rnum between 31 and 40;
```