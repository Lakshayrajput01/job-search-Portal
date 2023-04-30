package com.geekster.Job.Search.Portal.repository;

import com.geekster.Job.Search.Portal.models.Job;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobRepo extends CrudRepository<Job, Long>{

    //custom finders
    public List<Job> findByEmployerName(String employerName);

    public List<Job> findByLocation(String location);

    public List<Job> findByCompanyName(String companyName);

    public List<Job> findBySalaryGreaterThan(Double salary);

    // Native Custom Query -->>
    @Modifying
    @Query(value = "select * from jobs where title = :title", nativeQuery = true)
    public List<Job> selectJobByTitle(String title);
    @Query(value = "update jobs set location = :location where id = :id", nativeQuery = true)
    public void updateLocationById(Long id, String location);

    @Query(value = "select * from jobs where description = :description", nativeQuery = true)
    public List<Job> selectJobByDescription(String description);
    @Modifying
    @Query(value = "delete from jobs where id = :id", nativeQuery = true)
    public void deleteJobById(Long id);

}

