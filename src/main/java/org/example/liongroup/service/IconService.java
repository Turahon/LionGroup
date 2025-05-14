package org.example.liongroup.service;

import org.example.liongroup.dto.IconDto;
import org.example.liongroup.model.Category;
import org.example.liongroup.model.Icon;
import org.example.liongroup.model.Result;
import org.example.liongroup.repo.CategoryRepo;
import org.example.liongroup.repo.IconRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IconService {

    @Autowired
    IconRepo iconRepo;

    @Autowired
    CategoryRepo categoryRepo;

    public List<Icon> getAll(){
        return iconRepo.findAll();
    }

    public Icon getById(Long id){
        Optional<Icon> iconOptional = iconRepo.findById(id);
        return iconOptional.get();
    }

    public Result create(IconDto iconDto){
        Icon icon = new Icon();
        icon.setName(iconDto.getName());
        icon.setClassname(iconDto.getClassname());
        icon.setSvgcode(iconDto.getSvgcode());
        Optional<Category> categoryOptional = categoryRepo.findById(iconDto.getCategoryId());
        Category category = categoryOptional.get();
        icon.setCategoryId((List<Category>) category);
        iconRepo.save(icon);

        return new Result(true, "Icon created");
    }

    public Result update(Long id, IconDto iconDto){
        Optional<Icon> iconOptional = iconRepo.findById(id);
        if(iconOptional.isPresent()){
            Icon icon = iconOptional.get();
            icon.setName(iconDto.getName());
            icon.setClassname(iconDto.getClassname());
            icon.setSvgcode(iconDto.getSvgcode());
            icon.setCategoryId((List<Category>) categoryRepo);
            iconRepo.save(icon);

            return new Result(true, "Icon created");
        }
        return new Result(false, "Icon not found");
    }

    public Result delete(Long id){
        iconRepo.deleteById(id);
        return new Result(true, "Icon deleted");
    }
}
