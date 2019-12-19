package com.ifood.api.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sys implements Serializable{
	
	private int type;
	private int id;
	private String country;
	private long sunrise;
	private long sunset;

}
