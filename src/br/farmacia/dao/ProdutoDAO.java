package br.farmacia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.farmacia.database.ConnectionFactory;
import br.farmacia.modelo.Produto;

public class ProdutoDAO {
	public int insert(Produto produto){
		PreparedStatement ps;
		int returnCode = 0;
		
		try (Connection conn = new ConnectionFactory().getConnection()) {
			ps = (PreparedStatement) conn.prepareStatement(

					"insert into Produto (emprestimoNumero, codigoLivro, codigoUsuario, dataEmprestimo, dataDevolucao) values(?,?,?,?,?)");

//			ps.setInt(1, emprestimo.getEmprestimoNumero());
//			ps.setString(2, emprestimo.getLivro().getIsbn());
//			ps.setString(3, emprestimo.getUsuario().getRa());
//			ps.setString(4, emprestimo.getDataEmprestimo());
//			ps.setString(5, emprestimo.getDataDevolucao());
			returnCode = ps.executeUpdate();
			//logger.info("codigo de retorno do metodo adiciona empresa =" + codigoRetorno);
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}
	
	public int delete(int idProduto) { 
		// TODO: Descobrir qual é a Pk de produto pra colocar aqui
		java.sql.PreparedStatement ps;
		int returnCode = 0;
		try (Connection conn = new ConnectionFactory().getConnection()) {
			ps= conn.prepareStatement ("delete from Produto where idProduto = ?");
			ps.setInt(1, idProduto);
			returnCode = ps.executeUpdate();
		}
		catch (SQLException e){
			throw new RuntimeException(e);
		}
		return returnCode;
	}
	
	public int update(Produto produto){
		java.sql.PreparedStatement ps;
		int returnCode = 0;
		try (Connection conn = new ConnectionFactory().getConnection()) {
			ps= conn.prepareStatement ("update Produto set coisas_de_produto = ?  where idProduto = ?");
//			ps.setInt(-1); 
			//TODO: Aqui eu tenho que colocar o idProduto como ultimo pra poder
			// dar o update certo
			//TODO: Colocar os campos certos para o produto.
			returnCode = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnCode;
		
	}
	
	public int update(Produto[] produtos){
		int returnCode = 0;
		
		for (Produto produto : produtos){
			returnCode +=this.update(produto);
		}
		
		return returnCode;	
	}
	
	public Produto getProduto(int idProduto){
		java.sql.PreparedStatement ps;
		try (Connection conn = new ConnectionFactory().getConnection()) {
			ps= conn.prepareStatement ("update Produto set coisas_de_produto = ?  where idProduto = ?");
//			ps.setInt(-1); 
			//TODO: Aqui eu tenho que colocar o idProduto como ultimo pra poder
			// dar o update certo
			//TODO: Colocar os campos certos para o produto.
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//TODO: Colocar aqui como fazer pra construir o objeto produto apartir
		// dos resultados da query
		return null;
	}
}
