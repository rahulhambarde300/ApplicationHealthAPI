package com.tiaa.ApplicationHealth.application;

import com.tiaa.ApplicationHealth.application.Application;
import com.tiaa.ApplicationHealth.application.ApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@RestController
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/fetch/application/getApplicationNames")
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> applications = applicationService.findAllApplication();
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    @GetMapping("{appId}/name")
    public Optional<Application> getApplication(@PathVariable("appId") Long appId) {
        //Check if an application exists and return
        Optional<Application> application = applicationService.findApplicationById(appId);
        return application;
    }

    @PostMapping("/insert/application/newApp")
    public ResponseEntity<ArrayList<Object>> addApplication(@RequestBody Application application){
        Application newApplication =applicationService.addApplication(application);
        ArrayList<Object> response = new ArrayList<>();
        response.add(newApplication.getAppId());
        response.add(newApplication.getApplicationName());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/insert/application/new")
    public ResponseEntity<List<HashMap<String,Object>>> addApplications(@RequestBody List<Application> applications){

        List<Application> allApplications = applicationService.addAllApplications(applications);
        List<HashMap<String,Object>> response= new ArrayList<>();


        for(Application app: allApplications){
            HashMap<String,Object> temp = new HashMap<String, Object>();
            temp.put("appId",app.getAppId());
            temp.put("applicationName",app.getApplicationName());

            response.add(temp);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
