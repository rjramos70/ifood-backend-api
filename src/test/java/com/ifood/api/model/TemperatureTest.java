package com.ifood.api.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class TemperatureTest {

	private Temperature temp1 = new Temperature();
	private Temperature temp2 = new Temperature(new Main(35, 37, 38, 40, 26, 18), "Brasilia");
	
	@Test
	void testHashCode() {
		int expected1 = 6061;
		int hashCode1 = temp1.hashCode();
		System.out.println(" hashCode1 :: " + hashCode1);
		assertEquals(expected1, hashCode1);

		int expected2 = -1274009102;
		int hashCode2 = temp2.hashCode();
		System.out.println(" hashCode2 :: " + hashCode2);
		assertEquals(expected2, hashCode2);
	}

	@Test
	void testGetMain() {
		Main expexted1 = null;
		Main main1 = temp1.getMain();
		System.out.println(" main1 :: " + main1);
		assertEquals(expexted1, main1);
		
		Main expexted2 = new Main(35, 37, 38, 40, 26, 18);
		Main main2 = temp2.getMain();
		System.out.println(" main2 :: " + main2);
		assertEquals(expexted2, main2);
		
	}

	@Test
	void testGetName() {
		String expexted1 = null;
		String name1 = temp1.getName();
		System.out.println(" name1 :: " + name1);
		assertEquals(expexted1, name1);
		
		String expexted2 = "Brasilia";
		String name2 = temp2.getName();
		System.out.println(" name2 :: " + name2);
		assertEquals(expexted2, name2);
	}

	@Test
	void testSetMain() {
		Main newMain1 = new Main(35, 37, 38, 40, 26, 18);
		temp1.setMain(newMain1);
		Main main1 = temp1.getMain();
		System.out.println(" main1 :: " + main1);
		assertEquals(newMain1, main1);
		
		Main newMain2 = new Main(25, 20, 22, 44, 15, 17);
		temp2.setMain(newMain2);
		Main main2 = temp2.getMain();
		System.out.println(" main2 :: " + main2);
		assertEquals(newMain2, main2);
	}

	@Test
	void testSetName() {
		String expexted1 = "Cairo";
		temp1.setName(expexted1);
		String name1 = temp1.getName();
		System.out.println(" name1 :: " + name1);
		assertEquals(expexted1, name1);
		
		String expexted2 = "Berlin";
		temp2.setName(expexted2);
		String name2 = temp2.getName();
		System.out.println(" name2 :: " + name2);
		assertEquals(expexted2, name2);
	}

	@Test
	void testEqualsObject() {
		assertTrue(temp1.equals(new Temperature()));
		assertTrue(temp2.equals(new Temperature(new Main(35, 37, 38, 40, 26, 18), "Brasilia")));
	}
	
	@Test
	void testEqualsObjectFalse() {
		assertFalse(temp1.equals(new Temperature(new Main(35, 37, 38, 40, 26, 18), "Brasilia")));
		assertFalse(temp2.equals(new Temperature()));
	}

	@Test
	void testCanEqual() {
		assertTrue(temp1.canEqual(new Temperature()));
		assertTrue(temp2.canEqual(new Temperature(new Main(35, 37, 38, 40, 26, 18), "Brasilia")));
	}

	@Test
	void testToString() {
		String expexted1 = "Temperature(main=null, name=null)";
		String string1 = temp1.toString();
		System.out.println(" string1 :: " + string1);
		assertEquals(expexted1, string1);
		
		String expexted2 = "Temperature(main=Main(temp=35, feels_like=37.0, temp_min=38, temp_max=40, pressure=26, humidity=18), name=Brasilia)";
		String string2 = temp2.toString();
		System.out.println(" string2 :: " + string2);
		assertEquals(expexted2, string2);
	}

	@Test
	void testTemperature() {
		assertNotNull(temp1);
		assertNotNull(temp2);
	}

}
