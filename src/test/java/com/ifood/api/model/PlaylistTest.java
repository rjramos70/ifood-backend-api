package com.ifood.api.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class PlaylistTest {

	private Playlist playlist1 = new Playlist();
	private Playlist playlist2 = new Playlist("Rock", Arrays.asList("Legião Urbana", "Paralamas", "Engenheiros do Havai"));
	
	@Test
	void testHashCode() {
		int expected1 = 6061;
		int hashCode1 = playlist1.hashCode();
		assertEquals(expected1, hashCode1);

		int expected2 = -878707908;
		int hashCode2 = playlist2.hashCode();
		assertEquals(expected2, hashCode2);
		
	}

	@Test
	void testGetGenre() {
		String expected1 = null;
		String genre1 = playlist1.getGenre();
		assertEquals(expected1, genre1);

		String expected2 = "Rock";
		String genre2 = playlist2.getGenre();
		assertEquals(expected2, genre2);
	}

	@Test
	void testGetTitles() {
		List<String> expectedTitles1 = null;
		List<String> titles1 = playlist1.getTitles();
		assertEquals(expectedTitles1, titles1);
		
		List<String> expectedTitles2 = Arrays.asList("Legião Urbana", "Paralamas", "Engenheiros do Havai");
		List<String> titles2 = playlist2.getTitles();
		assertEquals(expectedTitles2, titles2);
	}

	@Test
	void testSetGenre() {
		String expected1 = "Samba";
		playlist1.setGenre(expected1);
		String genre1 = playlist1.getGenre();
		assertEquals(expected1, genre1);

		String expected2 = "Tango";
		playlist2.setGenre(expected2);
		String genre2 = playlist2.getGenre();
		assertEquals(expected2, genre2);
	}

	@Test
	void testSetTitles() {
		List<String> expectedTitles1 = Arrays.asList("Iron Maiden", "Ozzy", "Sepultura");
		playlist1.setTitles(expectedTitles1);
		List<String> titles1 = playlist1.getTitles();
		assertEquals(expectedTitles1, titles1);
		
		List<String> expectedTitles2 = Arrays.asList("Milionario e José Rico", "Leonardo", "Xitãozinho e Xororó");
		playlist2.setTitles(expectedTitles2);
		List<String> titles2 = playlist2.getTitles();
		assertEquals(expectedTitles2, titles2);
	}

	@Test
	void testEqualsObject() {
		assertTrue(playlist1.equals(new Playlist()));
		
		assertTrue(playlist2.equals(new Playlist("Rock", Arrays.asList("Legião Urbana", "Paralamas", "Engenheiros do Havai"))));
		
	}
	
	@Test
	void testEqualsObjectFalse() {
		assertFalse(playlist1.equals(new Playlist("Rock", Arrays.asList("Legião Urbana", "Paralamas", "Engenheiros do Havai"))));
		
		assertFalse(playlist2.equals(new Playlist()));
		
	}

	@Test
	void testEqualsObjectNull() {
		assertFalse(playlist1.equals(null));
		
		assertFalse(playlist2.equals(null));
		
	}

	@Test
	void testCanEqual() {
		assertTrue(playlist1.canEqual(new Playlist()));
		
		assertTrue(playlist2.canEqual(new Playlist("Rock", Arrays.asList("Legião Urbana", "Paralamas", "Engenheiros do Havai"))));
		
	}

	@Test
	void testToString() {
		String expected1 = "Playlist(genre=null, titles=null)";
		String string1 = playlist1.toString();
		assertEquals(expected1, string1);

		String expected2 = "Playlist(genre=Rock, titles=[Legião Urbana, Paralamas, Engenheiros do Havai])";
		String string2 = playlist2.toString();
		assertEquals(expected2, string2);
	}


	@Test
	void testPlaylist() {
		assertNotNull(playlist1);
		assertNotNull(playlist2);
	}

}
