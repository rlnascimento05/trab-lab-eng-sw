package br.farmacia.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    String url;
    String driver;
    String usuario;
    String senha;

    public ConnectionFactory(DatabaseConfig config){
        this.url = config.getUrl();
        this.driver = config.getDriver();
        this.usuario = config.getUsuario();
        this.senha = config.getSenha();
    }

	public Connection getConnection(){
        try {
            Class.forName(this.driver);
            return (Connection) DriverManager.getConnection(this.url,this.usuario,this.senha);
            }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
