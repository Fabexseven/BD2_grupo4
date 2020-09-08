package br.edu.unisinos.bd2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(of = "id")
@Entity
public class Jogador implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_Jogador")
	@SequenceGenerator(name = "s_Jogador", sequenceName = "s_Jogador", allocationSize = 1)
	private Long id;
	
	@Getter @Setter
	@Column(length = 50, nullable = false)
	private String nome;		

	@Getter @Setter
	@ManyToOne
	@JoinColumn(name = "posicao", foreignKey = @ForeignKey(name = "idPosicao"))
	private Posicao posicao;	
	
	@Getter @Setter
	@OneToMany(mappedBy = "jogador")
	private List<ClubeJogador> clubeJogadores; 	
	
	public Jogador() {
		clubeJogadores = new ArrayList<>();
	}		
	
	public Jogador(Posicao posicao, String nome) {
		this.posicao = posicao;		
		this.nome = nome;
	}	
}
