package br.farmacia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.farmacia.database.ConnectionFactory;
import br.farmacia.database.DatabaseConfig;
import br.farmacia.modelo.Pagamento;

public class PagamentoDAO {
    private ConnectionFactory connector;

    public PagamentoDAO(DatabaseConfig config){
        this.connector = new ConnectionFactory(config);
    }

    public int insert(Pagamento pagamento){
        PreparedStatement ps;
        int returnCode = 0;		

        try (Connection conn = this.connector.getConnection()) {
            ps = (PreparedStatement) conn.prepareStatement(

                    "insert into pedido("
                    + "CodPagamento, "
                    + "ValorTotal, "
					+ "Desconto, "
					+ "Tipo, "
					+ "DataPagamento) "
                    + "values(?,?)");

            ps.setInt(1, pagamento.getCodPagamento());
            ps.setDouble(2, pagamento.getValorTotal());//Nao sei se esta certo(O setDouble)
			ps.setDouble(3, pagamento.getDesconto());//Nao sei se esta certo(O setDouble)
			ps.setBoolean(4, pagamento.getTipo());//Nao sei se esta certo(O setBoolean)
			ps.setInt(5, pagamento.getDataPagamento());//Aqui e Date mas nao sei comofas
			ps.setInt(6, pagamento.getCodPagamento());
		
            returnCode = ps.executeUpdate();

            conn.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return returnCode;
    }

    public int insert(ArrayList<Pagamento> pagamentos){
    	int returnCode = 0;
    	for(Pagamento pag : pagamentos){
    		returnCode += this.insert(pag);
    	}
		return returnCode;
    }


    public int delete(Pagamento pagamento) {
        java.sql.PreparedStatement ps;
        int returnCode = 0;
        try (Connection conn = this.connector.getConnection()) {
            ps= conn.prepareStatement ("delete from Pagamento where CodPagamento = ?");
            ps.setInt(1, pagamento.getCodPagamento());
            returnCode = ps.executeUpdate();
            conn.close();
            ps.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        return returnCode;
    }

    public int update(Pagamento pagamento){
        java.sql.PreparedStatement ps;
        int returnCode = 0;
        try (Connection conn = this.connector.getConnection()) {
            ps= conn.prepareStatement (
                "update Pagamento set "
                    + "CodPagamento, "
                    + "ValorTotal, "
					+ "Desconto, "
					+ "Tipo, "
					+ "DataPagamento) "
                    + "where CodPagamento = ?");

            ps.setInt(1, pagamento.getCodPagamento());
            ps.setDouble(2, pagamento.getValorTotal());//Nao sei se esta certo(O setDouble)
			ps.setDouble(3, pagamento.getDesconto());//Nao sei se esta certo(O setDouble)
			ps.setBoolean(4, pagamento.getTipo());//Nao sei se esta certo(O setBoolean)
			ps.setInt(5, pagamento.getDataPagamento());//Aqui e Date mas nao sei comofas

            conn.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnCode;
    }

    public int update(Pagamento[] pagamentos){
        int returnCode = 0;
        for (Pagamento pagamento : pagamentos){
            returnCode +=this.update(pagamento);
        }
        return returnCode;
    }

    public Pagamento getPagamento(int idPagamento){
    	Pagamento pag = null;
        java.sql.PreparedStatement ps;
        try (Connection conn = this.connector.getConnection()) {
        	ps = conn.prepareStatement ("select * from pagamento where CodPagamento = ?");
            ps.setInt(1,idPagamento);

            ResultSet result = ps.executeQuery();

            ArrayList<Pagamento> pagamentos = buildPagamentos(result);
            pag = pagamentos.get(0);

            conn.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pag;
    }

    private ArrayList<Pagamento> buildPagamentos(ResultSet result) throws SQLException{
        ArrayList<Pagamento> pags = new ArrayList<Pagamento>();
        while (result.next()){
            Pagamento pag = new Pagamento();
            pag.setCodPagamento(result.getInt("CodPagamento")); 
            pag.setValorTotal(result.getDouble("ValorTotal"));//Nao sei se esta certo(O getDouble)
			pag.setDesconto(result.getDouble("Desconto"));//Nao sei se esta certo(O getDouble)
			pag.setTipo(result.getBoolean("Tipo"));//Nao sei se esta certo(O getBoolean)
			pag.setDataPagamento(result.getInt("DataPagamento"));//Aqui e Date mas nao sei comofas

            pags.add(pag);
        }

        return pags;
    }


    public ArrayList<Pagamento> getAllPagamentos(){
        //TODO: Finish this thing
        java.sql.PreparedStatement ps;
        return null;
    }
}
