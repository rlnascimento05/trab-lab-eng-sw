CREATE TABLE Medicamento(
	CodMedicamento INT,
	NomeProduto CHAR(100),
	TipoProduto CHAR(100),
	Fabricante VARCHAR (100),
	Descricao VARCHAR(255),
	Valor NUMBER (10,2),
	Peso INT,
	Validade DATE,
	QtdCapsula INT,
	Generico CHAR(1),
	PrincipioAtivo CHAR(255),
	Tarja CHAR(1),
	ContraIndicacao CHAR(255),
	ReacoesAdversas CHAR(255),
	Precaucoes CHAR(225)
);
