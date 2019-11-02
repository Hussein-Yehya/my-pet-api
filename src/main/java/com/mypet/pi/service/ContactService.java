package com.mypet.pi.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypet.pi.modal.Contact;
import com.mypet.pi.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	public List<Contact> findAllContact() {

		return this.contactRepository.findByActiveTrueOrderByCreationDateDesc();
	}

	public Contact getContactBy(Long id) {
		Optional<Contact> contactOptional = this.contactRepository.findById(id);
		if (contactOptional.isPresent()) {
			return contactOptional.get();
		}
		return null;
	}

	public void create(Contact contact) {

		if (Objects.isNull(contact.getUrlImage()) || contact.getUrlImage().isEmpty()) {
			contact.setUrlImage("https://lojaesporteespetacular.com.br/images/sem_foto.png");
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
		String petRecommendedTo = name;
		return this.contactRepository
				.findByUserIdAndNameStartingWithIgnoreCaseOrBreedStartingWithIgnoreCaseOrPetRecommendedToStartingWithIgnoreCase(
						userId, name, breed, petRecommendedTo);
	}

	public boolean pauseContact(Long id) {

		Optional<Contact> contactOptional = this.contactRepository.findById(id);

		if (contactOptional.isPresent()) {
			Contact contact = contactOptional.get();
			this.changeStatusContact(contact, false);

			this.contactRepository.save(contact);

			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

	public boolean undoneContact(Long id) {

		Optional<Contact> contactOptional = this.contactRepository.findById(id);

		if (contactOptional.isPresent()) {
			Contact contact = contactOptional.get();
			this.changeStatusContact(contact, true);

			this.contactRepository.save(contact);

			return Boolean.TRUE;
		}

		return Boolean.FALSE;

	}

	private void changeStatusContact(Contact contact, boolean status) {
		contact.setActive(status);
	}

	public boolean undoneAll() {

		List<Contact> contacts = this.contactRepository.findAll();

		contacts.stream().forEach(contact -> {
			contact.setActive(Boolean.TRUE);
			this.contactRepository.save(contact);
		});

		return Boolean.TRUE;
	}

}
