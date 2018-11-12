CREATE TABLE endereco(
	rua VARCHAR(50) PRIMARY KEY,
	bairro VARCHAR(50),
	cidade VARCHAR(25)	
);

CREATE TABLE clientes(
    nome varchar (25), 
    cpf varchar (25),
    id serial,
    id_end VARCHAR(50),
    PRIMARY KEY (id),
    FOREIGN KEY (id_end) REFERENCES endereco(rua) ON DELETE RESTRICT
);

