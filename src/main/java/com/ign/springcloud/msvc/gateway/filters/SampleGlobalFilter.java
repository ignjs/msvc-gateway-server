package com.ign.springcloud.msvc.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class SampleGlobalFilter implements GlobalFilter, Ordered {

	private final Logger log = LoggerFactory.getLogger(SampleGlobalFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("Global Filter executed");
		exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
		return chain.filter(exchange);
	}
	
	@Override
	public int getOrder() {
		return 100;
	}

	

}
