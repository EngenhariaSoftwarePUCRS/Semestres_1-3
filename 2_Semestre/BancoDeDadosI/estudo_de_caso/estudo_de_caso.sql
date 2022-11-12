create schema estudo_de_caso;
use estudo_de_caso;

create table estados (
	uf char(2) not null,
    nome varchar(50) not null,
    regiao char(2) not null,
    primary key(uf)
);
desc estados;

create table cidades (
	cod_cidade numeric(5) NOT NULL,
    nome varchar(80) NOT NULL, 
    uf char (2) NOT NULL,
    primary key (cod_cidade),
    foreign key (uf) references estados (uf)
);
describe cidades;

create table enderecos (
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

create table clientes (
	cod_cliente 	numeric(5) 		not null,
    nome 			varchar(100)	not null,
    data_cadastro 	date			not null,
    tipo 			char(1) 		not null,
    primary key (cod_cliente)
);
desc clientes;

create table pessoas_juridicas (
	cod_cliente numeric (5) NOT NULL
    ,razao_social varchar (100) NOT NULL
    ,cnpj char (13) NOT NULL
    ,foreign key (cod_cliente) references clientes (cod_cliente)
);
describe pessoas_juridicas;

create table pessoas_fisicas (
	cod_cliente			numeric(5)	not null
    ,cpf				char(11)	not null
    ,genero				char(1)		not null
    ,data_nascimento	date		not null
    ,cod_empresa		numeric(5)
    ,foreign key (cod_cliente)	references	clientes (cod_cliente)
);
desc pessoas_fisicas;

create table telefones (
	id_telefone		char(10)	not null
    ,ddd			numeric(2)	not null
    ,numero			numeric(9)	not null
    ,cod_cliente	numeric(5)	not null
    ,primary key (id_telefone)
    ,foreign key (cod_cliente)	references clientes (cod_cliente)
);
desc telefones;

create table pedidos(
	num_pedido numeric (10) NOT NULL,
    data_emissao date NOT NULL,
    cod_cliente numeric (5) NOT NULL,
    primary key (num_pedido),
    foreign key (cod_cliente) references clientes (cod_cliente)
);
describe pedidos;

create table entregas (
	num_entrega	numeric(10)		not null,
    data		date			not null,
	placa		char(8)			not null,
    mot_cnh		numeric(11)		not null,
    mot_nome	varchar(100)	not null,
    primary key (num_entrega)
);
desc entregas;

create table categorias (
	cod_categoria		numeric(2)	not null
    ,nome				varchar(50)	not null
    ,cod_categoria_pai	numeric(2)
    ,primary key (cod_categoria)
    ,foreign key (cod_categoria_pai) references categorias (cod_categoria)
);
desc categorias;

create table produtos (
	cod_produto numeric (3) NOT NULL
    ,nome varchar (50) NOT  NULL
    ,data_lancamento date NOT NULL 
    ,importado char(1) NOT NULL
    ,preco numeric (8,2) NOT NULL
    ,prazo_entrega numeric (3) NOT NULL
    ,cod_categoria numeric (2) NOT NULL
    ,primary key (cod_produto)
    ,foreign key (cod_categoria) references categorias (cod_categoria)
);
describe produtos;

create table itens_pedidos (
	num_pedido		numeric(10)	not null,
    cod_produto		numeric(3)	not null,
    quantidade		numeric(4),
    valor_unitario	numeric(8,2),
	num_entrega		numeric(10),
    foreign key	(num_pedido)	references	pedidos (num_pedido),
	foreign key	(cod_produto)	references	produtos (cod_produto),
    foreign key	(num_entrega)	references	entregas (num_entrega)
);
desc itens_pedidos;