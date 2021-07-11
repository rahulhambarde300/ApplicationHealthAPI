package com.tiaa.ApplicationHealth.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.HashMap;
import java.util.List;

public interface DataRepo extends JpaRepository<Data, Long> {
    public List<Data> findByApplicationAppId(Long id);

    public int countByApplicationAppId(Long id);

    public Data findByApplicationAppIdAndCounter(Long id, int count);

    public Data findFirstByApplicationAppIdOrderByCurrentTimeDesc(Long id);



    @Query(value = "SELECT application_app_id,AVG(MEMORY_USAGE) AS MEMORY " +
            "FROM DATA GROUP BY APPLICATION_APP_ID ORDER BY MEMORY DESC LIMIT 10", nativeQuery = true)
    public List<List<Long>> findMemoryAnalysis();

    @Query(value = "SELECT application_app_id,AVG(DISK_USAGE) AS DISK " +
            "FROM DATA GROUP BY APPLICATION_APP_ID ORDER BY DISK DESC LIMIT 10", nativeQuery = true)
    public List<List<Long>> findDiskAnalysis();

    @Query(value = "SELECT application_app_id,AVG(CPU_USAGE) AS CPU " +
            "FROM DATA GROUP BY APPLICATION_APP_ID ORDER BY CPU DESC LIMIT 10", nativeQuery = true)
    public List<List<Double>> findCpuAnalysis();


}
