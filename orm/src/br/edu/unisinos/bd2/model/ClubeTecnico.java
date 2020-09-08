package br.edu.unisinos.bd2.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(of = "id")
@Entity
@Table(uniqueConstraints = 
@UniqueConstraint(name = "uk_clubeTecnico", columnNames = {"clube", "tecnico"}))
public class ClubeTecnico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_ClubeTecnico")
	@SequenceGenerator(name = "s_ClubeTecnico", sequenceName = "s_ClubeTecnico", allocationSize = 1)
	private Long id;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name = "clube", foreignKey = @ForeignKey(name = "idClube"))
	private Clube clube;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name = "tecnico", foreignKey = @ForeignKey(name = "idTecnico"))
	private Tecnico tecnico;
	
	public ClubeTecnico() {}
	
	public ClubeTecnico(Clube clube, Tecnico tecnico) {
		this.clube = clube;
		this.tecnico = tecnico;	
	}
}
