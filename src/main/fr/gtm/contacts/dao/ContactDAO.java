package fr.gtm.contacts.dao;

//test 2

import java.util.List;

import fr.gtm.contacts.entities.Contact;

public interface ContactDAO {
	void save(Contact contact);
	void update(Contact contact);
	void delete(Contact contact);
	List<Contact> getAllContacts();
	Contact getContactById(long id);
	List<Contact> getContactsByNom(String nom);
	List<Contact> getContactsByCivilite(String civilite);

}
