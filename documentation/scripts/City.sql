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
