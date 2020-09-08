package br.edu.unisinos.bd2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(of = "id")
@Entity
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
	private Integer ano;		
	
	@Getter @Setter
	private Integer nroClubes;	
	
	@Getter @Setter
	@OneToMany(mappedBy = "campeonato")
	private List<Rodada> rodadas; 
	
	public Campeonato() {
		rodadas = new ArrayList<>();
	}
	
	public Campeonato(String nome, Integer ano, Integer nroClubes) {
		this.nome = nome;
		this.ano = ano;
		this.nroClubes = nroClubes;
	}
}
