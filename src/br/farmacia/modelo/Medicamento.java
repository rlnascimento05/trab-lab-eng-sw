package br.farmacia.modelo;

public class Medicamento extends Produto {
	private int codMedicamento;
	private int qtdCapsula;
	private boolean generico;
	private String principioAtivo;
	private String tarja;
	private String contraIndicacao;
	private String reacaoAdversa;
	private String precaucoes;
	 
	public Medicamento() {
		// TODO Construtor
	}

	public int getCodMedicamento() {
		return codMedicamento;
	}

	public void setCodMedicamento(int codMedicamento) {
		this.codMedicamento = codMedicamento;
	}

	public int getQtdCapsula() {
		return qtdCapsula;
	}

	public void setQtdCapsula(int qtdCapsula) {
		this.qtdCapsula = qtdCapsula;
	}

	public boolean isGenerico() {
		return generico;
	}

	public void setGenerico(boolean generico) {
		this.generico = generico;
	}

	public String getPrincipioAtivo() {
		return principioAtivo;
	}

	public void setPrincipioAtivo(String principioAtivo) {
		this.principioAtivo = principioAtivo;
	}

	public String getTarja() {
		return tarja;
	}

	public void setTarja(String tarja) {
		this.tarja = tarja;
	}

	public String getContraIndicacao() {
		return contraIndicacao;
	}

	public void setContraIndicacao(String contraIndicacao) {
		this.contraIndicacao = contraIndicacao;
	}

	public String getReacaoAdversa() {
		return reacaoAdversa;
	}

	public void setReacaoAdversa(String reacaoAdversa) {
		this.reacaoAdversa = reacaoAdversa;
	}

	public String getPrecaucoes() {
		return precaucoes;
	}

	public void setPrecaucoes(String precaucoes) {
		this.precaucoes = precaucoes;
	}

	
}
