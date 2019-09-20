package com.mypet.pi.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypet.pi.modal.Login;
import com.mypet.pi.modal.User;
import com.mypet.pi.service.UserService;

@RestController
@RequestMapping("api/users")
@CrossOrigin("*")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userSerivce;

	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity create(@RequestBody User user) {
		
		logger.info("User {}", user.toString());

		this.userSerivce.create(user);

		return ResponseEntity.ok().build();
	}

	@SuppressWarnings("rawtypes")
	@GetMapping
	public ResponseEntity list() {

		List<User> users = this.userSerivce.list();

		return ResponseEntity.ok(users);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody Login login) {

		Optional<User> user = this.userSerivce.findByEmailAndPassword(login.getEmail(), login.getPassword());

		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}

		return ResponseEntity.noContent().build();
	}
}
