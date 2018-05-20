package br.farmacia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import br.farmacia.database.ConnectionFactory;
import br.farmacia.modelo.Medicamento;

public class MedicamentoDAO {
	public int insert(Medicamento medicamento){
		PreparedStatement ps;
		int returnCode = 0;
		
		try (Connection conn = new ConnectionFactory().getConnection()) {
			ps = (PreparedStatement) conn.prepareStatement(

					"insert into medicamento("
					+ "CodMedicamento, "
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

			ps.setInt(1, medicamento.getCodMedicamento());
			ps.setString(2, medicamento.getNome());
			ps.setString(3, medicamento.getTipo());
			ps.setString(4, medicamento.getFabricante());
			ps.setDouble(5, medicamento.getValor());
			ps.setDouble(6, medicamento.getPeso());
			ps.setDate(7, medicamento.getValidade());
			ps.setInt(8,medicamento.getQtdCapsula());
			ps.setBoolean(9,medicamento.isGenerico());
			ps.setString(10,medicamento.getPrincipioAtivo());
			ps.setString(11,medicamento.getTarja());
			ps.setString(12,medicamento.getContraIndicacao());
			ps.setString(13, medicamento.getReacaoAdversa());
			ps.setString(14,medicamento.getPrecaucoes());
			returnCode = ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return returnCode;
	}
	
	public int delete(Medicamento medicamento) { 
		java.sql.PreparedStatement ps;
		int returnCode = 0;
		try (Connection conn = new ConnectionFactory().getConnection()) {
			ps= conn.prepareStatement ("delete from Medicamento where CodMedicamento = ?");
			ps.setInt(1, medicamento.getCodMedicamento());
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
			ps= conn.prepareStatement (
				"update Medicamento set "
				+ "CodMedicamento = ?, "
				+ "NomeProduto = ?, "
				+ "TipoProduto = ?, "
				+ "Fabricante = ?, "
				+ "Valor = ?, "
				+ "Peso = ?, "
				+ "Validade = ?, "
				+ "QtdCapsula = ?, "
				+ "Generico = ?, "
				+ "PrincipioAtivo = ?, "
				+ "Tarja = ?, "
				+ "ContraIndicacao = ?, "
				+ "ReacoesAdversas = ?, "
				+ "Precaucoes = ?"
				+ "where idMedicamento = ?");
			
			ps.setInt(1, medicamento.getCodMedicamento());
			ps.setString(2, medicamento.getNome());
			ps.setString(3, medicamento.getTipo());
			ps.setString(4, medicamento.getFabricante());
			ps.setDouble(5, medicamento.getValor());
			ps.setDouble(6, medicamento.getPeso());
			ps.setDate(7, medicamento.getValidade());
			ps.setInt(8,medicamento.getQtdCapsula());
			ps.setBoolean(9,medicamento.isGenerico());
			ps.setString(10,medicamento.getPrincipioAtivo());
			ps.setString(11,medicamento.getTarja());
			ps.setString(12,medicamento.getContraIndicacao());
			ps.setString(13, medicamento.getReacaoAdversa());
			ps.setString(14,medicamento.getPrecaucoes());
			ps.setInt(15, medicamento.getCodMedicamento());
			returnCode = ps.executeUpdate();
		} catch (SQLException e) {
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
			e.printStackTrace();
		}
		
		//TODO: Colocar aqui como fazer pra construir o objeto medicamento apartir
		// dos resultados da query
		return null;
	}
	
	public ArrayList<Medicamento> getAllMedicamentos(){
		//TODO: Finish this thing
		java.sql.PreparedStatement ps;
		return null;
	}
}
