package com.geekster.EmployeeAddress.controllers;

import com.geekster.EmployeeAddress.models.Address;
import com.geekster.EmployeeAddress.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {
    @Autowired
    IAddressRepository addressRepository;

    @PostMapping(value="/address")
    public void createAddress(@RequestBody Address address) {
         addressRepository.save(address);
    }

    @GetMapping("/address/{id}")
    public Address getAddressById(@PathVariable Long id) {
        return addressRepository.findAddressById(id);
    }

    @PutMapping("/update/address/{id}")
    public void updateAddress(@PathVariable Long id, @RequestBody Address addressDetails){
        Address address=addressRepository.findAddressById(id);
        address.setCity(addressDetails.getCity());
        address.setState(addressDetails.getState());
        address.setStreet(addressDetails.getStreet());
        address.setZipcode(addressDetails.getZipcode());
        addressRepository.save(address);
    }

    @DeleteMapping("/delete/address/{id}")
    public void deleteAddress(@PathVariable Long id){
        addressRepository.deleteById(id);
    }
}
