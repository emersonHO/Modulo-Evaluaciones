package com.fisiunmsm.ayudadoc.cursos;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fisiunmsm.ayudadoc.shared.helper.AyudocLog;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        Locale.setDefault( Locale.forLanguageTag( "ES" ) );

        AyudocLog.getInstance().log("debug", "Iniciando Spring Boot para Ayuda al Docente");
        SpringApplication.run(Main.class, args);
    }
}
