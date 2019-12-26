package com.ifood.api.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class TemperatureTest {

	private Temperature temp1 = new Temperature();
	private Temperature temp2 = new Temperature(new Main(35, 37, 38, 40, 26, 18), "Brasilia", new Coordinates(-10.9f, -37.55f));
	
	@Test
	void testHashCode() {
		int expected1 = 357642;
		int hashCode1 = temp1.hashCode();
		assertEquals(expected1, hashCode1);

		int expected2 = -947813100;
		int hashCode2 = temp2.hashCode();
		assertEquals(expected2, hashCode2);
	}

	@Test
	void testGetMain() {
		Main expexted1 = null;
		Main main1 = temp1.getMain();
		assertEquals(expexted1, main1);
		
		Main expexted2 = new Main(35, 37, 38, 40, 26, 18);
		Main main2 = temp2.getMain();
		assertEquals(expexted2, main2);
		
	}

	@Test
	void testGetName() {
		String expexted1 = null;
		String name1 = temp1.getName();
		assertEquals(expexted1, name1);
		
		String expexted2 = "Brasilia";
		String name2 = temp2.getName();
		assertEquals(expexted2, name2);
	}

	@Test
	void testSetMain() {
		Main newMain1 = new Main(35, 37, 38, 40, 26, 18);
		temp1.setMain(newMain1);
		Main main1 = temp1.getMain();
		assertEquals(newMain1, main1);
		
		Main newMain2 = new Main(25, 20, 22, 44, 15, 17);
		temp2.setMain(newMain2);
		Main main2 = temp2.getMain();
		assertEquals(newMain2, main2);
	}

	@Test
	void testSetName() {
		String expexted1 = "Cairo";
		temp1.setName(expexted1);
		String name1 = temp1.getName();
		assertEquals(expexted1, name1);
		
		String expexted2 = "Berlin";
		temp2.setName(expexted2);
		String name2 = temp2.getName();
		assertEquals(expexted2, name2);
	}

	@Test
	void testEqualsObject() {
		assertTrue(temp1.equals(new Temperature()));
		assertTrue(temp2.equals(new Temperature(new Main(35, 37, 38, 40, 26, 18), "Brasilia", new Coordinates(-10.9f, -37.55f))));
	}
	
	@Test
	void testEqualsObjectFalse() {
		assertFalse(temp1.equals(new Temperature(new Main(35, 37, 38, 40, 26, 18), "Brasilia", new Coordinates(-10.9f, -37.55f))));
		assertFalse(temp2.equals(new Temperature()));
	}

	@Test
	void testCanEqual() {
		assertTrue(temp1.canEqual(new Temperature()));
		assertTrue(temp2.canEqual(new Temperature(new Main(35, 37, 38, 40, 26, 18), "Brasilia", new Coordinates(-10.9f, -37.55f))));
	}

	@Test
	void testToString() {
		String expexted1 = "Temperature(main=null, name=null, coord=null)";
		String string1 = temp1.toString();
		assertEquals(expexted1, string1);
		
		String expexted2 = "Temperature(main=Main(temp=35, feels_like=37.0, temp_min=38, temp_max=40, pressure=26, humidity=18), name=Brasilia, coord=Coordinates(lat=-10.9, lon=-37.55))";
		String string2 = temp2.toString();
		assertEquals(expexted2, string2);
	}

	@Test
	void testTemperature() {
		assertNotNull(temp1);
		assertNotNull(temp2);
	}

}
