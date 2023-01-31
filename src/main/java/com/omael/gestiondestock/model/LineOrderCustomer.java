package com.omael.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "lineordercustomer")
public class LineOrderCustomer extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "idordercustomer")
    private OrderCustomer orderCustomer;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "unitprice")
    private BigDecimal unitPrice;
}
