package com.mypet.pi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypet.pi.modal.User;
import com.mypet.pi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void create(User user) {
		
		this.userRepository.save(new User(user.getName(), user.getEmail(), user.getPassword()));
	}

	public List<User> list() {

		return this.userRepository.findAll();
	}

	public Optional<User> findByEmailAndPassword(String email, String password) {
		return this.userRepository.findByEmailAndPassword(email, password);
	}
}
