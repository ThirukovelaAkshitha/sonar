package com.orderManagement.DTO;

import javax.validation.constraints.Pattern;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.orderManagement.entity.Product;

public class ProductDTO {
	
    String productId;
	@Pattern(regexp="[A-Za-z]+( [A-Za-z]+)*" , message = "{product.name.invalid}")
	@Max(100)
	String productName;
	@NotNull @Min(200)
	float price;
	@NotNull @Min(10)
	Integer stock;
	@NotNull @Max(500)
	String description;
	@Pattern(regexp = "([^\\s]+(\\.(?i)(jpeg|png)$))", message = "{image.format.invalid}")
    String image;
	String sellerId;
	String category;
	String subcategory;
	float productRating;
	

	
	
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
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public float getProductRating() {
		return productRating;
	}
	public void setProductRating(float productRating) {
		this.productRating = productRating;
	}

	//Converts Entity to DTO
	 
	public static ProductDTO valueOf(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(product.getProductId());
		productDTO.setProductName(product.getProductName());
		productDTO.setPrice(product.getPrice());
		productDTO.setStock(product.getStock());
		productDTO.setDescription(product.getDescription());
		productDTO.setImage(product.getImage());
		productDTO.setSellerId(product.getSellerId());
		productDTO.setCategory(product.getCategory());
		productDTO.setSubcategory(product.getSubcategory());
		productDTO.setProductRating(product.getProductRating());
		
		return productDTO;
	}
	
	//Converts DTO into Entity
	public Product createEntity() {
		Product product = new Product();
		product.setProductId(this.productId);
		product.setProductName(this.productName);
		product.setPrice(this.price);
		product.setStock(this.stock);
		product.setDescription(this.description);
		product.setImage(this.image);
		product.setSellerId(sellerId);
		product.setCategory(this.category);
		product.setSubcategory(this.subcategory);
		product.setProductRating(this.productRating);
		
		return product;
		
	}
	
}

	