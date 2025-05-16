package com.fisiunmsm.ayudadoc.evaluaciones.config;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Mono;

@Configuration
public class DatabaseConfig {

    @Bean
    public DatabaseClient databaseClient(ConnectionFactory connectionFactory) {
        return DatabaseClient.create(connectionFactory);
    }

    @Bean
    public Mono<Void> testConnection(DatabaseClient databaseClient) {
        return databaseClient
                .sql("SELECT 1")
                .fetch()
                .first()
                .doOnSuccess(result -> System.out.println("Conexión exitosa a la base de datos"))
                .doOnError(error -> System.err.println("Error al conectar a la base de datos: " + error.getMessage()))
                .then();
    }
}