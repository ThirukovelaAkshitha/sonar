package com.orderManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")

public class Product {
	@Id
	@Column(name="productid")
	String productId;
    
	@Column(name = "productname")
	String productName;
	
	@Column(name="price")
    float price;
    
	@Column(name="description")
    String description;
	
	@Column(name="category")
	String category;
	
	@Column(name="image")
	String image;
	
	@Column(name="productrating")
	float productRating;
	
	@Column(name="stock")
	Integer stock;
	
	@Column(name="sellerid")
	String sellerId;
	
	@Column(name="subcategory")
	String subcategory;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public float getProductRating() {
		return productRating;
	}

	public void setProductRating(float productRating) {
		this.productRating = productRating;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	

	
}
