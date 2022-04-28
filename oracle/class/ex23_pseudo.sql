
/*

    [의사 컬럼, Pseudo Column]
    - 실제 컬럼은 아니지만 컬럼처럼 동작하는 객체
    
    [rownum] ***
    - 행번호
    - 데이터
    - from절이 실행될 때 각 레코드에 rownum을 할당한다. (************************)
    - where절의 영향을 받아 reindexing을 한다. (************************)
    - rownum 사용 시 서브 쿼리를 자주 사용한다. (************************)
    
*/

select
    name, buseo,    -- 컬럼(속성) > 객체의 특성에 따라 다른 값을 가짐 (output만 존재)
    rownum,         -- 의사 컬럼  > 컬럼의 모습이나 특성과 가장 유사함 
    substr(name, 2) -- 함수       > 객체의 특성에 따라 다른 값을 가짐 (input, output 존재)
    sysdate,        -- 함수       > 모든 레코드가 동일한 값을 가짐 (output만 존재) 
    '상수'          -- 상수       > 모든 레코드가 동일한 값을 가짐
from tblInsa;


-- rownum 활용
select name, buseo, rownum from tblInsa where rownum = 1;
select name, buseo, rownum from tblInsa where rownum <= 5;

-- 게시판 > 페이지
-- 1 페이지 > rownum between 1 and 20
-- 2 페이지 > rownum between 21 and 40
-- 3 페이지 > rownum between 41 and 60

-- rownum을 활용한 결과는 rownum = 1인 행을 포함해야 하고 순차적으로 가져와야 함.
select name, buseo, rownum from tblInsa where rownum = 10;
select name, buseo, rownum from tblInsa where rownum > 5; 



select
    name, buseo, rownum     -- 2. 1에서 이미 할당된 숫자를 rownum을 통해 가져온다.(소비)
from tblInsa;               -- 1. from절이 실행되는 순간 모든 레코드의 rownum이 할당된다. (생성)


select 
    name, buseo, rownum     -- 3. 소비
from tblInsa                -- 1. 생성
where rownum = 3;           -- 2. 조건 > 1에서 생성된 


-- rownum 생성 후 정렬
select
    name, buseo, basicpay, rownum   -- 2.
from tblInsa                        -- 1.
order by basicpay desc;             -- 3.


-- 정렬 후 rownum 생성
select
    name, buseo, basicpay, rownum -- B절의 행번호
from ( -- B절
    select 
        name, buseo, basicpay, rownum as rnum
    from tblInsa -- A절
    order by basicpay desc
);



select
    name, buseo, basicpay, rnum, rownum
from (select -- rownum을 고정시키기 위해 사용한 서브쿼리
         name, buseo, basicpay, rownum as rnum
      from (
         select 
            name, buseo, basicpay
         from tblInsa
         order by basicpay desc
    ))
where rnum between 3 and 5;



-- 고객 명단 > 페이지 단위로 출력 > 10명씩

-- 1. 원하는 정렬
select * from tblAddressBook order by name asc;

-- 2. 1을 뷰로 생성 + rnum 생성
-- 와일드 카드 + 일반 컬럼 사용하기 위해서는 테이블이름.* 사용
select a.*, rownum as rnum from (select * from tblAddressBook order by name asc) a;

-- 3. 2를 뷰로 생성 + rnum 사용
select * from (select a.*, rownum as rnum from (select * from tblAddressBook order by name asc) a);

select * from (select a.*, rownum as rnum from (select * from tblAddressBook order by name asc) a)
    where rnum between 1 and 10;
    
select * from (select a.*, rownum as rnum from (select * from tblAddressBook order by name asc) a)
    where rnum between 11 and 20;
    
select * from (select a.*, rownum as rnum from (select * from tblAddressBook order by name asc) a)
    where rnum between 21 and 30;

    
-- 서브 쿼리를 뷰로 만듦
create or replace view vwAddressBook
as
select a.*, rownum as rnum from (select * from tblAddressBook order by name asc) a;


select * from vwAddressBook 
    where rnum between 31 and 40;
    
    