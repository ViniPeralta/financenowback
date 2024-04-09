create table tb_country (
	id int auto_increment primary key,
	name varchar(100) not null,
	abbreviation varchar(10) not null
);

insert into tb_country (name, abbreviation) values ('Brazil', 'BR');