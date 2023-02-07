package com.omael.gestiondestock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sale")
public class Sale extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "datesale")
    private Instant dateSale;

    @Column(name = "remark")
    private String remark;

    @Column(name = "idCompanies")
    private Integer idCompanies;
}
