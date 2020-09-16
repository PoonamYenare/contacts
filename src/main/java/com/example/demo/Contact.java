package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Contact {
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	private String name; 
	private String organisation; 
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "name", referencedColumnName="name")
	private List<PhoneNumber> phoneNumbers; 
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "name", referencedColumnName="name")
	private List<Address> addresses; 

	public Contact(String name, String organisation, List<PhoneNumber> phoneNumbers, List<Address> addresses) {
		super();
		this.name = name;
		this.organisation = organisation;
		this.phoneNumbers = phoneNumbers;
		this.addresses = addresses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public void addPhoneNumber(PhoneNumber phoneNumber) {
		if (this.phoneNumbers == null) {
			this.phoneNumbers = new ArrayList<PhoneNumber>();
		}
		this.phoneNumbers.add(phoneNumber);
	}

	public void addAddress(Address address) {
		if (this.addresses == null) {
			this.addresses = new ArrayList<Address>();
		}
		this.addresses.add(address);
	}

}
