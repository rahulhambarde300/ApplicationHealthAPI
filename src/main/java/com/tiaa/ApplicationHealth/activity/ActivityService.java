package com.tiaa.ApplicationHealth.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityService {
    private ActivityRepo activityRepo;

    @Autowired
    public ActivityService(ActivityRepo activityRepo) {
        this.activityRepo = activityRepo;
    }

    public List<Activity> getAllActivity(){
        return activityRepo.findAll();
    }

    public List<Activity> getActivityByAppId(Long appId){
        List<Activity> activities = new ArrayList<>();
        activityRepo.findByApplicationAppId(appId).forEach(activities :: add);
        return activities;
    }

    public Activity addActivity(Activity activity){
        return activityRepo.save(activity);
    }

    public Activity updateActivity(Activity activity){
        return activityRepo.save(activity);
    }

}
