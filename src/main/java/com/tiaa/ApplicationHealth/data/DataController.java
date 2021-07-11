package com.tiaa.ApplicationHealth.data;

import com.tiaa.ApplicationHealth.alert.parameters.ParameterValueChecker;
import com.tiaa.ApplicationHealth.application.Application;
import com.tiaa.ApplicationHealth.realtimedata.RealtimeSystem;
import com.tiaa.ApplicationHealth.system.System;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
public class DataController {
    private final DataService dataService;
    public int maxDataCount = 2;
    private ParameterValueChecker parameterValueChecker = new ParameterValueChecker();
    private String systemUri = "http://localhost:8080/fetch/system/realtime";


    public DataController(DataService dataService) {
        this.dataService = dataService;
    }


    @GetMapping("/fetch/application/data/{appId}")
    public ResponseEntity<List<Data>> getData(@PathVariable("appId") Long appId){
        return new ResponseEntity<>(dataService.getAllData(appId), HttpStatus.OK);
    }


    @PostMapping("/{appId}/data")
    public ResponseEntity<?> addData(@RequestBody Data data, @PathVariable("appId") Long appId){
        //Add application id to data
        data.setApplication(new Application(appId,"","","",""));

        //Check if the parameters are above limit
        parameterValueChecker.checkParameters(data);

        Data newData = dataService.addData(data);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/insert/application/data")
    public ResponseEntity<?> addAllData(@RequestBody List<Data> datas){
        for(Data data: datas){
            if(data.getCurrentTime() == null)
                data.setCurrentTime(LocalDateTime.now());

            data.setApplication(new Application(data.getApplicationID(),"","","",""));
            parameterValueChecker.checkParameters(data);

            int dataCount = dataService.getApplicationDataCount(data.getApplicationID());
            if(dataCount < maxDataCount){
                //Add new data

                dataCount += 1;

                data.setCounter(dataCount);
                dataService.addData(data);
            }
            else
            {
                //Update data
                Data recentData = dataService.getRecentApplicationData(data.getApplicationID());
                int count = recentData.getCounter();
                count %= maxDataCount;
                count += 1;
                Data oldestData = dataService.getApplicationDataByCounter(data.getApplicationID(), count);
                data.setDataId(oldestData.getDataId());
                data.setCounter(count);

                dataService.updateData(data);
            }


        }

        //dataService.addAllDatas(datas);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Analysis related endpoints below

    //Just need to add other analyis data
    @GetMapping("/fetch/application/analysis")
    public ResponseEntity<HashMap<String,Object>> getMemoryAnalysis(){
        HashMap<String, Object> response = new HashMap<>();

        RestTemplate restTemplate = new RestTemplate();
        RealtimeSystem realtimeSystem = restTemplate.getForObject(systemUri, RealtimeSystem.class);

        List<List<Long>> memoryUsageList = dataService.getMemoryAnalysis();
        List<List<Long>> diskUsageList = dataService.getDiskAnalysis();
        List<List<Double>> cpuUsageList = dataService.getCpuAnalysis();

        Long remainingMemory = realtimeSystem.getUsedMemory();
        Long remainingDisk = realtimeSystem.getUsedDisk();
        Double remainingCpu = realtimeSystem.getCpuLoad();

        for(List<Long> data: memoryUsageList){
            remainingMemory -= data.get(1);
        }
        for(List<Long> data: diskUsageList){
            remainingDisk -= data.get(1);
        }
        for(List<Double> data: cpuUsageList){
            remainingCpu -= data.get(1);
        }

        memoryUsageList.add(new ArrayList<>(Arrays.asList(-1L,remainingMemory)));
        diskUsageList.add(new ArrayList<>(Arrays.asList(-1L,remainingDisk)));
        cpuUsageList.add(new ArrayList<>(Arrays.asList(-1D,remainingCpu)));

        response.put("MemoryUsage",memoryUsageList);
        response.put("DiskUsage",diskUsageList);
        response.put("CpuUsage",cpuUsageList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @GetMapping("/fetch/application/analysis/disk")
//    public ResponseEntity<List<List<Long>>> getDiskAnalysis(){
//        return new ResponseEntity<>(dataService.getDiskAnalysis(), HttpStatus.OK);
//    }
//
//    @GetMapping("/fetch/application/analysis/cpu")
//    public ResponseEntity<List<List<Long>>> getCpuAnalysis(){
//        return new ResponseEntity<>(dataService.getCpuAnalysis(), HttpStatus.OK);
//    }
}
