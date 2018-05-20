package br.farmacia.modelo;

public class Pedido {
	private ItemProduto[] itensComprados;
	private int cpfCliente; 
		//TODO: Como essa relação sai do diagrama de classes e vira codigo.
	
	//QUESTION: Será que eu tenho que colocar o pagamento numa classe separada?
	
	public double valorTotal(){
		double result = 0;
		for(ItemProduto item : itensComprados){
			result += item.valor();
		}
		
		return result;
	}
}
