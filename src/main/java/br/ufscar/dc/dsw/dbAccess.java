package br.ufscar.dc.dsw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbAccess {
	public static void main(String[] args) {
		try {

			/* Setup para uso do banco de dados MySQL */
			
			Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/dsw1_reserva_hotel";
			Connection connection = (Connection) DriverManager.getConnection(url,
					"root", "password");

		} catch (ClassNotFoundException e) {
			System.out.println("A classe do driver de connectionexão não foi encontrada!");
		} catch (SQLException e) {
			System.out.println("O comando SQL não pode ser executado!");
		}
	}

}
