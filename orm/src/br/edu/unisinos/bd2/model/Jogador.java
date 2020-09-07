package br.edu.unisinos.bd2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

public class Jogador implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_Jogador")
	@SequenceGenerator(name = "s_Jogador", sequenceName = "s_Jogador", allocationSize = 1)
	private Long id;
	
	@Getter @Setter
	@Column(nullable = false)
	private Long idPosicao;
	
	@Getter @Setter
	@Column(length = 50, nullable = false)
	private String nome;		
}
