package com.fisiunmsm.ayudadoc.evaluaciones.service;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Rubrica;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.RubricaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RubricaService {
    @Autowired
    RubricaRepository rubricaRepository;
    public List<Rubrica> getRubrica(){
        return rubricaRepository.findAll();
    }

    public Optional<Rubrica> getRubrica(int id){
        return rubricaRepository.findById(id);
    }

    public void saveOrUpdateRubrica(Rubrica rubrica){
        rubricaRepository.save(rubrica);
    }

    public void deleteRubrica(int id){
        rubricaRepository.deleteById(id);
    }
}
