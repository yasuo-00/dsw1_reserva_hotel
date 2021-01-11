package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.classes.User;

public interface IUserService {
	User findById(Long id);

	List<User> findAll();

	void save(User user);

	void remove(Long id);
}
