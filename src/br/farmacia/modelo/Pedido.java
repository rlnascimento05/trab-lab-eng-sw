package br.farmacia.modelo;

public class Pedido {
	private ItemPedido[] itensComprados;
	private int cpfCliente; 
		//TODO: Como essa rela��o sai do diagrama de classes e vira codigo.
	
	//QUESTION: Ser� que eu tenho que colocar o pagamento numa classe separada?
	
	public double valorTotal(){
		double result = 0;
		for(ItemPedido item : itensComprados){
			result += item.valor();
		}
		
		return result;
	}
}
