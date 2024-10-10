package com.project.JobApp;

import com.project.JobApp.model.JobPost;
import com.project.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping({"/", "home"})    //Two url are calling single page
    public String home(){
        return "home";
    }

    @GetMapping("addjob")
    public String addJob(){

        return "addJob";
    }

    @PostMapping("handleForm")
    public String handleform(JobPost jobPost){
        service.addJob(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewAllJob(Model model){
        List<JobPost> jobs = service.getAllJob();
        model.addAttribute("jobPosts", jobs);
        return "viewalljobs";
    }
}
