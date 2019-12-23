package com.ifood.api.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class MainTest {
	
	@Autowired
	private Main main1 = new Main();
	
	@Autowired
	private Main main2 = new Main(31, 35, 25, 42, 45, 37);
	
	
	@Test
	void testHashCode() {
		int expected1 = -83181974;
		int hashCode1 = main1.hashCode();
		assertEquals(expected1, hashCode1);
		
		int expected2 = -557597689;
		int hashCode2 = main2.hashCode();
		assertEquals(expected2, hashCode2);
	}

	@Test
	void testGetTemp() {
		int expected2 = 31;
		Integer temp2 = main2.getTemp();
		assertEquals(expected2, temp2);
	}

	@Test
	void testGetFeels_like() {
		float expected2 = 35;
		float feels_like2 = main2.getFeels_like();
		assertEquals(expected2, feels_like2);
	}

	@Test
	void testGetTemp_min() {
		Integer expected2 = 25;
		Integer temp_min2 = main2.getTemp_min();
		assertEquals(expected2, temp_min2);
	}

	@Test
	void testGetTemp_max() {
		Integer expected2 = 42;
		Integer temp_max2 = main2.getTemp_max();
		assertEquals(expected2, temp_max2);
	}

	@Test
	void testGetPressure() {
		Integer expected2 = 45;
		Integer pressure2 = main2.getPressure();
		assertEquals(expected2, pressure2);
	}

	@Test
	void testGetHumidity() {
		Integer expected2 = 37;
		Integer humidity2 = main2.getHumidity();
		assertEquals(expected2, humidity2);
	}

	@Test
	void testSetTemp() {
		int expectedTemp2 = 20;
		main2.setTemp(expectedTemp2);
		Integer temp2 = main2.getTemp();
		assertEquals(expectedTemp2, temp2);
	}

	@Test
	void testSetFeels_like() {
		float expectedTemp2 = 20;
		main2.setFeels_like(expectedTemp2);
		float feels_like2 = main2.getFeels_like();
		assertEquals(expectedTemp2, feels_like2);
	}

	@Test
	void testSetTemp_min() {
		Integer expectedTemp2 = 21;
		main2.setTemp_min(expectedTemp2);
		Integer temp_min2 = main2.getTemp_min();
		assertEquals(expectedTemp2, temp_min2);
	}

	@Test
	void testSetTemp_max() {
		Integer expectedTemp2 = 21;
		main2.setTemp_max(expectedTemp2);
		Integer temp_max2 = main2.getTemp_max();
		assertEquals(expectedTemp2, temp_max2);
	}

	@Test
	void testSetPressure() {
		Integer expectedTemp2 = 21;
		main2.setPressure(expectedTemp2);
		Integer pressure2 = main2.getPressure();
		assertEquals(expectedTemp2, pressure2);
	}

	@Test
	void testSetHumidity() {
		Integer expectedTemp2 = 21;
		main2.setHumidity(expectedTemp2);
		Integer humidity2 = main2.getHumidity();
		assertEquals(expectedTemp2, humidity2);
	}

	@Test
	void testEqualsObject() {
		assertTrue(main1.equals(new Main()));
		assertTrue(main2.equals(new Main(31, 35, 25, 42, 45, 37)));
	}

	@Test
	void testCanEqual() {
		boolean canEqual1 = main1.canEqual(new Main());
		assertTrue(canEqual1);
		
		boolean canEqual2 = main2.canEqual(new Main(31, 35, 25, 42, 45, 37));
		assertTrue(canEqual2);
	}

	@Test
	void testToString() {
		String expected1 = "Main(temp=null, feels_like=0.0, temp_min=null, temp_max=null, pressure=null, humidity=null)";
		String main1toString = main1.toString();
		assertEquals(expected1, main1toString);
		
		String expected2 = "Main(temp=31, feels_like=35.0, temp_min=25, temp_max=42, pressure=45, humidity=37)";
		String main2toString = main2.toString();
		assertEquals(expected2, main2toString);
	}

	@Test
	void testMain() {
		assertNotNull(main1);
		assertNotNull(main2);
	}
}
