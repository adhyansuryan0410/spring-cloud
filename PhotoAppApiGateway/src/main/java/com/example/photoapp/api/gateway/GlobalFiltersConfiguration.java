package com.example.photoapp.api.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import reactor.core.publisher.Mono;

@Configuration
public class GlobalFiltersConfiguration {

	final Logger logger = LoggerFactory.getLogger(GlobalFiltersConfiguration.class);
	
	@Bean
	@Order(3)
	public GlobalFilter secondPreFilter() {
		return (exchange, chain) -> {
			logger.info("Second global prefilter executed");
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				logger.info("Second global post filter executed");
			}));
		};
	}
	
	@Bean
	@Order(2)
	public GlobalFilter thirdPreFilter() {
		return (exchange, chain) -> {
			logger.info("third global prefilter executed");
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				logger.info("third global post filter executed");
			}));
		};
	}
	
	@Bean
	@Order(1)
	public GlobalFilter fourthPreFilter() {
		return (exchange, chain) -> {
			logger.info("fourth global prefilter executed");
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				logger.info("fourth global post filter executed");
			}));
		};
	}
}
