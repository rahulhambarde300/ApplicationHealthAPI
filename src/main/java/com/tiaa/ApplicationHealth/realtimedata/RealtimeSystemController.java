package com.tiaa.ApplicationHealth.realtimedata;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RealtimeSystemController {
    private final RealtimeSystemService realtimeSystemService;

    public RealtimeSystemController(RealtimeSystemService realtimeSystemService) {
        this.realtimeSystemService = realtimeSystemService;
    }

    @GetMapping("/fetch/system/realtime")
    public ResponseEntity<RealtimeSystem> getSystemRealtimeData(){
        return new ResponseEntity<>(realtimeSystemService.getAllData(), HttpStatus.OK);
    }

    @PostMapping("/insert/system/realtime")
    public ResponseEntity<?> addSystemRealtimeData(@RequestBody RealtimeSystem realtimeSystem){
        RealtimeSystem data = realtimeSystemService.getAllData();
        if(data != null){
            //Update data
            realtimeSystem.setId(data.getId());
        }

        realtimeSystemService.addData(realtimeSystem);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
