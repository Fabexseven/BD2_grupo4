package br.edu.unisinos.bd2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

public class ClubeJogador implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_ClubeJogador")
	@SequenceGenerator(name = "s_ClubeJogador", sequenceName = "s_ClubeJogador", allocationSize = 1)
	private Long id;
	
	@Getter @Setter
	@Column(nullable = false)
	private Long idClube;
	
	@Getter @Setter
	@Column(nullable = false)
	private Long idJogador;
	
	public ClubeJogador() {
		
	}
}
