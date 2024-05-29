package br.ufrj.hucff.controleestoque.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
//	Fabrica de JPA
private static EntityManagerFactory factory = null;
	
	static {
		
	if (factory == null){
		factory = Persistence.createEntityManagerFactory("controleestoque");
	}
	}
	public static EntityManager geEntityManager() {
		return factory.createEntityManager();
	}

}
