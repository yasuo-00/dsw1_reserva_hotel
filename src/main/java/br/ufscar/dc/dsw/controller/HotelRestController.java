package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.ufscar.dc.dsw.classes.Hotel;
import br.ufscar.dc.dsw.classes.Hotel;
import br.ufscar.dc.dsw.service.spec.IHotelService;

@RestController
public class HotelRestController {

	@Autowired
	IHotelService hotelService;

	private boolean isJSONValid(String jsonInString) {
		try {
			return new ObjectMapper().readTree(jsonInString) != null;
		} catch (IOException e) {
			return false;
		}
	}

	private void parse(Hotel hotel, JSONObject json) {

		Object id = json.get("id");
		if (id != null) {
			if (id instanceof Integer) {
				hotel.setId(((Integer) id).longValue());
			} else {
				hotel.setId(((Long) id));
			}
		}

		hotel.setCnpj((String) json.get("cnpj"));
		hotel.setEmail((String) json.get("email"));
		hotel.setPassword((String) json.get("password"));
		hotel.setName((String) json.get("name"));
		hotel.setPhone((String) json.get("phone"));
		hotel.setCity((String) json.get("city"));
		Double dailyRate = (Double) json.get("dailyRate");
		hotel.setDailyRate(dailyRate);
		hotel.setRole("HOTEL");

	}

	@GetMapping(path = "/hotels")
	public ResponseEntity<List<Hotel>> list() {
		List<Hotel> list = hotelService.findAll();

		if (list.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(list);
	}

	@GetMapping(path = "/hotels/{id}")
	public ResponseEntity<Hotel> list(@PathVariable("id") Long id) {
		Hotel hotel = hotelService.findById(id);
		if (hotel == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(hotel);
	}
	
	@PostMapping(path = "/hotels")
	@ResponseBody
	public ResponseEntity<Hotel> cria(@RequestBody JSONObject json) {
		try {
			if (isJSONValid(json.toString())) {
				Hotel hotel = new Hotel();
				parse(hotel, json);
				hotelService.save(hotel);
				return ResponseEntity.ok(hotel);
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
	}

	@PutMapping(path = "/hotels/{id}")
	public ResponseEntity<Hotel> update(@PathVariable("id") Long id, @RequestBody JSONObject json) {
		try {
			if (isJSONValid(json.toString())) {
				Hotel hotel = hotelService.findById(id);
				if (hotel == null) {
					return ResponseEntity.notFound().build();
				} else {
					parse(hotel, json);
					hotelService.save(hotel);
					return ResponseEntity.ok(hotel);
				}
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
	}

	@DeleteMapping(path = "/hotels/{id}")
	public ResponseEntity<Boolean> remove(@PathVariable("id") Long id) {

		Hotel hotel = hotelService.findById(id);
		if (hotel == null) {
			return ResponseEntity.notFound().build();
		} else {
			hotelService.remove(id);
			return ResponseEntity.noContent().build();
		}
	}

	@GetMapping(path = "/hotels/city/")
	public ResponseEntity<List<Hotel>> listAll() {
		List<Hotel> list = hotelService.findAll();

		if (list.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(list);
	}

	@GetMapping(path = "/hotels/city/{city}")
	public ResponseEntity<List<Hotel>> listByCity(@PathVariable(name = "city") String city) {
		List<Hotel> list = hotelService.findAllByCity(city);
		if (list.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(list);
	}

}
