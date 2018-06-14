package br.farmacia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.farmacia.database.ConnectionFactory;
import br.farmacia.database.DatabaseConfig;
import br.farmacia.modelo.Cliente;

public class ClienteDAO {
	private ConnectionFactory connector;

	public ClienteDAO(DatabaseConfig config){
		this.connector = new ConnectionFactory(config);
	}

    public int insert(Cliente cliente){
        PreparedStatement ps;
        int returnCode = 0;

        try (Connection conn = this.connector.getConnection()) {
            ps = (PreparedStatement) conn.prepareStatement(

                    "insert into Cliente("
                    + "Nome, "
                    + "CPF, "
                    + "Sexo, "
                    + "Email, "
                    + "Celular, "
                    + "Telefone "
                    + "values(?,?,?,?,?,?)");

            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getCPF());
            ps.setString(3, cliente.getSexo());
            ps.setString(4,cliente.getEmail());
            ps.setInt(5,cliente.getCelular());
            ps.setInt(6,cliente.getTelefone());

            returnCode = ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return returnCode;
    }

	public int insert(ArrayList<Cliente> clientes){
    	int returnCode = 0;
    	for(Cliente cli : clientes){
    		returnCode += this.insert(cli);
    	}
		return returnCode;
    }
	
    public int delete(Cliente cliente) {
        java.sql.PreparedStatement ps;
        int returnCode = 0;
        try (Connection conn = this.connector.getConnection()) {
            ps= conn.prepareStatement ("delete from Cliente where CodMedicamento = ?");
            ps.setInt(1, cliente.getCpf());
            returnCode = ps.executeUpdate();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        return returnCode;
    }

    public int update(Cliente cliente){
        java.sql.PreparedStatement ps;
        int returnCode = 0;
        try (Connection conn = this.connector.getConnection()) {
            ps = (PreparedStatement) conn.prepareStatement(
                "update cliente set"
                + "Nome = ?, "
                + "CPF = ?, "
                + "Sexo = ?, "
                + "Email = ?, "
                + "Celular = ?, "
                + "Telefone = ? "
                + "where CPF = ?");

            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getCPF());
            ps.setString(3, cliente.getSexo());
            ps.setString(4,cliente.getEmail());
            ps.setInt(5,cliente.getCelular());
            ps.setInt(6,cliente.getTelefone());
            ps.setInt(7, cliente.getCPF());

            conn.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnCode;

    }

    public int update(Cliente[] clientes){
        int returnCode = 0;
        for (Cliente cliente : clientes){
            returnCode +=this.update(cliente);
        }
        return returnCode;
    }

    public Cliente getCliente(int idCliente){
    	Cliente cli = null;
        java.sql.PreparedStatement ps;
        try (Connection conn = this.connector.getConnection()) {
        	ps = conn.prepareStatement ("select * from cliente where CodCliente = ?");
            ps.setInt(2,idCliente);

            ResultSet result = ps.executeQuery();

            ArrayList<Cliente> cliente = buildClientes(result);
            cli = cliente.get(0);

            conn.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cli;
    }

    private ArrayList<Cliente> buildClientes(ResultSet result) throws SQLException{
        ArrayList<Cliente> clis = new ArrayList<Cliente>();
        while (result.next()){
            Cliente cli = new Cliente();
            cli.setNome(result.getString("Nome"));           
            cli.setCPF(result.getInt("CPF"));
			cli.setSexo(result.getString("Sexo"));
			cli.setEmail(result.getString("Email"));
			cli.setCelular(result.getInt("Celular"));
			cli.setTelefone(result.getInt("Telefone"));
			
            clis.add(cli);
        }

        return clis;
    }


    public ArrayList<Cliente> getAllClientes(){
        //TODO: Finish this thing
        java.sql.PreparedStatement ps;
        return null;
    }
}
