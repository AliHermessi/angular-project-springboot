package com.task.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Courses {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "title") 
	    private String title;

	    @Column(name = "description") 
	    private String description;

	    @Column(name = "image_url")
	    private String imageUrl;

	    @Column(name = "price")
	    private double price;

	    @Column(name = "duration_in_hours")
	    private int durationInHours;

	    public Courses() {
	        
	    }
	    
	    public Courses(Long id, String title, String description, String imageUrl, double price, int durationInHours) {
	        this.id = id;
	        this.title = title;
	        this.description = description;
	        this.imageUrl = imageUrl;
	        this.price = price;
	        this.durationInHours = durationInHours;
	        
	    }
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getImageUrl() {
			return imageUrl;
		}
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public int getDurationInHours() {
			return durationInHours;
		}
		public void setDurationInHours(int durationInHours) {
			this.durationInHours = durationInHours;
		}
	
		
		
		
}
