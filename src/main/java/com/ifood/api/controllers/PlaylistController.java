package com.ifood.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ifood.api.models.Temperature;
import com.ifood.api.models.WeatherResponse;
import com.ifood.api.services.OpenWeatherService;

import lombok.extern.slf4j.Slf4j;

import static com.ifood.api.constants.ApplicationConstants.API_END_POINT;
import static com.ifood.api.constants.OpenWeatherConstants.API_MAIN_PATH;
import static com.ifood.api.constants.OpenWeatherConstants.UNIT_AND_APPID;

@RestController
@Slf4j
public class PlaylistController {
	
	@Autowired
	OpenWeatherService openWeatherService;
	
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping(API_END_POINT + "/playlist/{city_name}")
	public Temperature getPlaylistByCityName(@PathVariable String city_name){
		
		return openWeatherService.getPlaylistByCityName(city_name);
	}

	@GetMapping(API_END_POINT + "/playlist2/{city_name}")
	public Temperature getPlaylistByCityName2(@PathVariable String city_name){
		
		return restTemplate.getForEntity(API_MAIN_PATH.concat(city_name).concat(UNIT_AND_APPID), Temperature.class).getBody();
	}
	
}
