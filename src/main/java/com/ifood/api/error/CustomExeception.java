package com.ifood.api.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomExeception extends Throwable {

	private static final long serialVersionUID = 1L;
	
	private String message;
	

}
