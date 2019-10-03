package com.mypet.pi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypet.pi.modal.Address;
import com.mypet.pi.modal.User;
import com.mypet.pi.modal.UserType;
import com.mypet.pi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void create(User user, UserType userType) {

		User u = this.buildUser(user, userType);
		this.userRepository.save(u);
	}

	private User buildUser(User user, UserType userType) {
		User u = new User();
		u.setName(user.getName());
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		u.setUserType(userType);

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

	public List<User> list() {

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
}
