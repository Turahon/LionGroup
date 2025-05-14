package org.example.liongroup.controller;

import org.example.liongroup.dto.HomeDto;
import org.example.liongroup.model.Home;
import org.example.liongroup.model.Result;
import org.example.liongroup.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping
    public List<Home> getAll(){
        return homeService.getAll();
    }

    @GetMapping("/{id}")
    public Home getById(@PathVariable Long id){
        Home home = homeService.getById(id);
        return home;
    }

    @PostMapping
    public Result create(@RequestBody HomeDto homeDto){
        Result result = homeService.create(homeDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody HomeDto homeDto){
        Result result = homeService.update(id, homeDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        Result result = homeService.delete(id);
        return result;
    }

}
