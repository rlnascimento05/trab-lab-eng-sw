package br.farmacia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.farmacia.database.ConnectionFactory;
import br.farmacia.database.DatabaseConfig;
import br.farmacia.modelo.Medicamento;

public class MedicamentoDAO {
    private ConnectionFactory connector;

    public MedicamentoDAO(DatabaseConfig config){
        this.connector = new ConnectionFactory(config);
    }

    public int insert(Medicamento medicamento){
        PreparedStatement ps;
        int returnCode = 0;

        try (Connection conn = this.connector.getConnection()) {
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
                    + "Precaucoes) "
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
        try (Connection conn = this.connector.getConnection()) {
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
        try (Connection conn = this.connector.getConnection()) {
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
    	Medicamento med = null;
        java.sql.PreparedStatement ps;
        try (Connection conn = this.connector.getConnection()) {
        	ps = conn.prepareStatement ("select * from medicamento where CodMedicamento = ?");
            ps.setInt(1,idMedicamento);

            ResultSet result = ps.executeQuery();

            ArrayList<Medicamento> medicamentos = buildMedicamentos(result);
            med = medicamentos.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return med;
    }

    private ArrayList<Medicamento> buildMedicamentos(ResultSet result) throws SQLException{
        ArrayList<Medicamento> meds = new ArrayList<Medicamento>();
        while (result.next()){
            Medicamento med = new Medicamento();
            med.setCodMedicamento(result.getInt("CodMedicamento"));
            med.setNome(result.getString("NomeProduto"));
            med.setTipo(result.getString("TipoProduto"));
            med.setFabricante(result.getString("Fabricante"));
            med.setValor(result.getDouble("Valor"));
            med.setPeso(result.getDouble("Peso"));
            med.setValidade(result.getDate("Validade"));
            med.setQtdCapsula(result.getInt("QtdCapsula"));
            med.setGenerico(result.getBoolean("Generico")); //FIXME: this may break, fix later
            med.setPrincipioAtivo(result.getString("PrincipioAtivo"));
            med.setTarja(result.getString("Tarja"));
            med.setContraIndicacao(result.getString("ContraIndicacao"));
            med.setReacaoAdversa(result.getString("ReacoesAdversas"));
            med.setPrecaucoes(result.getString("Precaucoes"));

            meds.add(med);
        }
        return meds;
    }


    public ArrayList<Medicamento> getAllMedicamentos(){
        //TODO: Finish this thing
        java.sql.PreparedStatement ps;
        return null;
    }
}
