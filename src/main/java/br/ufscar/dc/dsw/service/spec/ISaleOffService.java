package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.classes.SaleOff;

public interface ISaleOffService {
	SaleOff findById(Long id);
	
	List<SaleOff> findAll();
	
	void save(SaleOff saleOff);
	
	void remove(Long id);
	
	public List<SaleOff> findAllByHotel(Long hotelId);
	
	public List<SaleOff> findAllByBookingSite(Long siteId);
}
