package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {

	@Query("select c from Contact c where c.name = ?1")
	List<Contact> findByName(String name);

	@Query("select c from Contact c where c.organisation = ?1")
	List<Contact> findByOrganisation(String organisation);
}
