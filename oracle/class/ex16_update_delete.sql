

/*
    
    [UPDATE]
    - DML
    - 원하는 행의 원하는 컬럼 값을 수정하는 명령어
    
    UPDATE 테이블명 SET 컬럼명 = 값 [,컬럼명 = 값] [WHERE절]
    
    [DELETE]
    - DML
    - 원하는 행을 삭제하는 명령어
    
    DELETE [FROM] 테이블명 [WHERE절]
*/

commit;
rollback;

select * from tblCountry;

-- 대한민국 : 서울 > 세종
update tblCountry set capital = '세종' where name = '대한민국';

-- 전체 레코드 업데이트
-- 전세계 인구수 증가 > 10% 증가
update tblCountry set population = population * 1.1;

-- 여러 속성 변경
update tblCountry set capital = '부산', continent = 'EU', area = 30 where name = '대한민국';



-- basicpay 180~200만원인 사람 제거
delete from tblInsa where basicpay between 1800000 and 2000000;

select * from tblInsa;

-- 속성 하나만 삭제하고 싶은 경우 > update사용
update tblInsa set tel = null where num = 1001;
