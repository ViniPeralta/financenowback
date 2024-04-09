create table tb_address (
	id int auto_increment primary key,
	address varchar(150) not null,
	number varchar(10) not null,
	zip_code varchar(8) not null,
	city_id int not null,
	foreign key (city_id) references tb_city(id)
);
