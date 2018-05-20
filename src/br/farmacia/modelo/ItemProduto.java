package br.farmacia.modelo;

public class ItemProduto {
	private Produto item;
	private int quantidade;
	
	public double valor(){
		return this.item.getValor() * quantidade;
	}
	
	//TODO: Getters and Setters
}
