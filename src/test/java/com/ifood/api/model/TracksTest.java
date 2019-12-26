package com.ifood.api.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class TracksTest {

	private Tracks tracks1 = new Tracks();
	private Tracks tracks2 = new Tracks(Arrays.asList(new Titulo("Rock", new Artista("Íra"), new Album("rock na veia"))));
	
	@Test
	void testHashCode() {
		int expected1 = 102;
		int hashCode1 = tracks1.hashCode();
		assertEquals(expected1, hashCode1);

		int expected2 = -566843173;
		int hashCode2 = tracks2.hashCode();
		assertEquals(expected2, hashCode2);
	}

	@Test
	void testGetData() {
		List<Titulo> expected1 = null;
		List<Titulo> data1 = tracks1.getData();
		assertEquals(expected1, data1);

		List<Titulo> expected2 = Arrays.asList(new Titulo("Rock", new Artista("Íra"), new Album("rock na veia")));
		List<Titulo> data2 = tracks2.getData();
		assertEquals(expected2, data2);
	}

	@Test
	void testSetData() {
		List<Titulo> expected1 = Arrays.asList(new Titulo("Rock2", new Artista("Íra2"), new Album("rock na veia2")));
		tracks1.setData(expected1);
		List<Titulo> data1 = tracks1.getData();
		assertEquals(expected1, data1);

		List<Titulo> expected2 = Arrays.asList(new Titulo("Rock2", new Artista("Íra2"), new Album("rock na veia2")));
		tracks2.setData(expected2);
		List<Titulo> data2 = tracks2.getData();
		assertEquals(expected2, data2);
	}

	@Test
	void testEqualsObject() {
		assertTrue(tracks1.equals(new Tracks()));
		assertTrue(tracks2.equals(new Tracks(Arrays.asList(new Titulo("Rock", new Artista("Íra"), new Album("rock na veia"))))));
	}
	
	@Test
	void testEqualsObjectNull() {
		assertFalse(tracks1.equals(null));
		assertFalse(tracks2.equals(null));
	}
	
	@Test
	void testEqualsObjectError() {
		assertFalse(tracks1.equals(new Tracks(Arrays.asList(new Titulo("Rock", new Artista("Íra"), new Album("rock na veia"))))));
		assertFalse(tracks2.equals(new Tracks()));
	}

	@Test
	void testCanEqual() {
		assertTrue(tracks1.canEqual(new Tracks()));
		assertTrue(tracks2.canEqual(new Tracks(Arrays.asList(new Titulo("Rock", new Artista("Íra"), new Album("rock na veia"))))));
	}

	@Test
	void testCanEqualObjectNull() {
		assertFalse(tracks1.canEqual(null));
		assertFalse(tracks2.canEqual(null));
	}
	
	@Test
	void testCanEqualObjectError() {
		assertTrue(tracks1.canEqual(new Tracks(Arrays.asList(new Titulo("Rock", new Artista("Íra"), new Album("rock na veia"))))));
		assertTrue(tracks2.canEqual(new Tracks()));
	}
	
	@Test
	void testToString() {
		String expexted1 = "Tracks(data=null)";
		String string1 = tracks1.toString();
		assertEquals(expexted1, string1);
		
		String expexted2 = "Tracks(data=[Titulo(title=Rock, artist=Artista(name=Íra), album=Album(title=rock na veia))])";
		String string2 = tracks2.toString();
		assertEquals(expexted2, string2);
	}


	@Test
	void testTracks() {
		assertNotNull(tracks1);
		assertNotNull(tracks2);
	}

}
