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
@Table(name = "lineorderprovider")
public class LineOrderProvider extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "idorderprovider")
    private OrderProvider orderProvider;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "unitprice")
    private BigDecimal unitPrice;
}
