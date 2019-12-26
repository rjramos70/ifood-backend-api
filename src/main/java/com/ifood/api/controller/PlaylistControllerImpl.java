package com.ifood.api.controller;

import static com.ifood.api.constants.ApplicationConstants.API_END_POINT;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ifood.api.model.JsonResponse;
import com.ifood.api.service.OpenWeatherService;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping(API_END_POINT)
@Repository
public class PlaylistControllerImpl implements PlaylistController{

	
	private OpenWeatherService openWeatherService = new OpenWeatherService();
	
	@GetMapping("/playlist/{city_name}")
	public Mono<JsonResponse> getPlaylistByCityName(@PathVariable String city_name){

		return openWeatherService.getPlaylistByCityName(city_name);
	}
	
	@GetMapping("/playlist/{lat}/{lon}")
	public Mono<JsonResponse> getPlaylistByLatitudeLongitude(@PathVariable String lat, @PathVariable String lon){
		
		return openWeatherService.getPlaylistByLatitudeLongitude(lat, lon);

	}
	
	
}
