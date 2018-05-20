package br.farmacia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.farmacia.database.ConnectionFactory;
import br.farmacia.modelo.Medicamento;

public class MedicamentoDAO {
	public int insert(Medicamento medicamento){
		PreparedStatement ps;
		int returnCode = 0;
		
		try (Connection conn = new ConnectionFactory().getConnection()) {
			ps = (PreparedStatement) conn.prepareStatement(

					"insert into medicamento("
					+ "NomeProduto, "
					+ "TipoProduto, "
					+ "Fabricante, "
					+ "Valor, "
					+ "Peso, "
					+ "Validade, "
					+ "QtdCapsula, "
					+ "Generico, "
					+ "PrincipioAtivo, "
					+ "Tarja, "
					+ "ContraIndicacao, "
					+ "ReacoesAdversas, "
					+ "Precaucoes"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, medicamento.getNome());
			ps.setString(2, medicamento.getTipo());
			ps.setString(3, medicamento.getFabricante());
			ps.setDouble(4, medicamento.getValor());
			ps.setDouble(5, medicamento.getPeso());
			returnCode = ps.executeUpdate();
			//logger.info("codigo de retorno do metodo adiciona empresa =" + codigoRetorno);
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}
	
	public int delete(int idMedicamento) { 
		// TODO: Descobrir qual é a Pk de medicamento pra colocar aqui
		java.sql.PreparedStatement ps;
		int returnCode = 0;
		try (Connection conn = new ConnectionFactory().getConnection()) {
			ps= conn.prepareStatement ("delete from Medicamento where idMedicamento = ?");
			ps.setInt(1, idMedicamento);
			returnCode = ps.executeUpdate();
		}
		catch (SQLException e){
			throw new RuntimeException(e);
		}
		return returnCode;
	}
	
	public int update(Medicamento medicamento){
		java.sql.PreparedStatement ps;
		int returnCode = 0;
		try (Connection conn = new ConnectionFactory().getConnection()) {
			ps= conn.prepareStatement ("update Medicamento set coisas_de_medicamento = ?  where idMedicamento = ?");
//			ps.setInt(-1); 
			//TODO: Aqui eu tenho que colocar o idMedicamento como ultimo pra poder
			// dar o update certo
			//TODO: Colocar os campos certos para o medicamento.
			returnCode = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnCode;
		
	}
	
	public int update(Medicamento[] medicamentos){
		int returnCode = 0;
		
		for (Medicamento medicamento : medicamentos){
			returnCode +=this.update(medicamento);
		}
		
		return returnCode;	
	}
	
	public Medicamento getMedicamento(int idMedicamento){
		java.sql.PreparedStatement ps;
		try (Connection conn = new ConnectionFactory().getConnection()) {
			ps= conn.prepareStatement ("update Medicamento set coisas_de_medicamento = ?  where idMedicamento = ?");
//			ps.setInt(-1); 
			//TODO: Aqui eu tenho que colocar o idMedicamento como ultimo pra poder
			// dar o update certo
			//TODO: Colocar os campos certos para o medicamento.
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//TODO: Colocar aqui como fazer pra construir o objeto medicamento apartir
		// dos resultados da query
		return null;
	}
}
