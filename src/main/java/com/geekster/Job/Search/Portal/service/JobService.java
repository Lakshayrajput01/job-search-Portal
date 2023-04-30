package com.geekster.Job.Search.Portal.service;

import com.geekster.Job.Search.Portal.models.Job;
import com.geekster.Job.Search.Portal.repository.IJobRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    IJobRepo iJobRepo;

    public Iterable<Job> getAllJob() {
         return iJobRepo.findAll();

    }

    public String AddJob(List<Job>JobList){
        Iterable<Job> Added=iJobRepo.saveAll(JobList);
        if(Added !=null){
            return "Added Successfully";
        }
        return "Null value Does not Exist";
    }

    public void RemoveJobById(Long id) {
        iJobRepo.deleteById(id);
    }


    public List<Job> fetchByName(String employerName){
        return iJobRepo.findByEmployerName(employerName);
    }

    public List<Job> fetchBylocation(String location) {
        return iJobRepo.findByLocation(location);
    }

    public List<Job> fetchBycompanyName(String companyName) {
        return iJobRepo.findByCompanyName(companyName);
    }

    public List<Job> fetchBySalary(Double salary) {
        return iJobRepo.findBySalaryGreaterThan(salary);
    }

    public String updateJobById(Job updatedJob) {
        Job Jobobj = iJobRepo.findById(updatedJob.getId()).orElse(null);
        if(Jobobj != null){
            iJobRepo.save(updatedJob);
            return "Job updated Successfully!";
        }
        else {
            return "Id is not valid!";
        }
    }

    // Using Native Query Methods -->
    @Transactional
    public String updateLocationById(String location, Long id) {
        iJobRepo.updateLocationById(id, location);
        return "Location updated!";
    }
    @Transactional
    public String deleteByIdNative(Long id) {
        iJobRepo.deleteJobById(id);
        return "Job deleted!";
    }
    public List<Job> getAllJobsByTitle(String title) {
        return iJobRepo.selectJobByTitle(title);
    }
    public List<Job> getAllJobsByDescription(String description) {
        return iJobRepo.selectJobByDescription(description);
    }
}
