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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.ufscar.dc.dsw.classes.BookingSite;
import br.ufscar.dc.dsw.service.spec.IBookingSiteService;

@RestController
public class BookingSiteRestController {

	@Autowired
	IBookingSiteService bookingSiteService;

	private boolean isJSONValid(String jsonInString) {
		try {
			return new ObjectMapper().readTree(jsonInString) != null;
		} catch (IOException e) {
			return false;
		}
	}

	private void parse(BookingSite bookingSite, JSONObject json) {

		Object id = json.get("id");
		if (id != null) {
			if (id instanceof Integer) {
				bookingSite.setId(((Integer) id).longValue());
			} else {
				bookingSite.setId(((Long) id));
			}
		}

		bookingSite.setEmail((String) json.get("email"));
		bookingSite.setPassword((String) json.get("password"));
		bookingSite.setName((String) json.get("name"));
		bookingSite.setPhone((String) json.get("phone"));
		bookingSite.setUrl((String) json.get("url"));
		bookingSite.setRole("BOOKINGSITE");

	}

	@GetMapping(path = "/bookingSites")
	public ResponseEntity<List<BookingSite>> list() {
		List<BookingSite> list = bookingSiteService.findAll();

		if (list.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(list);
	}

	@GetMapping(path = "/bookingSites/{id}")
	public ResponseEntity<BookingSite> list(@PathVariable("id") Long id) {
		BookingSite bookingSite = bookingSiteService.findById(id);
		if (bookingSite == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(bookingSite);
	}
	
	@PostMapping(path = "/bookingSites")
	@ResponseBody
	public ResponseEntity<BookingSite> cria(@RequestBody JSONObject json) {
		try {
			if (isJSONValid(json.toString())) {
				BookingSite bookingSite = new BookingSite();
				parse(bookingSite, json);
				bookingSiteService.save(bookingSite);
				return ResponseEntity.ok(bookingSite);
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
	}

	@PutMapping(path = "/bookingSites/{id}")
	public ResponseEntity<BookingSite> update(@PathVariable("id") Long id, @RequestBody JSONObject json) {
		try {
			if (isJSONValid(json.toString())) {
				BookingSite bookingSite = bookingSiteService.findById(id);
				if (bookingSite == null) {
					return ResponseEntity.notFound().build();
				} else {
					parse(bookingSite, json);
					bookingSiteService.save(bookingSite);
					return ResponseEntity.ok(bookingSite);
				}
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
	}

	@DeleteMapping(path = "/bookingSites/{id}")
	public ResponseEntity<Boolean> remove(@PathVariable("id") long id) {

		BookingSite bookingSite = bookingSiteService.findById(id);
		if (bookingSite == null) {
			return ResponseEntity.notFound().build();
		} else {
			bookingSiteService.remove(id);
			return ResponseEntity.noContent().build();
		}
	}

}
