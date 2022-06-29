create database book_store;
use book_store;
create table user_Data(user_id int PRIMARY KEY, name varchar(20), email varchar(100), address varchar(60), date_Created varchar(30), password varchar(20)); 
show tables;
desc user_Data;

drop table user_Data;

create table book_Data(book_id int PRIMARY KEY,book_name varchar(20), book_author varchar(20), book_price varchar(20)); 
select * from user_Data;

create table order_data (order_id integer not null, address varchar(255), cancel bit not null, order_date date, price integer not null, quantity integer not null, book_id integer, user_id integer, primary key (order_id))