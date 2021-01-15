package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.ufscar.dc.dsw.classes.Hotel;
import br.ufscar.dc.dsw.classes.SaleOff;
import br.ufscar.dc.dsw.service.spec.ISaleOffService;


@RestController
public class SaleOffRestController {
	
	@Autowired
	ISaleOffService saleOffService;
	
	private boolean isJSONValid(String jsonInString) {
		try {
			return new ObjectMapper().readTree(jsonInString) != null;
		} catch (IOException e) {
			return false;
		}
	}
	
	
	@GetMapping(path = "/saleOffs")
	public ResponseEntity<List<SaleOff>> list() {
		List<SaleOff> list = saleOffService.findAll();

		if (list.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(list);
	}

	@GetMapping(path = "/saleOffs/{id}")
	public ResponseEntity<SaleOff> list(@PathVariable("id") Long id) {
		SaleOff saleOff = saleOffService.findById(id);
		if (saleOff == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(saleOff);
	}
	
	@GetMapping(path = "/saleOffs/bookingSite/{id}")
	public ResponseEntity<List<SaleOff>> listByBookingSite(@PathVariable("id") Long id){
		List<SaleOff> list = saleOffService.findAllByBookingSite(id);
		
		if (list.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(list);
	}
	
	@GetMapping(path = "/saleOffs/hotel/{id}")
	public ResponseEntity<List<SaleOff>> listByHotel(@PathVariable("id") Long id){
		List<SaleOff> list = saleOffService.findAllByHotel(id);
		
		if (list.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(list);
	}
}

