
/*

    [ALTER]
    - 테이블의 정의(스키마) 수정 시 사용하는 명령어
    - 되도록 테이블을 수정하는 상황을 발생시키면 안된다. > 설계 시 주의!!
    
    
    [테이블 수정 방법]
    
    1. 테이블 삭제 후 다시 생성 (DROP 후 CREATE)
        a. 기존 테이블에 데이터 X > 문제 없음
        b. 기존 테이블에 데이터 O > 미리 데이터 백업 후, 테이블 수정 후 데이터 복구
            - 서비스 운영 시 불가능한 방법
            
    2. 기존 테이블의 구조 변경 (ALTER 명령어 사용)
        a. 기존 테이블에 데이터 X > 문제 없음
        b. 기존 테이블에 데이터 O > 경우에 따라 다름
            - 서비스 운영시에도 사용 가능함

*/

drop table tblEdit;

create table tblEdit (
    seq number primary key,
    data varchar2(20) not null
);

insert into tblEdit values (1, '마우스');
insert into tblEdit values (2, '키보드');
insert into tblEdit values (3, '모니터');

select * from tblEdit;


-- Case 1. 새로운 컬럼 추가하기
alter table tblEdit 
    add (price number null);
    
-- NOT NULL 제약을 추가는 테이블이 비어있을 때 가능함 > 데이터 DELETE 후 ALTER 하는 것이 베스트
-- ORA-01758: table must be empty to add mandatory (NOT NULL) column
alter table tblEdit
    add (memo varchar2(100) not null);
    

-- Case 2. 컬럼 삭제하기
alter table tblEdit
    drop column memo2;
    
alter table tblEdit
    drop column memo;

alter table tblEdit
    drop column seq; -- PK 컬럼 삭제 > 절대 금지
    

-- Case 3. 컬럼 수정하기
insert into tblEdit values (4, '인텔 i7 12세대 최신형 노트북');


-- 1) 컬럼 길이 수정
alter table tblEdit
    modify (data varchar2(100));

-- 저장되어 있는 데이터보다 짧은 길이로 수정 불가
-- 01441. 00000 -  "cannot decrease column length because some value is too big"
alter table tblEdit
    modify (data varchar2(20));
    
select * from tblEdit;


-- 2) 컬럼의 제약사항 수정하기
alter table tblEdit
    modify (data varchar2(100) null);
    
alter table tblEdit
    modify (data varchar2(100) not null);


-- 3) 컬럼의 자료형 수정하기 > 테이블을 비워야 함
alter table tblEdit
    modify (seq varchar2(100));
    
    
-- 4) 컬럼명 수정하기
alter table tblEdit
    rename column data to etc;
    

-- 제약 사항 수정하기

drop table tblEdit;

create table tblEdit (
    seq number,
    data varchar2(20) not null,
    color varchar2(30) null
);

-- 제약 사항 따로 추가
alter table tblEdit
    add constraint tbledit_seq_pk primary key(seq);
    
alter table tblEdit
    add constraint tbledit_color_ck
        check (color in('red', 'yellow', 'blue'));
        
-- 제약 사항 삭제
alter table tblEdit
    drop constraint tbledit_color_ck;

insert into tblEdit values (1, '마우스', 'red');
insert into tblEdit values (2, '키보드');
insert into tblEdit values (3, '모니터');

