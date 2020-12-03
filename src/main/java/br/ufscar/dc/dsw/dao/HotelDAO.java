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

	public Hotel getByCNPJ(String cnpj) {
		Hotel hotel = null;

		String sql = "SELECT * from hotel h WHERE h.cnpj = ?";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, cnpj);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String name = resultSet.getString("name");
				String phone = resultSet.getString("phone");
				String city = resultSet.getString("city");
				double dailyRate = resultSet.getDouble("daily_rate");

				hotel = new Hotel(cnpj, name, phone, city, dailyRate);

			}

			resultSet.close();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return hotel;
	}

	public void insert(Hotel hotel) {
		String sql = "INSERT INTO hotel(cnpj,hotel_name, phone, city, daily_rate) VALUES(?,?,?,?,?)";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, hotel.getCnpj());
			statement.setString(2, hotel.getName());
			statement.setString(3, hotel.getPhone());
			statement.setString(4, hotel.getCity());
			// statement.setString(5, hotel.getEmail());
			statement.setString(5, String.valueOf(hotel.getDailyRate()));
			// statement.setString(7, hotel.getPassword());
			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Hotel hotel) {
		String sql = "DELETE FROM hotel where cnpj = ?;" + "DELETE FROM user where hotel_cnpj = ?";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, hotel.getCnpj());
			statement.setString(2, hotel.getCnpj());

			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Hotel hotel) {
		String sql = "UPDATE hotel SET name = ?, phone = ?, city = ?, daily_rate = ?";
		sql += ", WHERE cnpj = ?";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement = connection.prepareStatement(sql);
			statement.setString(1, hotel.getName());
			statement.setString(2, hotel.getPhone());
			statement.setString(3, hotel.getCity());
			// statement.setString(4, hotel.getEmail());
			// statement.setString(4, hotel.getPassword());
			statement.setString(5, String.valueOf(hotel.getDailyRate()));
			statement.setString(6, String.valueOf(hotel.getCnpj()));
			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Hotel> listAll() {
		List<Hotel> hotelList = new ArrayList<>();

		String sql = "SELECT * from hotel";

		try {
			Connection connection = this.getConnection();
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String cnpj = resultSet.getString("cnpj");
				String name = resultSet.getString("name");
				String city = resultSet.getString("city");
				// String password = resultSet.getString("password");
				// String email = resultSet.getString("email");
				double dailyRate = Double.parseDouble(resultSet.getString("daily_rate"));
				String phone = resultSet.getString("phone");
				Hotel hotel = new Hotel(cnpj, name, phone, city, dailyRate);
				hotelList.add(hotel);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return hotelList;
	}

	public List<Hotel> listAllByCNPJ() {
		List<Hotel> hotelList = new ArrayList<Hotel>();

		String sql = "SELECT * from hotel h ORDER BY cnpj";

		try {
			Connection connection = this.getConnection();
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);
			if (!resultSet.next()) {
				Hotel hotel = new Hotel();
				hotelList.add(hotel);
			} else {

				do {
					String cnpj = resultSet.getString("cnpj");
					String name = resultSet.getString("name");
					String city = resultSet.getString("city");
					// String password = resultSet.getString("password");
					// String email = resultSet.getString("email");
					double dailyRate = Double.parseDouble(resultSet.getString("daily_rate"));
					String phone = resultSet.getString("phone");
					Hotel hotel = new Hotel(cnpj, name, phone, city, dailyRate);
					hotelList.add(hotel);
				} while (resultSet.next());
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return hotelList;
	}

	public List<Hotel> listByCity(String city) {
		List<Hotel> hotelList = new ArrayList<Hotel>();

		String sql = "SELECT * from hotel h where h.city = ?";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, city);

			ResultSet resultSet = statement.executeQuery();
			if (!resultSet.next()) {
				Hotel hotel = new Hotel();
				hotelList.add(hotel);
			} else {

				do {
					String cnpj = resultSet.getString("cnpj");
					String name = resultSet.getString("name");
					// String password = resultSet.getString("password");
					// String email = resultSet.getString("email");
					double dailyRate = Double.parseDouble(resultSet.getString("daily_rate"));
					String phone = resultSet.getString("phone");
					Hotel hotel = new Hotel(cnpj, name, phone, city, dailyRate);
					hotelList.add(hotel);
				} while (resultSet.next());
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return hotelList;
	}
}
