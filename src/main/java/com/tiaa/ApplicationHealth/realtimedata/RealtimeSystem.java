package com.tiaa.ApplicationHealth.realtimedata;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RealtimeSystem {
    @Id
    @GeneratedValue
    private Long id;
    private Long usedMemory;
    private Long availableMemory;
    private Long usedDisk;
    private Long availableDisk;
    private Double cpuLoad;
    private int numberOfThread;

    public RealtimeSystem() {
    }

    public RealtimeSystem(Long id, Long usedMemory, Long availableMemory, Long usedDisk, Long availableDisk, Double cpuLoad, int numberOfThread) {
        this.id = id;
        this.usedMemory = usedMemory;
        this.availableMemory = availableMemory;
        this.usedDisk = usedDisk;
        this.availableDisk = availableDisk;
        this.cpuLoad = cpuLoad;
        this.numberOfThread = numberOfThread;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(Long usedMemory) {
        this.usedMemory = usedMemory;
    }

    public Long getAvailableMemory() {
        return availableMemory;
    }

    public void setAvailableMemory(Long availableMemory) {
        this.availableMemory = availableMemory;
    }

    public Long getUsedDisk() {
        return usedDisk;
    }

    public void setUsedDisk(Long usedDisk) {
        this.usedDisk = usedDisk;
    }

    public Long getAvailableDisk() {
        return availableDisk;
    }

    public void setAvailableDisk(Long availableDisk) {
        this.availableDisk = availableDisk;
    }

    public Double getCpuLoad() {
        return cpuLoad;
    }

    public void setCpuLoad(Double cpuLoad) {
        this.cpuLoad = cpuLoad;
    }

    public int getNumberOfThread() {
        return numberOfThread;
    }

    public void setNumberOfThread(int numberOfThread) {
        this.numberOfThread = numberOfThread;
    }
}
