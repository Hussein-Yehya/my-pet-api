package com.mypet.pi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

}
