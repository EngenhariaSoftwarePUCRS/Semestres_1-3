INSERT INTO Carro (Codigo, Placa, Marca, Modelo, Ano, Nome_motorista) VALUES
	(1, 'HUN7182', 'Chevrolet', 'Onix', 2020, 'Benedita Aurora Marli Porto'),
    (2, 'LVK2914', 'Volkswagen', 'Gol', 2018, 'Gustavo Ryan Peixoto'),
    (3, 'HZM8590', 'Toyota', 'Corolla', 2021, 'Rafaela Laura Pereira'),
    (4, 'NEA6661', 'Fiat', 'Palio', 2010, 'Sônia Ana Corte Real');
    
INSERT INTO Passageiro (CPF, Nome, Email, Telefone, Bairro, Cidade, Estado, Meio_Pagamento) VALUES
	('10531043088', 'Alexandre Rafael Julio Silveira Gonçalves', 'alexandrerafaelsilveira@gmail.com', '54981380067', 'Cerâmica', 'Erechim', 'Rio Grande do Sul', 'Crédito MasterCard'),
    ('29438733060', 'Theo Danilo Brito', 'theo_danilo_brito@jh2consulting.com', '55988063073', 'Nossa Senhora de Fátima', 'Santa Maria', 'Rio Grande do Sul', 'Visa 16 Dígitos'),
    ('98822414098', 'Raul Tiago Manuel da Silva', 'raul_dasilva@terra.com.br', '51991926194', 'São Vicente', 'Gravataí', 'Rio Grande do Sul', 'Visa Electron'),
    ('59362314029', 'Agatha Maitê Aline Gonçalves', 'agatha.maite.goncalves@uol.com.br', '51997736328', 'Passo da Areia', 'Porto Alegre', 'Rio Grande do Sul', 'Dinheiro'),
    ('78428732086', 'Rita Clarice Stella Melo', 'rita_clarice_melo@coldblock.com.br', '51991576603', NULL, NULL, NULL, 'Débito Maestro'),
    ('42738597009', 'Liz Débora Fernandes', 'lizdeborafernandes@vhbadvogados.com.br', '55999817972', 'Floresta', 'Porto Alegre', 'Rio Grande do Sul', NULL);
    
INSERT INTO Viagem (Id, Kms, Valor, Duracao, FK_Carro_Codigo) VALUES
    (1, 369, 922.5, 300, 2),
    (2, 369, 922.5, 305, 3),
    (3, 369, 922.5, 300, 1),
    (4, 359, 897.5, 300, 3),
    (5, 29, 72.5, 27, 3),
    (6, 377, 942.5, 310, 3),
    (7, 358, 895, 296, 1),
    (8, 358, 895, 296, 2),
    (9, 378, 945, 309, 3),
    (10, 6.3, 15.75, 10, 4),
    (11, 4.5, 11.25, 7, 4);
    
INSERT INTO Usa (FK_Passageiro_CPF, FK_Viagem_Id) VALUES
	('59362314029', 1),
    ('10531043088', 2),
    ('59362314029', 3),
    ('10531043088', 4),
    ('42738597009', 5),
    ('98822414098', 6),
	('29438733060', 7),
    ('29438733060', 8),
    ('78428732086', 9),
    ('59362314029', 10),
    ('42738597009', 11);
    
INSERT INTO Urbana (Bairro_Partida, Bairro_Destino, FK_Viagem_Id) VALUES
    ('Partenon', 'Floresta', 9),
	('Floresta', 'Passo da Areaia', 11);
    
INSERT INTO Interurbana (Taxa_Adicional, Cidade_Partida, Cidade_Destino, FK_Viagem_Id) VALUES
	(23.06, 'Porto Alegre', 'Erechim', 1),
	(23.06, 'Erechim', 'Porto Alegre', 2),
	(23.06, 'Porto Alegre', 'Erechim', 3),
    (22.44, 'Erechim', 'Santa Maria', 4),
	(23.06, 'Porto Alegre', 'Gravataí', 5),
	(23.56, 'Gravataí', 'Erechim', 6),
	(22.4, 'Santa Maria', 'Erechim', 7),
	(22.4, 'Erechim', 'Gravataí', 8),
	(23.06, 'Porto Alegre', 'Erechim', 10);