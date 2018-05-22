package br.farmacia.database;

public class DatabaseConfig {
    //TODO: Ver como se configura uma conexão para um banco de dados oracle.
    //TODO: Ver como fazer um esquema .env pra essa conexão pra eu não ter que
    // ficar alterando o codigo toda a vez que eu quiser mexer no proeto de um
    // outro pc.

    String url = "jdbc:oracle:thin:@localhost:1521/XE" ;
    String driver = "oracle.jdbc.driver.OracleDriver";
    String usuario = "FARMACIA";
    String senha = "alunofatec";

    public DatabaseConfig(String url, String driver, String usuario, String senha) {
        this.url = url;
        this.driver = driver;
        this.usuario = usuario;
        this.senha = senha;
    }
    public DatabaseConfig() {
		// TODO Auto-generated constructor stub
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

