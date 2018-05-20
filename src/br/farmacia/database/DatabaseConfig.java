package br.farmacia.database;

public class DatabaseConfig {
	//TODO: Ver como se configura uma conex�o para um banco de dados oracle.
	//TODO: Ver como fazer um esquema .env pra essa conex�o pra eu n�o ter que 
	// ficar alterando o codigo toda a vez que eu quiser mexer no proeto de um
	// outro pc.
	String url = "";
	String driver = "";
	String usuario = "";
	String senha = "";
	
	public DatabaseConfig(String url, String driver, String usuario, String senha) {
		this.url = url;
		this.driver = driver;
		this.usuario = usuario;
		this.senha = senha;
	}
	public String getUrl() {
		return url;
	}
	public String getDriver() {
		return driver;
	}
	public String getUsuario() {
		return usuario;
	}
	public String getSenha() {
		return senha;
	}
}

