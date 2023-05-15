CREATE TABLE Pauta (
   id INT PRIMARY KEY,
   titulo VARCHAR(64) NOT NULL,
   descricao VARCHAR(255),
   aberto BOOLEAN DEFAULT true
);
CREATE TABLE Voto (
   id INT PRIMARY KEY,
   idPauta INT NOT NULL,
   idAssociado INT NOT NULL,
   voto BOOLEAN NOT NULL
);