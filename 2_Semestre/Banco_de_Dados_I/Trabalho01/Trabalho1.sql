CREATE TABLE Autor (
 nome VARCHAR(10) NOT NULL,
 cnpj NUMERIC(10) NOT NULL,
 endereco VARCHAR(10) NOT NULL,
 endereco_0 VARCHAR(10) NOT NULL,
 titulo VARCHAR(10) NOT NULL,
 idade NUMERIC(10) NOT NULL,
 nacionalidade VARCHAR(10) NOT NULL
);

ALTER TABLE Autor ADD CONSTRAINT PK_Autor PRIMARY KEY (nome,cnpj,endereco,endereco_0,titulo);


CREATE TABLE Bibliotecas (
 endereco VARCHAR(10) NOT NULL,
 site VARCHAR(10) NOT NULL,
 nome VARCHAR(10) NOT NULL
);

ALTER TABLE Bibliotecas ADD CONSTRAINT PK_Bibliotecas PRIMARY KEY (endereco);


CREATE TABLE Designer_Artista (
 nome VARCHAR(10) NOT NULL,
 comissao NUMERIC(10) NOT NULL
);

ALTER TABLE Designer_Artista ADD CONSTRAINT PK_Designer_Artista PRIMARY KEY (nome);


CREATE TABLE Editora (
 cnpj NUMERIC(10) NOT NULL,
 lucro NUMERIC(10) NOT NULL,
 gastos NUMERIC(10) NOT NULL
);

ALTER TABLE Editora ADD CONSTRAINT PK_Editora PRIMARY KEY (cnpj);


CREATE TABLE Gráfica (
 cnpj NUMERIC(10) NOT NULL,
 nome VARCHAR(10) NOT NULL
);

ALTER TABLE Gráfica ADD CONSTRAINT PK_Gráfica PRIMARY KEY (cnpj);


CREATE TABLE Livraria (
 endereco VARCHAR(10) NOT NULL,
 nome VARCHAR(10) NOT NULL
);

ALTER TABLE Livraria ADD CONSTRAINT PK_Livraria PRIMARY KEY (endereco);


CREATE TABLE Livro (
 cnpj NUMERIC(10) NOT NULL,
 endereco VARCHAR(10) NOT NULL,
 endereco_0 VARCHAR(10) NOT NULL,
 titulo VARCHAR(10) NOT NULL,
 data_da_publicaçao NUMERIC(10) NOT NULL,
 preço NUMERIC(10) NOT NULL,
 genero VARCHAR(10) NOT NULL,
 objetivo VARCHAR(10) NOT NULL,
 sinopse VARCHAR(10) NOT NULL
);

ALTER TABLE Livro ADD CONSTRAINT PK_Livro PRIMARY KEY (cnpj,endereco,endereco_0,titulo);


CREATE TABLE Capa (
 titulo VARCHAR(10) NOT NULL,
 desenho VARCHAR(10) NOT NULL,
 autor VARCHAR(10) NOT NULL
);

ALTER TABLE Capa ADD CONSTRAINT PK_Capa PRIMARY KEY (titulo);


ALTER TABLE Autor ADD CONSTRAINT FK_Autor_0 FOREIGN KEY (cnpj,endereco,endereco_0,titulo) REFERENCES Livro (cnpj,endereco,endereco_0,titulo);


ALTER TABLE Livro ADD CONSTRAINT FK_Livro_0 FOREIGN KEY (cnpj) REFERENCES Editora (cnpj);
ALTER TABLE Livro ADD CONSTRAINT FK_Livro_1 FOREIGN KEY (endereco) REFERENCES Bibliotecas (endereco);
ALTER TABLE Livro ADD CONSTRAINT FK_Livro_2 FOREIGN KEY (endereco_0) REFERENCES Livraria (endereco);


