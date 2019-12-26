package com.ifood.api.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.ifood.api.constants.ApplicationConstants;

@ExtendWith(SpringExtension.class)
@WebFluxTest(PlaylistControllerImpl.class)
@ContextConfiguration(classes = {
		PlaylistControllerImpl.class
})
class PlaylistControllerImplTest {
	
	@Autowired
	private WebTestClient webTestClient;
	

	@Test
	void testGetPlaylistByCityName() {
		
		webTestClient
			.get()
			.uri(ApplicationConstants.API_END_POINT.concat("/playlist/{city_name}"), "Shuzenji")
			.exchange()
			.expectStatus().isOk()
			.expectBody()
//			.jsonPath("$.name", "Shuzenji");
			.consumeWith(response -> 
				Assertions.assertThat(response.getResponseBody()).isNotNull()
			);
			
		
	}

	@Test
	void testGetPlaylistByLatitudeLongitude() {
		webTestClient
		.get()
		.uri(ApplicationConstants.API_END_POINT.concat("/playlist/{lat}/{lon}"), "35", "139")
		.exchange()
		.expectStatus().isOk()
		.expectBody()
		.jsonPath("$.suggest_track", "classic music tracks");
	}

}
