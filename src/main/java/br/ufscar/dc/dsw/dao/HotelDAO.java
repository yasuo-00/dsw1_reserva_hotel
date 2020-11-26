package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.ufscar.dc.dsw.classes.Hotel;

public class HotelDAO extends GenericDAO<Hotel> {

	public void insert(Hotel hotel) {
		String sql = "INSERT INTO hotel(cnpj,nome_do_hotel, telefone, cidade, email, diaria, senha) VALUES(?,?,?,?,?,?,?)";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement = connection.prepareStatement(sql);
			statement.setString(1, hotel.getCNPJ());
			statement.setString(2, hotel.getName());
			statement.setString(3, hotel.getPhone());
			statement.setString(4, hotel.getCity());
			statement.setString(5, hotel.getEmail());
			statement.setString(6, String.valueOf(hotel.getDailyRate()));
			statement.setString(7, hotel.getPassword());
			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Hotel hotel) {
		String sql = "DELETE FROM hotel where cnpj = ?";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement = connection.prepareStatement(sql);
			statement.setString(1, hotel.getCNPJ());

			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Hotel hotel) {
		String sql = "UPDATE site_reserva SET nome_do_hotel = ?, telefone = ?, cidade = ?, email = ?, diaria = ?";
		sql += ", WHERE cnpj = ?";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement = connection.prepareStatement(sql);
			statement.setString(1, hotel.getName());
			statement.setString(2, hotel.getPhone());
			statement.setString(3, hotel.getCity());
			statement.setString(4, hotel.getEmail());
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
		return null;
	}
}
