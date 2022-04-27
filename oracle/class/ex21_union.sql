
/*

    [관계 대수 연산]
    1. 셀렉션 > select where
    2. 프로젝션 > select column
    3. 조인 > a join b
    4. 합집합, 차집합, 교집합
    
    [UNION]
    - 합집합
    
    [INTERSECT]
    - 교집합
    
    [MINUS]
    - 차집합

*/

-- join : 컬럼 + 컬럼
-- union : 레코드 + 레코드

-- 겹치는 컬럼 통합
select * from tblMan
union
select * from tblWoman;



-- union 전제조건 > 스키마가 동일해야 한다.
select * from tblCountry
union
select * from tblInsa; -- 오류



-- 개수와 자료형이 같은 컬럼을 가져오면 union 연산 적용 가능 > but 의미 없는 데이터
select name, capital, population from tblCountry
union
select name, buseo, basicpay from tblInsa;



-- union : 수학의 집합 개념 > 중복값 허용 X
select * from tblUnionA
union
select * from tblUnionB;



-- union all : 중복값 포함해서 출력
select * from tblUnionA
union all
select * from tblUnionB;



-- intersect > 교집합
select * from tblUnionA
intersect
select * from tblUnionB;



-- minus > 차집합
select * from tblUnionA
minus
select * from tblUnionB;

select * from tblUnionB
minus
select * from tblUnionA;
