package fr.gtm.contacts.facades;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.gtm.contacts.dao.ContactDAO;
import fr.gtm.contacts.dao.ContactMockDAO;
import fr.gtm.contacts.entities.Contact;

public class ContactFacadeTest {
	private Contact[] contacts = {
			new Contact("M","Lagaffe","Gaston"),
			new Contact("Mme","Blanc-Sec","Adèle"),
			new Contact("M","Leblanc","Juste"),
			new Contact("M","Brown","Emmet"),
			new Contact("M","Gordon","James"),
			new Contact("Mme","Croft","Lara")
	};
	private ContactFacade facade = new ContactFacade(new ContactMockDAO());
	
	@Test
	public void testSave() {
		Contact c = contacts[0];
		facade.save(c);
		int nb = facade.getAllContacts().size();
		assertEquals(1, nb);
		assertNotEquals(0, c.getId());
	}

	@Test
	public void testUpdate() {
		Contact c = contacts[0];
		facade.save(c);
		c.setNom("foo");
		facade.update(c);
		Contact c1 = facade.getContactById(c.getId());
		assertEquals("foo", c1.getNom());
	}

	@Test
	public void testDelete() {
		Contact c = contacts[0];
		facade.save(c);
		long id = c.getId();
		facade.delete(c);
		assertNull(facade.getContactById(id));
	}

	@Test
	public void testGetAllContacts() {
		for(Contact c : contacts) {
			facade.save(c);
		}
		assertEquals(contacts.length, facade.getAllContacts().size());
	}

	@Test
	public void testGetContactById() {
		Contact c = contacts[0];
		facade.save(c);
		long id = c.getId();
		assertEquals(c, facade.getContactById(id));
	}

	@Test
	public void testGetContactsByNom() {
		for(Contact c : contacts) {
			facade.save(c);
		}
		assertEquals(2, facade.getContactsByNom("L").size());
	}

	@Test
	public void testGetContactsByCivilite() {
		for(Contact c : contacts) {
			facade.save(c);
		}
		assertEquals(2, facade.getContactsByCivilite("Mme").size());
	}

}
