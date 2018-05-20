package br.farmacia.modelo;

import java.util.ArrayList;

public class Carrinho {
	private ArrayList<ItemPedido> itensCarrinho;

	
	public double valorTotal(){
		double valor=0;
		for(ItemPedido iten : itensCarrinho){
			valor += iten.valor();
		}
		
		return valor;
	}
	
	public boolean adiciona(ItemPedido item){
		return this.itensCarrinho.add(item);
	}
	
	public boolean remove(ItemPedido item){
		return this.itensCarrinho.remove(item);
	}
	
	//TODO:Getters and Setters
	//TODO:Constructor
}
