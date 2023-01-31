package com.omael.gestiondestock.dto;

import com.omael.gestiondestock.model.TypeMvtStk;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
public class MvtStkDto {
    private Instant dateMvt;

    private BigDecimal quantity;

    private ArticleDto article;

    private TypeMvtStk typeMvt;
}
