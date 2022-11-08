package com.example.employee.Models.Dto;

import lombok.Data;

@Data
public class AddressDto {
    private long id;
    private String street;
    private String houseNumber;
    private String zipCode;
}
