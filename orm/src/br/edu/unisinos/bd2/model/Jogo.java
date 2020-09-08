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
@UniqueConstraint(name = "uk_clubes_rodada", columnNames = {"rodada","clube1","clube2"}))
public class Jogo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_Jogo")
	@SequenceGenerator(name = "s_Jogo", sequenceName = "s_Jogo", allocationSize = 1)
	private Long id;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name = "rodada", foreignKey = @ForeignKey(name = "idRodada"))
	public Rodada rodada;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name = "clube1", foreignKey = @ForeignKey(name = "idClube1"))
	public Clube clube1;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name = "clube2", foreignKey = @ForeignKey(name = "idClube2"))
	public Clube clube2;
	
	@Getter @Setter
	public Integer clube1Gol;	
	
	@Getter @Setter
	public Integer clube2Gol;	
	
	@Getter @Setter
	public Integer clube1Amarelo;	
	
	@Getter @Setter
	public Integer clube2Amarelo;
	
	@Getter @Setter
	public Integer clube1Vermelho;	
	
	@Getter @Setter
	public Integer clube2Vermelho;
	
	@Getter @Setter
	public Integer clube1Ponto;	
	
	@Getter @Setter
	public Integer clube2Ponto;	
	
	public Jogo() {}	
	
	public Jogo(Rodada rodada, Clube clube1, Clube clube2) {
		this.rodada 			= rodada;
		this.clube1 			= clube1;
		this.clube2 			= clube2;
		this.clube1Gol			= (int) (Math.random() * 11); 
		this.clube2Gol			= (int) (Math.random() * 11);
		this.clube1Amarelo		= (int) (Math.random() * 3);
		this.clube2Amarelo		= (int) (Math.random() * 3);
		this.clube1Vermelho 	= (int) (Math.random() * 2);
		this.clube2Vermelho	 	= (int) (Math.random() * 2);
		this.clube1Ponto		= (this.clube1Gol==this.clube2Gol?1:(this.clube1Gol>this.clube2Gol?3:0));
		this.clube2Ponto		= (this.clube1Gol==this.clube2Gol?1:(this.clube2Gol>this.clube1Gol?3:0));
		
		rodada.totalJogos 		= rodada.totalJogos + 1;
		rodada.totalAmarelos	= rodada.totalAmarelos  + clube1Amarelo  + clube2Amarelo;
		rodada.totalVermelhos	= rodada.totalVermelhos + clube1Vermelho + clube2Vermelho;
		rodada.totalGols		= rodada.totalGols + clube1Gol + clube2Gol;
	}
	
	public Jogo(Rodada rodada,Clube clube1, Clube clube2, Integer clube1Gol, Integer clube2Gol, Integer clube1Amarelo, Integer clube2Amarelo, Integer clube1Vermelho, Integer clube2Vermelho, Integer clube1Ponto, Integer clube2Ponto) {
		this.rodada 		= rodada;
		this.clube1 		= clube1;
		this.clube2 		= clube2;
		this.clube1Gol		= clube1Gol;
		this.clube2Gol		= clube2Gol;
		this.clube1Amarelo	= clube1Amarelo;
		this.clube2Amarelo	= clube2Amarelo;
		this.clube1Vermelho = clube1Vermelho;
		this.clube2Vermelho = clube2Vermelho;
		this.clube1Ponto	= clube1Ponto;
		this.clube2Ponto	= clube2Ponto;
	}
}