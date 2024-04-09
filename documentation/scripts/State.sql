create table tb_state (
	id int auto_increment primary key,
	name varchar(100) not null,
	abbreviation varchar(10) not null,
	country_id int not null,
	foreign key (country_id) references tb_country(id)
);

insert into tb_state (name, abbreviation, country_id) values ('Sao Paulo', 'SP', 1);