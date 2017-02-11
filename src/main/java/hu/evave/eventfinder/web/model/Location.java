package hu.evave.eventfinder.web.model;

import java.math.BigDecimal;

public class Location {

	private Long id;
	private String name;
	private String country;
	private String city;
	private String zipCode;
	private String address;
	private BigDecimal lat;
	private BigDecimal lon;

	public Location() {
	}

	public Location(String name, String country, String city, String zipCode, String address, BigDecimal lat,
			BigDecimal lon) {
		this.name = name;
		this.country = country;
		this.city = city;
		this.zipCode = zipCode;
		this.address = address;
		this.lat = lat;
		this.lon = lon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLon() {
		return lon;
	}

	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}

	public Long getId() {
		return id;
	}

}
