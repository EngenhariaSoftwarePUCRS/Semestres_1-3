desc pessoa;
insert into pessoa (identificador, nome) values
	(0123456789, 'Stefen Edwin King'),
	(0712784975, 'Felipe Freitas Silva'),
    (2345678901, 'Joaquim Maria Machado de Assis'),
    (5016984762, 'Lucca Tisser Paradeda'),
    (4567890123, 'Michael Andreas Helmuth Ende'),
    (3572498100, 'Luiza Heller Kroeff Pla'),
    (6789012345, 'Joanne Kathleen Rowling'),
    (0216320981, 'Maria Eduarda Menezes de Lemos'),
    (8901234567, 'Eric Arthur Blair'),
    (1061774859, 'Murilo dos Santos Kasperbauer de Moraes');
select * from pessoa;

desc capa;
insert into capa (codigo, titulo, arte) values
	('859431860x', 'Dom Casmurro', 'Duas Pessoas, Criança, Casa ao Fundo'),
    ('0439708184', 'Harry Potter', 'Criança Voando Vassoura'),
    ('6555540133', 'A História Sem Fim', 'Criança, Dragão'),
    ('8556510469', 'O Iluminado', 'Porta Branca, Rachadura'),
    ('8535909559', 'A revolução dos bixos', 'Porco'),
    ('8556510256', 'Cujo', 'Pata Cachorro, Rasgo'),
    ('8535914846', '1984', 'Olho, TV'),
    ('8594318618', 'Memórias Póstumas de Brás Cubas', 'Homem, Árvores');
select * from capa;

desc livro;
insert into livro (codigo, genero, paginas, data_de_publicacao) values
	('859431860x', 'Romance', 208, '2019-05-02'),
    ('0439708184', 'Fantasia', 320, '1999-10-01'),
    ('6555540133', 'Fantasia', 416, '1984-10-05'),
    ('8556510469', 'Terror', 520, '2017-08-22'),
    ('8535909559', 'Ficção', 152, '2007-01-10'),
    ('8556510256', 'Suspense', 376, '2016-10-21'),
    ('8535914846', 'Ficção', 416, '2009-07-21'),
    ('8594318618', 'Romance', 192, '2019-05-02');
;
select * from livro;

desc autor;
insert into autor (identificador, codigo, nacionalidade, idade, pseudonimo, nome) values
	(0123456789, 8556510469, 'americano', 75, 'Steffen King', 'Stefen Edwin King'),
    (2345678901, 8594318618, 'brasileiro', 69, 'Machado de Assis', 'Joaquim Maria Machado de Assis'),
    (4567890123, 6555540133, 'alemao', 66, 'Michael Ende', 'Michael Andreas Helmuth Ende'),
    (6789012345, 0439708184, 'britanica', 57, 'JK Rowling', 'Joanne Kathleen Rowling'),
    (8901234567, 8535914846, 'indiano', 47, 'George Orwell', 'Eric Arthur Blair');
select * from autor;

desc designer;
insert into designer (identificador) value (3572498100);
select * from designer;

desc editora;
insert into editora (cnpj) values
	(02133757000193),
    (17285159000100);
select * from editora;

desc leitor;
insert into leitor (identificador) values
	(0216320981),
    (5016984762);
select * from leitor;