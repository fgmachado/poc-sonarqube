package br.pucrs.sonarmaven.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.pucrs.sonarmaven.entity.Pessoa;

@DataJpaTest
@RunWith(SpringRunner.class)
public class PessoaRepositoryTests {

	private static final String CPF = "01234567890";

	@Autowired
	private PessoaRepository repository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void consultaPorCpf() {
		Pessoa expected = Pessoa.builder()
				.id(1L)
				.nome("Pessoa de Testes")
				.cpf(CPF)
				.dataCadastro(LocalDateTime.now())
				.build();
		
		entityManager.merge(expected);
		entityManager.flush();
		
		Pessoa actual = repository.findByCpf(CPF).orElse(null);
		
		assertNotNull(actual);
		assertEquals(expected, actual);
	}
	
}
