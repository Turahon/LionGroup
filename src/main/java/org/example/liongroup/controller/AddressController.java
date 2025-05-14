package org.example.liongroup.controller;

import org.example.liongroup.dto.AddressDto;
import org.example.liongroup.model.Address;
import org.example.liongroup.model.Result;
import org.example.liongroup.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping
    public List<Address> getAll(){
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable Long id){
        Address address = addressService.getById(id);
        return address;
    }

    @PostMapping
    public Result create(@RequestBody AddressDto addressDto){
        Result result = addressService.create(addressDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody AddressDto addressDto){
        Result result = addressService.update(id, addressDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        Result result = addressService.delete(id);
        return result;
    }
}
