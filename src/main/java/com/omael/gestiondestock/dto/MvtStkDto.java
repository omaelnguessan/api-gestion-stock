package com.omael.gestiondestock.dto;

import com.omael.gestiondestock.model.MvtStk;
import com.omael.gestiondestock.model.TypeMvtStk;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
public class MvtStkDto {

    private Integer id;

    private Instant dateMvt;

    private BigDecimal quantity;

    private ArticleDto article;

    private TypeMvtStk typeMvt;

    private Integer idCompanies;

    public static MvtStkDto fromEntity(MvtStk mvtStk) {
        if (mvtStk == null) {
            //TODO throw an exception
            return null;
        }

        return MvtStkDto.builder()
                .id(mvtStk.getId())
                .dateMvt(mvtStk.getDateMvt())
                .quantity(mvtStk.getQuantity())
                .idCompanies(mvtStk.getIdCompanies())
                .build();
    }

    public static MvtStk toEntity(MvtStkDto mvtStkDto) {
        if (mvtStkDto == null) {
            //TODO throw an exception
            return null;
        }

        MvtStk mvtStk = new MvtStk();
        mvtStk.setDateMvt(mvtStkDto.getDateMvt());
        mvtStk.setQuantity(mvtStkDto.getQuantity());
        mvtStk.setIdCompanies(mvtStkDto.getIdCompanies());
        return mvtStk;
    }
}
