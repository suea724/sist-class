
/*
    
    [인덱스, Index]
    - 검색을 빠른 속도로 하기 위해 사용하는 도구
    - SQL 처리 속도를 빠르게 하기 위해 특정 컬럼에 대해 생성되는 검색 도구
    - b-tree 구조 사용
    
    [데이터베이스]
    - 테이블 내의 레코드 순서는 우리가 원하는 정렬 상태가 아니다.
    - 데이터 검색 시, 처음부터 끝까지 차례대로 검색(table full scan)
    - 특정 컬럼 검색 > 별도의 테이블에 복사 > 미리 정렬 > 인덱스
    - 원본 테이블 <- 참조 -> 인덱스
    
    [인덱스 장단점]
    - 처리 속도를 향상 시킨다.
    - 너무 잦은 인덱스 사용은 전체적인 DB의 성능을 저하시킨다.
    
    
    [자동으로 인덱스가 걸리는 컬럼]
    1. Primary key
    2. Unique
    - ** 일반 테이블에서 PK 컬럼을 검색하는 속도 >> 일반 테이블에서 PK가 아닌 컬럼을 검색하는 속도
    
    [인덱스를 사용해야 하는 경우]
    1. 테이블에 데이터(행)가 너무 많을 때
    2. where절에 사용되는 횟수가 많은 컬럼에 적용(*******)
    3. join에 조건으로 사용되는 횟수가 많은 컬럼에 적용(*******)
    4. 인덱스의 손익분기점 > 검색 결과가 10~15% 이하인 경우
    5. null을 포함하는 경우 > null은 인덱스에서 제외
    
    [인덱스를 사용하지 말아야 하는 경우]
    1. 테이블에 데이터(행)가 적은 경우 > 의미없음
    2. 인덱스의 손익분기점 > 검색 결과가 15% 이상인 경우
    3. 해당 테이블에 삽입, 수정, 삭제가 빈번한 경우(*************************)
    
*/

create table tblIndex
as
select * from tblInsa;

select count(*) from tblIndex;

-- 데이터 복사해서 넣기 > 3,866,624건
insert into tblIndex select * from tblIndex;

-- 쿼리 수행 시간 확인
set timing on;

-- 인덱스없이 검색 > 경과 시간: 00:00:01.205
select distinct name from tblIndex where name = '홍길동';

-- 인덱스 생성
create index idxName on tblIndex(name);

-- 인덱스 검색 > 경과 시간: 00:00:00.019
select distinct name from tblIndex where name = '홍길동';


/*
    인덱스 종류
    1. 고유 인덱스
        - 중복 인덱스 불가
        - e.g. PK, UNIQUE
        
    2. 비고유 인덱스
        - 중복 인덱스 가능
        - 일반 컬럼
        
    3. 단일 인덱스
        - 컬럼 1개를 대상
        
    4. 복합 인덱스
        - 컬럼 N개를 대상
    
    5. 함수 기반 인덱스
*/

-- 고유 인덱스
create unique index idxName on tblIndex(name);  -- 동명이인 없을 때


-- 비고유 인덱스
create index idxBuseo on tblIndex(buseo);   -- 일반 컬럼


-- 단일 인덱스
create index idxBuseo on tblIndex(buseo);

select count(*) from tblIndex where buseo =  '기획부'; -- 인덱스 효과 O

select count(*) from tblIndex where buseo =  '기획부' and name = '홍길동'; -- 인덱스 효과 X


-- 복합(결합) 인덱스
create index idxBuseoName on tblIndex(buseo, name);

select count(*) from tblIndex where buseo =  '기획부' and name = '홍길동'; -- 인덱스 효과 O


-- 함수 기반 인덱스

create index idxSsn on tblIndex(ssn);
create index idxSsn2 on tblIndex(substr(ssn, 8, 1));

select count(*) from tblIndex where substr(ssn, 8, 1) = '1';


