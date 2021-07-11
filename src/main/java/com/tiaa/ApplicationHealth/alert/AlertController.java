package com.tiaa.ApplicationHealth.alert;

import com.tiaa.ApplicationHealth.application.Application;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlertController {
    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @GetMapping("/fetch/alerts")
    public ResponseEntity<List<Alert>> getAllAlerts(){
        return new ResponseEntity<>(alertService.getAllAlerts(), HttpStatus.OK);
    }

    @GetMapping("/fetch/{appId}/alerts")
    public ResponseEntity<List<Alert>> getAllApplicationAlerts(@PathVariable("appId") Long appId){
        return new ResponseEntity<>(alertService.getAlertByAppId(appId), HttpStatus.OK);
    }

    @PostMapping("/addAlert")
    public ResponseEntity<Alert> addAlert(@RequestBody Alert alert){
        //alert.setApplication(new Application(appId,"","","",""));
        Alert newAlert = alertService.addAlert(alert);
        return new ResponseEntity<>(newAlert, HttpStatus.OK);
    }
}
