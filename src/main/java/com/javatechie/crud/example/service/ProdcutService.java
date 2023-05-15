package com.javatechie.crud.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.repository.ProjectRepository;

@Service
public class ProdcutService {

	@Autowired
	private ProjectRepository repository;

	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}

	public List<Product> getProducts() {
		return repository.findAll();
	}

	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}

	public Product getProductByName(String name) {
		return repository.findByName(name);
	}

	public String deleteProductById(int id) {
		repository.deleteById(id);
		return "product Deleted ! " + id;
	}

	public Product updateProducts(Product product) {
		Product existingproduct = repository.findById(product.getId()).orElse(product);
		existingproduct.setName(product.getName());
		existingproduct.setPrice(product.getPrice());
		existingproduct.setQuantity(product.getQuantity());

		return repository.save(existingproduct);
	}

}
