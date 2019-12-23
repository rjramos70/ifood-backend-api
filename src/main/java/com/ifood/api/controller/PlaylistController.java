package com.ifood.api.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.ifood.api.model.JsonResponse;

import reactor.core.publisher.Mono;

@Component
public interface PlaylistController {
	
	public Mono<JsonResponse> getPlaylistByCityName(@PathVariable String city_name);
	
	public Mono<JsonResponse> getPlaylistByLatitudeLongitude(@PathVariable String lat, @PathVariable String lon);

}
