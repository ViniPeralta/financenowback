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

create table tb_country (
	id int auto_increment primary key,
	name varchar(100),
	abbreviation varchar(10)
);

create table tb_state (
	id int auto_increment primary key,
	name varchar(100),
	abbreviation varchar(10),
	country_id int,
	foreign key (country_id) references tb_country(id)
);

create table tb_city (
	id int auto_increment primary key,
	name varchar(100),
	abbreviation varchar(10),
	state_id int,
	foreign key (state_id) references tb_state(id)
);