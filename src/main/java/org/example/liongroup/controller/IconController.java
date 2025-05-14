package org.example.liongroup.controller;

import org.example.liongroup.dto.IconDto;
import org.example.liongroup.model.Icon;
import org.example.liongroup.model.Result;
import org.example.liongroup.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class IconController {

    @Autowired
    IconService iconService;

    @GetMapping
    public List<Icon> getAll(){
        return iconService.getAll();
    }

    @GetMapping("/{id}")
    public Icon getById(@PathVariable Long id){
        Icon icon = iconService.getById(id);
        return icon;
    }

    @PostMapping
    public Result create(@RequestBody IconDto iconDto){
        Result result = iconService.create(iconDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody IconDto iconDto){
        Result result = iconService.update(id, iconDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        Result result = iconService.delete(id);
        return result;
    }
}
