package com.tiaa.ApplicationHealth.system;

import com.tiaa.ApplicationHealth.alert.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SystemService {
    private SystemRepo systemRepo;

    @Autowired
    public SystemService(SystemRepo systemRepo) {
        this.systemRepo = systemRepo;
    }

    public List<System> findSystem(){
        return systemRepo.findAll();
    }

    public Optional<System> findSystemById(String osName){
        return systemRepo.findById(osName);
    }

    public System addSystem(System system){
        return systemRepo.save(system);
    }

}
