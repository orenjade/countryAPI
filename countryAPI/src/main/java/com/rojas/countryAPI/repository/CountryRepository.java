package com.rojas.countryAPI.repository;

import com.rojas.countryAPI.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
	boolean existsByNameIgnoreCase(String name);
}
