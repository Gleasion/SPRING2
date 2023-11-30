create table board(
    board_no number(8) not null,
    title varchar2(200) not null,
    content varchar2(2000) null,
    writer varchar2(50) not null,
    reg_date date default sysdate null,
    constraint pk_board primary key(board_no)
);

create sequence seq_board increment by 1 start with 1 nocache;

create table member(
    user_no number(8) not null,
    user_id varchar2(50) not null,
    user_pw varchar2(100) not null,
    user_name varchar2(100) not null,
    coin number(8) default 0 null,
    reg_date date default sysdate null,
    upd_date date default sysdate null,
    enabled varchar2(10) default '1' null,
    constraint pk_member primary key(user_no)
);

create sequence seq_member increment by 1 start with 1 nocache;

create table member_auth(
    user_no number(8) not null,
    auth varchar2(50) not null,
    constraint fk_member_auth_user_no foreign key(user_no) references member(user_no)
);

select
    m.user_no, user_id, user_pw, user_name, reg_date, upd_date, auth
from member m left outer join member_auth ma on(m.user_no = ma.user_no)
where m.user_no = 1;


------------------------------------------------------------------------------------------------------------------------------------------

create table dditboard(
    bo_no number(8) not null,
    bo_title varchar2(300) not null,
    bo_content varchar2(4000) not null,
    b_writer varchar2(300) not null,
    bo_date date not null,
    bo_hit number(8) not null,
    constraint pk_dditboard primary key(bo_no)
);

create sequence seq_dditboard increment by 1 start with 1 nocache;
    
create table dditmember(
    mem_no number(8) not null,
    mem_id varchar2(100) not null,
    mem_pw varchar2(100) not null,
    mem_name varchar2(100) not null,
    mem_gender varchar2(30) not null,
    mem_email varchar2(150) not null,
    mem_phone varchar2(150) not null,
    mem_postcode varchar2(30) not null,
    mem_address1 varchar2(300) not null,
    mem_address2 varchar2(300) not null,
    mem_agree varchar2(30) not null,
    mem_profileimg varchar2(500) null,
    mem_regdate date not null,
    enabled varchar2(20),
    constraint pk_dditmember primary key(mem_no)
);

create sequence seq_dditmember increment by 1 start with 1 nocache;

create table dditmember_auth(
    mem_no number(8) not null,
    auth varchar2(50) not null,
    constraint fk_ddimember_auth_mem_no foreign key(mem_no)
        references dditmember(mem_no)
);

----------------------------------------------------------------------------------------------------------------------------


create table notice(
    bo_no number(8) not null,
    bo_title varchar2(300) not null,
    bo_content varchar2(4000) not null,
     bo_writer varchar2(150) not null,
    bo_date date not null,
    bo_hit number(8) default 0 null,
    constraint pk_notice primary key (bo_no)
);

create sequence seq_notice increment by 1 start with 1 nocache;

insert into notice values(seq_notice.nextval, '力格1', '郴侩1', 'a0001', sysdate, 0);
insert into notice values(seq_notice.nextval, '力格2', '郴侩1', 'a0001', sysdate, 0);
insert into notice values(seq_notice.nextval, '力格3', '郴侩1', 'a0001', sysdate, 0);
insert into notice values(seq_notice.nextval, '力格4', '郴侩1', 'a0001', sysdate, 0);
insert into notice values(seq_notice.nextval, '力格5', '郴侩1', 'a0001', sysdate, 0);
insert into notice values(seq_notice.nextval, '力格6', '郴侩1', 'a0001', sysdate, 0);
insert into notice values(seq_notice.nextval, '力格7', '郴侩1', 'a0001', sysdate, 0);
insert into notice values(seq_notice.nextval, '力格8', '郴侩1', 'a0001', sysdate, 0);
insert into notice values(seq_notice.nextval, '力格9', '郴侩1', 'a0001', sysdate, 0);
insert into notice values(seq_notice.nextval, '力格10', '郴侩1', 'a0001', sysdate, 0);
insert into notice values(seq_notice.nextval, '力格11', '郴侩1', 'a0001', sysdate, 0);
insert into notice values(seq_notice.nextval, '力格12', '郴侩1', 'a0001', sysdate, 0);
insert into notice values(seq_notice.nextval, '力格13', '郴侩1', 'a0001', sysdate, 0);
insert into notice values(seq_notice.nextval, '力格14', '郴侩1', 'a0001', sysdate, 0);
insert into notice values(seq_notice.nextval, '力格15', '郴侩1', 'a0001', sysdate, 0);
insert into notice values(seq_notice.nextval, '力格16', '郴侩1', 'a0001', sysdate, 0);
insert into notice values(seq_notice.nextval, '力格17', '郴侩1', 'a0001', sysdate, 0);
insert into notice values(seq_notice.nextval, '力格18', '郴侩1', 'a0001', sysdate, 0);
insert into notice values(seq_notice.nextval, '力格19', '郴侩1', 'a0001', sysdate, 0);
insert into notice values(seq_notice.nextval, '力格20', '郴侩1', 'a0001', sysdate, 0);
insert into notice values(seq_notice.nextval, '力格21', '郴侩1', 'a0001', sysdate, 0);
insert into notice values(seq_notice.nextval, '力格22', '郴侩1', 'a0001', sysdate, 0);
insert into notice values(seq_notice.nextval, '力格23', '郴侩1', 'a0001', sysdate, 0);

commit;


---------------------------------------------------------------------------------------------------------------------------

create table noticefile(
    file_no number(8) not null,
    bo_no number(8) not null,
    file_name varchar2(300) not null,
    fil_size number(20) not null,
    file_fancysize varchar2(100) not null,
    fil_mime varchar2(100) not null,
    file_savepath varchar2(500) not null,
    file_downcount number(8) not null,
    constraint pk_noticefile primary key(file_no),
    constraint fk_noticefile_bo_no foreign key(bo_no) references notice(bo_no)
);

create sequence seq_noticefile increment by 1 start with 1 nocache;

---------------------------------------------------------------------------------------------------------------------------

create table ddittag(
   bo_no number(8) not null,
   tag varchar2(300) not null,
   constraint fk_dditboard_bo_no foreign key(bo_no) references dditboard(bo_no)
);


----------------------------------------------------------------------------------------------------------------------------------

create table users(
    username varchar2(50) not null,
    password varchar2(50) not null,
    enabled char(1) default '1' null,
    constraint pk_users primary key(username)
);

create table authorities(
    username varchar2(50) not null,
    authority varchar2(50) not null,
    constraint fk_authorities_users_username foreign key(username)
        references users(username)
);

Insert into users values('user01', '1234', '1');
Insert into users values('member01', '1234', '1');
Insert into users values('admin01', '1234', '1');

Insert into authorities values('user01', 'ROLE_USER');
Insert into authorities values('member01', 'ROLE_MEMBER');
Insert into authorities values('admin01', 'ROLE_MEMBER');
Insert into authorities values('admin01', 'ROLE_ADMIN');

commit;

--------------------------------------------------------------------------------------------------------------------------------------------------------

create table persistent_logins(
    username varchar2(64) not null,
    series varchar2(64) not null,
    token varchar2(64) not null,
    last_used date not null,
    constraint pk_persistent_logins primary key(series)
);

commit;

--------------------------------------------------------------------------------------------------------------------------------------------------------
