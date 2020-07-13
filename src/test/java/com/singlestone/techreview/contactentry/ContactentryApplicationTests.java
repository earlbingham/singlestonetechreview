package com.singlestone.techreview.contactentry;

import com.singlestone.techreview.contactentry.model.Address;
import com.singlestone.techreview.contactentry.model.Contact;
import com.singlestone.techreview.contactentry.model.Name;
import com.singlestone.techreview.contactentry.model.Phone;
import com.singlestone.techreview.contactentry.repository.ContactRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContactentryApplication.class)
class ContactentryApplicationTests {

	@Autowired
	ContactRepository contactRepository;

	@Test
	void contextLoads() { }

	@Before
	public void setup() {
		Contact contact = new Contact();
		Phone phone = new Phone(contact);
		phone.setNumber("302-611-9148");
		phone.setType("mobile");
		Phone phone2 = new Phone(contact);
		phone2.setNumber("123-123-1234");
		phone2.setType("home");
		Set<Phone> phoneNumbers = new HashSet<>();
		phoneNumbers.add(phone);
		phoneNumbers.add(phone2);
		Name user1 = new Name("Harold", "Francis", "Gilkey");
		contact.setName(user1);
		contact.setPhoneNumbers(phoneNumbers);
		contactRepository.save(contact);

		Contact contact2 = new Contact("steve.jobs@apple.com");
		Phone phone3 = new Phone(contact2);
		phone3.setNumber("999-999-9999");
		phone3.setType("work");
		Name user2 = new Name("Steve", "Paul", "Jobs");
		Address address2 = new Address("123 Apple Lane",
				"Mountain View","California","94024");
		contact2.setName(user2);
		contact2.setAddress(address2);
		contact.setPhoneNumbers(Collections.singleton(phone3));
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
		Set<Phone> phoneNumbers = contacts.get(0).getPhoneNumbers();
		assertEquals(2, phoneNumbers.size());
	}

}
