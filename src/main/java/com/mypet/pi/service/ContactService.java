package com.mypet.pi.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypet.pi.modal.Contact;
import com.mypet.pi.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	public List<Contact> findAllContact() {

		List<Contact> findAll = this.contactRepository.findByOrderByCreationDateDesc();
		return findAll;
	}

	public Contact getContactBy(Long id) {
		return this.contactRepository.findById(id).get();
	}

	public void create(Contact contact) {

		if (Objects.isNull(contact.getUrlImage()) || contact.getUrlImage().isEmpty()) {
			contact.setUrlImage("http://www.biotecdermo.com.br/wp-content/uploads/2016/10/sem-imagem-2.jpg");
		}

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
		return this.contactRepository.findByNameStartingWithIgnoreCaseOrBreedStartingWithIgnoreCase(name, breed);
	}

	public List<Contact> getContactByNameAndUserId(String name, Long userId) {
		String breed = name;
		return this.contactRepository.findByUserIdAndNameStartingWithIgnoreCaseOrBreedStartingWithIgnoreCase(userId,
				name, breed);
	}

}
