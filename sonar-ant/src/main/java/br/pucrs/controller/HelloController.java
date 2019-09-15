package br.pucrs.controller;

import br.pucrs.service.HelloService;

public class HelloController {

	private HelloService service;
	
	public String hello() {
		return service.say("Hello");
	}
	
	public String say(String message) {
		return service.say(message);
	}
	
}
