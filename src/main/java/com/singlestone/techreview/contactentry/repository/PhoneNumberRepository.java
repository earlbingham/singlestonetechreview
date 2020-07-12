package com.singlestone.techreview.contactentry.repository;

import com.singlestone.techreview.contactentry.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepository extends JpaRepository<Phone, Long> {

}
