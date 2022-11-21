create table enderecos(
	cod_cliente numeric(5) NOT NULL,
    cod_endereco numeric(2) NOT NULL,
    rua varchar (80) NOT NULL,
    numero numeric (6) NOT NULL,
    complemento varchar (20),
    cep numeric (8) NOT NULL,
    cod_cidade numeric (5) NOT NULL,
    foreign key (cod_cidade) references cidades (cod_cidade)
);
describe enderecos;