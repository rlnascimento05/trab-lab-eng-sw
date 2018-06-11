package br.farmacia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.farmacia.database.ConnectionFactory;
import br.farmacia.database.DatabaseConfig;
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
					+ "Produtos, "
                    + "DataPedido) "
                    + "values(?,?,?)");

            ps.setInt(1, pedido.getCodPedido());
            ps.setInt(2, pedido.getProdutos());//ARRAY CARALHO
			ps.setInt(3, pedido.getDataPedido());//É DATE MAS NEM SEI COMOFAS

            returnCode = ps.executeUpdate();

            conn.close();
            ps.close();
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

    public int update(Pedido pedido){
        java.sql.PreparedStatement ps;
        int returnCode = 0;
        try (Connection conn = this.connector.getConnection()) {
            ps= conn.prepareStatement (
                "update Pedido set "
                    + "CodPedido, "
					+ "Produtos, "
                    + "DataPedido) "
                    + "values(?,?,?)");

            ps.setInt(1, pedido.getCodPedido());
            ps.setInt(2, pedido.getProdutos());//ARRAY CARALHO
			ps.setInt(3, pedido.getDataPedido());//É DATE MAS NEM SEI COMOFAS
            returnCode = ps.executeUpdate();

            conn.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnCode;
    }

    public int update(Pedido[] pedidos){
        int returnCode = 0;
        for (Pedido pedido : pedidos){
            returnCode +=this.update(pedido);
        }
        return returnCode;
    }

    public Pedido getPedido(int idPedido){
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
        return ped;
    }

    private ArrayList<Pedido> buildPedidos(ResultSet result) throws SQLException{
        ArrayList<Pedido> peds = new ArrayList<Pedido>();
        while (result.next()){
            Pedido ped = new Pedido();
            ped.setCodPedido(result.getInt("CodPedido"));           
            ped.setProdutos(result.getInt("Produtos"));//ARRAY CARALHO
			ped.setDataPedido(result.getInt("DataPedido"));//É DATE MAS NEM SEI COMOFAS

            peds.add(ped);
        }

        return peds;
    }


    public ArrayList<Pedido> getAllPedidos(){
        //TODO: Finish this thing
        java.sql.PreparedStatement ps;
        return null;
    }
}