package com.orderManagement.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
//import javax.validation.Valid;
import java.util.Optional;
import com.orderManagement.DTO.ProductDTO;
import com.orderManagement.entity.Product;
import com.orderManagement.repository.ProductRepository;
@Service
@Transactional
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	static int index = 50;
	
	public ProductDTO getProductDetails(String productId) {
		Product pdt=productRepo.findById(productId).get();
		ProductDTO prodtls=ProductDTO.valueOf(pdt);
		return prodtls;
	}
	

	public List<Product> getAllProducts(){
		List<Product> prodtls=productRepo.findAll();
		return prodtls;
	}
	
	//Fetches Product By Category
	
	public List<Product> getProductByCategory(String category){
		List<Product> prodtls=productRepo.findAllByCategory(category);
		return prodtls;
	}
	
	//Fetches Product by Name
	
	public List<Product> getProductByName(String prodname){
		List<Product> prodtls=productRepo.findAllByProductName(prodname);
		return prodtls;
	}
	
		
	//Adding of Products
	
	public String addProduct( String sellerId,ProductDTO productDTO) {
		try {
			String t = "C"+ index++;
		    Product product = new Product();
			product.setProductId(t);
			product.setProductName(productDTO.getProductName());
			product.setPrice(productDTO.getPrice());
			product.setStock(productDTO.getStock());
			product.setDescription(productDTO.getDescription());
			product.setImage(productDTO.getImage());
			product.setSubcategory(productDTO.getSubcategory());
			product.setSellerId(productDTO.getSellerId());
			product.setProductRating(productDTO.getProductRating());
			product.setCategory(productDTO.getCategory());
			
		    productRepo.save(product);
			return "Product added successfully";
		}
		catch(Exception e) {
			return "Product could not be added.Bad request";
		}
	}
	

	//Removing of Products
	
	public String removeProduct(String productId) {
		productRepo.deleteById(productId);
		return "Product Removed Sucessfully";
	}
	
	//Updating Products
	
	public String updateStock(String productId,Integer Stock) {
		Product prodtls = productRepo.findById(productId).get();
		prodtls.setStock(Stock);
		productRepo.save(prodtls);
		return "Updated Stock Successfully";
	}
	
	//To check whether productId exists in Database
	
	public boolean validProduct(String productId) {
		Optional<Product> product = productRepo.findById(productId);
		if (product.isPresent())
			return true;
		return false;
	}
	
}


    
   
	
	
