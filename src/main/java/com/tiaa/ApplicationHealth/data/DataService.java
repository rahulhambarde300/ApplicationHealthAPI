package com.tiaa.ApplicationHealth.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {
    private DataRepo dataRepo;

    @Autowired
    public DataService(DataRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    public List<Data> getAllData(Long appId){
        List<Data> data = new ArrayList<>();
        dataRepo.findByApplicationAppId(appId).forEach(data::add);
        return data;
    }

    public Data addData(Data data){
        return dataRepo.save(data);
    }

    public void updateData(Data data) { dataRepo.save(data); }

    public void addAllDatas(List<Data> datas){ dataRepo.saveAll(datas); }

    public int getApplicationDataCount(Long appId){
        return dataRepo.countByApplicationAppId(appId);
    }

    public Data getApplicationDataByCounter(Long appId, int counter){
        return dataRepo.findByApplicationAppIdAndCounter(appId, counter);
    }

    public Data getRecentApplicationData(Long appId){
        return dataRepo.findFirstByApplicationAppIdOrderByCurrentTimeDesc(appId);
    }


    //Analysis functions

    public List<List<Long>> getMemoryAnalysis(){
        return dataRepo.findMemoryAnalysis();
    }

    public List<List<Long>> getDiskAnalysis(){ return dataRepo.findDiskAnalysis(); }

    public List<List<Double>> getCpuAnalysis(){
        return dataRepo.findCpuAnalysis();
    }

}
