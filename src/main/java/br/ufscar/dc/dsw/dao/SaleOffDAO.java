package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.classes.SaleOff;

public class SaleOffDAO extends GenericDAO<SaleOff>{
	
	private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public SaleOff getSaleOff(String hotelCNPJ, String bookingSiteURL, LocalDate initialDate, LocalDate finalDate) {
		String sql = "SELECT * FROM sale_off s where s.hotel_cnpj = ? AND s.booking_site_url = ? AND s.initial_date = ? AND s.final_date = ? ";
		SaleOff saleOff=null;

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			
			statement.setString(1, hotelCNPJ);
			statement.setString(2, bookingSiteURL);
			statement.setString(3, initialDate.toString());
			statement.setString(4, finalDate.toString());
			
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
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

			statement.setString(1, saleOff.getHotelCnpj());
			statement.setString(2, saleOff.getBookingSiteUrl());
			statement.setDate(3, java.sql.Date.valueOf(saleOff.getInitialDate()));
			statement.setDate(4, java.sql.Date.valueOf(saleOff.getFinalDate()));
			statement.setDouble(5, saleOff.getDiscount());
			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(SaleOff saleOff) {
		String sql = "DELETE FROM sale_off where hotel_cnpj = ? AND booking_site_url = ? AND initial_date = ? AND final_date = ?";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, saleOff.getHotelCnpj());
			statement.setString(2, saleOff.getBookingSiteUrl());
			statement.setDate(3, java.sql.Date.valueOf(saleOff.getInitialDate()));
			statement.setDate(4, java.sql.Date.valueOf(saleOff.getFinalDate()));

			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(SaleOff saleOff) {
		String sql = "UPDATE sale_off SET discount = ? WHERE hotel_cnpj = ? AND booking_site_url = ? AND initial_date = ? AND final_date = ?";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setDouble(1, saleOff.getDiscount());
			statement.setString(2, saleOff.getHotelCnpj());
			statement.setString(3, saleOff.getBookingSiteUrl());
			statement.setDate(4, java.sql.Date.valueOf(saleOff.getInitialDate()));
			statement.setDate(5, java.sql.Date.valueOf(saleOff.getFinalDate()));
			
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
					String initialDate = resultSet.getString("initial_date");
					LocalDate formattedInitialDate = LocalDate.parse(initialDate);
					String finalDate = resultSet.getString("final_date");
					LocalDate formattedFinalDate = LocalDate.parse(finalDate);
					SaleOff saleOff = new SaleOff(hotelCNPJ, bookingSiteURL, formattedInitialDate, formattedFinalDate, discount);
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
		
		public List<SaleOff> listAllOfHotel(String cnpj) {
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
					String initialDate = resultSet.getString("initial_date");
					LocalDate formattedInitialDate = LocalDate.parse(initialDate);
					String finalDate = resultSet.getString("final_date");
					LocalDate formattedFinalDate = LocalDate.parse(finalDate);
					SaleOff saleOff = new SaleOff(cnpj, bookingSiteURL, formattedInitialDate, formattedFinalDate, discount);
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
