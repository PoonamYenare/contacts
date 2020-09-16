package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AddressBook {

	@Autowired
	private ContactRepository repo;

	public AddressBook() {
		super();
	}

	public Contact addContact(Contact contact) {
		return repo.save(contact);
	}

	public void deleteContact(String name) {
		repo.deleteById(name);
	}

	public ResponseEntity<Contact> updateContact(String name, Contact contact) {
		//Optional<Contact> contactData = repo.findById(name);
	
		//if (contactData.isPresent()) {
			Contact c = repo.findById(name).get();
			c.setName(contact.getName());
			c.setOrganisation(contact.getOrganisation());
			c.setAddresses(contact.getAddresses());
			c.setPhoneNumbers(contact.getPhoneNumbers());
			System.out.println(c.getName()+ c.getOrganisation()+ c.getAddresses() + c.getPhoneNumbers());
			return new ResponseEntity<>(repo.save(c), HttpStatus.OK);
		//} else {
			//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		//}
	}

	public List<Contact> searchByName(String name) {
		return repo.findByName(name);
	}

	public List<Contact> searchByOrganisation(String organisation) {
		return repo.findByOrganisation(organisation);
	}
}
