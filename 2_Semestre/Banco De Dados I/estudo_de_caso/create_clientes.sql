create table clientes (
	cod_cliente 	numeric(5) 		not null,
    nome 			varchar(100)	not null,
    data_cadastro 	date			not null,
    tipo 			char(1) 		not null,
    primary key (cod_cliente)
);
desc clientes;