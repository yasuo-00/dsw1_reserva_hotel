package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.classes.User;
import br.ufscar.dc.dsw.dao.IUserDAO;
import br.ufscar.dc.dsw.service.spec.IUserService;

@Service
@Transactional(readOnly = false)
public class UserService implements IUserService{
	
	@Autowired
	IUserDAO dao;
	
	public void save(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		dao.save(user);
	}

	public void remove(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public User findById(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<User> findAll() {
		return dao.findAll();
	}
	
}
