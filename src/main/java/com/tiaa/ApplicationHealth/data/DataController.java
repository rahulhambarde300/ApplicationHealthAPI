package com.tiaa.ApplicationHealth.data;

import com.tiaa.ApplicationHealth.alert.parameters.ParameterValueChecker;
import com.tiaa.ApplicationHealth.application.Application;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/application")
public class DataController {
    private final DataService dataService;

    private ParameterValueChecker parameterValueChecker = new ParameterValueChecker();

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }


    @GetMapping("/{appId}/data")
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

    @PostMapping("/data")
    public ResponseEntity<?> addAllData(@RequestBody List<Data> datas){
        for(Data data: datas){
            if(data.getCurrentTime() == null)
                data.setCurrentTime(LocalDateTime.now());
            data.setApplication(new Application(data.getApplicationID(),"","","",""));
            parameterValueChecker.checkParameters(data);
        }
        dataService.addAllDatas(datas);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
