package com.singlestone.techreview.contactentry;

import com.singlestone.techreview.contactentry.model.Address;
import com.singlestone.techreview.contactentry.model.Contact;
import com.singlestone.techreview.contactentry.model.Phone;
import com.singlestone.techreview.contactentry.model.Name;
import com.singlestone.techreview.contactentry.repository.ContactRepository;
import com.singlestone.techreview.contactentry.repository.PhoneNumberRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContactentryApplication.class)
class ContactentryApplicationTests {

	@Autowired
	ContactRepository contactRepository;

	@Autowired
	PhoneNumberRepository phoneNumberRepository;

	@Test
	void contextLoads() { }

	@Before
	public void setup() {
		Phone phoneNumber = new Phone("302-611-9148", "mobile");
		Phone phoneNumber2 = new Phone("123-123-1234", "home");
		Set<Phone> phoneNumbers = new HashSet<>();
		phoneNumbers.add(phoneNumber);
		phoneNumbers.add(phoneNumber2);
		Name user1 = new Name("Harold", "Francis", "Gilkey");
		Contact contact = new Contact();
		contact.setName(user1);
		contact.setPhoneNumbers(phoneNumbers);
		contactRepository.save(contact);

		Phone phoneNumber3 = new Phone("999-999-9999", "work");
		Name user2 = new Name("Steve", "Paul", "Jobs");
		Address address2 = new Address("123 Apple Lane",
				"Mountain View","California","94024");
		Contact contact2 = new Contact("steve.jobs@apple.com");
		contact2.setName(user2);
		contact2.setAddress(address2);
		contact.setPhoneNumbers(Collections.singleton(phoneNumber3));
		contactRepository.save(contact2);
	}

	@Test
	public void shouldAddContacts() {
		List<Contact> contacts = contactRepository.findAll();
		assertFalse(contacts.isEmpty());
	}

	@Test
	public void shouldReturnMultiplePhoneNumbers() {
		List<Contact> contacts = contactRepository.findAll();
		assertFalse(contacts.isEmpty());
		for(Contact contact : contacts) {
			Set<Phone> phoneNumbers = contact.getPhoneNumbers();
			System.out.println("size: " + phoneNumbers.size());
			List<Long> contactIds = new ArrayList<>();
			contactIds.add(contact.getId());
			List<Phone> phoneNumbers2 = phoneNumberRepository.findAllById(contactIds);
			// assertEquals(2, phoneNumbers2.size());
			System.out.println("phone2: " + phoneNumbers2.size());
			assertFalse(phoneNumbers.isEmpty());
		}

	}
}
