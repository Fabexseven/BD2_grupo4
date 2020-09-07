	package br.edu.unisinos.bd2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

public class Campeonato implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_Campeonato")
	@SequenceGenerator(name = "s_Campeonato", sequenceName = "s_Campeonato", allocationSize = 1)
	private Long id;
	
	@Getter @Setter
	@Column(length = 50, nullable = false)
	private String nome;		
	
	@Getter @Setter
	@Column(length = 4, nullable = false)
	private Integer ano;		
	
	@Getter @Setter
	@Column(length = 2, nullable = false)
	private Integer nroClubes;	

}
