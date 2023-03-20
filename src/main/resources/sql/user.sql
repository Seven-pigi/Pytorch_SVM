//创建数据库
create database chenLiHeadLines;


use chenLiHeadLines;

create table user(
    id int primary key auto_increment,
    username varchar(32) unique not null,
    password varchar(32) not null
);


//想创建好的数据库中添加数据
insert into user values(1,"wcy","123456");

//查看自己添加的数据
select * from user;