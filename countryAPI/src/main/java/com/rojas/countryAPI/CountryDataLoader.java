package com.rojas.countryAPI;

import com.rojas.countryAPI.model.Country;
import com.rojas.countryAPI.repository.CountryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CountryDataLoader implements CommandLineRunner {

	private final CountryRepository repository;

	public CountryDataLoader(CountryRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... args) {
		String[][] rows = {
			{"United States/Canada", "English"},
			{"Australia", "English"},
			{"Belgique", "French"},
			{"België", "Dutch"},
			{"Brazil", "Portuguese"},
			{"Ceska Republika", "Czech"},
			{"China", "Chinese"},
			{"Danmark", "Danish"},
			{"Deutschland", "German"},
			{"Espana", "Spanish"},
			{"Finland", "Finnish"},
			{"France", "French"},
			{"Hong Kong", "Chinese"},
			{"India", "Hindi"},
			{"Ireland", "English"},
			{"Italia", "Italian"},
			{"Japan", "Japanese"},
			{"Korea", "Korean"},
			{"Magyarorszag", "Hungarian"},
			{"Mexico", "Spanish"},
			{"Nederland", "Dutch"},
			{"New Zealand", "English"},
			{"Norge", "Norwegian"},
			{"Osterreich", "German"},
			{"Polska", "Polish"},
			{"Portugal", "Portuguese"},
			{"Russia", "Russian"},
			{"Singapore", "English"},
			{"South Africa", "English"},
			{"Sverige", "Swedish"},
			{"Switzerland", "German"},
			{"Taiwan", "Chinese"},
			{"Thailand", "Thai"},
			{"United Kingdom", "English"}
		};

		for (String[] row : rows) {
			if (!repository.existsByNameIgnoreCase(row[0])) {
				repository.save(new Country(0, row[0], row[1]));
			}
		}
	}
}
