package br.edu.unisinos.bd2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
public class Rodada implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_Rodada")
	@SequenceGenerator(name = "s_Rodada", sequenceName = "s_Rodada", allocationSize = 1)
	public Long id;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name = "campeonato", foreignKey = @ForeignKey(name = "idCampeonato"))
	private Campeonato campeonato;
	
	@Getter @Setter
	public Integer totalJogos;		
	
	@Getter @Setter
	public Integer totalAmarelos;		
	
	@Getter @Setter
	public Integer totalVermelhos;	
	
	@Getter @Setter
	public Integer totalGols;
	
	@Getter @Setter
	@OneToMany(mappedBy = "rodada")
	private List<Jogo> jogos; 
	
	@Getter @Setter
	@OneToMany(mappedBy = "rodada")
	private List<ClassificacaoRodada> classificacao; 
	
	public Rodada() {
		jogos = new ArrayList<>();
		classificacao = new ArrayList<>();
	}
	
	public Rodada(Campeonato campeonato) {
		this.campeonato = campeonato;	
		this.totalJogos = 0;
		this.totalAmarelos = 0;
		this.totalVermelhos = 0;
		this.totalGols = 0;		
	}
	
	public Rodada(Campeonato campeonato, Integer totalJogos,  Integer totalAmarelos,  Integer totalVermelhos, Integer totalGols) {
		this.campeonato = campeonato;		
		this.totalJogos = totalJogos;
		this.totalAmarelos = totalAmarelos;
		this.totalVermelhos = totalVermelhos;
		this.totalGols = totalGols;
	}	
}
