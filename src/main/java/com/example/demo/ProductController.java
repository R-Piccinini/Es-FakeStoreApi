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
@RequestMapping("/api/products")
public class ProductController {
	
	  @Autowired
	    private ProductService productservice;
	  
	  @GetMapping
	    public List<Product> getLista() {
	        return productservice.getLista();
	    }
	  
	  @PostMapping
	    public ResponseEntity<String> addProd(@RequestBody Product product) {
	        productservice.addProd(product);;
	        return new ResponseEntity<>("Prodotto aggiunto", HttpStatus.CREATED);
	    }
	  
	  @PutMapping("/{id}")
	    public ResponseEntity<String> updateProd(@PathVariable Integer id, @RequestBody Product updatedProd) {
	        boolean updated = productservice.updateProd(id, updatedProd);
	        if (updated) {
	            return new ResponseEntity<>("Prodotto modificato", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Prodotto non trovato", HttpStatus.NOT_FOUND);
	        }
	    }
	  
	  @DeleteMapping("/{id}")
	    public ResponseEntity<String> removeProd(@PathVariable Integer id) {
	        boolean removed = productservice.removeProd(id);
	        if (removed) {
	            return new ResponseEntity<>("Prodotto rimosso", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Prodotto non trovato", HttpStatus.NOT_FOUND);
	        }
	    }
}
