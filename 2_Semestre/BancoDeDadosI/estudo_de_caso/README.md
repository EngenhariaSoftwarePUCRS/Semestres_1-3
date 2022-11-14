Uma empresa de tecnologia está desenvolvendo uma aplicação que controla a venda de livros. Após uma fase inicial de levantamento de requisitos (Fase de Engenharia de Requisitos), constatou-se o seguite:

1. Deseja-se armazenar os dados dos clientes, incluindo seus nomes e a data em que foram cadastrados, além de, opcionalmente, seu endereço completo.
    1. Sabe-se que pessoas jurídicas (empresas) possuem um CNPJ que as identifica, além de uma razão social, que é o seu nome oficial.
    2. Já as pessoas físicas possuem um CPF que as identifica, além de uma data de aniversário e vários números de telefone.
2. Os produtos possuem um código único, um nome, uma data de lançamento, um preço e um prazo de entrega em dias.
    1. Os produtos podem ser importados os nacionais.
    2. Cada produto é classificado em uma categoria. As categorias possuem um nome e podem ser detalhadas em sub-categorias.
3. Os clientes fazem pedidos, que recebem um número único e têm sua data registrada.
    1. Cada pedido pode incluir um ou mais itens.
    2. Cada item de um pedido é uma certa quantidade de um determinado produto, sendo indicado o valor unitário pago.
4. A empresa agenda as entregas dos pedidos.
    1. Uma entrega pode reunir diversos itens de pedidos diferentes. Ou seja, os itens de um pedido podem ser separados em múltiplas entregas.
    2. Cada entrega tem um número único, uma data, sendo feita por um veículo cuja placa é registrada.
    3. Também é registrado o nome e o número da CNH do motorista que fará a entrega.