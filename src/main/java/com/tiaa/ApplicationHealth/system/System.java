package com.tiaa.ApplicationHealth.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class System {
    @Id
    @Column(nullable = false)
    private String osName;
    private Long memorySize;
    private Long diskSize;
    private int cpuCores;
    private int systemType;
    private Long systemUptime;
    private String systemFamily;
    private String Manufacturer;

    public System() {
    }

    public System(String osName, Long memorySize, Long diskSize,
                  int cpuCores, int systemType, Long systemUptime, String systemFamily, String manufacturer) {
        this.osName = osName;
        this.memorySize = memorySize;
        this.diskSize = diskSize;
        this.cpuCores = cpuCores;
        this.systemType = systemType;
        this.systemUptime = systemUptime;
        this.systemFamily = systemFamily;
        Manufacturer = manufacturer;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public Long getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(Long memorySize) {
        this.memorySize = memorySize;
    }

    public Long getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(Long diskSize) {
        this.diskSize = diskSize;
    }

    public int getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(int cpuCores) {
        this.cpuCores = cpuCores;
    }

    public int getSystemType() {
        return systemType;
    }

    public void setSystemType(int systemType) {
        this.systemType = systemType;
    }

    public Long getSystemUptime() {
        return systemUptime;
    }

    public void setSystemUptime(Long systemUptime) {
        this.systemUptime = systemUptime;
    }

    public String getSystemFamily() {
        return systemFamily;
    }

    public void setSystemFamily(String systemFamily) {
        this.systemFamily = systemFamily;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "System{" +
                "osName='" + osName + '\'' +
                ", memorySize=" + memorySize +
                ", diskSize=" + diskSize +
                ", cpuCores=" + cpuCores +
                ", systemType=" + systemType +
                ", systemUptime=" + systemUptime +
                ", systemFamily='" + systemFamily + '\'' +
                ", Manufacturer='" + Manufacturer + '\'' +
                '}';
    }
}
