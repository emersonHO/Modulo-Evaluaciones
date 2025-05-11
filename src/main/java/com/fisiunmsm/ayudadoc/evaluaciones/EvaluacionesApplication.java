package com.fisiunmsm.ayudadoc.evaluaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@SpringBootApplication
public class EvaluacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvaluacionesApplication.class, args);
	}

	@Configuration
	public class CorsGlobalConfiguration {
		@Bean
		public CorsWebFilter corsWebFilter() {
			CorsConfiguration corsConfig = new CorsConfiguration();
			corsConfig.addAllowedOrigin("http://localhost:5173");
			corsConfig.addAllowedMethod("*");
			corsConfig.addAllowedHeader("*");

			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			source.registerCorsConfiguration("/**", corsConfig);

			return new CorsWebFilter(source);
		}
	}

}
