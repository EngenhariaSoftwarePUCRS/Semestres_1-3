create table pessoas_fisicas (
	cod_cliente			numeric(5)	not null
    ,cpf				char(11)	not null
    ,genero				char(1)		not null
    ,data_nascimento	date		not null
    ,cod_empresa		numeric(5)
    ,foreign key (cod_cliente)	references	clientes (cod_cliente)
);
desc pessoas_fisicas;