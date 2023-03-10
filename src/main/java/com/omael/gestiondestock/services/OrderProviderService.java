package com.omael.gestiondestock.services;

import com.omael.gestiondestock.dto.OrderProviderDto;

import java.util.List;

public interface OrderProviderService {

    OrderProviderDto save(OrderProviderDto orderProviderDto);

    OrderProviderDto findById(Integer orderProviderId);

    OrderProviderDto findOrderProviderByCode(String codeOrderProvider);

    List<OrderProviderDto> findAll();

    void delete(Integer orderProviderId);
}
