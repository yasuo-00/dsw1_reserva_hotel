package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.classes.BookingSite;

public interface IBookingSiteService {
	BookingSite findById(Long id);
	
	List<BookingSite> findAll();
	
	void save(BookingSite bookingSite);
	
	void remove(Long id);
}
