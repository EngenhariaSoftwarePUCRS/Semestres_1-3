create table entregas (
	num_entrega	numeric(10)		not null,
    data		date			not null,
	placa		char(8)			not null,
    mot_cnh		numeric(11)		not null,
    mot_nome	varchar(100)	not null,
    primary key (num_entrega)
);
desc entregas;