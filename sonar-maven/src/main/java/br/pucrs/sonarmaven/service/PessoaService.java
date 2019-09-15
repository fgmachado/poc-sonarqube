package br.pucrs.sonarmaven.service;

import java.util.List;
import java.util.Optional;

import br.pucrs.sonarmaven.entity.Pessoa;

public interface PessoaService {

	List<Pessoa> consultarTodas();
	
	Optional<Pessoa> consultarPorCpf(String cpf);
	
}
