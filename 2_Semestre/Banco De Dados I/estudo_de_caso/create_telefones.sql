create table telefones (
	id_telefone		char(10)	not null
    ,ddd			numeric(2)	not null
    ,numero			numeric(9)	not null
    ,cod_cliente	numeric(5)	not null
    ,primary key (id_telefone)
    ,foreign key (cod_cliente)	references clientes (cod_cliente)
);
desc telefones;