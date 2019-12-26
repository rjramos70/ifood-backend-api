package com.ifood.api.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class TituloTest {

	private Titulo titulo1 = new Titulo();
	private Titulo titulo2 = new Titulo("Rock", new Artista("Íra"), new Album("rock na veia"));
	
	@Test
	void testHashCode() {
		int expected1 = 357642;
		int hashCode1 = titulo1.hashCode();
		System.out.println(" hashCode1 :: " + hashCode1);
		assertEquals(expected1, hashCode1);

		int expected2 = -566843263;
		int hashCode2 = titulo2.hashCode();
		System.out.println(" hashCode2 :: " + hashCode2);
		assertEquals(expected2, hashCode2);
	}

	@Test
	void testGetTitle() {
		String expexted1 = null;
		String title1 = titulo1.getTitle();
		System.out.println(" title1 :: " + title1);
		assertEquals(expexted1, title1);
		
		String expexted2 = "Rock";
		String title2 = titulo2.getTitle();
		System.out.println(" title2 :: " + title2);
		assertEquals(expexted2, title2);
	}

	@Test
	void testGetArtist() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAlbum() {
		fail("Not yet implemented");
	}

	@Test
	void testSetTitle() {
		fail("Not yet implemented");
	}

	@Test
	void testSetArtist() {
		fail("Not yet implemented");
	}

	@Test
	void testSetAlbum() {
		fail("Not yet implemented");
	}

	@Test
	void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	void testCanEqual() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	@Test
	void testTituloStringArtistaAlbum() {
		fail("Not yet implemented");
	}

	@Test
	void testTitulo() {
		fail("Not yet implemented");
	}

}
