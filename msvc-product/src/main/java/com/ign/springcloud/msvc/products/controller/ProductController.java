package com.ign.springcloud.msvc.products.controller;

import org.springframework.web.bind.annotation.RestController;
import com.ign.springcloud.msvc.products.entity.Product;
import com.ign.springcloud.msvc.products.service.ProductService;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ProductController {

	final private ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}

	@GetMapping
	public List<Product> list() {
		return this.service.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> details(@PathVariable Long id) throws InterruptedException {

		if (id.equals(10L)) {
			throw new RuntimeException("Product not found");
		}

		if (id.equals(7L)) {
			TimeUnit.SECONDS.sleep(3L);
		}

		Optional<Product> productOptional = service.findById(id);
		return productOptional.isPresent() ? ResponseEntity.ok(productOptional.orElseThrow())
				: ResponseEntity.notFound().build();
	}

}
