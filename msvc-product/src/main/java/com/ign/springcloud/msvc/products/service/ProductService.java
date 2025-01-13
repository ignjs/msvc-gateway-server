package com.ign.springcloud.msvc.products.service;

import java.util.List;
import java.util.Optional;

import com.ign.springcloud.msvc.products.entity.Product;

public interface ProductService {

	List<Product> findAll();

	Optional<Product> findById(Long id);

}
