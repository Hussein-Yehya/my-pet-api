package com.mypet.pi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypet.pi.modal.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByEmailAndPassword(String email, String password);
	
	public Optional<User> findByEmail(String email);
	
	public List<User> findByNameStartingWithIgnoreCaseOrEmailStartingWithIgnoreCase(String name, String email);


}
