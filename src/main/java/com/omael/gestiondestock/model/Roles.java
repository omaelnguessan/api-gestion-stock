package com.omael.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "roles")
public class Roles extends AbstractEntity {
    @Column(name = "rolename")
    private String roleName;

    @Column(name = "idCompanies")
    private Integer idCompanies;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;
}
