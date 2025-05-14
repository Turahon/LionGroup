package org.example.liongroup.controller;

import org.example.liongroup.dto.JobDto;
import org.example.liongroup.model.Job;
import org.example.liongroup.model.Result;
import org.example.liongroup.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping
    public List<Job> getAll(){
        return jobService.getAll();
    }

    @GetMapping("/{id}")
    public Job getById(@PathVariable Long id){
        Job job = jobService.getById(id);
        return job;
    }

    @PostMapping
    public Result create(@RequestBody JobDto jobDto){
        Result result = jobService.create(jobDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody JobDto jobDto){
        Result result = jobService.update(id, jobDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        Result result = jobService.delete(id);
        return result;
    }
}
