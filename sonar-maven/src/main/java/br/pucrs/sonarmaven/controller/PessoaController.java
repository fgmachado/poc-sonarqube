package br.pucrs.sonarmaven.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.sonarmaven.entity.Pessoa;
import br.pucrs.sonarmaven.service.PessoaService;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

	@Autowired
	private PessoaService service;
	
	@GetMapping
	public List<Pessoa> consultarTodas() {
		return service.consultarTodas();
	}
	
	@GetMapping("{cpf}")
	public Optional<Pessoa> consultarPorCpf(@PathParam("cpf") String cpf) {
		return service.consultarPorCpf(cpf);
	}
	
}
