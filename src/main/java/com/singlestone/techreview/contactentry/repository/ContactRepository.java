package com.singlestone.techreview.contactentry.repository;

import com.singlestone.techreview.contactentry.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
