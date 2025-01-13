package com.ign.springcloud.msvc.items.controller;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ign.springcloud.msvc.items.model.Item;
import com.ign.springcloud.msvc.items.model.Product;
import com.ign.springcloud.msvc.items.service.ItemService;

@RestController
public class ItemController {

	private final ItemService service;
	private final CircuitBreakerFactory cBreakerFactory;
	private final Logger log = org.slf4j.LoggerFactory.getLogger(ItemController.class);

	// @Qualifier is used to specify which implementation of the ItemService
	// interface
	public ItemController(@Qualifier("itemServiceWebClient") ItemService service,
			CircuitBreakerFactory cBreakerFactory) {
		this.cBreakerFactory = cBreakerFactory;
		this.service = service;
	}

	@GetMapping
	public List<Item> list(@RequestParam(name = "name", required = false) String name,
			@RequestHeader(name = "tokenRequest") String token) {
		System.out.println("name: " + name + " token: " + token);
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> details(@PathVariable Long id) {
		/* Optional<Item> itemOptional = service.findAById(id); */
		Optional<Item> itemOptional = cBreakerFactory.create("items").run(() -> service.findAById(id),
				throwable -> {
					log.error(throwable.getMessage());
					Product product = new Product();
					product.setCreateAt(LocalDate.now());
					product.setId(1L);
					product.setName("Amazon Fire TV Stick");
					product.setPrice(39.99);
					return Optional.of(new Item(product, 5));

				});
		if (itemOptional.isPresent()) {
			return ResponseEntity.ok(itemOptional.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(Collections.singletonMap("message", "No existe el producto"));
	}
}
