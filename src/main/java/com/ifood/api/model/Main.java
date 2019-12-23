package com.ifood.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Main {

	private Integer temp;
	private float feels_like;
	private Integer temp_min;
	private Integer temp_max;
	private Integer pressure;
	private Integer humidity;
	
}
