package com.fisiunmsm.ayudadoc.evaluaciones.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("componenterubrica")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ComponenteRubrica {
    @Id
    private Integer id;
    private Integer rubricaid;
    private Long componenteid;
}
