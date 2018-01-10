CREATE DATABASE IF NOT EXISTS TrabalhoFinal; 

USE TrabalhoFinal;

CREATE TABLE IF NOT EXISTS Livro (
    id INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(200) NOT NULL,
    autor VARCHAR(200) NOT NULL,
    isbn VARCHAR(50) NOT NULL,
    paginas INT NOT NULL,
    valor DOUBLE(10 , 2 ) NOT NULL,
    publicacao DATE NOT NULL,
    quantidade INT NOT NULL,
    PRIMARY KEY (idlivro)
);


INSERT INTO livro (titulo,autor,isbn, paginas, valor, publicacao, quantidade) VALUES ("O Senhor dos Anéis I - A Sociedade do Anel", "J.R.R. Tolkien", 8533613377,434,59.00,'2000-01-01 00:00:00',3);
INSERT INTO livro (titulo,autor,isbn, paginas, valor, publicacao, quantidade) VALUES ("O Senhor dos Anéis II - As Duas Torres", "J.R.R. Tolkien", 8533613385,373,46.00,'2000-01-01 00:00:00',10);
INSERT INTO livro (titulo,autor,isbn, paginas, valor, publicacao, quantidade) VALUES ("O Senhor dos Anéis III - O Retorno do Rei", "J.R.R. Tolkien", 8533613393,441,53.00,'2000-01-01 00:00:00',7);
INSERT INTO livro (titulo,autor,isbn, paginas, valor, publicacao, quantidade) VALUES ("Fahrenheit 451", "Ray Bradbury", 8525052248,216,35.00,'2012-01-01 00:00:00',17);
INSERT INTO livro (titulo,autor,isbn, paginas, valor, publicacao, quantidade) VALUES ("O Conde de Montecristo", "Alexandre Dumas", 9788537808276,1663,89.00,'2012-01-01 00:00:00',30);

select * from livro;

CREATE TABLE IF NOT EXISTS Usuario(
    login VARCHAR(100) NOT NULL,
	nome VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    PRIMARY KEY (login)
);

INSERT INTO usuario (login,nome,senha) VALUES ("fkeppejr", "Fernando", "1234");

select * from usuario;