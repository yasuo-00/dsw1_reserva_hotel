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
	
	public BookingSite getByURL(String url) {
		String sql = "SELECT * FROM booking_site b where b.url = ?";
		BookingSite bookingSite=null;

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement = connection.prepareStatement(sql);
			statement.setString(1, url);

			ResultSet resultSet = statement.executeQuery(sql);
			String name = resultSet.getString("name");
			String phone = resultSet.getString("phone");
			bookingSite = new BookingSite(url, name, phone);

			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return bookingSite;
	}

	public void insert(BookingSite bookingSite) {
		String sql = "INSERT INTO bookingSite(url,name, phone) VALUES(?,?,?)";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement = connection.prepareStatement(sql);
			statement.setString(1, bookingSite.getUrl());
			statement.setString(2, bookingSite.getName());
			statement.setString(3, String.valueOf(bookingSite.getPhone()));

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
		String sql = "UPDATE site_reserva SET name = ?, phone = ?";
		sql += ", WHERE url = ?";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement = connection.prepareStatement(sql);
			statement.setString(1, bookingSite.getName());
			statement.setString(2, String.valueOf(bookingSite.getPhone()));
			// statement.setString(3, bookingSite.getPassword());
			// statement.setString(4, bookingSite.getEmail());
			statement.setString(6, bookingSite.getUrl());

			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<BookingSite> listAll() {
		List<BookingSite> bookingSitesList = new ArrayList<>();

		String sql = "SELECT * from BookingSite b";

		try {
			Connection connection = this.getConnection();
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String url = resultSet.getString("url");
				String name = resultSet.getString("name");
				String phone = resultSet.getString("phone");
				BookingSite bookingSite = new BookingSite(url, name, phone);
				bookingSitesList.add(bookingSite);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return bookingSitesList;
	}

	public List<BookingSite> listAllByURL() {
		List<BookingSite> bookingSitesList = new ArrayList<>();

		String sql = "SELECT * from BookingSite b ORDER BY b.url";

		try {
			Connection connection = this.getConnection();
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String url = resultSet.getString("url");
				String name = resultSet.getString("name");
				String phone = resultSet.getString("phone");
				BookingSite bookingSite = new BookingSite(url, name, phone);
				bookingSitesList.add(bookingSite);
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
