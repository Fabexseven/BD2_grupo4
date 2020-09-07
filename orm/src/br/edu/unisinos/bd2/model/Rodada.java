package br.edu.unisinos.bd2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

public class Rodada implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_Rodada")
	@SequenceGenerator(name = "s_Rodada", sequenceName = "s_Rodada", allocationSize = 1)
	@Column(length = 2)
	private Long id;
	
	@Getter @Setter
	@Column(nullable = false)
	private Long idRodada;
	
	@Getter @Setter
	@Column(length = 2, nullable = true)
	private Integer totalJogos;		
	
	@Getter @Setter
	@Column(length = 3, nullable = true)
	private Integer totalAmarelos;		
	
	@Getter @Setter
	@Column(length = 3, nullable = true)
	private Integer totalVermelhos;	
	
	@Getter @Setter
	@Column(length = 3, nullable = true)
	private Integer totalGols;	
}
