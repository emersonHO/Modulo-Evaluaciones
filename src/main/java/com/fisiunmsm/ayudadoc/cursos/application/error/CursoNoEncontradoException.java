package com.fisiunmsm.ayudadoc.cursos.application.error;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.fisiunmsm.ayudadoc.shared.error.ApiException;

public class CursoNoEncontradoException extends ApiException {

    public CursoNoEncontradoException(MessageSource mensajes, String codigo) {
                
        super( mensajes.getMessage("cur.err.no_encontrado.tit", null, LocaleContextHolder.getLocale()), 
               mensajes.getMessage("cur.err.no_encontrado.desc", new String[] { codigo }, LocaleContextHolder.getLocale()) );
        
    }
}
