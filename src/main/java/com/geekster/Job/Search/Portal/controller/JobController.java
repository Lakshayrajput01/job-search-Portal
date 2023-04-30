package com.geekster.Job.Search.Portal.controller;

import com.geekster.Job.Search.Portal.models.Job;
import com.geekster.Job.Search.Portal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class JobController {
    @Autowired
    JobService jobService;

    //CRUD Operations
    @GetMapping(value = "/getalljob")
    public Iterable<Job> getJob(){
        return jobService.getAllJob();
    }
    @PostMapping(value = "/addjob")
    public String AddJob(@RequestBody List<Job> JobList){
        return jobService.AddJob(JobList);
    }
    @DeleteMapping(value = "/Deletejob/byId/{id}")
    public void RemoveJobById(@PathVariable Long id){
        jobService.RemoveJobById(id);
    }

    @PutMapping(value = "updatejob")
    public String updateJob(@RequestBody Job updatedJob){
        return jobService.updateJobById(updatedJob);
    }

//    @PutMapping(value = "Update")



    //getbyname finder
    @GetMapping(value = "/getbyname/{employerName}")
    public List<Job> getJobName(@PathVariable String employerName){
        return jobService.fetchByName(employerName);
    }
    @GetMapping(value = "/getbylocation/{location}")
        public List<Job> getByLocation(@PathVariable String location){
            return jobService.fetchBylocation(location);
        }

    @GetMapping(value = "/getbycompanyName/{companyName}")
    public List<Job> getBycompanyName(@PathVariable String companyName){
        return jobService.fetchBycompanyName(companyName);
    }
    @GetMapping(value = "/getbysalary/{salary}")
    public List<Job> GetByLocation(@PathVariable Double salary){
        return jobService.fetchBySalary(salary);
    }

    @PutMapping(value = "jobs/location/{location}/id/{id}")
    public String updateLocationById(@PathVariable String location,@PathVariable Long id){
        return jobService.updateLocationById(location, id);
    }
    @DeleteMapping(value = "job/native/{id}")
    public String deleteByIdNative(@PathVariable Long id){
        return jobService.deleteByIdNative(id);
    }
    @GetMapping(value = "jobs/title/{title}")
    public List<Job> getAllJobsByTitle(@PathVariable String title){
        return jobService.getAllJobsByTitle(title);
    }
    @GetMapping(value = "jobs/description/{description}")
    public List<Job> getAllJobsByDescription(@PathVariable String description){
        return jobService.getAllJobsByDescription(description);
    }

}
