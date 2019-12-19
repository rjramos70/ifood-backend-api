package com.ifood.api.services;

import static com.ifood.api.constants.OpenWeatherConstants.API_MAIN_PATH;
import static com.ifood.api.constants.OpenWeatherConstants.UNIT_AND_APPID;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;

import com.ifood.api.models.Temperature;

@Service
public class OpenWeatherService {

	
	public Temperature getPlaylistByCityName(@PathVariable String city_name) {

		return WebClient.create().get().uri(API_MAIN_PATH.concat(city_name).concat(UNIT_AND_APPID)).retrieve()
				.bodyToMono(Temperature.class).block();
	}

}
