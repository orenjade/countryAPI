package com.rojas.countryAPI.controller;

import com.rojas.countryAPI.model.Country;
import com.rojas.countryAPI.service.ICountryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

	@Autowired
	private ICountryService countryService;

	@RequestMapping("/all-users")
	public List<Country> getAllUser() {
		return countryService.findAll();
	}

	@GetMapping("/api/countries")
	public List<Country> list() {
		return countryService.findAll();
	}

	@GetMapping("/api/countries/{id}")
	public Country get(@PathVariable Long id) {
		return countryService.findById(id);
	}

	@PostMapping("/api/countries")
	public Country create(@RequestBody Country country) {
		country.setId(0);
		return countryService.addCountry(country);
	}

	@PutMapping("/api/countries/{id}")
	public Country update(@PathVariable Long id, @RequestBody Country country) {
		country.setId(id);
		return countryService.updateCountry(country);
	}

	@DeleteMapping("/api/countries/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		countryService.deleteCountry(id);
		return ResponseEntity.noContent().build();
	}
}
