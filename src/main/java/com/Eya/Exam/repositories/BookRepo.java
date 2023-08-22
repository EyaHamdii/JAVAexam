package com.Eya.Exam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Eya.Exam.models.Course;

@Repository
public interface BookRepo extends CrudRepository<Course, Long> ,PagingAndSortingRepository{
	
	// Read All
	List<Course> findAll();
}



