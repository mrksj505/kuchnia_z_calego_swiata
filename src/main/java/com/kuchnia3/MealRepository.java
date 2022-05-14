package com.kuchnia3;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class MealRepository {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
    .createEntityManagerFactory("Kuchnia3");
	
	public static void main(String[] args) {
		ENTITY_MANAGER_FACTORY.close();
	}
	
	public void addMeal(String name, String kind, String country, Integer minutes, String recipe) {
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			
			Meal new_meal = new Meal();
			new_meal.setMeal_name(name);
			new_meal.setKind(kind);
			new_meal.setCountry(country);
			new_meal.setMinutes_to_cook(minutes);
			new_meal.setRecipe(recipe);
			
			em.persist(new_meal);
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
	public Meal getMeal(Integer id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT m FROM Meal m WHERE m.id_meal = :id_meal_param";
		
		TypedQuery<Meal> tq = em.createQuery(query, Meal.class);
		tq.setParameter("id_meal_param", id);
		Meal meal = null;
		try {
    		// Get matching customer object and output
    		meal = tq.getSingleResult();
    		System.out.println(meal.getMeal_name() + " " + meal.getCountry());
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
		return meal;
	}
	public List<Meal> getAllMeals() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT m FROM Meal m";
		TypedQuery<Meal> tq = em.createQuery(query, Meal.class);
		List<Meal> listMeal = null;
		try {
			listMeal = tq.getResultList();
		}
		catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}

		// Sortowanie listy po id
		Collections.sort(listMeal, new Comparator<Meal>() {
		    public int compare(Meal m1, Meal m2)
		    {
		        return m1.getId_meal().compareTo(m2.getId_meal()); // Compare by name, for example
		    }});
		
		return listMeal;
	}
	
	public void updateMeal(int id, String name, String kind, String country, Integer minutes, String recipe) {
	    EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
	    EntityTransaction et = null;
	        
	    Meal edited_meal = null;
	 
	        try {
	            et = em.getTransaction();
	            et.begin();
	 
	            edited_meal = em.find(Meal.class, id);
	            edited_meal.setMeal_name(name);
	            edited_meal.setKind(kind);
	            edited_meal.setCountry(country);
	            edited_meal.setMinutes_to_cook(minutes);
	            edited_meal.setRecipe(recipe);
	 
	            // Save the customer object
	            em.persist(edited_meal);
	            et.commit();
	        } catch (Exception ex) {
	            // If there is an exception rollback changes
	            if (et != null) {
	                et.rollback();
	            }
	            ex.printStackTrace();
	        } finally {
	            // Close EntityManager
	            em.close();
	        }
	    }
}
