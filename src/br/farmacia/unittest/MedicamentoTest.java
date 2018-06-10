package br.farmacia.unittest;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Test;

import br.farmacia.dao.MedicamentoDAO;
import br.farmacia.database.DatabaseConfig;
import br.farmacia.modelo.Medicamento;

public class MedicamentoTest {
    private static MedicamentoDAO dao = new MedicamentoDAO(new DatabaseConfig());
    private static ObtemMedicamento medicamentos = new ObtemMedicamento();

    @Test
    public void test_insert(){
    	Medicamento med1 = medicamentos.getMed1();
        Medicamento med2 = medicamentos.getMed2();

        ArrayList<Medicamento> meds = new ArrayList<Medicamento>();
        meds.add(med1);
        meds.add(med2);

        assertEquals(dao.insert(meds),2);
    }

    @Test
    public void test_select(){
        Medicamento med = medicamentos.getMed1();
        int cod = med.getCodMedicamento();

        Medicamento databaseMed = dao.getMedicamento(cod);

        assertTrue(databaseMed.getNome().equals(med.getNome()));
    }

    @Test
    public void test_delete(){
        dao.delete(medicamentos.getMed1());
        dao.delete(medicamentos.getMed2());
    }

    @Test
    public void test_update(){
        Medicamento med = medicamentos.getMed1();
        med.setNome("OutroNome");
        med.setFabricante("OutroFabricante");

        assertEquals(dao.update(med),1);
    }


    @AfterClass
	public static void tearDownAfterClass() throws Exception {
    	dao.delete(medicamentos.getMed1());
    	dao.delete(medicamentos.getMed2());
	}
}
