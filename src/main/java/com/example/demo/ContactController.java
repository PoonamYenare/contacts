package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private AddressBook addressBook;

	@PostMapping("/add")
	public ResponseEntity<Void> addContact(@RequestBody Contact contact) {
		addressBook.addContact(contact);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/delete/{name}")
	public void deleteContact(@PathVariable("name") String name) {
		addressBook.deleteContact(name);
	}

	@PutMapping(path = "/update/{name}")
	public ResponseEntity<Contact> updateContact(@PathVariable("name") String name, Contact contact) {
		return addressBook.updateContact(name, contact);
	}

	@GetMapping(path = "/getByName/{name}")
	public List<Contact> findContactByName(@PathVariable("name") String name) {
		return addressBook.searchByName(name);

	}

	@GetMapping(path = "/getByOrganisation/{organisation}")
	public List<Contact> findContactByOrganisation(@PathVariable("organisation") String organisation) {
		return addressBook.searchByOrganisation(organisation);
	}

}
