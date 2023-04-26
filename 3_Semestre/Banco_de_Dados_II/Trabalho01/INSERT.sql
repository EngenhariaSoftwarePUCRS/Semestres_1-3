INSERT INTO Carro (Codigo, Placa, Marca, Modelo, Ano, Nome_motorista) VALUES
	(1, 'HUN7182', 'Chevrolet', 'Onix', 2020, 'Benedita Aurora Marli Porto'),
    (2, 'LVK2914', 'Volkswagen', 'Gol', 2018, 'Gustavo Ryan Peixoto'),
    (3, 'HZM8590', 'Toyota', 'Corolla', 2021, 'Rafaela Laura Pereira'),
    (4, 'NEA6661', 'Fiat', 'Palio', 2010, 'Sônia Ana Corte Real');
    
INSERT INTO Passageiro (CPF, Nome, Email, Telefone, Bairro, Meio_Pagamento) VALUES
	('40153021845', 'Julio Caleb Marcelo Corte Real Assis', 'julio_caleb_corterealassis@expressoforte.com.br', '61981253455', 'Ceilândia Norte (Ceilândia)', 'Crédito MasterCard'),
    ('43870718692', 'Marcelo Luiz Vieira', 'marcelo_vieira@studiodeideias.com', '79987733936', 'Cidade Nova', 'Visa 16 Dígitos'),
    ('98944351490', 'Marlene Mirella Assis', 'marlene_assis@contjulioroberto.com.br', '15992325358', 'Jardim Santa Inêz', 'Visa Electron'),
    ('64812811058', 'José Theo Giovanni Aragão', 'jose.theo.aragao@netsite.com.br', '81998804732', 'COHAB', 'Dinheiro'),
    ('38598277312', 'Marcos Kaique Lorenzo Viana', 'marcos-viana88@terra.com.br', '6937921678', NULL, 'Débito Maestro'),
    ('90897008200', 'Sabrina Ayla Nogueira', 'sabrinaaylanogueira@sygma.com.br', '85987842372', 'Presidente Kennedy', NULL);
    
INSERT INTO Viagem (Id, Kms, Valor, Duracao, FK_Carro_Codigo) VALUES
    (1, 10.5, 25.75, 30, 1),
    (2, 15.2, 30.00, 40, 2),
    (3, 5.7, 12.50, 20, 3),
    (4, 20.0, 50.00, 50, 4),
    (5, 8.5, 20.25, 25, 1),
    (6, 12.0, 27.50, 35, 2),
    (7, 3.5, 8.75, 15, 3),
    (8, 18.3, 45.00, 45, 4),
    (9, 9.2, 22.50, 27, 1),
    (10, 14.7, 32.50, 38, 2),
    (11, 6.0, 15.00, 22, 3);
