package com.mypet.pi.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypet.pi.modal.Contact;
import com.mypet.pi.modal.User;
import com.mypet.pi.repository.UserRepository;
import com.mypet.pi.service.ContactService;

@RestController
@RequestMapping("api/contacts")
@CrossOrigin("*")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@Autowired
	private UserRepository userRepository;

	@SuppressWarnings("rawtypes")
	@GetMapping
	public ResponseEntity getAll() {

		List<Contact> contacts = this.contactService.findAllContact();


		return ResponseEntity.ok(contacts);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/{id}")
	public ResponseEntity getById(@PathVariable("id") Long id) {

		Contact contact = this.contactService.getContactBy(id);

		return ResponseEntity.ok(contact);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("")
	public ResponseEntity create(@RequestBody Contact contact) {
		
		System.out.println("RECEBENDO UM NOVO CONTACT: " + contact.toString());

		if (Objects.nonNull(contact.getUser())) {
			Optional<User> user = this.userRepository.findById(contact.getUser().getId());

			if (user.isPresent()) {
				contact.setUser(user.get());

				this.contactService.create(contact);

				return ResponseEntity.ok().build();

			}

		}

		return ResponseEntity.badRequest().build();

	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(@PathVariable("id") Long id) {

		this.contactService.delete(id);

		return ResponseEntity.ok().build();
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/all")
	public ResponseEntity deleteAll() {

		this.contactService.deleteAll();

		return ResponseEntity.ok().build();
	}
	
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/users/{idUser}")
	public ResponseEntity getContactByIdUser(@PathVariable("idUser") Long idUser) {

		List<Contact> contacts = this.contactService.getContactByIdUser(idUser);

		return ResponseEntity.ok(contacts);
	}
	
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/name/{name}")
	public ResponseEntity getContactByName(@PathVariable("name") String name) {

		List<Contact> contacts = this.contactService.getContactByName(name);

		 return ResponseEntity.ok(contacts);

	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/name/{name}/user/{userId}")
	public ResponseEntity getContactByNameAndUserId(@PathVariable("name") String name, @PathVariable("userId") Long userId) {

		List<Contact> contacts = this.contactService.getContactByNameAndUserId(name, userId);

		 return ResponseEntity.ok(contacts);

	}
	
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
	}
	
	

}
