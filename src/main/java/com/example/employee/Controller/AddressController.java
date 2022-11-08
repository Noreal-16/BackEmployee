package com.example.employee.Controller;

import com.example.employee.Models.Dto.AddressDto;
import com.example.employee.Service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/address", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public ResponseEntity<List<AddressDto>> getAllAddress() {
        return ResponseEntity.ok(addressService.getAllAddress());
    }

    @GetMapping("{id}")
    public ResponseEntity<AddressDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(addressService.getById(id));
    }

    @PostMapping
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto addressDto) {
        return new ResponseEntity<>(this.addressService.createAddress(addressDto), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<AddressDto> updateAddress(@PathVariable long id, @RequestBody AddressDto addressDto) {
        return new ResponseEntity<>(this.addressService.updateAddress(id, addressDto), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteByIdAddress(@PathVariable long id) {
        return ResponseEntity.ok(this.addressService.deleteAddress(id));
    }
}
