package com.example.employee.Service.Imp;

import com.example.employee.Models.Address;
import com.example.employee.Models.Dto.AddressDto;
import com.example.employee.Reposiroty.AddressRepository;
import com.example.employee.Service.AddressService;
import com.example.employee.Utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressServiceImp implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public AddressDto getById(long id) {
        return convertEntityToDto(getByIdAddress(id));
    }

    @Override
    public List<AddressDto> getAllAddress() {
        return this.addressRepository.findAll().stream().map(this::convertEntityToDto).toList();
    }

    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        Address address = convertDtoToEntity(addressDto);
        return convertEntityToDto(this.addressRepository.save(address));
    }

    @Override
    public AddressDto updateAddress(long id, AddressDto addressDto) {
        Address address = getByIdAddress(id);
        address.setStreet(addressDto.getStreet());
        address.setHouseNumber(addressDto.getHouseNumber());
        address.setZipCode(addressDto.getZipCode());
        return convertEntityToDto(this.addressRepository.save(address));
    }

    @Override
    public Long deleteAddress(long id) {
        getByIdAddress(id);
        this.addressRepository.deleteById(id);
        return id;
    }

    private AddressDto convertEntityToDto(Address address){
        return Mapper.modelMapper().map(address, AddressDto.class);
    }

    private Address convertDtoToEntity(AddressDto addressDto){
        return Mapper.modelMapper().map(addressDto, Address.class);
    }
    private Address getByIdAddress(long id){
        Optional<Address> addressOptional = this.addressRepository.findById(id);
        if (addressOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " No se encuentra Dirección con el id " +  id);
        }
        return addressOptional.get();
    }
}
