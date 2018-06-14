ALTER TABLE Cliente     ADD CONSTRAINT pk_Cliente       PRIMARY KEY (CPF);
ALTER TABLE Pedido      ADD CONSTRAINT pk_Pedido        PRIMARY KEY (CodPedido);
ALTER TABLE Pagamento   ADD CONSTRAINT pk_Pagamento     PRIMARY KEY (CodPagamento);
ALTER TABLE Medicamento ADD CONSTRAINT pk_Medicamento   PRIMARY KEY (CodMedicamento);
ALTER TABLE Cosmetico   ADD CONSTRAINT pk_Cosmetico     PRIMARY KEY (CodCosmetico);
ALTER TABLE Produto     ADD CONSTRAINT pk_Produto       PRIMARY KEY (CodProduto);
 
ALTER TABLE Pedido      ADD CONSTRAINT fk_Cliente       FOREIGN KEY (cpf)         REFERENCES CPF(Cliente);
ALTER TABLE Pagamento   ADD CONSTRAINT fk_Pedido        FOREIGN KEY (codpedido)   REFERENCES CodPedido(Pedido);
ALTER TABLE Pedido      ADD CONSTRAINT fk_Produto       FOREIGN KEY (codproduto)  REFERENCES CodProduto(Produto);
ALTER TABLE Medicamento ADD CONSTRAINT fk_Produto       FOREIGN KEY (codproduto)  REFERENCES CodProduto(Produto);
ALTER TABLE Cosmeticos  ADD CONSTRAINT fk_Produto       FOREIGN KEY (codproduto)  REFERENCES CodProduto(Produto);
