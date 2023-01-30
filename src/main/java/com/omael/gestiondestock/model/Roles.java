package com.omael.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "roles")
public class Roles extends AbstractEntity {
    @Column(name = "rolename")
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;
}
