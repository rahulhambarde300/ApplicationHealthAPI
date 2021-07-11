package com.tiaa.ApplicationHealth.activity;

import com.tiaa.ApplicationHealth.application.Application;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Activity {
    @Id
    @GeneratedValue
    private Long activityId;
    //private Long applicationID;
    private int counter;
    private boolean running;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    private Application application;

    public Activity() {
    }

    public Activity(Long activityId, int counter, boolean running, LocalDateTime startTime, LocalDateTime endTime, Application application) {
        this.activityId = activityId;
        //this.applicationID = applicationID;
        this.counter = counter;
        this.running = running;
        this.startTime = startTime;
        this.endTime = endTime;
        this.application = application;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

//    public Long getApplicationID() {
//        return applicationID;
//    }
//
//    public void setApplicationID(Long applicationID) {
//        this.applicationID = applicationID;
//    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityId=" + activityId +
                ", counter=" + counter +
                ", running=" + running +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", application=" + application +
                '}';
    }
}
