package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.classes.BookingSite;
import br.ufscar.dc.dsw.dao.IBookingSiteDAO;
import br.ufscar.dc.dsw.service.spec.IBookingSiteService;

@Service
@Transactional(readOnly = false)
public class BookingSiteService implements IBookingSiteService{
	@Autowired
	IBookingSiteDAO dao;
	
	public void save(BookingSite bookingSite) {
		dao.save(bookingSite);
	}

	public void remove(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public BookingSite findById(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<BookingSite> findAll() {
		return dao.findAll();
	}
}
