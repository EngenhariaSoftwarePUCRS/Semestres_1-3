create table categorias (
	cod_categoria		numeric(2)	not null
    ,nome				varchar(50)	not null
    ,cod_categoria_pai	numeric(2)
    ,primary key (cod_categoria)
    ,foreign key (cod_categoria_pai) references categorias (cod_categoria)
);
desc categorias;