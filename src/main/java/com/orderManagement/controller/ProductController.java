package com.orderManagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orderManagement.DTO.ProductDTO;
import com.orderManagement.entity.Product;
import com.orderManagement.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	
	//private ProductDTO productDTO;
	
	@GetMapping(value = "/product")
	public List<Product> getAllProducts(){
		List<Product> prodtls=productService.getAllProducts();
		return prodtls;
	}
	
	//Fetching product by productName
	
	@GetMapping(value = "/product/name/{productName}")
	public List<Product> getProductByName(@PathVariable String productName){
		List<Product> prodtls=productService.getProductByName(productName);
		return prodtls;
	}
	
	//Fetching name by category

	@GetMapping(value="/product/category/{category}")
	public List<Product> getProductByCategory(@PathVariable String category){
		List<Product> prodtls=productService.getProductByCategory(category);
		return prodtls;
	}
	
	@RequestMapping(value="/product/id/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductDTO getProductDetails(@PathVariable String productId){
		ProductDTO prodtls=productService.getProductDetails(productId);
		return prodtls;
	}
	
	@PostMapping(value="/product/sellers/{stock}/update")
	public String UpdateStock(@PathVariable Integer stock,@RequestBody ProductDTO productDTO) {
		String stk=productService.updateStock(productDTO.getProductId(),stock);
		return stk;
	}
   
	@PostMapping(value="/product/{productId}/add")
	 public String addProduct(@PathVariable String productId, @RequestBody ProductDTO productDTO) {
		String prodtls= productService.addProduct(productId, productDTO);
		return prodtls;
	}
    //Deleting products by seller
	
	 @DeleteMapping(value="product/sellers/{sellerId}/{productId}/delete")
	 public String deleteProduct(@PathVariable String sellerId,@PathVariable String productId) {
		  String prodtls = productService.removeProduct(productId);
	      return prodtls;
		
	}
	 
	//To check whether productId exists in Database
	 @GetMapping(value="product/{productId}/valid")
	 public Boolean validProduct(@PathVariable String productId) {
		 boolean isValid = productService.validProduct(productId);
		 return isValid;
	 }
	
}