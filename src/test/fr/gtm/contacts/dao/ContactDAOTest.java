package fr.gtm.contacts.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.gtm.contacts.entities.Contact;

public class ContactDAOTest {
	private Contact[] contacts = {
			new Contact("M","Lagaffe","Gaston"),
			new Contact("Mme","Blanc-Sec","Adèle"),
			new Contact("M","Leblanc","Juste"),
			new Contact("M","Brown","Emmet"),
			new Contact("M","Gordon","James"),
			new Contact("Mme","Croft","Lara")
	};
	private ContactDAO dao = new ContactMockDAO();
	
	@Test
	public void testSave() {
		Contact c = contacts[0];
		dao.save(c);
		int nb = dao.getAllContacts().size();
		assertEquals(1, nb);
		assertNotEquals(0, c.getId());
	}

	@Test
	public void testUpdate() {
		Contact c = contacts[0];
		dao.save(c);
		c.setNom("foo");
		dao.update(c);
		Contact c1 = dao.getContactById(c.getId());
		assertEquals("foo", c1.getNom());
	}

	@Test
	public void testDelete() {
		Contact c = contacts[0];
		dao.save(c);
		long id = c.getId();
		dao.delete(c);
		assertNull(dao.getContactById(id));
	}

	@Test
	public void testGetAllContacts() {
		for(Contact c : contacts) {
			dao.save(c);
		}
		assertEquals(contacts.length, dao.getAllContacts().size());
	}

	@Test
	public void testGetContactById() {
		Contact c = contacts[0];
		dao.save(c);
		long id = c.getId();
		assertEquals(c, dao.getContactById(id));
	}

	@Test
	public void testGetContactsByNom() {
		for(Contact c : contacts) {
			dao.save(c);
		}
		assertEquals(2, dao.getContactsByNom("L").size());
	}

	@Test
	public void testGetContactsByCivilite() {
		for(Contact c : contacts) {
			dao.save(c);
		}
		assertEquals(2, dao.getContactsByCivilite("Mme").size());
	}

}
