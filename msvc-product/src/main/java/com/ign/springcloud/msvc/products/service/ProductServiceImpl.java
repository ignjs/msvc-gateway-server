package com.ign.springcloud.msvc.products.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ign.springcloud.msvc.products.entity.Product;
import com.ign.springcloud.msvc.products.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	final private ProductRepository repository;

	final private Environment environment;

	public ProductServiceImpl(ProductRepository repository, Environment environment) {
		this.environment = environment;
		this.repository = repository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return ((List<Product>) repository.findAll()).stream().map(p -> {
			p.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			return p;
		}).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Product> findById(Long id) {
		return repository.findById(id).map(p -> {
			p.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			return p;
		});
	}

}
