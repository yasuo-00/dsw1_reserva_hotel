package br.ufscar.dc.dsw.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.classes.BookingSite;

@SuppressWarnings("unchecked")
public interface IBookingSiteDAO extends CrudRepository<BookingSite, Long> {

	BookingSite findById(long id);

	List<BookingSite> findAll();

	BookingSite save(BookingSite bookingSite);

	void deleteById(Long id);

}
