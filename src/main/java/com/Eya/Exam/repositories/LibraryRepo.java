package com.Eya.Exam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Eya.Exam.models.Library;

@Repository
public interface LibraryRepo extends CrudRepository<Library, Long> {
	
List<Library> findAll();
}