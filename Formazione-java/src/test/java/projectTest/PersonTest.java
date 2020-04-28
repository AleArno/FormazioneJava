package projectTest;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.Test;

import project.Person;

public class PersonTest {

	private Person p;

	@Before
	public void start() {
		p = new Person();
		p.setName("Antonio");
		p.setSurname("Rossi");
		p.setBirth("08/10/2000");
		p.setKey("ABCDEFG12345678");
	}

//	@Test
//	public void testPersonaSenzaDati() {
//		assertNull("Nome nullo", p.getName());
//		assertNull("Cognome nullo", p.getSurname());
//		assertNull("Data nascita nulla", p.getBirth());
//		assertNull("Chiave nulla", p.getKey());
//	}

	

	@Test
	public void testNome() {

		assertEquals("Mi aspetto di vedere come nome: Antonio", "Antonio", p.getName());
	}

	@Test
	public void testCognome() {
		assertEquals("Mi aspetto di vedere come cognome: Rossi", "Rossi", p.getSurname());
	}

	@Test
	public void testNascita() {
		assertEquals("Mi aspetto di vedere come data di nascita: 08/10/2000", "08/10/2000", p.getBirth());
	}

	@Test
	public void testChiave() {
		assertEquals("Mi aspetto di vedere come chiave: ABCDEFG12345678", "ABCDEFG12345678", p.getKey());
	}

}
