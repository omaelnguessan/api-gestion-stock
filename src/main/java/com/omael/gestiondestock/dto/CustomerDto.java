package com.omael.gestiondestock.dto;

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

    public static CustomerDto fromEntity(Customer customer) {
        if (customer == null) {
            //TODO throw an exception
            return null;
        }

        return CustomerDto.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .phone(customer.getPhone())
                .email(customer.getEmail())
                .picture(customer.getPicture())
                .build();
    }

    public static Customer toEntity(CustomerDto customerDto) {
        if (customerDto == null) {
            //TODO throw an exception
            return null;
        }

        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setPhone(customerDto.getPhone());
        customer.setEmail(customerDto.getEmail());
        customer.setPicture(customerDto.getPicture());
        return customer;
    }

}
