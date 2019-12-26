package com.ifood.api.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ifood.api.error.CustomExeception;
import com.ifood.api.model.JsonResponse;
import com.ifood.api.model.Temperature;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class OpenWeatherService {
	
	// Por nome da cidade
	// http://api.openweathermap.org/data/2.5/weather?q=Rio de Janeiro&units=metric&APPID=4fe8ce47347a8b26a85294ded4bf0f35
	
	private final String API_MAIN_PATH = "http://api.openweathermap.org/data/2.5/weather?";
	private final String UNIT_AND_APPID = "&units=metric&appid=4fe8ce47347a8b26a85294ded4bf0f35";
	
	// por latitude e longitude
	// http://api.openweathermap.org/data/2.5/weather?lat=35&lon=139&units=metric&APPID=4fe8ce47347a8b26a85294ded4bf0f35
	
	private int temperature;
	private String city_name;
	

	/**
	 * Método que gera playlist com base no nome da cidade
	 * @param city_name
	 * @return Mono<JsonResponse>
	 */
	public Mono<JsonResponse> getPlaylistByCityName(String city_name){
		
		return getPlayListId(getUrlByCityName(city_name));
	}
	
	/**
	 * Método que gera playlist com base na latitude e longitude da cidade
	 * @param latitude
	 * @param longitude
	 * @return Mono<JsonResponse>
	 */
	public Mono<JsonResponse> getPlaylistByLatitudeLongitude(String latitude, String longitude){
		
		return getPlayListId(getUrlByLatitudeAndLongitude(latitude, longitude));
	}
	
	
	/**
	 * Método responsavel por obter a cidade, tempertura e playlist
	 * @param urlComParametros
	 * @return Mono<JsonResponse>
	 */
	private Mono<JsonResponse> getPlayListId(String urlComParametros) {
		// Obter cidade e temperatura
		Mono<JsonResponse> responseMono = WebClient
			.create()
			.get()
			//.uri("/weather?q={city_name}&units=metric&APPID=4fe8ce47347a8b26a85294ded4bf0f35", "Brasilia")
			.uri(urlComParametros)
			.retrieve()
			.onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new CustomExeception("Erro no cliente")))
			.onStatus(HttpStatus::is5xxServerError, response -> Mono.error(new CustomExeception("Erro no servidor")))
			.bodyToMono(Temperature.class)
			.publishOn(Schedulers.elastic())
			.flatMap(retorno -> {
				// get the playlist base on temperature
				return WebClient
						.create()
						.get()
						.uri("https://deezerdevs-deezer.p.rapidapi.com/playlist/" + BusinessRulesService.getPlaylistIdByTemperature(retorno.getMain().getTemp()))
						.header("X-RapidAPI-Key", "40960e6417mshaf5daaab06d5058p1d915ejsn8d7f918a6626")
						.header("x-rapidapi-host", "deezerdevs-deezer.p.rapidapi.com")
						.retrieve()
						.onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new CustomExeception("Erro no cliente")))
						.onStatus(HttpStatus::is5xxServerError, response -> Mono.error(new CustomExeception("Erro no servidor")))
						.bodyToMono(JsonResponse.class)
						.doOnSuccess(element -> {
							element.setCity_name(retorno.getName());
							element.setTemperature(retorno.getMain().getTemp());
							element.setLatitude(retorno.getCoord().getLat());
							element.setLongitude(retorno.getCoord().getLon());
							element.setSuggest_track(BusinessRulesService.getSuggestTrack(retorno.getMain().getTemp()));
						});
			})
			.log(" playlist :: ");
		
		return responseMono;
		
	}
	
	
	/**
	 * Método que monta a URL com base no nome da cidade
	 * @param city_name
	 * @return String
	 */
	private String getUrlByCityName(String city_name) {
		
		return API_MAIN_PATH.concat("q=").concat(city_name).concat(UNIT_AND_APPID);
	}

	/**
	 * Método que monta a URL com base na latitude e longitude da cidade.
	 * @param lat
	 * @param lon
	 * @return String
	 */
	private String getUrlByLatitudeAndLongitude(String lat, String lon) {
		
		return API_MAIN_PATH.concat("lat=").concat(lat).concat("&lon=").concat(lon).concat(UNIT_AND_APPID);
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	

}



