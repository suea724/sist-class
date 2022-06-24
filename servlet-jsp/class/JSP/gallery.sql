create table tblGallery (
    seq number primary key,              -- 번호
    filename varchar2(100) not null,      -- 이미지 파일명(하드 디스크에 저장된 이름)
    subject varchar2(100) not null,        -- 제목
    regdate date default sysdate          -- 작성 시각
);

create sequence seqGallery;

select * from tblGallery;