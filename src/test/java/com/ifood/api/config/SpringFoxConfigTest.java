package com.ifood.api.config;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class SpringFoxConfigTest {

	private SpringFoxConfig springFoxConfig = new SpringFoxConfig();
	
	@Test
	void testSpringFoxConfig() {
		assertNotNull(springFoxConfig);
	}

}
