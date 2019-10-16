package com.mypet.pi.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.mypet.pi.modal.Login;
import com.mypet.pi.modal.User;
import com.mypet.pi.modal.UserType;
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

		user.setUserType(UserType.COMMON);

		this.userSerivce.create(user);

		return ResponseEntity.ok().build();
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/admin")
	public ResponseEntity createADMIN(@RequestBody User user) {

		logger.info("User {}", user.toString());

		user.setUserType(UserType.ADMIN);

		this.userSerivce.create(user);

		return ResponseEntity.ok().build();
	}

	@SuppressWarnings("rawtypes")
	@GetMapping
	public ResponseEntity list() {

		List<User> users = this.userSerivce.findAllUsers ();

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

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/all")
	public ResponseEntity deleteAll() {

		this.userSerivce.deleteAll();

		return ResponseEntity.ok().build();
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(@PathVariable("id") Long id) {

		this.userSerivce.deleteById(id);

		return ResponseEntity.ok().build();
	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/{id}")
	public ResponseEntity getById(@PathVariable("id") Long id) {

		Optional<User> user = this.userSerivce.getById(id);

		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}

		return ResponseEntity.noContent().build();
	}

}
