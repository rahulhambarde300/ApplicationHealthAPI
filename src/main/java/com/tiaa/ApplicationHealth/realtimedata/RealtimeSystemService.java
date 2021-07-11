package com.tiaa.ApplicationHealth.realtimedata;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
public class RealtimeSystemService {
    @Autowired
    private RealtimeSystemRepo realtimeSystemRepo;

    public RealtimeSystemService(RealtimeSystemRepo realtimeSystemRepo) {
        this.realtimeSystemRepo = realtimeSystemRepo;
    }

    public RealtimeSystem getAllData(){
        List<RealtimeSystem> dataList = realtimeSystemRepo.findAll();
        RealtimeSystem data = dataList.size() > 0 ? dataList.get(0) : null;
        return data;
    }

    public void addData(RealtimeSystem realtimeSystem){
        realtimeSystemRepo.save(realtimeSystem);
    }
}
