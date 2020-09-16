package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PhoneNumber {

	@Id
	private String label;
	private String phoneNumber;

	private String name;

	public PhoneNumber() {
		super();
	}

	public PhoneNumber(String label, String phoneNumber, String name) {
		super();
		this.label = label;
		this.phoneNumber = phoneNumber;
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
