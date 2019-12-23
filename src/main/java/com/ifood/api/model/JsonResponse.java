package com.ifood.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResponse {

	private String city_name;
	private Integer temperature;
	private String suggest_track;
	private Tracks tracks;
	
}
