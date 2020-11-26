package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.classes.SaleOff;

public class SaleOffDAO extends GenericDAO<SaleOff>{

	public void insert(SaleOff saleOff) {
		String sql = "INSERT INTO saleOff(hotel_cnpj, booking_site_url, initial_date, final_date, discount) VALUES(?,?,?,?,?)";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement = connection.prepareStatement(sql);
			statement.setString(1, saleOff.getHotelCNPJ());
			statement.setString(2, saleOff.getBookingSiteURL());
			statement.setDate(3, new java.sql.Date(saleOff.getInitialDate().getTime()));
			statement.setDate(4, new java.sql.Date(saleOff.getFinalDate().getTime()));
			statement.setDouble(4, saleOff.getDiscount());
			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(SaleOff saleOff) {
		String sql = "DELETE FROM saleOff where cnpj = ?";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement = connection.prepareStatement(sql);
			statement.setString(1, saleOff.getHotelCNPJ());
			statement.setString(2, saleOff.getBookingSiteURL());
			statement.setDate(3, new java.sql.Date(saleOff.getInitialDate().getTime()));
			statement.setDate(4, new java.sql.Date(saleOff.getFinalDate().getTime()));

			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(SaleOff saleOff) {
		String sql = "UPDATE discount = ?";
		sql += ", WHERE hotel_cnpj = ?, booking_site_url = ?, initial_date = ?, final_date = ?";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement = connection.prepareStatement(sql);
			statement.setDouble(1, saleOff.getDiscount());
			statement.setString(2, saleOff.getHotelCNPJ());
			statement.setString(3, saleOff.getBookingSiteURL());
			statement.setDate(4, new java.sql.Date(saleOff.getInitialDate().getTime()));
			statement.setDate(5, new java.sql.Date(saleOff.getFinalDate().getTime()));
			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	
		public List<SaleOff> listAll() {
			List<SaleOff> saleOffList = new ArrayList<>();

			String sql = "SELECT * from SaleOff";

			try {
				Connection connection = this.getConnection();
				Statement statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					String hotelCNPJ = resultSet.getString("cnpj");
					String bookingSiteURL = resultSet.getString("hotel_name");
					int discount = resultSet.getInt("discount");
					Date initialDate = resultSet.getDate("initialDate");
					Date finalDate = resultSet.getDate("finalDate");
					SaleOff livro = new SaleOff(hotelCNPJ, bookingSiteURL, initialDate, finalDate, discount);
					saleOffList.add(livro);
				}

				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return saleOffList;
		}
}
