-- Criação de tabelas

create table clientes (
 cod_cliente numeric(5) not null,
 nome varchar(100) not null,
 data_cadastro date not null,
 tipo char(1) not null,
 constraint pk_clientes primary key (cod_cliente),
 constraint chk_cli_tipo check (tipo in ('F','J'))
);

create index idx_cli_nome on clientes (nome);


create table pessoas_juridicas (
 cod_cliente numeric(5) not null,
 cnpj char(18) not null,
 razao_social varchar(100) not null,
 constraint pk_pessoas_juridicas primary key (cod_cliente)
);

create unique index ak_pj_cnpj on pessoas_juridicas (cnpj);


create table pessoas_fisicas (
 cod_cliente numeric(5) not null,
 cpf char(11) not null,
 data_nascimento date not null,
 genero char(1) not null,
 cod_empresa numeric(5),
 constraint pk_pessoas_fisicas primary key (cod_cliente),
 constraint chk_pf_genero check (genero in ('F','M'))
);

create unique index ak_pf_cpf on pessoas_fisicas (cpf);
create index ifk_pf_pj on pessoas_fisicas (cod_empresa);


create table estados (
 uf char(2) not null,
 nome varchar(50) not null,
 regiao char(2) not null,
 constraint pk_estados primary key (uf),
 constraint chk_est_regiao check (regiao in ('S','SE','CO','NE','N'))
);


create table cidades (
 cod_cidade numeric(5) not null,
 nome varchar(80) not null,
 uf char(2) not null,
 constraint pk_cidades primary key (cod_cidade)
);

create index ifk_cid_est on cidades (uf);


create table enderecos (
 cod_cliente numeric(5) not null,
 cod_endereco numeric(2) not null,
 rua varchar(80) not null,
 numero numeric(6) not null,
 complemento varchar(20),
 cep numeric(8) not null,
 cod_cidade numeric(5) not null,
 constraint pk_enderecos primary key (cod_cliente,cod_endereco)
);

create index ifk_end_cid on enderecos (cod_cidade);


create table telefones (
 id_telefone char(10) not null,
 ddd numeric(2) not null,
 numero numeric(9) not null,
 cod_cliente numeric(5) not null,
 constraint pk_telefones primary key (id_telefone)
);

create index ifk_tel_pf on telefones (cod_cliente);


create table pedidos (
 num_pedido numeric(10) not null,
 data_emissao date not null,
 cod_cliente numeric(5) not null,
 constraint pk_pedidos primary key (num_pedido)
);

create index ifk_ped_cli on pedidos (cod_cliente);


create table categorias (
 cod_categoria numeric(2) not null,
 nome varchar(50) not null,
 cod_categoria_pai numeric(2),
 constraint pk_categorias primary key (cod_categoria)
);

create index idx_cat_nome on categorias (nome);
create index ifk_cat_cat on categorias (cod_categoria_pai);


create table produtos (
 cod_produto numeric(3) not null,
 nome varchar(100) not null,
 data_lancamento date not null,
 importado char(1) not null,
 preco numeric(8,2) not null,
 prazo_entrega numeric(3) not null,
 cod_categoria numeric(2) not null,
 constraint pk_produtos primary key (cod_produto),
 constraint chk_prod_importado check (importado in ('S','N'))
);

create index idx_prod_nome on produtos (nome);
create index ifk_prod_cat on produtos (cod_categoria);


create table entregas (
 num_entrega numeric(10) not null,
 data date not null,
 placa char(8) not null,
 mot_cnh numeric(11) not null,
 mot_nome varchar(100) not null,
 constraint pk_entregas primary key (num_entrega)
);

create index idx_entr_placa on entregas (placa);
create index idx_entr_motnome on entregas (mot_nome);


create table itens_pedidos (
 num_pedido numeric(10) not null,
 cod_produto numeric(3) not null,
 quantidade numeric(4),
 valor_unitario numeric(8,2),
 num_entrega numeric(10),
 constraint pk_itens_pedidos primary key (num_pedido,cod_produto)
);

create index ifk_itped_prod on itens_pedidos (cod_produto);
create index ifk_itped_entr on itens_pedidos (num_entrega);


-- chaves estrangeiras

alter table pessoas_juridicas add constraint fk_pj_cli foreign key (cod_cliente) references clientes (cod_cliente);

alter table pessoas_fisicas add constraint fk_pf_cli foreign key (cod_cliente) references clientes (cod_cliente);
alter table pessoas_fisicas add constraint fk_pf_pj foreign key (cod_empresa) references pessoas_juridicas (cod_cliente);

alter table cidades add constraint fk_cid_est foreign key (uf) references estados (uf);

alter table enderecos add constraint fk_end_cli foreign key (cod_cliente) references clientes (cod_cliente);
alter table enderecos add constraint fk_end_cid foreign key (cod_cidade) references cidades (cod_cidade);

alter table telefones add constraint fk_tel_pf foreign key (cod_cliente) references pessoas_fisicas (cod_cliente);

alter table pedidos add constraint fk_ped_cli foreign key (cod_cliente) references clientes (cod_cliente);

alter table categorias add constraint fk_cat_cat foreign key (cod_categoria_pai) references categorias (cod_categoria);

alter table produtos add constraint fk_prod_cat foreign key (cod_categoria) references categorias (cod_categoria);

alter table itens_pedidos add constraint fk_itped_ped foreign key (num_pedido) references pedidos (num_pedido);
alter table itens_pedidos add constraint fk_itped_prod foreign key (cod_produto) references produtos (cod_produto);
alter table itens_pedidos add constraint fk_itped_entr foreign key (num_entrega) references entregas (num_entrega);
