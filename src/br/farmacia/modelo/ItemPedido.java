package br.farmacia.modelo;

public class ItemPedido {
    private Produto item;
    private int quantidade;

    public double valor(){
        return this.item.getValor() * quantidade;
    }

	public Produto getItem() {
		return item;
	}

	public void setItem(Produto item) {
		this.item = item;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
    
}
