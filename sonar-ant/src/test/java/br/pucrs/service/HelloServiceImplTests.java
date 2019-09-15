package br.pucrs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class HelloServiceImplTests {

	@Mock
	private HelloService service;
	
	@Test
	public void say() {
		String message = "Hello";
		
		when(service.say(message)).thenReturn(message);
		
		assertEquals(message, service.say(message));
	}
	
}
