package com.rojas.countryAPI.service;

import com.rojas.countryAPI.model.Country;
import java.util.List;

public interface ICountryService {
	List<Country> findAll();
	Country findById(Long id);
	Country addCountry(Country country);
	Country updateCountry(Country country);
	void deleteCountry(Long id);
}
