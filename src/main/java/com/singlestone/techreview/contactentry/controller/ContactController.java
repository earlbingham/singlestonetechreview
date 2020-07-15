package com.singlestone.techreview.contactentry.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.singlestone.techreview.contactentry.exception.ResourceNotFoundException;
import com.singlestone.techreview.contactentry.model.Contact;
import com.singlestone.techreview.contactentry.model.Phone;
import com.singlestone.techreview.contactentry.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ContactController {

    private static final Logger log = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/contacts")
    public String getAllContacts() throws JsonProcessingException {
        StringBuilder sb = new StringBuilder();
        List<Contact> contacts = contactRepository.findAll();
        if(contacts.size() > 1) {
            sb.append("[ ");
        }
        for(Contact contact : contacts) {
            List<Long> contactIds = new ArrayList<>();
            contactIds.add(contact.getId());
            if(sb.length() > 3) sb.append(", ");
            sb.append(contact.toString());
        }
        if(contacts.size() > 1) {
            sb.append("] ");
        }
        return (sb.toString());
    }

    @GetMapping("/contacts/{id}")
    public String getContactById(@PathVariable(value = "id") Long contactId)
            throws ResourceNotFoundException {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found for this id :: " + contactId));
        return contact.toString();
    }

    @PostMapping("/contacts")
    public String createContact(@RequestBody Contact contact) {
        Set<Phone> phones = contact.getPhoneNumbers();
        Set<Phone> phones2 = new HashSet<>();
        for(Phone phone : phones) {
            Phone phone1 = new Phone(contact);
            phone1.setNumber(phone.getNumber());
            phone1.setType(phone.getType());
            phones2.add(phone1);
        }
        contact.setPhoneNumbers(phones2);
        contactRepository.save(contact);
        return contact.toString();
    }

    @PutMapping("/contacts/{id}")
    public String updateContact(@PathVariable(value = "id") Long contactId,
                                                      @RequestBody Contact contactDetails) throws ResourceNotFoundException {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found for this id :: " + contactId));
        Set<Phone> phones = contact.getPhoneNumbers();
        Set<Phone> phones2 = new HashSet<>();
        for(Phone phone : phones) {
            Phone phone1 = new Phone(contact);
            phone1.setNumber(phone.getNumber());
            phone1.setType(phone.getType());
            phones2.add(phone1);
        }
        contact.setPhoneNumbers(phones2);
        contactRepository.save(contact);
        return contact.toString();
    }

    @DeleteMapping("/contacts/{id}")
    public String deleteContact(@PathVariable(value = "id") Long contactId)
            throws ResourceNotFoundException {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found for this id :: " + contactId));
        contactRepository.delete(contact);
        Map<String,Boolean> response = new HashMap<>();
        return "{ \"status\": \"Deleted contact id: " + contactId + "\" }";
    }

}
