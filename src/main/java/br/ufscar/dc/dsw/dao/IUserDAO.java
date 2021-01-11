package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.ufscar.dc.dsw.classes.User;

@SuppressWarnings("unchecked")
public interface IUserDAO extends CrudRepository<User, Long> {

	User findById(long id);

	List<User> findAll();

	User save(User user);

	void deleteById(Long id);

	@Query("SELECT u FROM User u WHERE u.email = :email")
	public User getUserByEmail(@Param("email") String email);

}
