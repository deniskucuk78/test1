package fr.gtm.contacts.dao;

import java.util.ArrayList;
import java.util.List;

import fr.gtm.contacts.entities.Contact;

public class ContactMockDAO implements ContactDAO {
	private List<Contact> contacts = new ArrayList<Contact>();
	private static long idCpt = 0;

	@Override
	public void save(Contact contact) {
		contact.setId(++idCpt);
		contacts.add(contact);
	}

	@Override
	public void update(Contact contact) {
		for(Contact c : contacts) {
			if(c.getId() == contact.getId()) {
				c.setCivilite(contact.getCivilite());
				c.setNom(contact.getNom());
				c.setPrenom(contact.getPrenom());
			}
		}
	}

	@Override
	public void delete(Contact contact) {
		contacts.remove(contact);
		contact.setId(0);
	}

	@Override
	public List<Contact> getAllContacts() {
		return contacts;
	}

	@Override
	public Contact getContactById(long id) {
		for(Contact c : contacts) {
			if(c.getId() == id)
				return c;
		}
		return null;
	}

	@Override
	public List<Contact> getContactsByNom(String nom) {
		List<Contact> liste = new ArrayList<>();
		for(Contact c : contacts) {
			if(c.getNom().startsWith(nom)) {
				liste.add(c);
			}
		}
		return liste;
	}

	@Override
	public List<Contact> getContactsByCivilite(String civilite) {
		List<Contact> liste = new ArrayList<>();
		for(Contact c : contacts) {
			if(c.getCivilite().equals(civilite)) {
				liste.add(c);
			}
		}
		return liste;
	}

}
