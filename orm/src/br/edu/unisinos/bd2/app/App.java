package br.edu.unisinos.bd2.app;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.edu.unisinos.bd2.model.Campeonato;
import br.edu.unisinos.bd2.model.ClassificacaoRodada;
import br.edu.unisinos.bd2.model.Clube;
import br.edu.unisinos.bd2.model.ClubeJogador;
import br.edu.unisinos.bd2.model.ClubeTecnico;
import br.edu.unisinos.bd2.model.Jogador;
import br.edu.unisinos.bd2.model.Jogo;
import br.edu.unisinos.bd2.model.Posicao;
import br.edu.unisinos.bd2.model.Rodada;
import br.edu.unisinos.bd2.model.Tecnico;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bd2");
		EntityManager em = emf.createEntityManager();

		//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Begin	
		em.getTransaction().begin();
		//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Posições
		Posicao atacante = em.merge(new Posicao("Atacante"));
		Posicao meioCampo = em.merge(new Posicao("Meio-Campo"));
		Posicao lateral = em.merge(new Posicao("Lateral"));
		Posicao zagueiro = em.merge(new Posicao("Zagueiro"));
		Posicao goleiro = em.merge(new Posicao("Goleiro"));
		//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Jogadores
		Jogador pepe = em.merge(new Jogador(atacante,"Pepê"));
		Jogador maicon = em.merge(new Jogador(meioCampo,"Maicon"));
		Jogador victorFerraz = em.merge(new Jogador(lateral,"Victor Ferraz"));
		Jogador pedroGeromel = em.merge(new Jogador(zagueiro,"Pedro Geromel"));
		Jogador vanderlei = em.merge(new Jogador(goleiro,"Vanderlei"));
		Jogador paoloGuerreiro = em.merge(new Jogador(atacante,"Paolo Guerreiro"));
		Jogador thiagoGalhardo = em.merge(new Jogador(meioCampo,"Thiago Galhardo"));
		Jogador moises = em.merge(new Jogador(lateral,"Moisés"));
		Jogador victorCuesta = em.merge(new Jogador(zagueiro,"Victor Cuesta"));
		Jogador marceloLomba = em.merge(new Jogador(goleiro,"Marcelo Lomba"));
		//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Tecnicos
		Tecnico renatoPortaluppi = em.merge(new Tecnico("Renato Portaluppi"));
		Tecnico eduardoCoudet = em.merge(new Tecnico("Eduardo Coudet"));
		//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Clubes
		Date gremioFound = Date.valueOf("1903-09-15");
		Clube gremio = em.merge(new Clube("Grêmio",gremioFound));
		Date interFound = Date.valueOf("1909-04-04");
		Clube inter = em.merge(new Clube("Internacional",interFound));
		//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//ClubeTecnico
		em.persist(new ClubeTecnico(gremio, renatoPortaluppi));
		em.persist(new ClubeTecnico(inter, eduardoCoudet));
		//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//ClubeJogador
		em.persist(new ClubeJogador(gremio, pepe));
		em.persist(new ClubeJogador(gremio, maicon));
		em.persist(new ClubeJogador(gremio, victorFerraz));
		em.persist(new ClubeJogador(gremio, pedroGeromel));
		em.persist(new ClubeJogador(gremio, vanderlei));
		em.persist(new ClubeJogador(inter, paoloGuerreiro));
		em.persist(new ClubeJogador(inter, thiagoGalhardo));
		em.persist(new ClubeJogador(inter, moises));
		em.persist(new ClubeJogador(inter, victorCuesta));
		em.persist(new ClubeJogador(inter, marceloLomba));
		//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Campeonato
		Integer nroClubes = 2;
		Campeonato campeonato = em.merge(new Campeonato("Gaúcho", 2020, nroClubes));
		//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Rodadas
		Rodada rodada1 = em.merge(new Rodada(campeonato));
		Rodada rodada2 = em.merge(new Rodada(campeonato));
		//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Jogos	
		em.persist(new Jogo(rodada1,gremio,inter));//metodo criado para gerar valores através do math random
		em.persist(new Jogo(rodada2,gremio,inter));//metodo criado para gerar valores através do math random
		//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Commit	
		em.getTransaction().commit();
		em.clear();
		//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Updates	
		TypedQuery<Jogo> q = em.createQuery("FROM Jogo ", Jogo.class);
		q.getResultList().stream().forEach(o -> {		
			Rodada rodada = o.rodada;	
			Clube clube1  = o.clube1;	
			Clube clube2  = o.clube2;
			int[] clube1data = {o.clube1Ponto,(o.clube1Ponto == 3?1:0), (o.clube1Ponto == 1?1:0), (o.clube1Ponto == 0?1:0), o.clube1Gol,o.clube2Gol};
			int[] clube2data = {o.clube2Ponto,(o.clube2Ponto == 3?1:0), (o.clube2Ponto == 1?1:0), (o.clube2Ponto == 0?1:0), o.clube2Gol,o.clube1Gol};
			
			TypedQuery<ClassificacaoRodada> q1 = em.createQuery("FROM ClassificacaoRodada", ClassificacaoRodada.class);
			q1.getResultList().stream().forEach(o1 -> {
				
				if(o1.clube.id == clube1.id) {
					clube1data[0] += o1.totalPontos;
					clube1data[1] += o1.totalVitorias;
					clube1data[2] += o1.totalEmpates;
					clube1data[3] += o1.totalDerrotas;
					clube1data[4] += o1.totalGolsPro;
					clube1data[5] += o1.totalGolsContra;			
				}				
				else {
					clube2data[0] += o1.totalPontos;
					clube2data[1] += o1.totalVitorias;
					clube2data[2] += o1.totalEmpates;
					clube2data[3] += o1.totalDerrotas;
					clube2data[4] += o1.totalGolsPro;
					clube2data[5] += o1.totalGolsContra;			
				}						
			});	
			
			//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			//Begin	
		    em.getTransaction().begin();
			//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			//ClassificacaoRodada	
			em.persist(new ClassificacaoRodada(rodada, clube1, clube1data[0], clube1data[1], clube1data[2], clube1data[3], clube1data[4], clube1data[5],((clube1data[0]==clube2data[0])?1:(clube1data[0]>clube2data[0])?1:2)));
			em.persist(new ClassificacaoRodada(rodada, clube2, clube2data[0], clube2data[1], clube2data[2], clube2data[3], clube2data[4], clube2data[5],((clube1data[0]==clube2data[0])?2:(clube2data[0]>clube1data[0])?1:2)));
			//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			//Commit	
			em.getTransaction().commit();
			em.clear();
		});
		em.clear();	
	}
}
