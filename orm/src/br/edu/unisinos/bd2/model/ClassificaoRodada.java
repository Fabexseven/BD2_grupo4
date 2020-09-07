package br.edu.unisinos.bd2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

public class ClassificaoRodada implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_ClassificaoRodada")
	@SequenceGenerator(name = "s_ClassificaoRodada", sequenceName = "s_ClassificaoRodada", allocationSize = 1)
	private Long id;
	
	@Getter @Setter
	@Column(nullable = false)
	private Long idCampeonato;
	
	@Getter @Setter
	@Column(length = 2, nullable = false)
	private Long idRodada;
	
	@Getter @Setter
	@Column(length = 2, nullable = false)
	private Long idPosicao;
	
	@Getter @Setter
	@Column(nullable = false)
	private Long idClube;
	
	@Getter @Setter
	@Column(length = 3, nullable = true)
	private Integer totalPontos;	
	
	@Getter @Setter
	@Column(length = 2, nullable = true)
	private Integer totalVitorias;	
	
	@Getter @Setter
	@Column(length = 2, nullable = true)
	private Integer totalEmpates;	
	
	@Getter @Setter
	@Column(length = 2, nullable = true)
	private Integer totalDerrotas;
	
	@Getter @Setter
	@Column(length = 3, nullable = true)
	private Integer totalGolsPro;	
	
	@Getter @Setter
	@Column(length = 3, nullable = true)
	private Integer totalGolsContra;		
}