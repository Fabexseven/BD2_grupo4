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
public class Tecnico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_Tecnico")
	@SequenceGenerator(name = "s_Tecnico", sequenceName = "s_Tecnico", allocationSize = 1)
	private Long id;
	
	@Getter @Setter
	@Column(length = 50, nullable = false)
	private String nome;	

	@Getter @Setter
	@OneToMany(mappedBy = "tecnico")
	private List<ClubeTecnico> clubeTecnicos; 
	
	public Tecnico() {
		clubeTecnicos = new ArrayList<>();
	}

	public Tecnico(String nome) {
		this.nome = nome;
	}
}
