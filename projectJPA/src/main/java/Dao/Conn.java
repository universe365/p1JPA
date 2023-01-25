package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conn {
	
//	public static void main(String[] args) {
//		System.out.println(Conn.getDB());
//		
//	}
	
	public static EntityManager getDB() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products");
		System.out.println(emf); //print if success
		EntityManager em = emf.createEntityManager();
		System.out.println(em);
		
		return em;
	}
	

}
