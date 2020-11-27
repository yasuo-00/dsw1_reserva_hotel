package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.classes.Hotel;

public class HotelDAO extends GenericDAO<Hotel> {

	public void insert(Hotel hotel) {
		String sql = "INSERT INTO hotel(cnpj,hotel_name, phone, city, daily_rate) VALUES(?,?,?,?,?)";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement = connection.prepareStatement(sql);
			statement.setString(1, hotel.getCNPJ());
			statement.setString(2, hotel.getName());
			statement.setString(3, hotel.getPhone());
			statement.setString(4, hotel.getCity());
			//statement.setString(5, hotel.getEmail());
			statement.setString(5, String.valueOf(hotel.getDailyRate()));
			//statement.setString(7, hotel.getPassword());
			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Hotel hotel) {
		String sql = "DELETE FROM hotel where cnpj = ?;"
				+ "DELETE FROM user where hotel_cnpj = ?";
		

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement = connection.prepareStatement(sql);
			statement.setString(1, hotel.getCNPJ());
			statement.setString(2, hotel.getCNPJ());

			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Hotel hotel) {
		String sql = "UPDATE site_reserva SET hotel_name = ?, phone = ?, city = ?, daily_rate = ?";
		sql += ", WHERE cnpj = ?";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement = connection.prepareStatement(sql);
			statement.setString(1, hotel.getName());
			statement.setString(2, hotel.getPhone());
			statement.setString(3, hotel.getCity());
			//statement.setString(4, hotel.getEmail());
			//statement.setString(4, hotel.getPassword());
			statement.setString(5, String.valueOf(hotel.getDailyRate()));
			statement.setString(6, String.valueOf(hotel.getCNPJ()));
			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	
		public List<Hotel> listAll() {
			List<Hotel> bookingSitesList = new ArrayList<>();

			String sql = "SELECT * from Hotel";

			try {
				Connection connection = this.getConnection();
				Statement statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					String cnpj = resultSet.getString("cnpj");
					String name = resultSet.getString("hotel_name");
					String city = resultSet.getString("city");
					//String password = resultSet.getString("password");
					//String email = resultSet.getString("email");
					double dailyRate = Double.parseDouble(resultSet.getString("daily_rate"));
					String phone = resultSet.getString("phone");
					Hotel livro = new Hotel(cnpj, name, phone, city, dailyRate);
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
