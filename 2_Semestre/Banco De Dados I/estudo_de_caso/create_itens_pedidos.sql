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