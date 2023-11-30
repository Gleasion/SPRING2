-- 2023.09.16(��) ���� 
-- ȸ�� �� �Խ���, ���� ���̺�

-- ȸ�� ���̺� �ۼ� ����
create table member(
    mem_no number(8) not null,
    mem_id varchar2(150) not null,
    mem_pw varchar2(150) not null,
    mem_name varchar2(150) not null,
    mem_nickname varchar2(300) not null,
    mem_regdate date not null,
    constraint pk_member primary key(mem_no)
);

-- ȸ�� sequence �ۼ� ����
create sequence seq_member increment by 1 start with 1 nocache;

-- �Խ��� ���̺� �ۼ� ����
create table board(
    bo_no number(8) not null,
    bo_title varchar2(300) not null,
    bo_content varchar2(4000) not null,
    bo_writer varchar2(150) not null,
    bo_date date not null,
    bo_hit number(8) default 0 null,
    constraint pk_board primary key(bo_no)
);

-- �Խ��� sequence �ۼ� ����
create sequence seq_board increment by 1 start with 1 nocache;

-- �Խ��� ���� ���̺� �ۼ� ����
create table boardfile(
    file_no number(8) not null,
    bo_no number(8) not null,
    file_name varchar2(300) not null,
    file_size number(20) not null,
    file_fancysize varchar2(100) not null,
    file_mime varchar2(100) not null,
    file_savepath varchar2(400) not null,
    file_downcount number(8) not null,
    constraint pk_boardfile primary key(file_no),
    constraint fk_noticefile_bo_no foreign key(bo_no) references board(bo_no)
);

create sequence seq_boardfile increment by 1 start with 1 nocache;