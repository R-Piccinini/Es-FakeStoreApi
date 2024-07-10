package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	private List<Category> listaCat;

	public CategoryService() { // costruttore array
		this.listaCat = new ArrayList<>();
		listaCat.add(new Category(1, "men's clothing"));
		listaCat.add(new Category(2, "jewelery"));
		listaCat.add(new Category(3, "electronics"));
		listaCat.add(new Category(4, "women's clothing"));
		listaCat.add(new Category(5, "prova"));
	}

	public List<Category> getLista() { // ottieni lista categorie
		return listaCat;
	}

	public void addCat(Category category) { // aggiungi categoria
		listaCat.add(category);
	}

	public boolean updateCat(Integer id, Category updatedCat) { // modifica categoria

		Optional<Category> existingCat = listaCat.stream().filter(c -> c.getId().equals(id)).findFirst();
		if (existingCat.isPresent()) {
			Category cat = existingCat.get();
			cat.setId(updatedCat.getId());
			cat.setName(updatedCat.getName());

			return true;
		}
		return false;
	}

	public boolean removeCat(Integer id) { // rimozione categoria
		return listaCat.removeIf(c -> c.getId().equals(id));
	}
}
