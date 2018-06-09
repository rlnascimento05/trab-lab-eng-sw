DROP TABLE Cliente;
DROP TABLE Cosmetico;
DROP TABLE Funcionario;
DROP TABLE Pagamento;
DROP TABLE Medicamento;
DROP TABLE Pedido;

CREATE TABLE Cliente(
	Nome CHAR(200),
	CPF INT,
	Sexo CHAR(50),
	Email VARCHAR(255),
	Celular INT,
	Telefone INT
);

CREATE TABLE Cosmetico(
	CodCosmetico INT,
	NomeProduto CHAR(100),
	TipoProduto CHAR(100),
	Fabricante VARCHAR (100),
	Descricao VARCHAR(255),
	Valor NUMBER(10,3),
	Peso INT,
	Validade DATE,
	Marca CHAR(255),
	Usos CHAR(255)
);

CREATE TABLE Funcionario(
	NomeCompletoF CHAR(200),
	CPF INT,
	Sexo CHAR(50),
	Email VARCHAR(255),	
	Cargo Char(50),
	Celular INT,
	Telefone INT
);

CREATE TABLE Funcionario(
	NomeCompletoF CHAR(200),
	CPF INT,
	Sexo CHAR(50),
	Email VARCHAR(255),	
	Cargo Char(50),
	Celular INT,
	Telefone INT
);

CREATE TABLE Pagamento(
	CodPagamento INT,
	ValorTotal NUMBER(10,2)
);

CREATE TABLE Pedido(
	CodPedido INT,
	NomeProduto CHAR(100),
	ValorPoduto NUMBER(10,2)
);