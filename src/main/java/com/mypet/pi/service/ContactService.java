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

	public List<Contact> allContact() {

		return this.contactRepository.findAll();
	}
	
	public Contact getContactBy(Long id) {
		return this.contactRepository.findById(id).get();
	}
	
	public void create(Contact contact) {
		
		this.contactRepository.save(contact);
	}
	
}
