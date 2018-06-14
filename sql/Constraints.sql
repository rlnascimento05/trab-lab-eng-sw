ALTER TABLE Cliente     ADD CONSTRAINT pk_Cliente       PRIMARY KEY (CPF);
ALTER TABLE Pedido      ADD CONSTRAINT pk_Pedido        PRIMARY KEY (CodPedido);
ALTER TABLE Pagamento   ADD CONSTRAINT pk_Pagamento     PRIMARY KEY (CodPagamento);
ALTER TABLE Medicamento ADD CONSTRAINT pk_Medicamento   PRIMARY KEY (CodMedicamento);
ALTER TABLE Cosmetico   ADD CONSTRAINT pk_Cosmetico     PRIMARY KEY (CodCosmetico);
ALTER TABLE Produto     ADD CONSTRAINT pk_Produto       PRIMARY KEY (CodProduto);
ALTER TABLE ItemPedido  ADD CONSTRAINT pk_ItemPedido    PRIMARY KEY (CodProduto,CodPedido);

ALTER TABLE Pedido      ADD CONSTRAINT fk_Cliente       FOREIGN KEY (CPF)         REFERENCES CPF(Cliente);
ALTER TABLE Pagamento   ADD CONSTRAINT fk_Pedido        FOREIGN KEY (CodPedido)   REFERENCES CodPedido(Pedido);
ALTER TABLE Pedido      ADD CONSTRAINT fk_Produto       FOREIGN KEY (CodProduto)  REFERENCES CodProduto(Produto);
ALTER TABLE Medicamento ADD CONSTRAINT fk_Produto       FOREIGN KEY (CodProduto)  REFERENCES CodProduto(Produto);
ALTER TABLE Cosmeticos  ADD CONSTRAINT fk_Produto       FOREIGN KEY (CodProduto)  REFERENCES CodProduto(Produto);
ALTER TABLE ItemPedido  ADD CONSTRAINT pk_Pedido        FOREIGN KEY (CodPedido)   REFERENCES CodPedido(Pedido);
ALTER TABLE ItemPedido  ADD CONSTRAINT pk_Produto       FOREIGN KEY (CodProduto)  REFERENCES CodProduto(Produto);
