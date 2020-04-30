package projectTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import project.Parser;
import project.Person;
public class ParserTest {

	private ArrayList<Person> person=new ArrayList<Person>();
	
	@Before
	public void before() {
		Parser p=Parser.getInstance();
		try {
			person=p.parseXML("personlist.xml");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void personeConNomiNonAccettabili() {
		for(int i=0; i<person.size();i++) {
		assertFalse(person.get(i).getName().length()>50);
	}}
	
	@Test
	public void personeConCognomeNonAccettabile() {
		for(int i=0; i<person.size();i++) {
		assertFalse(person.get(i).getSurname().length()>50);
	}}
	
	@Test
	public void personeConChiaveNonAccettabile() {
		for(int i=0; i<person.size();i++) {
		assertFalse(person.get(i).getKey().length()>15);
	}}
	@Test
	public void personeConChiaveNulla() {
		for(int i=0; i<person.size();i++) {
		assertFalse(person.get(i).getKey().isEmpty());
	}}
	@Test
	public void personeConNomeNullo() {
		for(int i=0; i<person.size();i++) {
		assertFalse(person.get(i).getName().isEmpty());
	}}
	
	@Test
	public void personeConCognomeNullo() {
		for(int i=0; i<person.size();i++) {
		assertFalse(person.get(i).getSurname().isEmpty());
	}}
	
	@Test
	public void testNomePersona1() {

		assertEquals("Mi aspetto di vedere come nome: Pippo", "Pippo", person.get(0).getName());
	}

	@Test
	public void testCognomePersona1() {
		assertEquals("Mi aspetto di vedere come cognome: Carlos", "Carlos", person.get(0).getSurname());
	}

	@Test
	public void testNascitaPersona1() {
		assertEquals("Mi aspetto di vedere come data di nascita: 1998/03/25", "1998/03/25", person.get(0).getBirth());
	}

	@Test
	public void testChiavePersona1() {
		assertEquals("Mi aspetto di vedere come chiave: KKSSIOSDISOD999", "KKSSIOSDISOD999", person.get(0).getKey());
	}
	@Test
	public void testNomePersona2() {

		assertEquals("Mi aspetto di vedere come nome: Mimmo", "Mimmo", person.get(1).getName());
	}

	@Test
	public void testCognomePersona2() {
		assertEquals("Mi aspetto di vedere come cognome: Bruttus", "Bruttus", person.get(1).getSurname());
	}

	@Test
	public void testNascitaPersona2() {
		assertEquals("Mi aspetto di vedere come data di nascita: 1991/05/01", "1991/05/01", person.get(1).getBirth());
	}

	@Test
	public void testChiavePersona2() {
		assertEquals("Mi aspetto di vedere come chiave: KKSSIOSDISOD989", "KKSSIOSDISOD989", person.get(1).getKey());
	}

	
	
}
