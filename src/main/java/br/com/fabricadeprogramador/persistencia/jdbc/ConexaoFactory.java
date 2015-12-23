package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConnection() {
		
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/fabricaweb","postgres","jEsus777");
		} catch (SQLException e) {
			// Relançando uma Runtime exception para o DAO não ficar dependente de uma SQL Exception
			throw new RuntimeException(e);
		}
		
	}

}
