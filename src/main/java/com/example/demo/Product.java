package com.example.demo;

public class Product {
	private Integer id;
	private String title;
	private double price;
	private String description;
	private String category;

	public Product(Integer id, String title, double price, String description, String category) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.description = description;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
