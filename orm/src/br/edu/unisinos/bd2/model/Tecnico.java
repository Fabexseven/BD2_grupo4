package br.edu.unisinos.bd2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Tecnico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_Tecnico")
	@SequenceGenerator(name = "s_Tecnico", sequenceName = "s_Tecnico", allocationSize = 1)
	@OneToMany(mappedBy = "tecnico")
	private Long id;
	
	@Getter @Setter
	@Column(length = 50, nullable = false)
	private String nome;	
	
	public Tecnico() {
		
	}

	public Tecnico(String nome) {
		this.nome = nome;
	}
}
