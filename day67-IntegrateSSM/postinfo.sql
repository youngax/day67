create table invitation(
	id int primary key auto_increment,
	title varchar(20) not null,
	summary varchar(50),
	author varchar(20),
	createdate date not null
)

create table reply_detail(
	id int primary key auto_increment,
	invid int not null,
	content varchar(50) not null,
	author varchar(20) default "匿名用户",
	createdate date not null
)

delete from reply_detail where invid = 5