package com.omael.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "orderprovider")
public class OrderProvider extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "dateorder")
    private Instant dateOrder;

    @ManyToOne
    @JoinColumn(name = "idprovider")
    private Provider provider;


    @OneToMany(mappedBy = "orderProvider")
    private List<LineOrderProvider> lineOrderProviders;

}
