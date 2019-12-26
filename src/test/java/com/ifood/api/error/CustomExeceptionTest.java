package com.ifood.api.error;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.ifood.api.model.Titulo;
import com.ifood.api.model.Tracks;

@RunWith(SpringRunner.class)
class CustomExeceptionTest {

	private CustomExeception exception1 = new CustomExeception();
	private CustomExeception exception2 = new CustomExeception("Mensagem de teste");
	
	@Test
	void testHashCode() {
		int expected1 = 102;
		int hashCode1 = exception1.hashCode();
		assertEquals(expected1, hashCode1);

		int expected2 = -961387484;
		int hashCode2 = exception2.hashCode();
		assertEquals(expected2, hashCode2);
	}

	@Test
	void testGetMessage() {
		String expexted1 = null;
		String message1 = exception1.getMessage();
		assertEquals(expexted1, message1);
		
		String expexted2 = "Mensagem de teste";
		String message2 = exception2.getMessage();
		assertEquals(expexted2, message2);
	}

	@Test
	void testSetMessage() {
		String expected1 = "Erro teste";
		exception1.setMessage(expected1);
		String message1 = exception1.getMessage();
		assertEquals(expected1, message1);
		
		String expected2 = "Mensagem de teste";
		exception2.setMessage(expected2);
		String message2 = exception2.getMessage();
		assertEquals(expected2, message2);
	}

	@Test
	void testEqualsObject() {
		assertTrue(exception1.equals(new CustomExeception()));
		assertTrue(exception2.equals(new CustomExeception("Mensagem de teste")));
	}

	@Test
	void testEqualsObjectNull() {
		assertFalse(exception1.equals(null));
		assertFalse(exception2.equals(null));
	}
	
	@Test
	void testEqualsObjectError() {
		assertFalse(exception1.equals(new CustomExeception("Mensagem de teste")));
		assertFalse(exception2.equals(new CustomExeception()));
	}
	
	@Test
	void testCanEqual() {
		assertTrue(exception1.canEqual(new CustomExeception()));
		assertTrue(exception2.canEqual(new CustomExeception("Mensagem de teste")));
	}

	@Test
	void testCanEqualNull() {
		assertFalse(exception1.canEqual(null));
		assertFalse(exception2.canEqual(null));
	}
	
	@Test
	void testCanEqualError() {
		assertFalse(exception1.canEqual(new Titulo()));
		assertFalse(exception2.canEqual(new Tracks()));
	}
	@Test
	void testToString() {
		String expected1 = "CustomExeception(message=null)";
		String string1 = exception1.toString();
		assertEquals(expected1, string1);
		
		String expected2 = "CustomExeception(message=Mensagem de teste)";
		String string2 = exception2.toString();
		assertEquals(expected2, string2);
	}


	@Test
	void testCustomExeception() {
		assertNotNull(exception1);
		assertNotNull(exception2);
	}

}
