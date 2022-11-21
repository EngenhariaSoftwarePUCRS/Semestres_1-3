create table cidades (
	cod_cidade numeric(5) NOT NULL,
    nome varchar(80) NOT NULL, 
    uf char (2) NOT NULL,
    primary key (cod_cidade),
    foreign key (uf) references estados (uf)
);
describe cidades;