package com.fisiunmsm.ayudadoc.evaluaciones.handler;

import org.springframework.stereotype.Component;

import com.fisiunmsm.ayudadoc.evaluaciones.service.JwtUtil;

import java.util.Map;

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
        String username = "usuarioDemo";
        String token = jwtUtil.generateToken(username);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .bodyValue(Map.of("token", token));
    }
}
