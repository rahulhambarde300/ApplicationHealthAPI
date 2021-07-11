package com.tiaa.ApplicationHealth.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActivityRepo extends JpaRepository<Activity, Long> {
    public List<Activity> findByApplicationAppId(Long id);

    //@Query(value = "SELECT new com.tiaa.ApplicationHealth.activity()")
    //public Activity findFirstByCounterAndApplicationAppIdOrderByCounter();
}
