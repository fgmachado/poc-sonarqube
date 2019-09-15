package br.pucrs.sonarmaven.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.pucrs.sonarmaven.entity.Pessoa;
import br.pucrs.sonarmaven.service.PessoaService;

@RunWith(SpringRunner.class)
@WebMvcTest(PessoaController.class)
public class PessoaControllerTests {
	
	private static final String CPF = "01234567890";

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private PessoaService service;
	
	private Pessoa pessoa;
	
	@Before
	public void setup() {
		pessoa = Pessoa.builder()
				.id(1L)
				.nome("Pessoa de Testes")
				.cpf(CPF)
				.dataCadastro(LocalDateTime.now())
				.build();
	}
	
	@Test
	public void consultarTodas() throws Exception {
		when(service.consultarTodas()).thenReturn(Arrays.asList(pessoa));
		
		mvc.perform(get("/pessoas").contentType(APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].cpf", is(pessoa.getCpf())));
	}
	
	/*@Test
	public void consultarPorCpf() throws Exception {
		when(service.consultarPorCpf(CPF)).thenReturn(Optional.of(pessoa));
		
		mvc.perform(get("/pessoas/" + CPF).contentType(APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.cpf", is(pessoa.getCpf())));
	}*/
	
}
