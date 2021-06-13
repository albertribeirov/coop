package br.com.cooperativa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("lacqua");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}