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
	name varchar(100) not null,
	abbreviation varchar(10) not null
);

insert into tb_country (name, abbreviation) values ('Brazil', 'BR');

create table tb_state (
	id int auto_increment primary key,
	name varchar(100) not null,
	abbreviation varchar(10) not null,
	country_id int not null,
	foreign key (country_id) references tb_country(id)
);

insert into tb_state (name, abbreviation, country_id) values ('Sao Paulo', 'SP', 1);

create table tb_city (
	id int auto_increment primary key,
	name varchar(100) not null,
	abbreviation varchar(10) not null,
	state_id int not null,
	foreign key (state_id) references tb_state(id)
);

insert into tb_city (name, abbreviation, state_id) values
('Sao Paulo', 'SP', 1),
('Guarulhos', 'GRU', 1),
('Campinas', 'CAM', 1),
('Sao Bernardo do Campo', 'SBC', 1),
('Santo Andre', 'SA', 1),
('Osasco', 'OS', 1),
('Ribeirao Preto', 'RP', 1),
('Sao Jose dos Campos', 'SJC', 1),
('Sao Jose do Rio Preto', 'SJRP', 1);