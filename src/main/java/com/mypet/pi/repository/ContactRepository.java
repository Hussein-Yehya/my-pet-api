package com.mypet.pi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mypet.pi.modal.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

	List<Contact> findByUserId(Long idUser);

	List<Contact> findByNameStartingWithIgnoreCaseOrBreedStartingWithIgnoreCaseOrPetRecommendedTo(String name,
			String breed, String petRecommendedTo);

	List<Contact> findByActiveTrueOrderByCreationDateDesc();

	List<Contact> findByUserIdAndNameStartingWithIgnoreCaseOrBreedStartingWithIgnoreCaseOrPetRecommendedTo(Long userId,
			String name, String breed, String petRecommendedTo);

	@Transactional
	void deleteByUserId(Long idUser);

}
