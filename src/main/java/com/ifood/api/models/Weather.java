package com.ifood.api.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather implements Serializable{
	
	private int id;
	private String main;
	private String description;
	private String icon;
	

}
