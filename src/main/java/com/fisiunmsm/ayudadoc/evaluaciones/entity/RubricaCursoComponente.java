package com.fisiunmsm.ayudadoc.evaluaciones.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("rubricacursocomponente")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RubricaCursoComponente {
    @Id
    private int id;

    private int rubricaid;
    private Long cursocomponenteid;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getRubricaid() {
        return rubricaid;
    }
    public void setRubricaid(int rubricaid) {
        this.rubricaid = rubricaid;
    }
    public Long getCursocomponenteid() {
        return cursocomponenteid;
    }
    public void setCursocomponenteid(Long cursocomponenteid) {
        this.cursocomponenteid = cursocomponenteid;
    }
}
