package br.edu.unisinos.bd2.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

public class Clube implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_Clube")
	@SequenceGenerator(name = "s_Clube", sequenceName = "s_Clube", allocationSize = 1)
	private Long id;
	
	@Getter @Setter
	@Column(length = 50, nullable = false)
	private String nome;		
	
	@Getter @Setter
	@Column(nullable = false)
	private Date dtFundacao;		
}
