package br.pucrs.sonarmaven.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import br.pucrs.sonarmaven.entity.Pessoa;
import br.pucrs.sonarmaven.repository.PessoaRepository;

@RunWith(SpringRunner.class)
public class PessoaServiceImplTests {

	private static final String CPF = "01234567890";

	@TestConfiguration
	static class PessoaServiceImplConfiguration {
		
		@Bean
		public PessoaService pessoaService() {
			return new PessoaServiceImpl();
		}

	}
	
	@Autowired
	private PessoaService service;
	
	@MockBean
	private PessoaRepository repository;
	
	private Pessoa pessoa;
	
	@Before
	public void setup() {
		pessoa = Pessoa.builder()
				.id(1L)
				.nome("Pessoa de Testes")
				.cpf(CPF)
				.dataCadastro(LocalDateTime.now())
				.build();
		
		when(repository.findByCpf(CPF)).thenReturn(Optional.of(pessoa));
		when(repository.findAll()).thenReturn(Arrays.asList(pessoa));
	}
	
	@Test
	public void consultarTodas() {
		List<Pessoa> pessoas = service.consultarTodas();
		assertEquals(Arrays.asList(pessoa), pessoas);
	}
	
	@Test
	public void consultarPorCpf() {
		Pessoa actual = service.consultarPorCpf(CPF).orElse(null);
		
		assertNotNull(actual);
		assertEquals(CPF, actual.getCpf());
	}
	
}
