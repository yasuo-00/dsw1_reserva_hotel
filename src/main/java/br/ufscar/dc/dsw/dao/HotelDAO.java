package br.ufscar.dc.dsw.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.ufscar.dc.dsw.classes.Hotel;

public class HotelDAO extends GenericDAO<Hotel, String> {
	
	@Override
	public Hotel find(String id) {
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Hotel hotel = em.find(Hotel.class, id);
		tx.commit();
		em.close();
		return hotel;
	}
	
	@Override
	public void save(Hotel hotel) {
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(hotel);
		tx.commit();
		em.close();
	}
	
	@Override
	public void update(Hotel hotel) {
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(hotel);
		em.close();
	}
	
	@Override
	public void delete(String id) {
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		Hotel hotel = em.getReference(Hotel.class, id);
		tx.begin();
		em.remove(hotel);
		tx.commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Hotel> findAll() {
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query q = em.createQuery("Select u FROM hotel u");
		List<Hotel> list = q.getResultList();
		tx.commit();
		em.close();
		return list;
	}
	
/**
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

	
	public void update(Hotel hotel, Hotel hotel) {
		String sql = "UPDATE hotel SET name = ?, phone = ?, city = ?, daily_rate = ? WHERE cnpj = ?;";
		String sqlUser = "UPDATE hotel SET email=?, password=? WHERE hotel_cnpj = ?;";

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			PreparedStatement userStatement = connection.prepareStatement(sqlUser);

			statement = connection.prepareStatement(sql);
			statement.setString(1, hotel.getName());
			statement.setString(2, hotel.getPhone());
			statement.setString(3, hotel.getCity());
			statement.setString(4, String.valueOf(hotel.getDailyRate()));
			statement.setString(5, String.valueOf(hotel.getCnpj()));

			userStatement.setString(1, hotel.getEmail());
			userStatement.setString(2, hotel.getPassword());
			userStatement.setString(3, String.valueOf(hotel.getCnpj()));
			statement.executeUpdate();
			userStatement.executeUpdate();

			statement.close();
			userStatement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

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
	**/
}
