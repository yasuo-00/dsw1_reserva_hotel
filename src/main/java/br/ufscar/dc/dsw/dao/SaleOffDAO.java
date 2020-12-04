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
	
	public SaleOff getSaleOff(String hotelCNPJ, String bookingSiteURL, java.util.Date initialDate, java.util.Date finalDate) {
		String sql = "SELECT * FROM sale_off s where s.hotel_cnpj = ?, s.booking_site_url = ?, s.initial_date = ?, s.final_date = ?";
		SaleOff saleOff=null;

		try {
			Connection connectionection = this.getConnection();
			PreparedStatement statement = connectionection.prepareStatement(sql);

			statement = connectionection.prepareStatement(sql);
			statement.setString(1, hotelCNPJ);
			statement.setString(2, bookingSiteURL);
			statement.setDate(3, new java.sql.Date(initialDate.getTime()));
			statement.setDate(4, new java.sql.Date(finalDate.getTime()));
			
			ResultSet resultSet = statement.executeQuery(sql);
			double discount = resultSet.getDouble("discount");
			saleOff = new SaleOff(hotelCNPJ, bookingSiteURL, initialDate, finalDate, discount);

			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return saleOff;
	}

	public void insert(SaleOff saleOff) {
		String sql = "INSERT INTO sale_off(hotel_cnpj, booking_site_url, initial_date, final_date, discount) VALUES(?,?,?,?,?)";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement = connection.prepareStatement(sql);
			statement.setString(1, saleOff.getHotelCNPJ());
			statement.setString(2, saleOff.getBookingSiteURL());
			statement.setDate(3, new java.sql.Date(saleOff.getInitialDate().getTime()));
			statement.setDate(4, new java.sql.Date(saleOff.getFinalDate().getTime()));
			statement.setDouble(5, saleOff.getDiscount());
			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(SaleOff saleOff) {
		String sql = "DELETE FROM sale_off where hotel_cnpj = ?, booking_site_url = ?, initial_date = ?, final_date = ?";

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

			String sql = "SELECT * from sale_off";

			try {
				Connection connection = this.getConnection();
				Statement statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					String hotelCNPJ = resultSet.getString("hotel_cnpj");
					String bookingSiteURL = resultSet.getString("booking_site_url");
					int discount = resultSet.getInt("discount");
					Date initialDate = resultSet.getDate("initial_date");
					Date finalDate = resultSet.getDate("final_date");
					SaleOff saleOff = new SaleOff(hotelCNPJ, bookingSiteURL, initialDate, finalDate, discount);
					saleOffList.add(saleOff);
				}

				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return saleOffList;
		}
		
		public List<SaleOff> listAllOffHotel(String cnpj) {
			List<SaleOff> saleOffList = new ArrayList<SaleOff>();

			String sql = "SELECT * from sale_off where hotel_cnpj=?";

			try {
				Connection connection = this.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, cnpj);

				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {
					String bookingSiteURL = resultSet.getString("booking_site_url");
					int discount = resultSet.getInt("discount");
					Date initialDate = resultSet.getDate("initial_date");
					Date finalDate = resultSet.getDate("final_date");
					SaleOff saleOff = new SaleOff(cnpj, bookingSiteURL, initialDate, finalDate, discount);
					saleOffList.add(saleOff);
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
