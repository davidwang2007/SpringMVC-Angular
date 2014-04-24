#root login
create database david_cb default character set utf8 collate utf8_general_ci;
create user 'david_db_user'@'%' identified by 'sale_db_user_pass';
grant all privileges on david_cb.* to 'sale_db_user'@'%' with grant option;

create table user(
	id integer primary key auto_increment comment '',
	username varchar(50) not null,
	realname varchar(50) default '',
	password varchar(100) not null,
	age tinyint default 18,
	gender varchar(5) default '',
	email varchar(50) default '',
	phone varchar(30) default '',
	address varchar(200) default '',
	create_date datetime,
	update_date datetime,
	description varchar(200) default ''
)ENGINE = InnoDB comment='用户表';