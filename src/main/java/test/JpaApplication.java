package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import test.entity.Member;

public class JpaApplication {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		//test
		try {
			Member member = new Member();
			member.setId(100L);
			member.setName("hello~~");
			
			em.persist(member);
			
			tx.commit();
		} catch(Exception e) {
			tx.rollback();			
		} finally {
			em.close();						
		}
		
		emf.close();
	}
}
