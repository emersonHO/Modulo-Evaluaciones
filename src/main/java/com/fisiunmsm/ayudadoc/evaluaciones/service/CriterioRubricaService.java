package com.fisiunmsm.ayudadoc.evaluaciones.service;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.CriterioRubrica;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.CriterioRubricaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriterioRubricaService {
    @Autowired
    CriterioRubricaRepository criterioRubricaRepository;
    public List<CriterioRubrica> getCriterioRubrica() {
        return criterioRubricaRepository.findAll();
    }

    public Optional<CriterioRubrica> getCriterioRubrica(int id) {
        return criterioRubricaRepository.findById(id);
    }

    public void saveOrUpdateCriterioRubrica(CriterioRubrica criterioRubrica) {
        criterioRubricaRepository.save(criterioRubrica);
    }

    public void deleteCriterioRubrica(int id) {
        criterioRubricaRepository.deleteById(id);
    }
}
