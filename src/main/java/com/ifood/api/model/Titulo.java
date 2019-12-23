package com.ifood.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Titulo {
	
	private String title;
	private Artista artist;
	private Album album;

}
