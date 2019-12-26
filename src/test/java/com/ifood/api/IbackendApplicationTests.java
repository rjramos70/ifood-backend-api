package com.ifood.api;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IbackendApplicationTests {

	private IbackendApplication ibackendApplication = new IbackendApplication();
	
	@Test
	void contextLoads() {
		assertNotNull(ibackendApplication);
	}

}
