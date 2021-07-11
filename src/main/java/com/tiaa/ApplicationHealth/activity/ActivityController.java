package com.tiaa.ApplicationHealth.activity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Activity>> getAllActivity(){
        return new ResponseEntity<>(activityService.getAllActivity(), HttpStatus.OK);
    }

    @GetMapping("/{appId}")
    public ResponseEntity<List<Activity>> getActivityByAppId(@PathVariable("appId") Long appId){
        return new ResponseEntity<>(activityService.getActivityByAppId(appId),HttpStatus.OK);
    }

    @PostMapping("/addAlert")
    public ResponseEntity<?> addActivity(@RequestBody Activity activity){
        activityService.addActivity(activity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
