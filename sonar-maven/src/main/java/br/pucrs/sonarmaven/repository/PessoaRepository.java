package br.pucrs.sonarmaven.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucrs.sonarmaven.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	Optional<Pessoa> findByCpf(String cpf);
	
}
