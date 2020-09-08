package br.edu.unisinos.bd2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(of = "id")
@Entity
public class ClassificacaoRodada implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_ClassificaoRodada")
	@SequenceGenerator(name = "s_ClassificaoRodada", sequenceName = "s_ClassificaoRodada", allocationSize = 1)
	public Long id;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name = "rodada", foreignKey = @ForeignKey(name = "idRodada"))
	private Rodada rodada;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name = "clube", foreignKey = @ForeignKey(name = "idClube"))
	public Clube clube;
	
	@Getter @Setter
	@Column(nullable = false)
	public Integer posicao;
	
	@Getter @Setter
	public Integer totalPontos;	
	
	@Getter @Setter
	public Integer totalVitorias;	
	
	@Getter @Setter
	public Integer totalEmpates;	
	
	@Getter @Setter
	public Integer totalDerrotas;
	
	@Getter @Setter
	public Integer totalGolsPro;	
	
	@Getter @Setter
	public Integer totalGolsContra;	

	public ClassificacaoRodada() {}
	
	public ClassificacaoRodada(Rodada rodada, Clube clube) {
		this.posicao = 0;
		this.totalPontos = 0;
		this.totalVitorias = 0;
		this.totalEmpates = 0;
		this.totalDerrotas = 0;
		this.totalGolsPro = 0;
		this.totalGolsContra = 0;
		this.rodada = rodada;
		this.clube = clube;
	}
	
	public ClassificacaoRodada(Rodada rodada, Clube clube, Integer totalPontos, Integer totalVitorias, Integer totalEmpates, Integer totalDerrotas, Integer totalGolsPro, Integer totalGolsContra, Integer posicao) {
		this.posicao = posicao;
		this.totalPontos = totalPontos;
		this.totalVitorias = totalVitorias;
		this.totalEmpates = totalEmpates;
		this.totalDerrotas = totalDerrotas;
		this.totalGolsPro = totalGolsPro;
		this.totalGolsContra = totalGolsContra;
		this.rodada = rodada;
		this.clube = clube;
	}
}