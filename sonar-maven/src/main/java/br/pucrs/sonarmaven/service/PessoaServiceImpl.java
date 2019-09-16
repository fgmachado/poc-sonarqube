package br.pucrs.sonarmaven.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucrs.sonarmaven.entity.Pessoa;
import br.pucrs.sonarmaven.repository.PessoaRepository;

@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> consultarTodas() {
		return repository.findAll();
	}

	public Optional<Pessoa> consultarPorCpf(String cpf) {
		return repository.findByCpf(cpf);
	}
	
}
