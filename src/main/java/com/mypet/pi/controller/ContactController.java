package com.mypet.pi.controller;

import java.util.List;

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
import com.mypet.pi.service.ContactService;

@RestController
@RequestMapping("api/contacts")
@CrossOrigin("*")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@SuppressWarnings("rawtypes")
	@GetMapping
	public ResponseEntity test() {

		List<Contact> contacts = this.contactService.allContact();

		return ResponseEntity.ok(contacts);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/{id}")
	public ResponseEntity test(@PathVariable("id") Long id) {

		Contact contact = this.contactService.getContactBy(id);

		return ResponseEntity.ok(contact);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("")
	public ResponseEntity create(@RequestBody Contact contact) {

		this.contactService.create(contact);

		return ResponseEntity.ok(contact);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {

		this.contactService.delete(id);

		return ResponseEntity.ok().build();
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/all")
	public ResponseEntity deleteAll() {

		this.contactService.deleteAll();

		return ResponseEntity.ok().build();
	}

}
