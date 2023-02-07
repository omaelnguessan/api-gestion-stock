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
@Table(name = "ordercustomer")
public class OrderCustomer extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "dateorder")
    private Instant dateOrder;

    @Column(name = "idCompanies")
    private Integer idCompanies;

    @ManyToOne
    @JoinColumn(name = "idclient")
    private Customer customer;

    @OneToMany(mappedBy = "orderCustomer")
    private List<LineOrderCustomer> lineOrderCustomers;

}
