package br.edu.unisinos.bd2.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.unisinos.bd2.model.Tecnico;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bd2");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(new Tecnico("Renato"));
		em.getTransaction().commit();
		em.clear();

	}
}
