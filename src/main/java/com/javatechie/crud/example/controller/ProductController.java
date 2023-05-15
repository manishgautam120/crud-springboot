package com.javatechie.crud.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.service.ProdcutService;

@RestController
public class ProductController {

	@Autowired
	private ProdcutService prodcutService;
	@PostMapping("/addproduct")
	public Product addproduct(@RequestBody Product product) {

		return prodcutService.saveProduct(product);
	}

	@PostMapping("/addproducts")
	public List<Product> addproducts(@RequestBody List<Product> products) {

		return prodcutService.saveProducts(products);
	}
	
	@GetMapping("/GetProducts")
	public List<Product> getproductAll() {

		return prodcutService.getProducts();
	}
	
	@GetMapping("/GetproductById/{id}")
	public Product getproductById(@PathVariable int id) {

		return prodcutService.getProductById(id);
	}
	
	@GetMapping("/GetProductByName/{name}")
	public Product getproductByName(@PathVariable String name) {

		return prodcutService.getProductByName(name);
	}
	
	
	
	
	@PutMapping("/UpdateProduct")
	public Product updateproduct(@RequestBody Product product) {

		return prodcutService.updateProducts(product);
	}
	
	
	@DeleteMapping("/DeleteProductById")
	public String deleteproductById(@PathVariable int id) {

		return prodcutService.deleteProductById(id);
	}
}
