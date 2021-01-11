package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.classes.Hotel;

public interface IHotelService {
	Hotel findById(Long id);
	
	List<Hotel> findAll();
	
	void save(Hotel hotel);
	
	void remove(Long id);
	
	public List<Hotel> findAllByCity(String city);
	

}
