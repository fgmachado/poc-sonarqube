package br.pucrs.sonarmaven.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "pessoa")
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private LocalDateTime dataCadastro;
	
}
