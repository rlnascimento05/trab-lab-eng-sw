ALTER TABLE Funcionario ADD CONSTRAINT pk_Funcionario 	PRIMARY KEY (CPF);
ALTER TABLE Cliente 	ADD CONSTRAINT pk_Cliente 		PRIMARY KEY (CPF);
ALTER TABLE Pedido 		ADD CONSTRAINT pk_Pedido 		PRIMARY KEY (CodPedido);
ALTER TABLE Pagamento 	ADD CONSTRAINT pk_Pagamento 	PRIMARY KEY (CodPagamento);
ALTER TABLE Medicamento ADD CONSTRAINT pk_Medicamento	PRIMARY KEY (CodMedicamento);
ALTER TABLE Cosmetico 	ADD CONSTRAINT pk_Cosmetico 	PRIMARY KEY (CodCosmetico);