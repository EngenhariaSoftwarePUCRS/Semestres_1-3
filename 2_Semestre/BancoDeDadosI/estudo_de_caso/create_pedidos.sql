create table pedidos(
	num_pedido numeric (10) NOT NULL,
    data_emissao date NOT NULL,
    cod_cliente numeric (5) NOT NULL,
    foreign key (cod_cliente) references clientes (cod_cliente)    
);
describe pedidos;