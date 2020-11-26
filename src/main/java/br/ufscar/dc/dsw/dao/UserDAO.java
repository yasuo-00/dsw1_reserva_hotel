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

		String sql = "INSERT INTO user (name, email, password, role) VALUES (?, ?, ?, ?)";

		try {
			Connection connectionection = this.getConnection();
			PreparedStatement statement = connectionection.prepareStatement(sql);
			;

			statement = connectionection.prepareStatement(sql);
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getRole());
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

			// statement.setLong(1, user.getId());
			statement.executeUpdate();

			statement.close();
			conn.close();
		} catch (SQLException e) {
		}
	}

	public void update(User user) {
		String sql = "UPDATE User SET name = ?, login = ?, password = ?, role = ? WHERE id = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getRole());
			// statement.setLong(5, user.getId());
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
				String id = resultSet.getString("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				String role = resultSet.getString("role");
				User user = new User(id, name, email, password, role);
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

		String sql = "SELECT * from User WHERE email = ?";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String id = resultSet.getString("id");
				String nome = resultSet.getString("nome");
				String password = resultSet.getString("password");
				String role = resultSet.getString("role");

				user = new User(id, nome, email, password, role);
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
