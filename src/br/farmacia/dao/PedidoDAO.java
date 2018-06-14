package br.farmacia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.farmacia.database.ConnectionFactory;
import br.farmacia.database.DatabaseConfig;
import br.farmacia.modelo.ItemPedido;
import br.farmacia.modelo.Pedido;

public class PedidoDAO {
    private ConnectionFactory connector;

    public PedidoDAO(DatabaseConfig config){
        this.connector = new ConnectionFactory(config);
    }

    public int insert(Pedido pedido){
        PreparedStatement ps;
        int returnCode = 0;
	
        try (Connection conn = this.connector.getConnection()) {
            ps = (PreparedStatement) conn.prepareStatement(
                    "insert into pedido("
                    + "CodPedido, "
                    + "CpfCliente,"
                    + "DataPedido) "
                    + "values(?,?,?)");
        	
            ps.setInt(1,pedido.getCodPedido());
            ps.setInt(1,pedido.getCpfCliente());
            ps.setDate(1,pedido.getDataPedido());
        	
            returnCode += ps.executeUpdate();
            ps.close();
            
        	for(ItemPedido item : pedido.getItensComprados()){
        		ps = (PreparedStatement) conn.prepareStatement(
                    "insert into ItemPedido("
                     + "CodPedido, "
                     + "CodProduto,"
                     + "Quantidade) "
                     + "values(?,?,?)");

                ps.setInt(1, pedido.getCodPedido());
                ps.setInt(2, item.getItem().getCodProduto());
                ps.setInt(3, item.getQuantidade());

                returnCode += ps.executeUpdate();
                ps.close();
        	}

            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return returnCode;
    }

    public int insert(ArrayList<Pedido> pedidos){
    	int returnCode = 0;
    	for(Pedido ped : pedidos){
    		returnCode += this.insert(ped);
    	}
		return returnCode;
    }


    public int delete(Pedido pedido) {
        java.sql.PreparedStatement ps;
        int returnCode = 0;
        try (Connection conn = this.connector.getConnection()) {
            ps= conn.prepareStatement ("delete from Pedido where CodPedido = ?");
            ps.setInt(1, pedido.getCodPedido());
            returnCode = ps.executeUpdate();
            conn.close();
            ps.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        return returnCode;
    }

    //Eu acho que esse cara não precisa de update;
    
    public Pedido getPedido(int idPedido){ //TODO: Mudar esse cara.
    	//TODO: Implement this
    	Pedido ped = null;
        java.sql.PreparedStatement ps;
        try (Connection conn = this.connector.getConnection()) {
        	ps = conn.prepareStatement ("select * from pedido where CodPedido = ?");
            ps.setInt(1,idPedido);

            ResultSet result = ps.executeQuery();

            ArrayList<Pedido> pedidos = buildPedidos(result);
            ped = pedidos.get(0);

            conn.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<Pedido> buildPedidos(ResultSet result) throws SQLException{
    	//TODO: Implement this
        return null;
    }


    public ArrayList<Pedido> getAllPedidos(){
        //TODO: Finish this
        java.sql.PreparedStatement ps;
        return null;
    }
}