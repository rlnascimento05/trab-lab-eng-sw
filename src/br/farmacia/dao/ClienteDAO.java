package br.farmacia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.farmacia.database.ConnectionFactory;
import br.farmacia.modelo.Cliente;

public class ClienteDAO {
    public int insert(Cliente cliente){
        PreparedStatement ps;
        int returnCode = 0;

        try (Connection conn = new ConnectionFactory().getConnection()) {
            ps = (PreparedStatement) conn.prepareStatement(

                    "insert into cliente("
                    + "Nome, "
                    + "CPF, "
                    + "Sexo, "
                    + "Email, "
                    + "Celular, "
                    + "Telefone "
                    + "values(?,?,?,?,?,?)");

            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getCpf());
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

    public int delete(Cliente cliente) {
        java.sql.PreparedStatement ps;
        int returnCode = 0;
        try (Connection conn = new ConnectionFactory().getConnection()) {
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
        try (Connection conn = new ConnectionFactory().getConnection()) {
            ps = (PreparedStatement) conn.prepareStatement(
                "update cliente set"
                + "Nome = ?, "
                + "CPF = ?, "
                + "Sexo = ?, "
                + "Email = ?, "
                + "Celular = ?, "
                + "Telefone = ? "
                + "where cpf = ?");

            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getCpf());
            ps.setString(3, cliente.getSexo());
            ps.setString(4,cliente.getEmail());
            ps.setInt(5,cliente.getCelular());
            ps.setInt(6,cliente.getTelefone());
            ps.setInt(7, cliente.getCpf());

            returnCode = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnCode;

    }

    public Cliente getCliente(int cpf){
        //TODO: Finish this thing
        return null;
    }
}
