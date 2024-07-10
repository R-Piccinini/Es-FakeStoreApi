package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	  @Autowired
	    private CategoryService categoryservice;
	  
	  @GetMapping
	    public List<Category> getLista() {
	        return categoryservice.getLista();
	    }
	  
	  @PostMapping
	    public ResponseEntity<String> addCat(@RequestBody Category category) {
	        categoryservice.addCat(category);;
	        return new ResponseEntity<>("Categoria aggiunta", HttpStatus.CREATED);
	    }
	  
	  @PutMapping("/{id}")
	    public ResponseEntity<String> updateCat(@PathVariable Integer id, @RequestBody Category updatedCat) {
	        boolean updated = categoryservice.updateCat(id, updatedCat);
	        if (updated) {
	            return new ResponseEntity<>("Categoria modificata", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Categoria non trovata", HttpStatus.NOT_FOUND);
	        }
	    }
	  
	  @DeleteMapping("/{id}")
	    public ResponseEntity<String> removeCat(@PathVariable Integer id) {
	        boolean removed = categoryservice.removeCat(id);
	        if (removed) {
	            return new ResponseEntity<>("Categoria rimossa", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Categoria non trovata", HttpStatus.NOT_FOUND);
	        }
	    }
}