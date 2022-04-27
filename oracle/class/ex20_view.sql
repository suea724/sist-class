

/*

    [View, 뷰]
    - 데이터베이스 객체 중 하나(DDL(CREATE, ALTER, DROP) 사용 > 테이블, 시퀀스, 제약사항, 뷰)
    - (= 가상 테이블, 복사 테이블, 뷰 테이블 등 ...)
    - 테이블처럼 사용 (***************)
    - 사용 용도 > 쿼리의 양을 줄이는 것이 목표 > 반복된 SELECT 또는 긴 SELECT에 사용
    - 뷰의 정의 : SQL(쿼리문)를 저장한 객체 (***********) (데이터 저장 X)
    
    CREATE (OR REPLACE) VIEW 뷰 이름
    AS
    SELECT 문;
    
*/

-- 뷰 생성
create view vwInsa
as
select * from tblInsa;


-- 뷰 셀렉션 작업
select * from vwInsa;


-- or replace 키워드 추가
create or replace view vwInsa
as
select * from tblInsa where buseo = '영업부';


select * from vwInsa;


-- 비디오 가게 사장의 하루 업무
-- 쿼리 너무 복잡! > 뷰 생성

create or replace view "대여 체크"
as
select
    m.name as mname,
    v.name as vname,
    to_char(r.rentdate, 'yyyy-mm-dd') as rentdate,
    case
        when r.retdate is not null then '완료'
        else '미완료'
    end as state
from tblRent r
    inner join tblVideo v
        on v.seq = r.video
            inner join tblMember m
                on m.seq = r.member;


select * from "대여 체크";
                
                
                
-- tblInsa > 서울 직원 > view
create or replace view vwSeoul
as
select * from tblInsa where city = '서울';


-- 같은 결과
select * from vwSeoul; -- 20명                                   -- 이름이 있는 뷰 > 뷰       
select * from (select * from tblInsa where city = '서울');       -- 이름이 없는 뷰 > 인라인 뷰


update tblInsa set city = '제주' where num in (1001, 1005, 1008);

select * from tblInsa where city = '서울';



-- 권한 > 계정별로 객체에 대한 접근/조작 등을 통제

select * from tblInsa;   -- 신입. tblInsa 접근 권한 X
select * from 신입전용;  -- 신입. view 접근 권한 O

create or replace view 신입전용
as
select num, name, ssn, city from tblInsa;



create or replace view vwTodo
as
select * from tblTodo;


-- 뷰 SQL > SELECT, INSERT, DELETE, UPDATE 모두 사용 가능 > but SELECT만 사용해야함!! (**읽기 전용 테이블**)
-- 나머지 SQL은 테이블을 직접 조작할 때 사용

select * from vwTodo; -- 단순 뷰 > 뷰의 SELECT가 1개의 테이블로 구성
insert into vwTodo values (21, '오라클 정리하기', sysdate, null);
update vwTodo set completedate = sysdate where seq = 21;
delete from vwTodo where seq = 21;

select * from "대여 체크"; -- 복합 뷰 > 2개 이상의 테이블을 SELECT
insert into "대여 체크" values ('홍길동', '영구와 땡칠이', sysdate, '미완료'); -- 오류!


