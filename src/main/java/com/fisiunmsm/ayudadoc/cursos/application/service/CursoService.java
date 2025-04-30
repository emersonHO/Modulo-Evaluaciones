package com.fisiunmsm.ayudadoc.cursos.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.fisiunmsm.ayudadoc.cursos.application.error.CursoNoEncontradoException;
import com.fisiunmsm.ayudadoc.cursos.domain.model.Curso;
import com.fisiunmsm.ayudadoc.cursos.infraestructure.mapper.CursoTable;
import com.fisiunmsm.ayudadoc.cursos.infraestructure.repository.CursoRepository;
import com.fisiunmsm.ayudadoc.shared.config.Constantes;
import com.fisiunmsm.ayudadoc.shared.helper.AyudocLog;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CursoService {
    
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private MessageSource mensajes;

    public Flux<Curso> obtenerCursosActivos() {
        return cursoRepository.queryCursosActivos().flatMap(CursoTable::toMono);
    }

    public Mono<Curso> crearCurso( Curso curso ) {

        AyudocLog.getInstance().debug("Ingresando a crer el curso: " + curso.getCodigo() );
        
        Curso newCurso = curso;
        newCurso.setEstado( Constantes.ACTIVO );

        CursoTable cursoEntity = CursoTable.fromDomainModel( newCurso );

        //Mono<CursoTable> mc = cursoRepository.save(cursoEntity).doOnSuccess(pl -> {});
        //Mono<Curso> c = mc.map( c1 -> c1.toDomainModel() );
        //return c;

        return cursoRepository.save(cursoEntity).doOnSuccess(pl -> {}).map( c1 -> c1.toDomainModel() );
    }

    public Mono<Curso> actualizarCurso( Long id, Curso curso ) {

        AyudocLog.getInstance().debug("Ingresando a actualizar curso: " + id );

        return cursoRepository.findById(id)
            .switchIfEmpty(Mono.error(new CursoNoEncontradoException( mensajes, id.toString() )) )
            .flatMap( encontrado -> {

                encontrado.setId( id );
                if (curso.getCodigo()!=null) encontrado.setCodigo( curso.getCodigo() );
                if (curso.getNombre()!=null) encontrado.setNombre( curso.getNombre() );
                if (curso.getTipo()!=null) encontrado.setTipo( curso.getTipo() );                
                if (curso.getNumHorasTeoria()!=null) encontrado.setNumhorasteoria( curso.getNumHorasTeoria() );
                if (curso.getNumHorasPractica()!=null) encontrado.setNumhoraspractica( curso.getNumHorasPractica() );
                if (curso.getNumHorasLaboratorio()!=null) encontrado.setNumhoraslaboratorio( curso.getNumHorasLaboratorio() );
                if (curso.getNumCreditos()!=null) encontrado.setNumcreditos( curso.getNumCreditos() );
                if (curso.getPlanEstudiosId()!=null) encontrado.setPlanestudiosid( curso.getPlanEstudiosId() );
                if (curso.getCiclo()!=null) encontrado.setCiclo( curso.getCiclo() );
                if (curso.getPeriodoAcademicoId()!=null) encontrado.setPeriodoacademicoid( curso.getPeriodoAcademicoId() );
                if (curso.getInstitucionid()!=null) encontrado.setInstitucionid( curso.getInstitucionid() );
                if (curso.getDepartamentoid()!=null) encontrado.setDepartamentoid( curso.getDepartamentoid() );
                if (curso.getEstado()!=null) encontrado.setEstado( curso.getEstado() );
                if (curso.getSumilla()!=null) encontrado.setSumilla( curso.getSumilla() );
                if (curso.getModalidad()!=null) encontrado.setModalidad( curso.getModalidad() );
                if (curso.getEtiquetas()!=null) encontrado.setEtiquetas( curso.getEtiquetas() );

                return cursoRepository.save(encontrado).doOnSuccess(pl -> {}).map( c1 -> c1.toDomainModel() );
        });
    }

    public Mono<Curso> copiarCurso( Curso curso )   {

        AyudocLog.getInstance().debug("Copiando el curso: " + curso.getId() );

        return cursoRepository.findById(curso.getId())
            .switchIfEmpty( Mono.error(new CursoNoEncontradoException( mensajes, curso.getId().toString() )) )
            .flatMap( encontrado -> {

                Curso nuevoCurso = new Curso();
                try {
        
                    nuevoCurso = (Curso)encontrado.toDomainModel().clone();
                    nuevoCurso.setCodigo( curso.getNuevoCodigo() );
                    if (curso.getNombre()!=null) nuevoCurso.setNombre( curso.getNombre() );
                    nuevoCurso.setEstado(Constantes.COPIADO);
                    AyudocLog.getInstance().debug( nuevoCurso.toString() );
        
                } catch (CloneNotSupportedException e) {
                    
                    AyudocLog.getInstance().error("Error en la copia: " + e.getMessage() );
                    e.printStackTrace();
                }
                CursoTable cursoEntityNuevo = CursoTable.fromDomainModel( nuevoCurso );

                return cursoRepository.save(cursoEntityNuevo).doOnSuccess(pl -> {}).map( c1 -> c1.toDomainModel() );   
            });
            
    }

}
