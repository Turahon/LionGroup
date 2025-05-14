package org.example.liongroup.service;

import org.example.liongroup.dto.JobDto;
import org.example.liongroup.model.Icon;
import org.example.liongroup.model.Job;
import org.example.liongroup.model.Result;
import org.example.liongroup.repo.IconRepo;
import org.example.liongroup.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    JobRepo jobRepo;

    @Autowired
    IconRepo iconRepo;

    public List<Job> getAll(){
        return jobRepo.findAll();
    }

    public Job getById(Long id){
        Optional<Job> optional = jobRepo.findById(id);
        return optional.get();
    }

    public Result create(JobDto jobDto){
        Job job = new Job();
        job.setName(jobDto.getName());
        job.setDescription(jobDto.getDescription());
        Optional<Icon> iconOptional = iconRepo.findById(jobDto.getIconId());
        Icon icon = iconOptional.get();
        job.setIconId((List<Icon>) icon);
        jobRepo.save(job);

        return new Result(true, "Job created");
    }

    public Result update(Long id, JobDto jobDto){
        Optional<Job> optional = jobRepo.findById(id);
        if (optional.isPresent()){
            Job job = optional.get();
            job.setName(jobDto.getName());
            job.setDescription(jobDto.getDescription());
            Optional<Icon> iconOptional = iconRepo.findById(jobDto.getIconId());
            Icon icon = iconOptional.get();
            job.setIconId((List<Icon>) icon);
            jobRepo.save(job);

            return new Result(true, "Job updated");
        }
        return new Result(false, "Job not found");
    }

    public Result delete(Long id){
        jobRepo.deleteById(id);
        return new Result(true, "Job deleted");
    }


}
