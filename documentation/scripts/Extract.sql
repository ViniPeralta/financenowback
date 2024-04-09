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