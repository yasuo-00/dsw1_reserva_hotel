package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.classes.BookingSite;

public class BookingSiteDAO extends GenericDAO<BookingSite> {

	public void insert(BookingSite bookingSite) {
		String sql = "INSERT INTO bookingSite(url,name, phone) VALUES(?,?,?)";

		try {
			Connection connectionection = this.getConnection();
			PreparedStatement statement = connectionection.prepareStatement(sql);

			statement = connectionection.prepareStatement(sql);
			statement.setString(1, bookingSite.getUrl());
			statement.setString(2, bookingSite.getName());
			statement.setString(3, String.valueOf(bookingSite.getPhone()));

			statement.executeUpdate();

			statement.close();
			connectionection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(BookingSite bookingSite) {
		String sql = "DELETE FROM site_reserva where url = ?";

		try {
			Connection connectionection = this.getConnection();
			PreparedStatement statement = connectionection.prepareStatement(sql);

			statement = connectionection.prepareStatement(sql);
			statement.setString(1, bookingSite.getUrl());

			statement.executeUpdate();

			statement.close();
			connectionection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(BookingSite bookingSite) {
		String sql = "UPDATE site_reserva SET name = ?, phone = ?";
		sql += ", WHERE url = ?";

		try {
			Connection connectionection = this.getConnection();
			PreparedStatement statement = connectionection.prepareStatement(sql);

			statement = connectionection.prepareStatement(sql);
			statement.setString(1, bookingSite.getName());
			statement.setString(2, String.valueOf(bookingSite.getPhone()));
			//statement.setString(3, bookingSite.getPassword());
			//statement.setString(4, bookingSite.getEmail());
			statement.setString(6, bookingSite.getUrl());

			statement.executeUpdate();

			statement.close();
			connectionection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<BookingSite> listAll() {
		List<BookingSite> bookingSitesList = new ArrayList<>();

		String sql = "SELECT * from BookingSite";

		try {
			Connection connection = this.getConnection();
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String url = resultSet.getString("url");
				String name = resultSet.getString("name");
				String phone = resultSet.getString("phone");
				BookingSite livro = new BookingSite(url, name, phone);
				bookingSitesList.add(livro);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return bookingSitesList;
	}
}
