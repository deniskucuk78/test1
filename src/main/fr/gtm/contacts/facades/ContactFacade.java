package fr.gtm.contacts.facades;

import java.util.List;

import fr.gtm.contacts.dao.ContactDAO;
import fr.gtm.contacts.entities.Contact;

public class ContactFacade{
	private ContactDAO dao;
	
	public ContactFacade(ContactDAO dao) {
		this.dao = dao;
	}

	public void save(Contact contact) {
		dao.save(contact);
	}

	public void update(Contact contact) {
		dao.update(contact);
	}

	public void delete(Contact contact) {
		dao.delete(contact);
	}


	public List<Contact> getAllContacts() {
		return dao.getAllContacts();
	}

	public Contact getContactById(long id) {
		return dao.getContactById(id);
	}

	public List<Contact> getContactsByNom(String nom) {
		return dao.getContactsByNom(nom);
	}

	public List<Contact> getContactsByCivilite(String civilite) {
		return dao.getContactsByCivilite(civilite);
	}

}
