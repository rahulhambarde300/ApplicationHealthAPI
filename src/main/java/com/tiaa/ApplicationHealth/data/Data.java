package com.tiaa.ApplicationHealth.data;

import com.tiaa.ApplicationHealth.application.Application;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long dataId;
    @Column(name="`currentTime`")
    private String currentTime;
    @Column(name="`memoryUsage`")
    private long memoryUsage;
    @Column(name="`diskUsage`")
    private long diskUsage;
    @Column(name="`cpuUsage`")
    private double cpuUsage;
    private int numberOfThread;

    @ManyToOne
    private Application application;

    public Data() {
    }

    public Data(long dataId, String currentTime, long memoryUsage, long diskUsage, int numberOfThread, double cpuUsage, Application application) {
        this.dataId = dataId;
        this.currentTime = currentTime;
        this.memoryUsage = memoryUsage;
        this.diskUsage = diskUsage;
        this.numberOfThread = numberOfThread;
        this.cpuUsage = cpuUsage;
        this.application = application;
    }

    public long getDataId() {
        return dataId;
    }

    public void setDataId(long dataId) {
        this.dataId = dataId;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public long getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(long memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public long getDiskUsage() {
        return diskUsage;
    }

    public void setDiskUsage(long diskUsage) {
        this.diskUsage = diskUsage;
    }

    public int getNumberOfThread() {
        return numberOfThread;
    }

    public void setNumberOfThread(int numberOfThread) {
        this.numberOfThread = numberOfThread;
    }


    public double getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    @Override
    public String toString() {
        return "Data{" +
                "dataId=" + dataId +
                ", currentTime=" + currentTime +
                ", memoryUsage=" + memoryUsage +
                ", diskUsage=" + diskUsage +
                ", numberOfThread=" + numberOfThread +
                ", cpuUsage=" + cpuUsage +
                ", application=" + application +
                '}';
    }
}
