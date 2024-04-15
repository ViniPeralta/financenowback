create table tb_company (
	id int auto_increment primary key,
	name varchar(150) not null,
	email varchar(150) null,
	phone varchar(9) null,
	user_id int not null,
	address_id int not null,
	image blob null,
	sale_percentage int not null,
	work_percentage int not null,
	status varchar(1) not null,
	foreign key (user_id) references tb_users(id),
	foreign key (address_id) references tb_address(id)
);
