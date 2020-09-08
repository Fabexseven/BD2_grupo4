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
@UniqueConstraint(name = "uk_clubeJogador", columnNames = {"clube", "jogador"}))
public class ClubeJogador implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_ClubeJogador")
	@SequenceGenerator(name = "s_ClubeJogador", sequenceName = "s_ClubeJogador", allocationSize = 1)
	private Long id;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name = "clube", foreignKey = @ForeignKey(name = "idClube"))
	private Clube clube;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name = "jogador", foreignKey = @ForeignKey(name = "idJogador"))
	private Jogador jogador;
	
	public ClubeJogador() {}
	
	public ClubeJogador(Clube clube, Jogador jogador) {
		this.clube = clube;
		this.jogador = jogador;
	}
}
