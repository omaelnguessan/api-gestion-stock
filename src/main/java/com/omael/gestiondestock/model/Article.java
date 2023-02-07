package com.omael.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "article")
public class Article extends AbstractEntity {

    @Column(name = "codearticle")
    private String codeArticle;

    @Column(name ="designation")
    private String designation;

    @Column(name = "unitpriceht")
    private BigDecimal unitPriceHt;

    @Column(name = "ratevat")
    private BigDecimal rateVat;

    @Column(name = "unitpricettc")
    private BigDecimal unitPriceTTC;

    @Column(name = "picture")
    private String picture;

    @Column(name = "idCompanies")
    private Integer idCompanies;


    @ManyToOne
    @JoinColumn(name = "idcategory")
    private Category category;

}
