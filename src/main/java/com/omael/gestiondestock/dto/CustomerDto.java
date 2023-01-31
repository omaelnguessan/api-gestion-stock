package com.omael.gestiondestock.dto;

import ch.qos.logback.core.net.server.Client;
import com.omael.gestiondestock.model.Customer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CustomerDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private AddressDto address;

    private String picture;

    private String email;

    private String phone;

    private List<OrderCustomerDto> orderCustomers;

}
