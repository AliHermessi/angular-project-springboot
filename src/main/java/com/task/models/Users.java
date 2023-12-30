package com.task.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Users {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	  @Column(name = "name") 
	  private String name;
	  @Column(name = "email") 
	  private String email;
	  @Column(name = "number") 
	  private String number;
	  @Column(name = "imageUrl") 
	  private String imageUrl;
	  
	  public Users() 
	  {
		  
	  }
	  public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Users (Long id,String name,String email,String number) {
		  this.id=id;
		  this.number=number;
		  this.email=email;
		  this.name=name;
		  
	  }
	  
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	  

}
