package com.mypet.pi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypet.pi.modal.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

	public List<Contact> findByIdCreationDateDesc();
}
