package com.mypet.pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypet.pi.modal.Contact;
import com.mypet.pi.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	public List<Contact> findAllContact() {

		List<Contact> findAll = this.contactRepository.findAll();
		return findAll;
	}

	public Contact getContactBy(Long id) {
		return this.contactRepository.findById(id).get();
	}

	public void create(Contact contact) {

		this.contactRepository.save(contact);

	}

	public void delete(Long id) {
		this.contactRepository.deleteById(id);
	}

	public void deleteAll() {
		this.contactRepository.deleteAll();
	}

	public List<Contact> getContactByIdUser(Long idUser) {
		return this.contactRepository.findByUserId(idUser);

	}

	public List<Contact> getContactByName(String name) {
		String breed = name;
		return  this.contactRepository.findByNameStartingWithIgnoreCaseOrBreedStartingWithIgnoreCase(name, breed);
	}
	
}
