
/*

    [트랜잭션, Transaction]
    - 데이터를 조작하는 업무의 물리적(시간적) 단위
    - 1개 이상의 명령어(행동,SQL)로 구성된 작업 단위(기간)
    - 1개 이상의 명령어를 하나의 목적(논리 집합)으로 묶어놓은 단위
    
    
    [트랜잭션 명령어, DCL(TCL)]
    1. COMMIT : 현재 트랜잭션에서 했던 모든 행동을 데이터베이스에 반영
    2. ROLLBACK : 현재 트랜잭션에서 했던 모든 행동을 데이터베이스에 반영X, 취소 (트랜잭션 시작으로 돌아감)
    3. SAVEPOINT : 중간 저장, rollback시 savepoint로 돌아감
    
    - 한 트랜잭션이 너무 길거나 짧게 관리하지 않는 것이 좋음 > 길면 롤백 시 작업 내용 날아감
    
*/

create table tblTrans 
as
select name, buseo, jikwi from tblInsa where city = '서울';


select * from tblTrans;


-- 로그인(접속) > 트랜잭션 시작

-- INSERT, UPDATE, DELETE 명령어는 실행 즉시 데이터베이스에 반영되지 않음 > 임시적으로 적용
-- commit 명령어로 데이터베이스에 영구 적용할 수 있음!

delete from tblTrans where name = '박문수';
select * from tblTrans;

rollback; -- 롤백

select * from tblTrans;

delete from tblTrans where name = '박문수';
select * from tblTrans;

commit; -- 커밋

delete from tblTrans where name = '김인수';
select * from tblTrans;

update tblCountry set capital = '세종';

rollback;

select * from tblCountry;

update tblCountry set capital = '세종' where name = '대한민국';

commit;


/*

    [트랜잭션이 언제 시작? 언제 끝?]
    
    - 새로운 트랜잭션이 시작하는 경우
        1. 클라이언트가 접속한 직후
        2. commit 실행 직후
        3. rollback 실행 직후
        
    - 현재 트랜잭션이 종료되는 경우
        1. commit 실행 > 현재 트랜잭션을 DB에 반영
        2. rollback 실행 > 현재 트랜잭션을 DB에 반영하지 않음
        3. 클라이언트가 접속을 종료할 때
            a. 정상 종료
                - 현재 트랜잭션에 아직 반영되지 않는 명령어가 남아있으면 사용자에게 질문
            b. 비정상 종료
                - 무조건 rollback
        4. DDL(CREATE, ALTER. DROP) 실행 시
            - 실행 즉시 commit 동반 > Auto Commit
            - DDL 성격 > 구조 변경 > 데이터 영향 O > 사전에 미리 저장(Commit)
            
    
    <참고> 클라이언트 도구
    - Auto Commit 옵션 설정 가능(사용자 선택)
    
*/


select * from tblTrans;

commit; -- 지금부터 새로운 트랜잭션 시작의 의미

delete from tblTrans where buseo = '영업부';

select * from tblTrans;

-- DDL 사용 > Auto Commit 발생
create table tblTest (
    seq number primary key
);

rollback;

select * from tblTrans;

commit;

select * from tblTrans;

insert into tblTrans values ('가가가', '영업부', '부장');
insert into tblTrans values ('나나나', '영업부', '과장');

select * from tblTrans;

savepoint a;

delete from tblTrans where name = '김말숙';

select * from tblTrans;

savepoint b;

delete from tblTrans where buseo = '개발부';

select * from tblTrans;

rollback to b; -- savepoint b로 돌아감

select * from tblTrans;

