package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.classes.User;

public class UserDAO extends GenericDAO<User> {

	public void insert(User user) {

		String sql = "INSERT INTO user (email, password, hotel_cnpj, booking_site_url) VALUES (?, ?, ?, ?)";

		try {
			Connection connectionection = this.getConnection();
			PreparedStatement statement = connectionection.prepareStatement(sql);

			statement = connectionection.prepareStatement(sql);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getHotelCNPJ());
			statement.setString(4, user.getBookingSiteURL());
			statement.executeUpdate();

			statement.close();
			connectionection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(User user) {
		String sql = "DELETE FROM User where id = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, user.getId());
			statement.executeUpdate();

			statement.close();
			conn.close();
		} catch (SQLException e) {
		}
	}

	public void update(User user) {
		String sql = "UPDATE User SET  email = ?, password = ?, role = ? WHERE id = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getHotelCNPJ());
			statement.setString(4, user.getBookingSiteURL());
			statement.setInt(5, user.getId());
			statement.executeUpdate();

			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<User> listAll() {

		List<User> usersList = new ArrayList<>();

		String sql = "SELECT * from User u";

		try {
			Connection connection = this.getConnection();
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				String hotelCNPJ = resultSet.getString("hotel_cnpj");
				String bookingSiteURL = resultSet.getString("booking_site_url");
				User user = new User(id, email, password, hotelCNPJ, bookingSiteURL);
				usersList.add(user);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return usersList;
	}

	public List<User> listAllByURL() {

		List<User> usersList = new ArrayList<>();

		String sql = "SELECT * from User u WHERE u.booking_site_url IS NOT NULL ORDER BY u.booking_site_url";

		try {
			Connection connection = this.getConnection();
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				//String hotelCNPJ = resultSet.getString("hotel_cnpj");
				String bookingSiteURL = resultSet.getString("booking_site_url");
				User user = new User(id, email, password, null, bookingSiteURL);
				usersList.add(user);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return usersList;
	}
	
	public List<User> listAllByCNPJ() {

		List<User> usersList = new ArrayList<>();

		String sql = "SELECT * from User u WHERE u.hotel_cnpj IS NOT NULL ORDER BY u.hotel_cnpj";

		try {
			Connection connection = this.getConnection();
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				String hotelCNPJ = resultSet.getString("hotel_cnpj");
				//String bookingSiteURL = resultSet.getString("booking_site_url");
				User user = new User(id, email, password, hotelCNPJ, null);
				usersList.add(user);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return usersList;
	}

	public User getByEmail(String email) {
		User user = null;

		String sql = "SELECT * from user WHERE email = ?";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				String password = resultSet.getString("password");
				String hotelCNPJ = resultSet.getString("hotel_cnpj");
				String bookingSiteURL = resultSet.getString("booking_site_url");

				user = new User(id, email, password, hotelCNPJ, bookingSiteURL);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return user;

	}

	public User getByHotelCNPJ(String hotelCNPJ) {
		User user = null;

		String sql = "SELECT * from user WHERE hotel_cnpj = ?";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, hotelCNPJ);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				String bookingSiteURL = resultSet.getString("booking_site_url");

				user = new User(id, email, password, hotelCNPJ, bookingSiteURL);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return user;

	}

	public User getByBookingSiteURL(String bookingSiteURL) {
		User user = null;

		String sql = "SELECT * from user WHERE booking_site_url = ?";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, bookingSiteURL);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				String hotelCNPJ = resultSet.getString("hotel_cnpj");

				user = new User(id, email, password, hotelCNPJ, bookingSiteURL);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return user;

	}

}
