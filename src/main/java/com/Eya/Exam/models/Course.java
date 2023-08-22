package com.Eya.Exam.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

import java.util.Date; //for new Date()
import java.text.SimpleDateFormat; 

@Entity
@Table(name="course")
public class Course {
// MEMBER VARIABLES
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 5, max = 200, message="you need a Name!!!!")
	private String title;
	
	@NotNull
	@Min(10)
	@Max(9999)
	private Integer prices;

	// M:1
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="library_id")
	private Library library;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private User author;
	
	
	
	@NotBlank
	@Size(min = 5, max = 200, message="you need a description!!!!")
	private String description;
	
	@NotBlank
	@Size(min = 5, max = 200, message="Day is required!!!!")
	private String weekday;
	
	// This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;

	
	
	// EMPTY CONSTRUCTOR
	public Course() {
	}
	
//	----- methods ---
    // other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        LocalDate currentDate = LocalDate.now();
        this.createdAt = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }   

    
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	// GETTERS & SETTERS
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

	public void setDescription(String Description) {
		this.description = Description;
	}
	public String getWeekday() {
		return weekday;
	}

	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}
	public Integer getPrices() {
		return prices;
	}


	public void setPrices(Integer prices) {
		this.prices = prices;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	
	
	
}