package com.rojas.countryAPI.service;

import com.rojas.countryAPI.model.Country;
import com.rojas.countryAPI.repository.CountryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService implements ICountryService {

	@Autowired
	private CountryRepository repository;

	@Override
	public List<Country> findAll() {
		return (List<Country>) repository.findAll();
	}

	@Override
	public Country findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Country not found: " + id));
	}

	@Override
	public Country addCountry(Country country) {
		return repository.save(country);
	}

	@Override
	public Country updateCountry(Country country) {
		Country existing = findById(country.getId());
		existing.setName(country.getName());
		existing.setLanguage(country.getLanguage());
		return repository.save(existing);
	}

	@Override
	public void deleteCountry(Long id) {
		findById(id);
		repository.deleteById(id);
	}
}
