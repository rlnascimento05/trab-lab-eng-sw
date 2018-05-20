package br.farmacia.modelo;

import java.text.SimpleDateFormat;

public abstract class Produto {
	protected String nome;
	protected String tipo;
	protected String fabricante;
	protected String descricao;
	protected double valor;
	protected double peso;
	protected SimpleDateFormat validade;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public SimpleDateFormat getValidade() {
		return validade;
	}
	public void setValidade(SimpleDateFormat validade) {
		this.validade = validade;
	}
}
