package com.ifood.api.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class BusinessRulesServiceTest {

	@Autowired
	private BusinessRulesService businessRulesService;
	
	@Test
	void testSuggestTrack() {
		String expected1 = "tracks for party";
		String suggestTrack1 = businessRulesService.suggestTrack(31);
		assertEquals(expected1, suggestTrack1);
		
		String expected2 = "pop music tracks";
		String suggestTrack2 = businessRulesService.suggestTrack(20);
		assertEquals(expected2, suggestTrack2);
		
		String expected3 = "rock music tracks";
		String suggestTrack3 = businessRulesService.suggestTrack(13);
		assertEquals(expected3, suggestTrack3);
		
		String expected4 = "classic music tracks";
		String suggestTrack4 = businessRulesService.suggestTrack(5);
		assertEquals(expected4, suggestTrack4);
	}

	@Test
	void testGetPlaylistIdBySuggestTrack() {
		String expectedplaylistId1 = "2097558104";
		String playlistId1 = businessRulesService.getPlaylistIdBySuggestTrack(businessRulesService.suggestTrack(31));
		assertEquals(expectedplaylistId1 , playlistId1);
		
		String expectedplaylistId2 = "6373020664";
		String playlistId2 = businessRulesService.getPlaylistIdBySuggestTrack(businessRulesService.suggestTrack(20));
		assertEquals(expectedplaylistId2 , playlistId2);
		
		String expectedplaylistId3 = "1306931615";
		String playlistId3 = businessRulesService.getPlaylistIdBySuggestTrack(businessRulesService.suggestTrack(13));
		assertEquals(expectedplaylistId3 , playlistId3);
		
		String expectedplaylistId4 = "1673882381";
		String playlistId4 = businessRulesService.getPlaylistIdBySuggestTrack(businessRulesService.suggestTrack(5));
		assertEquals(expectedplaylistId4 , playlistId4);
	}

}
