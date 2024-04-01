create database financenow;

use financenow;

create table tb_users (
	id int auto_increment primary key,
	username varchar(50),
    email varchar(50),
    password varchar(50)
);
    
create table tb_extract (
	id int auto_increment primary key,
    user_id int,
    transfer_type varchar(50),
    transfer_value double,
    essential boolean,
    category varchar(50),
    transfer_description varchar(50),
    transfer_date datetime,
    foreign key (user_id) references tb_users(id)
);