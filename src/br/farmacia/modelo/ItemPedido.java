package br.farmacia.modelo;

public class ItemPedido {
	private Produto item;
	private int quantidade;
	
	public double valor(){
		return this.item.getValor() * quantidade;
	}
	
	//TODO: Getters and Setters
}
