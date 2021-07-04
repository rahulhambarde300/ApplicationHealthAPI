package com.tiaa.ApplicationHealth.application;

import com.tiaa.ApplicationHealth.application.Application;
import com.tiaa.ApplicationHealth.application.ApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    private ApplicationRepo applicationRepo;

    @Autowired
    public ApplicationService(ApplicationRepo applicationRepo) {
        this.applicationRepo = applicationRepo;
    }

    public Application addApplication(Application application){
        return applicationRepo.save(application);
    }

    public List<Application> findAllApplication(){
        return applicationRepo.findAll();
    }
}
