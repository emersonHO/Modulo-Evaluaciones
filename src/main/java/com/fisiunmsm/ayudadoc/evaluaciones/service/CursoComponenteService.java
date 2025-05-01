package com.fisiunmsm.ayudadoc.evaluaciones.service;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.CursoComponente;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.CursoComponenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoComponenteService {
    @Autowired
    CursoComponenteRepository cursoComponenteRepository;
    public List<CursoComponente> getCursoComponente() {
        return cursoComponenteRepository.findAll();
    }

    public Optional<CursoComponente> getCursoComponente(long id) {
        return cursoComponenteRepository.findById(id);
    }

    public void saveOrUpdateCursoComponente(CursoComponente cursoComponente) {
        cursoComponenteRepository.save(cursoComponente);
    }

    public void deleteCursoComponente(long id) {
        cursoComponenteRepository.deleteById(id);
    }
}
