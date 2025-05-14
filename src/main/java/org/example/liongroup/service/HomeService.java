package org.example.liongroup.service;

import org.example.liongroup.dto.HomeDto;
import org.example.liongroup.model.*;
import org.example.liongroup.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeService {
    @Autowired
    HomeRepo homeRepo;

    @Autowired
    PhotoRepo photoRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    AddressRepo addressRepo;

    public List<Home> getAll(){
        return homeRepo.findAll();
    }

    public Home getById(Long id){
        Optional<Home> byId = homeRepo.findById(id);
        return byId.get();
    }

    public Result create(HomeDto homeDto){
        Home home = new Home();
        home.setTitle(homeDto.getTitle());
        home.setDescription(homeDto.getDescription());
        Optional<Photo> photoOptional = photoRepo.findById(homeDto.getPhotoId());
        Photo photo = photoOptional.get();
        home.setPhotoId((List<Photo>) photo);
        Optional<Category> categoryOptional = categoryRepo.findById(homeDto.getCategoryId());
        Category category = categoryOptional.get();
        home.setCategoryId((List<Category>) category);
        Optional<Product> productOptional = productRepo.findById(homeDto.getProductID());
        Product product = productOptional.get();
        home.setProductID((List<Product>) product);
        Optional<Address> addressOptional = addressRepo.findById(homeDto.getAddresseID());
        Address address = addressOptional.get();
        home.setAddresseID((List<Address>) address);
        homeRepo.save(home);

        return new Result(true, "Home created");
    }

    public Result update(Long id, HomeDto homeDto){
        Optional<Home> homeOptional = homeRepo.findById(id);
        if(homeOptional.isPresent()) {
            Home home = homeOptional.get();
            home.setTitle(homeDto.getTitle());
            home.setDescription(homeDto.getDescription());
            home.setPhotoId((List<Photo>) photoRepo);
            home.setCategoryId((List<Category>) categoryRepo);
            home.setProductID((List<Product>) productRepo);
            home.setAddresseID((List<Address>) addressRepo);
            homeRepo.save(home);

            return new Result(true, "Home updated");
        }
        return new Result(false, "Home not found");
    }

    public Result delete(Long id){
        homeRepo.deleteById(id);
        return new Result(true, "Home deleted");
    }

}
