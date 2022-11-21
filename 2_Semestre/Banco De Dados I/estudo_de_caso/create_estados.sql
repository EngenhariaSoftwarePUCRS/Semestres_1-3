create table estados (
	uf char(2) not null,
    nome varchar(50) not null,
    regiao char(2) not null,
    primary key(uf)
);
desc estados;