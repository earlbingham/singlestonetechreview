package com.singlestone.techreview.contactentry;

import com.singlestone.techreview.contactentry.model.Address;
import com.singlestone.techreview.contactentry.model.Contact;
import com.singlestone.techreview.contactentry.model.Name;
import com.singlestone.techreview.contactentry.model.Phone;
import com.singlestone.techreview.contactentry.repository.ContactRepository;
import com.singlestone.techreview.contactentry.repository.PhoneNumberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ContactRepository contactRepository) {
        StringBuilder sb = new StringBuilder();
        Contact contact = new Contact("harold.gilkey@yahoo.com");
        Phone phoneNumber = new Phone(contact);
        phoneNumber.setNumber("302-611-9148");
        phoneNumber.setType("mobile");
        Phone phoneNumber2 = new Phone(contact);
        phoneNumber2.setNumber("123-123-1234");
        phoneNumber2.setType("home");
        Set<Phone> phoneNumbers = new HashSet<>();
        phoneNumbers.add(phoneNumber);
        phoneNumbers.add(phoneNumber2);
        Name user = new Name("Harold", "Francis", "Gilkey");
        Address address = new Address("8360 High Autumn Road","Cannon","Delaware","19797");
        contact.setName(user);
        contact.setAddress(address);
        contact.setPhoneNumbers(phoneNumbers);
        contactRepository.save(contact);

        Contact contact2 = new Contact("steve.jobs@apple.com");
        Phone phoneNumber3 = new Phone(contact2);
        phoneNumber3.setNumber("999-999-9999");
        phoneNumber3.setType("work");
        Name user2 = new Name("Steve", "Paul", "Jobs");
        Address address2 = new Address("123 Apple Lane",
                "Mountain View","California","94024");
        contact2.setName(user2);
        contact2.setAddress(address2);
        Set<Phone> phoneNumbers2 = new HashSet<>();
        phoneNumbers2.add(phoneNumber3);
        contact2.setPhoneNumbers(phoneNumbers2);
        contactRepository.save(contact2);

        List<Contact> contactList2 = contactRepository.findAll();
        for(Contact c : contactList2) {
            sb.append("Preloaded " + c.toString());
        }

        return args -> {
            log.info(sb.toString());
        };
    }
}
