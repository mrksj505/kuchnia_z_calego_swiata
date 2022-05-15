package com.kuchnia3;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "meal_dwa")
public class Meal implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_meal", unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id_meal;

	@Column(name = "meal_name")
	private String meal_name;
	
	@Column(name = "kind")
	private String kind;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "minutes_to_cook")
	private Integer minutes_to_cook;
	
	@Column(name = "recipe")
	private String recipe;
	
	public Integer getId_meal() {
		return id_meal;
	}

	public void setId_meal(Integer id_meal) {
		this.id_meal = id_meal;
	}

	public String getMeal_name() {
		return meal_name;
	}

	public void setMeal_name(String meal_name) {
		this.meal_name = meal_name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getMinutes_to_cook() {
		return minutes_to_cook;
	}

	public void setMinutes_to_cook(Integer minutes_to_cook) {
		this.minutes_to_cook = minutes_to_cook;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}
}