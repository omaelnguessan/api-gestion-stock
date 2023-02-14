package com.omael.gestiondestock.controller;

import com.omael.gestiondestock.controller.api.OrderProviderApi;
import com.omael.gestiondestock.dto.OrderProviderDto;
import com.omael.gestiondestock.services.OrderProviderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderProviderController implements OrderProviderApi {

    private final OrderProviderService orderProviderService;

    @Autowired
    public OrderProviderController(OrderProviderService orderProviderService) {
        this.orderProviderService = orderProviderService;
    }


    @Override
    public OrderProviderDto save(OrderProviderDto orderProviderDto) {
        return this.orderProviderService.save(orderProviderDto);
    }

    @Override
    public OrderProviderDto findById(Integer orderProviderId) {
        return this.orderProviderService.findById(orderProviderId);
    }

    @Override
    public OrderProviderDto findOrderProviderByCode(String codeOrderProvider) {
        return this.orderProviderService.findOrderProviderByCode(codeOrderProvider);
    }

    @Override
    public List<OrderProviderDto> findAll() {
        return this.orderProviderService.findAll();
    }

    @Override
    public void delete(Integer orderProviderId) {
        this.orderProviderService.delete(orderProviderId);
    }
}
