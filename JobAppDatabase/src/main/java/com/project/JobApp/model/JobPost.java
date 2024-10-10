package com.project.JobApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data    //Using this we dont have to write getter and setter, toString method
@NoArgsConstructor   //Annotation for default constructor
@AllArgsConstructor   //Annotation for arguement constructor
@Component   //I want to use this in other classes
@Entity
@Table(name = "job_post")
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;

    @ElementCollection
    private List<String> postTechStack;
}
