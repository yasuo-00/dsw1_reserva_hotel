package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.classes.SaleOff;
import br.ufscar.dc.dsw.classes.User;
import br.ufscar.dc.dsw.dao.ISaleOffDAO;
import br.ufscar.dc.dsw.service.spec.ISaleOffService;


@Service
@Transactional(readOnly = false)
public class SaleOffService implements ISaleOffService{
	@Autowired
	ISaleOffDAO dao;
	
	public void save(SaleOff saleOff) {
		dao.save(saleOff);
	}

	public void remove(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public SaleOff findById(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<SaleOff> findAll() {
		return dao.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<SaleOff> findAllByHotel(Long hotelId){
		return dao.getSaleOffByHotel(hotelId);
	}
	
	@Transactional(readOnly = true)
	public List<SaleOff> findAllByBookingSite(Long siteId){
		return dao.getSaleOffByBookingSite(siteId);
	}
	

}
