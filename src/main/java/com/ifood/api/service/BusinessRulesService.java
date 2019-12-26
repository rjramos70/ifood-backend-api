package com.ifood.api.service;

import java.util.HashMap;
import java.util.Map;

public class BusinessRulesService {

	private static Map<String, String> playlistIds;
	private static Map<Integer, String> suggestTrackTypes;
	
	private static void load() {
		if (suggestTrackTypes == null) {
			suggestTrackTypes = new HashMap<>();
			suggestTrackTypes.put(1, "tracks for party");
			suggestTrackTypes.put(2, "pop music tracks");
			suggestTrackTypes.put(3, "rock music tracks");
			suggestTrackTypes.put(4, "classic music tracks");
		}
		
		// classic music tracks -> 1673882381
		// tracks for party     -> 2097558104
		// pop music tracks     -> 6373020664
		// rock music tracks    -> 1306931615
		
		if (playlistIds == null) {
			playlistIds= new HashMap<>();
			playlistIds.put(suggestTrackTypes.get(1), "2097558104");
			playlistIds.put(suggestTrackTypes.get(2), "6373020664");
			playlistIds.put(suggestTrackTypes.get(3), "1306931615");
			playlistIds.put(suggestTrackTypes.get(4), "1673882381");
		}
	}
	
	public static String getSuggestTrack(int temperature) {
		load();
		
		String result = null;
		if (temperature > 30) {
			result = suggestTrackTypes.get(1); 	// "tracks for party";
		}else if (temperature >= 15 && temperature <= 30) {
			result = suggestTrackTypes.get(2); 	// "pop music tracks";
		}else if (temperature >= 10 && temperature < 15) {
			result = suggestTrackTypes.get(3); 	// "rock music tracks";
		}else if (temperature < 10) {
			result = suggestTrackTypes.get(4); 	// "classic music tracks";
		}
		return result;
	}
	
	public static String getPlaylistIdByTemperature(int temperature) {
		load();
		return playlistIds.get(getSuggestTrack(temperature));
	}
	
//	public static String getPlaylistIdBySuggestTrack(String suggestTrack) {
//		return playlistIds.get(suggestTrack);
//	}
	
}
