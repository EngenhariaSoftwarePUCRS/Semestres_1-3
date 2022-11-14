create table pessoas_juridicas(
	cod_cliente numeric (5) NOT NULL
    ,razao_social varchar (100) NOT NULL
    ,cnpj char (13) NOT NULL
    ,foreign key (cod_cliente) references clientes (cod_cliente)
);
describe pessoas_juridicas;