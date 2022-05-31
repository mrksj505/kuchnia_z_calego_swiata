package com.kuchnia3.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.dom4j.tree.AbstractEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "users")
public class User extends AbstractEntity {

	
	private static final long serialVersionUID = 1L;

	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	   @Id 
	   @Column(name = "id", unique=true)
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Integer id;
	
	   @Column(name = "username")
	   private String username;

	   @Column(name = "password")
	   private String pwHash;

	   public User() {}

	   public User(String username, String password) {
	      this.username = username;
	      this.pwHash = encoder.encode(password);
	   }

	   public String getUsername() {
	      return username;
	   }
	   
	   public Integer getId() {
		return id;
	   }

		public void setId(Integer id) {
			this.id = id;
		}

	public boolean isMatchingPassword(String password) {
		   return encoder.matches(password, pwHash);
		}

}