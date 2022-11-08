package com.example.employee.Service;

import com.example.employee.Models.Dto.AddressDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    AddressDto getById(long id);

    List<AddressDto> getAllAddress();

    AddressDto createAddress(AddressDto addressDto);

    AddressDto updateAddress(long id, AddressDto addressDto);

    Long deleteAddress(long id);
}
