package com.omael.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "provider")
public class Provider extends AbstractEntity{
    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Embedded
    private Address address;

    @Column(name = "picture")
    private String picture;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "idCompanies")
    private Integer idCompanies;

    @OneToMany(mappedBy = "provider")
    private List<OrderProvider> orderProviders;
}
