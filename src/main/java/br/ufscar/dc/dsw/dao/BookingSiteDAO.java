package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.classes.BookingSite;
import br.ufscar.dc.dsw.classes.User;

public class BookingSiteDAO extends GenericDAO<BookingSite> {

	public BookingSite getByURL(String url) {
		String sql = "SELECT * FROM booking_site WHERE url=?;";
		BookingSite bookingSite = null;

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, url);

			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
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
		String sql = "INSERT INTO booking_site(url,name, phone) VALUES(?,?,?);";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement = connection.prepareStatement(sql);
			statement.setString(1, bookingSite.getUrl());
			statement.setString(2, bookingSite.getName());
			statement.setString(3, bookingSite.getPhone());

			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(BookingSite bookingSite) {
		String sql = "DELETE FROM booking_site where url=?;";
		String sqlUser = "DELETE FROM user where booking_site_url=?;";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			PreparedStatement userStatement = connection.prepareStatement(sqlUser);

			statement.setString(1, bookingSite.getUrl());
			userStatement.setString(1, bookingSite.getUrl());

			statement.executeUpdate();
			userStatement.executeUpdate();

			statement.close();
			userStatement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(BookingSite bookingSite) {
	}

	public void update(BookingSite bookingSite, User user) {
		String sql = "UPDATE booking_site SET name=?, phone=? WHERE url=?;";
		String sqlUser = "UPDATE user SET email=?, password=? WHERE booking_site_url=?;";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			PreparedStatement userStatement = connection.prepareStatement(sqlUser);

			statement.setString(1, bookingSite.getName());
			statement.setString(2,bookingSite.getPhone());
			statement.setString(3, bookingSite.getUrl());

			userStatement.setString(1, user.getPassword());
			userStatement.setString(2, user.getEmail());
			userStatement.setString(3, bookingSite.getUrl());

			statement.executeUpdate();
			userStatement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<BookingSite> listAll() {
		List<BookingSite> bookingSitesList = new ArrayList<>();

		String sql = "SELECT * from booking_site;";

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
		List<BookingSite> bookingSiteList = new ArrayList<BookingSite>();

		String sql = "SELECT * from booking_site ORDER BY url;";

		try {
			Connection connection = this.getConnection();
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);
			if (!resultSet.next()) {
				BookingSite bookingsite = new BookingSite();
				bookingSiteList.add(bookingsite);
			} else {

				do {
					String url = resultSet.getString("url");
					String name = resultSet.getString("name");
					String phone = resultSet.getString("phone");
					BookingSite bookingSite = new BookingSite(url, name, phone);
					bookingSiteList.add(bookingSite);
				} while (resultSet.next());
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return bookingSiteList;
	}
}
