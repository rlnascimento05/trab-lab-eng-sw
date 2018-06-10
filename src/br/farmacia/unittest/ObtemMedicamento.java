package br.farmacia.unittest;

import java.sql.Date;

import br.farmacia.modelo.Medicamento;

public class ObtemMedicamento {
    public Medicamento getMed1(){
        Medicamento med1 = new Medicamento();
        med1.setCodMedicamento(12);
        med1.setContraIndicacao("Nenhuma");
        med1.setDescricao("25 capsulas");
        med1.setFabricante("Bayer");
        med1.setNome("Decrepitax");
        med1.setPeso(32);
        med1.setPrecaucoes("Teste");
        med1.setPrincipioAtivo("Vacilo");
        med1.setQtdCapsula(25);
        med1.setReacaoAdversa("Humanos");
        med1.setTarja("1"); 	//aqui o tamanho é 1 no banco de dados
                               // aumentar isso no banco ou criar uma tabela de relação de tarjas ou
                            // colocar essa logica aqui.
        med1.setTipo("2");
        med1.setValidade(new Date(27, 8, 2018));
        med1.setValor(100);

        return med1;
	}

    public Medicamento getMed2(){
        Medicamento med2 = new Medicamento();

        med2.setCodMedicamento(13);
        med2.setContraIndicacao("Nenhuma");
        med2.setDescricao("25 capsulas");
        med2.setFabricante("Bayer");
        med2.setNome("Decrepitato");
        med2.setPeso(32);
        med2.setPrecaucoes("Teste");
        med2.setPrincipioAtivo("Necrochorume");
        med2.setQtdCapsula(25);
        med2.setReacaoAdversa("Humanos");
        med2.setTarja("1"); 	//aqui o tamanho é 1 no banco de dados
                               // aumentar isso no banco ou criar uma tabela de relação de tarjas ou
                            // colocar essa logica aqui.
        med2.setTipo("2");
        med2.setValidade(new Date(27, 8, 2018));
        med2.setValor(100);

        return med2;
    }
}
