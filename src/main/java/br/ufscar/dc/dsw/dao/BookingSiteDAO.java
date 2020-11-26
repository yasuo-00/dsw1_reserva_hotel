package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.ufscar.dc.dsw.classes.BookingSite;

public class BookingSiteDAO extends GenericDAO<BookingSite> {

	public void insert(BookingSite bookingSite) {
		String sql = "INSERT INTO bookingSite(url,nome, telefone, senha, email) VALUES(?,?,?,?,?)";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement = connection.prepareStatement(sql);
			statement.setString(1, bookingSite.getUrl());
			statement.setString(2, bookingSite.getName());
			statement.setString(3, String.valueOf(bookingSite.getPhone()));
			statement.setString(4, bookingSite.getPassword());
			statement.setString(5, bookingSite.getEmail());
			
			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(BookingSite bookingSite) {
		String sql = "DELETE FROM site_reserva where url = ?";
		
		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement = connection.prepareStatement(sql);
			statement.setString(1, bookingSite.getUrl());
			
			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(BookingSite bookingSite) {
		String sql = "UPDATE site_reserva SET nome = ?, telefone = ?, email = ?";
		sql+=", WHERE url = ?";
		
		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement = connection.prepareStatement(sql);
			statement.setString(1, bookingSite.getName());
			statement.setString(2, String.valueOf(bookingSite.getPhone()));
			statement.setString(3, bookingSite.getPassword());
			statement.setString(4, bookingSite.getEmail());
			statement.setString(6, bookingSite.getUrl());
			
			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<BookingSite> listAll() {
		return null;
	}
}
