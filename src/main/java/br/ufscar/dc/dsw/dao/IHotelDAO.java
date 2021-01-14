package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.ufscar.dc.dsw.classes.Hotel;
import br.ufscar.dc.dsw.classes.User;

public interface IHotelDAO extends CrudRepository<Hotel, Long> {
	
	Hotel findById(long id);

	List<Hotel> findAll();

	@SuppressWarnings("unchecked")
	Hotel save(Hotel hotel);

	void deleteById(Long id);
	
	@Query("SELECT h FROM Hotel h WHERE h.city = :city")
	public List<Hotel> getHotelByCity(@Param("city") String city);
	
}
