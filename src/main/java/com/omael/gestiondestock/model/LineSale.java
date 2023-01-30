package com.omael.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "linesale")
public class LineSale extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "idsale")
    private Sale sale;

    @Column(name = "unitprice")
    private BigDecimal unitPrice;

    @Column(name = "quantity")
    private BigDecimal quantity;

}
