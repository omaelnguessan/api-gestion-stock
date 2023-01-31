package com.omael.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user")
public class User extends AbstractEntity {
    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Embedded
    private Address address;

    @Column(name = "picture")
    private String picture;

    @Column(name = "datebirth")
    private Instant dateBirth;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "idcompanies")
    private Companies companies;

    @OneToMany(mappedBy = "user")
    private List<Roles> roles;
}
