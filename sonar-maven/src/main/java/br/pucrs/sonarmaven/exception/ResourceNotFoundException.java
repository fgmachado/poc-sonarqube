package br.pucrs.sonarmaven.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private final String message;

}
