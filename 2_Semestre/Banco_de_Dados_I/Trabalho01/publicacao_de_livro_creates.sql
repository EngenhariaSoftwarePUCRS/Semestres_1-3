CREATE TABLE Autor (
 identificador NUMERIC(10) NOT NULL,
 codigo VARCHAR(500) NOT NULL,
 nacionalidade VARCHAR(40),
 idade NUMERIC(2),
 pseudonimo VARCHAR(50),
 nome VARCHAR(50)
);

ALTER TABLE Autor ADD CONSTRAINT PK_Autor PRIMARY KEY (identificador,codigo);


CREATE TABLE Capa (
 codigo VARCHAR(500) NOT NULL,
 titulo VARCHAR(10),
 arte NUMERIC(10)
);

ALTER TABLE Capa ADD CONSTRAINT PK_Capa PRIMARY KEY (codigo);


CREATE TABLE Livro (
 codigo VARCHAR(500) NOT NULL,
 genero VARCHAR(20),
 paginas NUMERIC(5),
 data_de_publicacao DATE
);

ALTER TABLE Livro ADD CONSTRAINT PK_Livro PRIMARY KEY (codigo);


CREATE TABLE Pessoa (
 identificador NUMERIC(10) NOT NULL,
 nome VARCHAR(50)
);

ALTER TABLE Pessoa ADD CONSTRAINT PK_Pessoa PRIMARY KEY (identificador);


CREATE TABLE PessoaJuridica (
 identificador NUMERIC(10) NOT NULL,
 cnpj NUMERIC(14),
 razaoSocial VARCHAR(100)
);

ALTER TABLE PessoaJuridica ADD CONSTRAINT PK_PessoaJuridica PRIMARY KEY (identificador);


CREATE TABLE Designer (
 identificador NUMERIC(10) NOT NULL
);

ALTER TABLE Designer ADD CONSTRAINT PK_Designer PRIMARY KEY (identificador);


CREATE TABLE Editora (
 cnpj NUMERIC(14) NOT NULL
);

ALTER TABLE Editora ADD CONSTRAINT PK_Editora PRIMARY KEY (cnpj);


CREATE TABLE Leitor (
 identificador NUMERIC(10) NOT NULL
);

ALTER TABLE Leitor ADD CONSTRAINT PK_Leitor PRIMARY KEY (identificador);


CREATE TABLE PessoaFisica (
 identificador NUMERIC(10) NOT NULL,
 cpf NUMERIC(11),
 dataNascimento DATE,
 genero CHAR(1)
);

ALTER TABLE PessoaFisica ADD CONSTRAINT PK_PessoaFisica PRIMARY KEY (identificador);


CREATE TABLE Telefone (
 identificador NUMERIC(10) NOT NULL,
 ddd NUMERIC(3),
 numero NUMERIC(11)
);

ALTER TABLE Telefone ADD CONSTRAINT PK_Telefone PRIMARY KEY (identificador);


ALTER TABLE Autor ADD CONSTRAINT FK_Autor_0 FOREIGN KEY (identificador) REFERENCES Pessoa (identificador);
ALTER TABLE Autor ADD CONSTRAINT FK_Autor_1 FOREIGN KEY (codigo) REFERENCES Capa (codigo);
ALTER TABLE Autor ADD CONSTRAINT FK_Autor_2 FOREIGN KEY (codigo) REFERENCES Livro (codigo);


ALTER TABLE Capa ADD CONSTRAINT FK_Capa_0 FOREIGN KEY (codigo) REFERENCES Livro (codigo);


ALTER TABLE PessoaJuridica ADD CONSTRAINT FK_PessoaJuridica_0 FOREIGN KEY (identificador) REFERENCES Pessoa (identificador);


ALTER TABLE Designer ADD CONSTRAINT FK_Designer_0 FOREIGN KEY (identificador) REFERENCES Pessoa (identificador);


ALTER TABLE Leitor ADD CONSTRAINT FK_Leitor_0 FOREIGN KEY (identificador) REFERENCES Pessoa (identificador);


ALTER TABLE PessoaFisica ADD CONSTRAINT FK_PessoaFisica_0 FOREIGN KEY (identificador) REFERENCES Pessoa (identificador);
ALTER TABLE PessoaFisica ADD CONSTRAINT FK_PessoaFisica_1 FOREIGN KEY (identificador) REFERENCES PessoaJuridica (identificador);


ALTER TABLE Telefone ADD CONSTRAINT FK_Telefone_0 FOREIGN KEY (identificador) REFERENCES PessoaFisica (identificador);


