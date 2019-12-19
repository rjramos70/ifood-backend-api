package com.ifood.api.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Main implements Serializable{
	
	private Double temp;
	private Double feels_like;
	private Double temp_min;
	private Double temp_max;
	private int pressure;
	private int humidity;

}
