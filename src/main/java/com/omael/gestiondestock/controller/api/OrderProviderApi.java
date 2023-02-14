package com.omael.gestiondestock.controller.api;

import com.omael.gestiondestock.dto.OrderProviderDto;

import java.util.List;

public interface OrderProviderApi {

    OrderProviderDto save(OrderProviderDto orderProviderDto);

    OrderProviderDto findById(Integer orderProviderId);

    OrderProviderDto findOrderProviderByCode(String codeOrderProvider);

    List<OrderProviderDto> findAll();

    void delete(Integer orderProviderId);
}
