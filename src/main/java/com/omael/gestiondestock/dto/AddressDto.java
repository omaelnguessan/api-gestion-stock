package com.omael.gestiondestock.dto;


import com.omael.gestiondestock.model.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {
    private String address1;

    private String address2;

    private String city;

    private String zipCode;

    private String country;

    public static AddressDto fromEntity(Address address) {
        if (address == null) {
            //TODO throw an exception
            return null;
        }

        return AddressDto.builder()
                .address1(address.getAddress1())
                .address2(address.getAddress2())
                .zipCode(address.getZipCode())
                .country(address.getCountry())
                .city(address.getCity())
                .build();
    }

    public static Address toEntity(AddressDto addressDto) {
        if (addressDto == null) {
            //TODO throw an exception
            return null;
        }

        Address address = new Address();
        address.setAddress1(addressDto.getAddress1());
        address.setAddress2(addressDto.getAddress2());
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setZipCode(addressDto.getZipCode());
        return address;
    }
}
