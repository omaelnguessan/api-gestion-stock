package com.omael.gestiondestock.dto;

import com.omael.gestiondestock.model.OrderProvider;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class OrderProviderDto {

    private Integer id;

    private String code;

    private Instant dateOrder;

    private ProviderDto provider;

    private List<LineOrderProviderDto> lineOrderProviders;

    public static OrderProviderDto fromEntity(OrderProvider orderProvider) {
        if (orderProvider == null) {
            //TODO throw an exception
            return null;
        }

        return OrderProviderDto.builder()
                .id(orderProvider.getId())
                .code(orderProvider.getCode())
                .dateOrder(orderProvider.getDateOrder())
                .build();
    }

   public static OrderProvider toEntity(OrderProviderDto orderProviderDto) {
       if (orderProviderDto == null) {
           //TODO throw an exception
           return null;
       }
       OrderProvider orderProvider = new OrderProvider();
       orderProvider.setCode(orderProvider.getCode());
       orderProvider.setDateOrder(orderProviderDto.getDateOrder());
       return orderProvider;
   }
}
