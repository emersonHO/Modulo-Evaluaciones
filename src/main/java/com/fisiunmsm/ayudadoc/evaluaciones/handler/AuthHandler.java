package com.fisiunmsm.ayudadoc.evaluaciones.handler;

import org.springframework.stereotype.Component;

import com.fisiunmsm.ayudadoc.evaluaciones.service.JwtUtil;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class AuthHandler {

    private final JwtUtil jwtUtil;

    public AuthHandler(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public Mono<ServerResponse> generateToken(ServerRequest request) {
        // En un POST, esperamos el nombre de usuario en el cuerpo de la solicitud.
        // Asumimos que el cuerpo es un JSON con la clave "username".
        return request.bodyToMono(Map.class)
                .flatMap(body -> {
                    String username = (String) body.get("test@correo.com");
                    if (username == null || username.trim().isEmpty()) {
                        // Si el username no está presente o está vacío, devuelve un error 400 Bad Request.
                        return ServerResponse.badRequest()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(Map.of("error", "Username is required"));
                    }
                    String token = jwtUtil.generateToken(username);
                    return ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(Map.of("token", token));
                })
                .onErrorResume(e -> {
                    // Manejo de errores si el cuerpo de la solicitud no es un JSON válido o hay algún otro problema.
                    return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(Map.of("error", "Error processing request: " + e.getMessage()));
                })
                .switchIfEmpty(
                    // Manejar el caso donde el cuerpo de la solicitud está vacío
                    ServerResponse.badRequest()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(Map.of("error", "Request body is empty"))
                );
    }
}
