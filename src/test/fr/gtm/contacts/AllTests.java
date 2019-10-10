package fr.gtm.contacts;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.gtm.contacts.dao.ContactDAOTest;
import fr.gtm.contacts.facades.ContactFacade;
import fr.gtm.contacts.facades.ContactFacadeTest;

@RunWith(Suite.class)
@SuiteClasses({ContactDAOTest.class,ContactFacadeTest.class})
public class AllTests {

}
