package com.fisiunmsm.ayudadoc.cursos.presentation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class WebFluxSecurityConfig {
  
  @Bean
  public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
    //return http.csrf().disable().build();
    //http.oauth2Client();
    //return http.authorizeExchange().anyExchange().permitAll().and().build();
    //return http.httpBasic().and().build();
    //return http.csrf().disable().authorizeExchange().anyExchange().authenticated().and().httpBasic().and().build();
    
    return http.csrf().disable().httpBasic().and().build();   // no valida clave de Autenticacion Basica, pero si deja pasar CORS
    //return http.csrf().disable().authorizeExchange().anyExchange().authenticated().and().httpBasic().and().build();   // no valida clave de Autenticacion Basica, pero si deja pasar CORS
  }
}