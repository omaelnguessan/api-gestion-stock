package com.omael.gestiondestock.dto;

import com.omael.gestiondestock.model.LineSale;
import com.omael.gestiondestock.model.Sale;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class SaleDto {

    private Integer id;

    private String code;

    private Instant dateSale;

    private String remark;

    private Integer idCompanies;

    private List<LineSaleDto> lineSales;

    public static SaleDto fromEntity(Sale sale) {
        if (sale == null) {
            //TODO throw an exception
            return null;
        }

        return SaleDto.builder()
                .id(sale.getId())
                .code(sale.getCode())
                .dateSale(sale.getDateSale())
                .remark(sale.getRemark())
                .idCompanies(sale.getIdCompanies())
                .build();
    }

    public static Sale toEntity(SaleDto saleDto) {
        if (saleDto == null) {
            //TODO throw an exception
            return null;
        }

        Sale sale = new Sale();
        sale.setCode(saleDto.getCode());
        sale.setDateSale(saleDto.getDateSale());
        sale.setRemark(saleDto.getRemark());
        sale.setIdCompanies(saleDto.getIdCompanies());
        return sale;
    }
}
