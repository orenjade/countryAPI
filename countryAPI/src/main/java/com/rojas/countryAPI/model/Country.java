package com.rojas.countryAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "countries")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String language;

	public Country() {
	}

	public Country(long id, String name, String language) {
		this.id = id;
		this.name = name;
		this.language = language;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Country{");
		sb.append("id=").append(id);
		sb.append(", name='").append(name).append('\'');
		sb.append(", language=").append(language);
		sb.append('}');
		return sb.toString();
	}
}
