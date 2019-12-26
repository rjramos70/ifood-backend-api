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
		assertEquals(expected1, hashCode1);

		int expected2 = -566843263;
		int hashCode2 = titulo2.hashCode();
		assertEquals(expected2, hashCode2);
	}

	@Test
	void testGetTitle() {
		String expexted1 = null;
		String title1 = titulo1.getTitle();
		assertEquals(expexted1, title1);
		
		String expexted2 = "Rock";
		String title2 = titulo2.getTitle();
		assertEquals(expexted2, title2);
	}

	@Test
	void testGetArtist() {
		Artista expexted1 = null;
		Artista artist1 = titulo1.getArtist();
		assertEquals(expexted1, artist1);
		
		Artista expexted2 = new Artista("Íra");
		Artista artist2 = titulo2.getArtist();
		assertEquals(expexted2, artist2);
	}

	@Test
	void testGetAlbum() {
		Album expexted1 = null;
		Album album1 = titulo1.getAlbum();
		assertEquals(expexted1, album1);
		
		Album expexted2 = new Album("rock na veia");
		Album album2 = titulo2.getAlbum();
		assertEquals(expexted2, album2);
	}

	@Test
	void testSetTitle() {
		String expexted1 = "Tango";
		titulo1.setTitle(expexted1);
		String title1 = titulo1.getTitle();
		assertEquals(expexted1, title1);
		
		String expexted2 = "Bolero";
		titulo2.setTitle(expexted2);
		String title2 = titulo2.getTitle();
		assertEquals(expexted2, title2);
	}

	@Test
	void testSetArtist() {
		Artista expexted1 = new Artista("Barão Vermelho");
		titulo1.setArtist(expexted1);
		Artista artist1 = titulo1.getArtist();
		assertEquals(expexted1, artist1);
		
		Artista expexted2 = new Artista("Engenheiros do Havai");
		titulo2.setArtist(expexted2);
		Artista artist2 = titulo2.getArtist();
		assertEquals(expexted2, artist2);
	}

	@Test
	void testSetAlbum() {
		Album expexted1 = new Album("rock na veia");
		titulo1.setAlbum(expexted1);
		Album album1 = titulo1.getAlbum();
		assertEquals(expexted1, album1);
		
		Album expexted2 = new Album("rock na veia2");
		titulo2.setAlbum(expexted2);
		Album album2 = titulo2.getAlbum();
		assertEquals(expexted2, album2);
	}

	@Test
	void testEqualsObject() {
		assertTrue(titulo1.equals(new Titulo()));
		assertTrue(titulo2.equals(new Titulo("Rock", new Artista("Íra"), new Album("rock na veia"))));
		
	}

	@Test
	void testEqualsObjectNull() {
		assertFalse(titulo1.equals(null));
		assertFalse(titulo2.equals(null));
		
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testEqualsObjectError1() {
		assertFalse(titulo1.equals(new Album()));
		assertFalse(titulo2.equals(new Album()));
		
	}
	@Test
	void testEqualsObjectError2() {
		assertFalse(titulo1.equals(new Titulo("Rock1", new Artista("Íra1"), new Album("rock na veia1"))));
		assertFalse(titulo2.equals(new Titulo("Rock2", new Artista("Íra2"), new Album("rock na veia2"))));
		
	}
	
	@Test
	void testCanEqual() {
		assertTrue(titulo1.canEqual(new Titulo()));
		assertTrue(titulo1.canEqual(new Titulo("Rock", new Artista("Íra"), new Album("rock na veia"))));
		
	}

	@Test
	void testToString() {
		String expexted1 = "Titulo(title=null, artist=null, album=null)";
		String string1 = titulo1.toString();
		assertEquals(expexted1, string1);
		
		String expexted2 = "Titulo(title=Rock, artist=Artista(name=Íra), album=Album(title=rock na veia))";
		String string2 = titulo2.toString();
		assertEquals(expexted2, string2);
	}

	@Test
	void testTitulo() {
		assertNotNull(titulo1);
		assertNotNull(titulo2);
	}

}
