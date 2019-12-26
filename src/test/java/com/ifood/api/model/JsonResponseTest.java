package com.ifood.api.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class JsonResponseTest {
	

	private List<Titulo> titulos = new ArrayList<>();
	
	private JsonResponse jsonResponse1 = new JsonResponse();
	
	private JsonResponse jsonResponse2;

	@Before
	private void setUp() {
		this.titulos.add(new Titulo("Première Gymnopédie", new Artista("Alexandre Tharaud"), new Album("Satie: Avant-dernières pensées (Bonus Track Version)")));
		this.titulos.add(new Titulo("Ancient Airs & Dances, Suite No. 3, P. 172: I. Italiana", new Artista("Tonkünstler Orchester"), new Album("String Serenade")));
		jsonResponse2 = new JsonResponse("brasilia", 31, "tracks for party", new Tracks(this.titulos));
	}
	
	
	@Test
	void testHashCode() {
		setUp();
		
		int expected1 = 21100921;
		int hashCode1 = jsonResponse1.hashCode();
		assertEquals(expected1, hashCode1);
		
		int expected2 = 534777543;
		int hashCode2 = jsonResponse2.hashCode();
		assertEquals(expected2, hashCode2);
	}

	@Test
	void testGetCity_name() {
		setUp();
		
		String expected1 = null;
		String city_name1 = jsonResponse1.getCity_name();
		assertEquals(expected1, city_name1);
		
		String expected2 = "brasilia";
		String city_name2 = jsonResponse2.getCity_name();
		assertEquals(expected2, city_name2);
	}

	@Test
	void testGetTemperature() {
		setUp();
		
		Integer expected1 = null;
		Integer temperature1 = jsonResponse1.getTemperature();
		assertEquals(expected1, temperature1);
		
		Integer expected2 = 31;
		Integer temperature2 = jsonResponse2.getTemperature();
		assertEquals(expected2, temperature2);
	}

	@Test
	void testGetSuggest_track() {
		setUp();
		
		String expected1 = null;
		String suggest_track1 = jsonResponse1.getSuggest_track();
		assertEquals(expected1, suggest_track1);
		
		String expected2 = "tracks for party";
		String suggest_track2 = jsonResponse2.getSuggest_track();
		assertEquals(expected2, suggest_track2);
	}

	@Test
	void testGetTracks() {
		setUp();
		
		Tracks expected1 = null;
		Tracks tracks1 = jsonResponse1.getTracks();
		assertEquals(expected1, tracks1);
		
		Tracks expected2 = new Tracks(titulos);
		Tracks tracks2 = jsonResponse2.getTracks();
		assertEquals(expected2, tracks2);
	}

	@Test
	void testSetCity_name() {
		String expected1 = "Buenos Aires";
		jsonResponse1.setCity_name("Buenos Aires");
		String city_name1 = jsonResponse1.getCity_name();
		assertEquals(expected1, city_name1);
	}

	@Test
	void testSetTemperature() {
		Integer expected1 = 27;
		jsonResponse1.setTemperature(27);
		Integer temperature1 = jsonResponse1.getTemperature();
		assertEquals(expected1, temperature1);
	}

	@Test
	void testSetSuggest_track() {
		String expected1 = "pop music tracks";
		jsonResponse1.setSuggest_track("pop music tracks");
		String suggest_track1 = jsonResponse1.getSuggest_track();
		assertEquals(expected1, suggest_track1);
	}

	@Test
	void testSetTracks() {
		setUp();
		
		Tracks expected1 = new Tracks(titulos);
		jsonResponse1.setTracks(new Tracks(titulos));
		Tracks tracks1 = jsonResponse1.getTracks();
		assertEquals(expected1, tracks1);
	}

	@Test
	void testEqualsObject() {
		setUp();
		
		boolean expected1 = true;
		boolean equals1 = jsonResponse1.equals(new JsonResponse());
		assertEquals(expected1, equals1);
		
		boolean expected2 = false;
		boolean equals2 = jsonResponse2.equals(new JsonResponse());
		assertEquals(expected2, equals2);
		
	}

	@Test
	void testCanEqual() {
		setUp();
		
		boolean expected1 = true;
		boolean equals1 = jsonResponse1.canEqual(new JsonResponse());
		assertEquals(expected1, equals1);
		
		boolean expected2 = false;
		boolean equals2 = jsonResponse2.canEqual(new JsonResponse());
		assertNotEquals(expected2, equals2);
	}

	@Test
	void testToString() {
		setUp();
		
		String expected1 = "JsonResponse(city_name=null, temperature=null, suggest_track=null, tracks=null)";
		String string1 = jsonResponse1.toString();
		assertEquals(expected1, string1);
		
		String expected2 = "JsonResponse(city_name=brasilia, temperature=31, suggest_track=tracks for party, tracks=Tracks(data=[Titulo(title=Première Gymnopédie, artist=Artista(name=Alexandre Tharaud), album=Album(title=Satie: Avant-dernières pensées (Bonus Track Version))), Titulo(title=Ancient Airs & Dances, Suite No. 3, P. 172: I. Italiana, artist=Artista(name=Tonkünstler Orchester), album=Album(title=String Serenade))]))";
		String string2 = jsonResponse2.toString();
		assertEquals(expected2, string2);
	}
	

	@Test
	void testJsonResponse() {
		setUp();
		assertNotNull(jsonResponse1);
		assertNotNull(jsonResponse2);
	}

}
