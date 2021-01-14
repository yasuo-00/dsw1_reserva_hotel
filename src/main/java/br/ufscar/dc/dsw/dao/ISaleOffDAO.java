package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.ufscar.dc.dsw.classes.SaleOff;
import br.ufscar.dc.dsw.classes.User;

@SuppressWarnings("unchecked")
public interface ISaleOffDAO extends CrudRepository<SaleOff, Long>{
	
	SaleOff findById(long id);

	List<SaleOff> findAll();
	

	SaleOff save(SaleOff saleOff);

	void deleteById(Long id);
	
	
	//fazer listagem de saleOff por hotel
	@Query("SELECT s FROM SaleOff s WHERE s.hotel.id = :hotelId")
	public List<SaleOff> getSaleOffByHotel(@Param("hotelId") Long hotelId);
	//fazer listagem de saleOff por bookingSite
	@Query("SELECT s FROM SaleOff s WHERE s.bookingSite.id = :siteId")
	public List<SaleOff> getSaleOffByBookingSite(@Param("siteId") Long siteId);
	

}
