package com.apex.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CUSTOMER")
public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	
	public Customer() {
		super();
	}

	public int getId() {
		return id;
	}

	@XmlElement(name = "ID")
	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	@XmlElement(name = "FIRSTNAME")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@XmlElement(name = "LASTNAME")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet() {
		return street;
	}

	@XmlElement(name = "STREET")
	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	@XmlElement(name = "CITY")
	public void setCity(String city) {
		this.city = city;
	}
}
