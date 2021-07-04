package com.tiaa.ApplicationHealth.application;

import com.tiaa.ApplicationHealth.application.Application;
import com.tiaa.ApplicationHealth.application.ApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/application")
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/new")
    public ResponseEntity<ArrayList<Object>> addApplication(@RequestBody Application application){
        Application newApplication =applicationService.addApplication(application);
        ArrayList<Object> response = new ArrayList<>();
        response.add(newApplication.getAppId());
        response.add(newApplication.getApplicationName());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getApplicationNames")
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> applications = applicationService.findAllApplication();
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

}
