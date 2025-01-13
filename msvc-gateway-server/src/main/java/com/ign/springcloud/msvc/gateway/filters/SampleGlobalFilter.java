package com.ign.springcloud.msvc.gateway.filters;

import java.util.Optional;

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

	private final Logger logger = LoggerFactory.getLogger(SampleGlobalFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("Executing global filter after the request has been received");
		exchange.getRequest().mutate().headers(h -> h.add("token", "abcdefg"));

		return chain.filter(exchange).then(Mono.fromRunnable(() -> {
			logger.info("Executing global filter before the response has been sent");

			String token = exchange.getRequest().getHeaders().getFirst("token");
			if (token != null) {
				logger.info("token: " + token);
				exchange.getResponse().getHeaders().add("token", token);
			}

			Optional.ofNullable(exchange.getRequest().getHeaders().getFirst("token")).ifPresent(val -> {
				logger.info("token2: " + val);
				exchange.getResponse().getHeaders().add("token2", val);
			});

			logger.info("token: " + token);
			exchange.getResponse().getHeaders().add("GlobalFilter", "GlobalFilter");
			exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
		}));
	}

	@Override
	public int getOrder() {
		return 100;
	}

}
