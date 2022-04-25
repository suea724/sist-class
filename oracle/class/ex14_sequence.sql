
/*

    [시퀀스, Sequence]
    - 데이터베이스 객체 중 하나 (오라클 전용 객체)
    - 일련 번호를 생성하는 객체 (***********)
    - (주로) 식별자를 만드는데 사용한다. > PK 컬럼에 값을 넣을 때 잘 사용한다.
    
    시퀀스 객체 생성하기 
    - create sequence 시퀀스명;
    
    시퀀스 객체 삭제하기
    - drop sequence 시퀀스명;
    
    시퀀스 객체 사용하기
    - 시퀀스.nextVal (**********)
    - 시퀀스.currVal
    
*/

create sequence seqNum;

select seqNum.currVal from dual;
select seqNum.nextVal from dual;

drop sequence seqNum;



drop table tblMemo;

create table tblMemo(
    
    seq number(3) primary key,      
    name varchar2(30),  
    memo varchar2(1000), 
    regdate date        
    
);

create sequence seqMemo;

insert into tblMemo(seq, name, memo, regdate) values (seqMemo.nextVal, '홍길동', '메모입니다.', sysdate);
insert into tblMemo(seq, name, memo, regdate) values (seqMemo.nextVal, '홍길동홍길동홍길동홍길동홍길동', '메모입니다.', sysdate);

select * from tblMemo;

-- 다양한 형태로 활용
-- 쇼핑몰 > 상품 테이블 > 상품 번호

select 'A' || seqNum.nextVal from dual;
select 'A' || to_char(seqNum.nextVal, '0000') from dual;
select 'A' || ltrim(to_char(seqNum.nextVal, '0000')) from dual;

-- currVal > peek() 역할 > 잘 안쓰임
select seqNum.currVal from dual;

/*

    시퀀스 객체 생성하기 > 옵션까지 사용하는 일은 별로 없음
    
    create sequence 시퀀스명;
    
    create sequence 시퀀스명
                    increment by n  -- 증감치 (양수/음수)
                    start with n    -- 시작값(seed)
                    maxvalue n      -- 최댓값
                    minvalue n      -- 최솟값
                    cycle
                    cache n;

*/

drop sequence seqTest;

create sequence seqTest 
                increment by 1
                start with 10
                maxvalue 30
                cycle
                cache 20; 

select seqTest.nextVal from dual;



