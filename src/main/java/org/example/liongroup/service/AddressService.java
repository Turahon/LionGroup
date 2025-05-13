package org.example.liongroup.service;

import org.example.liongroup.dto.AddressDto;
import org.example.liongroup.model.Address;
import org.example.liongroup.model.Result;
import org.example.liongroup.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepo addressRepo;

    public List<Address> getAll(){
        return addressRepo.findAll();
    }


    public Address getById(Long id){
        Optional<Address> byId = addressRepo.findById(id);
        return byId.get();
    }

    public Result create(AddressDto addressDto){
        Address address = new Address();
        address.setCity(addressDto.getCity());
        address.setRegion(addressDto.getRegion());
        addressRepo.save(address);

        return new Result(true, "Address created");
    }

    public Result update(Long id, AddressDto addressDto){
        Optional<Address> addressOptional = addressRepo.findById(id);
        if (addressOptional.isPresent()){
            Address address = addressOptional.get();
            address.setCity(addressDto.getCity());
            address.setRegion(addressDto.getRegion());
            addressRepo.save(address);

            return new Result(true, "Address updated");
        }
        return new Result(false, "Address not found");
    }

    public Result delete(Long id){
        addressRepo.deleteById(id);
        return new Result(true, "Address deleted");
    }
}
