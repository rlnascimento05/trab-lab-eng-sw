package br.farmacia.unittest;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import br.farmacia.dao.MedicamentoDAO;
import br.farmacia.database.DatabaseConfig;
import br.farmacia.modelo.Medicamento;

public class MedicamentoTest {
    private MedicamentoDAO dao = new MedicamentoDAO(new DatabaseConfig());

    public void test_insert(){
        Medicamento med = new Medicamento();
        med.setCodMedicamento(12);
        med.setContraIndicacao("Nenhuma");
        med.setDescricao("25 capsulas");
        med.setFabricante("Bayer");
        med.setNome("Decrepitax");
        med.setPeso(32);
        med.setPrecaucoes("Teste");
        med.setPrincipioAtivo("Vacilo");
        med.setQtdCapsula(25);
        med.setReacaoAdversa("Humanos");
        med.setTarja("1"); 	//aqui o tamanho é 1 no banco de dados
                               // aumentar isso no banco ou criar uma tabela de relação de tarjas ou
                            // colocar essa logica aqui.
        med.setTipo("2");
        med.setValidade(new Date(27, 8, 2018));
        med.setValor(100);

        assertEquals(dao.insert(med),1);
    }

    @Test
    public void test_select(){
    	 Medicamento med = new Medicamento(); //TODO: Refactor this shit
         med.setCodMedicamento(12);
         med.setContraIndicacao("Nenhuma");
         med.setDescricao("25 capsulas");
         med.setFabricante("Bayer");
         med.setNome("Decrepitax");
         med.setPeso(32);
         med.setPrecaucoes("Teste");
         med.setPrincipioAtivo("Vacilo");
         med.setQtdCapsula(25);
         med.setReacaoAdversa("Humanos");
         med.setTarja("1"); 	//aqui o tamanho é 1 no banco de dados
                                // aumentar isso no banco ou criar uma tabela de relação de tarjas ou
                             // colocar essa logica aqui.
         med.setTipo("2");
         med.setValidade(new Date(27, 8, 2018));
         med.setValor(100);

         int cod = 12;

         Medicamento databaseMed = dao.getMedicamento(cod);

         assertTrue(databaseMed.getNome() == med.getNome());

    }
}
