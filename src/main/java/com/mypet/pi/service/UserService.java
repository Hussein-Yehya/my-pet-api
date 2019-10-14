package com.mypet.pi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypet.pi.modal.Address;
import com.mypet.pi.modal.User;
import com.mypet.pi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void create(User user) {

		User u = this.buildUser(user);
		this.userRepository.save(u);
	}

	private User buildUser(User user) {
		User u = new User();
		u.setName(user.getName());
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		u.setUserType(user.getUserType());

		Address address = this.buildAddress(user.getAddress());
		
		u.setAddress(address);

		return u;
	}

	private Address buildAddress(Address address) {
		Address a = new Address();
		a.setCity(address.getCity());
		a.setComplements(address.getComplements());
		a.setCountry(address.getCountry());
		a.setDistrict(address.getDistrict());
		a.setNumber(address.getNumber());
		a.setState(address.getState());
		a.setStreet(address.getStreet());

		return a;
	}

	public List<User> findAllUsers() {

		return this.userRepository.findAll();
	}

	public Optional<User> findByEmailAndPassword(String email, String password) {
		return this.userRepository.findByEmailAndPassword(email, password);
	}

	public void deleteAll() {

		this.userRepository.deleteAll();

	}

	public void deleteById(Long id) {

		this.userRepository.deleteById(id);

	}
	
	public Optional<User> getById(Long id) {

		return this.userRepository.findById(id);

	}
}
