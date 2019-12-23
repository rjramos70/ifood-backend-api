package com.ifood.api.service;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.ifood.api.model.JsonResponse;
import com.ifood.api.model.Temperature;

import reactor.core.publisher.Mono;

public class OpenWeatherService {
	
	// Por nome da cidade
	// http://api.openweathermap.org/data/2.5/weather?q=Rio de Janeiro&units=metric&APPID=4fe8ce47347a8b26a85294ded4bf0f35
	
	private final static String API_MAIN_PATH = "http://api.openweathermap.org/data/2.5/weather?";
	private final static String UNIT_AND_APPID = "&units=metric&APPID=4fe8ce47347a8b26a85294ded4bf0f35";
	
	// por latitude e longitude
	// http://api.openweathermap.org/data/2.5/weather?lat=35&lon=139&units=metric&APPID=4fe8ce47347a8b26a85294ded4bf0f35
	
	private static int temperature;
	private static String city_name;
	

	/**
	 * Método que gera playlist com base no nome da cidade
	 * @param city_name
	 * @return Mono<JsonResponse>
	 */
	public static Mono<JsonResponse> getPlaylistByCityName(String city_name){
		
		return getPlayListId(getUrlByCityName(city_name));
	}
	
	/**
	 * Método que gera playlist com base na latitude e longitude da cidade
	 * @param latitude
	 * @param longitude
	 * @return Mono<JsonResponse>
	 */
	public static Mono<JsonResponse> getPlaylistByLatitudeLongitude(String latitude, String longitude){
		
		return getPlayListId(getUrlByLatitudeAndLongitude(latitude, longitude));
	}
	
	
	/**
	 * Método responsavel por obter a cidade, tempertura e playlist
	 * @param urlComParametros
	 * @return Mono<JsonResponse>
	 */
	private static Mono<JsonResponse> getPlayListId(String urlComParametros) {

		// Obter cidade e temperatura
		Mono<Temperature> flatMap = WebClient
			.create()
			.get()
			.uri(urlComParametros)
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
			.flatMap(response -> response.bodyToMono(Temperature.class))
			.log(" getPlayListId :: ");
		
		flatMap.subscribe(value -> {
			city_name = value.getName();
			temperature = value.getMain().getTemp();
		});
		
		String suggestTrack = BusinessRulesService.suggestTrack(temperature);
		String playlistId = BusinessRulesService.getPlaylistIdBySuggestTrack(suggestTrack);
		
		// Obter playlist 
		Mono<JsonResponse> bodyToFlux = WebClient
				.create()
				.get()
				.uri("https://deezerdevs-deezer.p.rapidapi.com/playlist/" + playlistId)
				.header("X-RapidAPI-Key", "40960e6417mshaf5daaab06d5058p1d915ejsn8d7f918a6626")
				.header("x-rapidapi-host", "deezerdevs-deezer.p.rapidapi.com")
				.retrieve()
				.bodyToMono(JsonResponse.class)
				.doOnSuccess(element -> {
					element.setCity_name(city_name);
					element.setTemperature(temperature);
					element.setSuggest_track(suggestTrack);
				})
				.log(" getPlaylistTracks :: ");
			
		return bodyToFlux;
	}
	
	
	/**
	 * Método que monta a URL com base no nome da cidade
	 * @param city_name
	 * @return String
	 */
	private static String getUrlByCityName(String city_name) {
		
		return API_MAIN_PATH.concat("q=").concat(city_name).concat(UNIT_AND_APPID);
	}

	/**
	 * Método que monta a URL com base na latitude e longitude da cidade.
	 * @param lat
	 * @param lon
	 * @return String
	 */
	private static String getUrlByLatitudeAndLongitude(String lat, String lon) {
		
		return API_MAIN_PATH.concat("lat=").concat(lat).concat("&lon=").concat(lon).concat(UNIT_AND_APPID);
	}
}
