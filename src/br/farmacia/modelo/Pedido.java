package br.farmacia.modelo;

import java.sql.Date;

public class Pedido {
	private int CodPedido;
    private ItemPedido[] itensComprados;
    private int cpfCliente;
    private Date dataPedido;
    
    //TODO: Como essa relação sai do diagrama de classes e vira codigo.
    //QUESTION: Será que eu tenho que colocar o pagamento numa classe separada?

    public double valorTotal(){
        double result = 0;
        for(ItemPedido item : itensComprados){
            result += item.valor();
        }

        return result;
    }

    public ItemPedido[] getItensComprados() {
        return itensComprados;
    }

    public void setItensComprados(ItemPedido[] itensComprados) {
        this.itensComprados = itensComprados;
    }

    public int getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(int cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public int getCodPedido() {
        return this.CodPedido;
    }

    public void setCodPedido(int cod) {
        this.CodPedido = cod;
    }

    public Date getDataPedido(){
        return this.dataPedido;
    }

    public void setDataPedido(Date data){
        this.dataPedido = data;
    }
}
