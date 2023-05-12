CREATE TABLE Pauta (
   id INT PRIMARY KEY,
   titulo VARCHAR(64) NOT NULL,
   descricao VARCHAR(255),
   aberto BOOLEAN DEFAULT true
);
