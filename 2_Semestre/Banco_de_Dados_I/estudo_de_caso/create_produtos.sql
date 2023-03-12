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