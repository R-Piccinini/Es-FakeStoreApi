package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	private List<Product> listaProd;

	public ProductService() { //costruttore array
		this.listaProd = new ArrayList<>();
		listaProd.add(new Product(1, "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops", 12.50,
				"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
				"men's clothing"));
		listaProd.add(new Product(2, "John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet", 695,
				"From our Legends Collection, the Naga was inspired by the mythical water dragon that protects the ocean's pearl. Wear facing inward to be bestowed with love and abundance, or outward for protection.",
				"jewelery"));
		listaProd.add(new Product(3, "WD 2TB Elements Portable External Hard Drive - USB 3.0 ", 64.00,
				"USB 3.0 and USB 2.0 Compatibility Fast data transfers Improve PC Performance High Capacity; Compatibility Formatted NTFS for Windows 10, Windows 8.1, Windows 7; Reformatting may be required for other operating systems; Compatibility may vary depending on user’s hardware configuration and operating system",
				"electronics"));
		listaProd.add(new Product(4, "MBJ Women's Solid Short Sleeve Boat Neck V", 9.85,
				"95% RAYON 5% SPANDEX, Made in USA or Imported, Do Not Bleach, Lightweight fabric with great stretch for comfort, Ribbed on sleeves and neckline / Double stitching on bottom hem",
				"women's clothing"));
	}
	
	 public List<Product> getLista() { //ottieni lista prodotti
	        return listaProd;
	    }
	 
	 
	 public void addProd(Product product) { //aggiungi prodotto
	        listaProd.add(product);
	    }
	 
	 	public boolean updateProd(Integer id, Product updatedProd) { //modifica prodotto
	
	    	Optional<Product> existingProd = listaProd.stream().filter(p -> p.getId().equals(id)).findFirst();
	        if (existingProd.isPresent()) {  
				Product prod = existingProd.get();     
	            prod.setTitle(updatedProd.getTitle());
	            prod.setDescription(updatedProd.getDescription());
	            prod.setPrice(updatedProd.getPrice());
	            
	            return true;
	        }
	        return false;
	    }
	 
	    public boolean removeProd(Integer id) { //rimozione prodotto
	        return listaProd.removeIf(p -> p.getId().equals(id));
	    }
}
