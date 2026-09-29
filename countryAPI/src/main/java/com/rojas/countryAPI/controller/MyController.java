package com.rojas.countryAPI.controller;

import com.rojas.countryAPI.model.Country;
import com.rojas.countryAPI.service.ICountryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

	@Autowired
	private ICountryService countryService;

	@GetMapping("/countries")
	public String findCountries(Model model) {
		var countries = (List<Country>) countryService.findAll();
		model.addAttribute("countries", countries);
		return "showCountries";
	}

	@GetMapping("/add-country")
	public String addCountry(Model model) {
		model.addAttribute("add country", new Country());
		return "addCountry";
	}

	@PostMapping("/add-country")
	public String addCountrySubmit(@ModelAttribute Country country, Model model) {
		model.addAttribute("country", country);
		countryService.addCountry(country);
		var countries = (List<Country>) countryService.findAll();
		model.addAttribute("countries", countries);
		return "showCountries";
	}

	@GetMapping("/edit-country/{id}")
	public String editCountry(@PathVariable Long id, Model model) {
		model.addAttribute("country", countryService.findById(id));
		return "editCountry";
	}

	@PostMapping("/edit-country")
	public String editCountrySubmit(@ModelAttribute Country country) {
		countryService.updateCountry(country);
		return "redirect:/countries";
	}

	@PostMapping("/delete-country/{id}")
	public String deleteCountry(@PathVariable Long id) {
		countryService.deleteCountry(id);
		return "redirect:/countries";
	}
}
