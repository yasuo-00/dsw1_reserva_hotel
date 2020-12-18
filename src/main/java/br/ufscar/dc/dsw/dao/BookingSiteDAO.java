package br.ufscar.dc.dsw.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.ufscar.dc.dsw.classes.BookingSite;

public class BookingSiteDAO extends GenericDAO<BookingSite, Long> {
	public BookingSite find(Long id) {
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		BookingSite bookingSite = em.find(BookingSite.class, id);
		tx.commit();
		em.close();
		return bookingSite;
	}
	
	@Override
	public void save(BookingSite bookingSite) {
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(bookingSite);
		tx.commit();
		em.close();
	}
	
	@Override
	public void update(BookingSite bookingSite) {
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(bookingSite);
		em.close();
	}
	
	public void delete(Long id) {
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		BookingSite bookingSite = em.getReference(BookingSite.class, id);
		tx.begin();
		em.remove(bookingSite);
		tx.commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BookingSite> findAll() {
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query q = em.createQuery("Select u FROM bookingSite u");
		List<BookingSite> list = q.getResultList();
		tx.commit();
		em.close();
		return list;
	}
	
	/**

	public BookingSite getByURL(String url) {
		String sql = "SELECT * FROM booking_site WHERE url=?;";
		BookingSite bookingSite = null;

		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, url);

			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			String name = resultSet.getString("name");
			String phone = resultSet.getString("phone");
			bookingSite = new BookingSite(url, name, phone);

			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return bookingSite;
	}


	public List<BookingSite> listAllByURL() {
		List<BookingSite> bookingSiteList = new ArrayList<BookingSite>();

		String sql = "SELECT * from booking_site ORDER BY url;";

		try {
			Connection connection = this.getConnection();
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);
			if (!resultSet.next()) {
				BookingSite bookingsite = new BookingSite();
				bookingSiteList.add(bookingsite);
			} else {

				do {
					String url = resultSet.getString("url");
					String name = resultSet.getString("name");
					String phone = resultSet.getString("phone");
					BookingSite bookingSite = new BookingSite(url, name, phone);
					bookingSiteList.add(bookingSite);
				} while (resultSet.next());
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return bookingSiteList;
	}**/
}
