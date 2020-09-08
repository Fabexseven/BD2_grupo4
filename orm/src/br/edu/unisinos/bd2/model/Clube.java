package br.edu.unisinos.bd2.model;

import java.io.Serializable;
import java.sql.Date;
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
public class Clube implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_Clube")
	@SequenceGenerator(name = "s_Clube", sequenceName = "s_Clube", allocationSize = 1)
	public Long id;
	
	@Getter @Setter
	@Column(length = 50, nullable = false)
	private String nome;		
	
	@Getter @Setter
	@Column(nullable = false)
	private Date dtFundacao;			
	
	@Getter @Setter
	@OneToMany(mappedBy = "clube")
	private List<ClubeJogador> jogadorClubes; 			
	
	@Getter @Setter
	@OneToMany(mappedBy = "clube")
	private List<ClubeTecnico> tecnicoClubes; 
	
	@Getter @Setter
	@OneToMany(mappedBy = "clube1")
	private List<Jogo> jogos1; 
	
	@Getter @Setter
	@OneToMany(mappedBy = "clube2")
	private List<Jogo> jogos2; 		
	
	@Getter @Setter
	@OneToMany(mappedBy = "clube")
	private List<ClassificacaoRodada> classificacao; 
	
	public Clube() {
		jogadorClubes = new ArrayList<>();
		tecnicoClubes = new ArrayList<>();
		jogos1 = new ArrayList<>();
		jogos2 = new ArrayList<>();
		classificacao = new ArrayList<>();
	}
	
	public Clube(String nome, Date dtFundacao) {
		this.nome = nome;
		this.dtFundacao = dtFundacao;
	}
}
