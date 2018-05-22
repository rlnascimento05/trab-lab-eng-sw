package br.farmacia.unittest;

import static org.junit.Assert.*;

import org.junit.Test;

import br.farmacia.database.ConnectionFactory;
import br.farmacia.database.DatabaseConfig;

public class DatabaseTest {
	@Test
	public void test_conection() {
		// cenario
		DatabaseConfig config = new  DatabaseConfig();

		// acao
		ConnectionFactory connectionFactory = new ConnectionFactory(config);

		// verificacao
		assertNotNull(connectionFactory.getConnection());
	}

}
