package br.edu.unisinos.bd2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

public class Jogo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_Jogo")
	@SequenceGenerator(name = "s_Jogo", sequenceName = "s_Jogo", allocationSize = 1)
	private Long id;
	
	@Getter @Setter
	@Column(nullable = false)
	private Long idCampeonato;
	
	@Getter @Setter
	@Column(length = 2, nullable = false)
	private Long idRodada;
	
	@Getter @Setter
	@Column(nullable = false)
	private Long idClube1;
	
	@Getter @Setter
	@Column(nullable = false)
	private Long idClube2;
	
	@Getter @Setter
	@Column(length = 2, nullable = true)
	private Integer clube1Gol;	
	
	@Getter @Setter
	@Column(length = 2, nullable = true)
	private Integer clube2Gol;	
	
	@Getter @Setter
	@Column(length = 2, nullable = true)
	private Integer clube1Amarelo;	
	
	@Getter @Setter
	@Column(length = 2, nullable = true)
	private Integer clube2Amarelo;
	
	@Getter @Setter
	@Column(length = 2, nullable = true)
	private Integer clube1Vermelho;	
	
	@Getter @Setter
	@Column(length = 2, nullable = true)
	private Integer clube2Vermelho;
	
	@Getter @Setter
	@Column(length = 2, nullable = true)
	private Integer clube1Ponto;	
	
	@Getter @Setter
	@Column(length = 2, nullable = true)
	private Integer clube2Ponto;		
}