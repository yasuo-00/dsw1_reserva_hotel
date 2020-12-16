package br.ufscar.dc.dsw.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.ufscar.dc.dsw.classes.User;

public class UserDAO extends GenericDAO<User> {

	@Override
	public User find(Long id) {
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		User user = em.find(User.class, id);
		tx.commit();
		em.close();
		return user;
	}
	
	@Override
	public void save(User user) {
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(user);
		tx.commit();
		em.close();
	}
	
	@Override
	public void update(User user) {
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(user);
		em.close();
	}
	
	@Override
	public void delete(Long id) {
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		User user = em.getReference(User.class, id);
		tx.begin();
		em.remove(user);
		tx.commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query q = em.createQuery("Select u FROM user u");
		List<User> list = q.getResultList();
		tx.commit();
		em.close();
		return list;
	}
	/**
	public List<User> listAllByURL() {

		List<User> usersList = new ArrayList<>();

		String sql = "SELECT * from User u WHERE u.booking_site_url IS NOT NULL ORDER BY u.booking_site_url;";

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

		String sql = "SELECT * from User u WHERE u.hotel_cnpj IS NOT NULL ORDER BY u.hotel_cnpj;";

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

		String sql = "SELECT * from user WHERE email = ?;";

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

		String sql = "SELECT * from user WHERE hotel_cnpj = ?;";

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

		String sql = "SELECT * from user WHERE booking_site_url = ?;";

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

	}**/

}
