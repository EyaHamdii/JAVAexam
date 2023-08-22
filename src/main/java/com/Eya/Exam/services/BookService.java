package com.Eya.Exam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Eya.Exam.models.Course;
import com.Eya.Exam.repositories.BookRepo;

@Service
public class BookService {
	// === CRUD ===
	
	@Autowired
	private BookRepo bookRepo;
	
	// READ ALL
	public List<Course> allBooks(){
		return bookRepo.findAll();
	}
	
	// CREATE
	public Course createBook(Course b) {
		return bookRepo.save(b);
	}
	
	// READ ONE
	public Course findBook(Long id) {
		
		Optional<Course> maybeBook = bookRepo.findById(id);
		if(maybeBook.isPresent()) {
			return maybeBook.get();
		}else {
			return null;
		}
	}
	
	// UPDATE 
	public Course updateBook(Course b) {
		return bookRepo.save(b);
	}
	
	// DELETE
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
}
