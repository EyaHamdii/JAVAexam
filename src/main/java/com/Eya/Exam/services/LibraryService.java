package com.Eya.Exam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Eya.Exam.models.Library;
import com.Eya.Exam.repositories.LibraryRepo;

@Service
public class LibraryService {
	// === CRUD ===
	
	@Autowired
	private LibraryRepo libRepo;
	
	// READ ALL
	public List<Library> alllibs(){
		return libRepo.findAll();
	}
	
	// CREATE
	public Library createLibrary(Library l) {
		return libRepo.save(l);
	}
	
	// READ ONE
	public Library findLibrary(Long id) {
		
		Optional<Library> maybeLibrary = libRepo.findById(id);
		if(maybeLibrary.isPresent()) {
			return maybeLibrary.get();
		}else {
			return null;
		}
	}
	
	// UPDATE 
	public Library updateLibrary(Library l) {
		return libRepo.save(l);
	}
	
	// DELETE
	public void deleteLib(Long id) {
		libRepo.deleteById(id);
	}
	
}
