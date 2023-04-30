package com.geekster.Job.Search.Portal.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity

public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String title;

    private String description;
    @NotNull
    private String location;

    private Double salary;

    private String companyName;

    private String employerName;

    @Enumerated(value = EnumType.STRING)
    private JobType jobType;

}
