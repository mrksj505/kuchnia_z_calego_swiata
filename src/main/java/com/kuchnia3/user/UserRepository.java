package com.kuchnia3.user;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
		    .createEntityManagerFactory("Kuchnia3");
			
			public static void main(String[] args) {
				ENTITY_MANAGER_FACTORY.close();
			}

	public User getUserById(Integer id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT u FROM User u WHERE u.id = :id_user_param";
		
		TypedQuery<User> tq = em.createQuery(query, User.class);
		tq.setParameter("id_user_param", id);
		User user = null;
		try {
    		user = tq.getSingleResult();
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
		return user;
	}
	public User getUserByName(String username) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT u FROM User u WHERE u.username = :username_param";
		
		TypedQuery<User> tq = em.createQuery(query, User.class);
		tq.setParameter("username_param", username);
		User user = null;
		try {
    		user = tq.getSingleResult();
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
		return user;
	}
	
	public void saveUser(User user) {
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			
			em.persist(user);
			et.commit();	
		}
		catch(Exception ex) {
			if(et != null) {
				et.rollback();
			}
			ex.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	   
}
