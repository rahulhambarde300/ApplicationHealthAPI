package com.tiaa.ApplicationHealth.system;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system")
public class SystemController {
    private SystemService systemService;

    public SystemController(SystemService systemService) {
        this.systemService = systemService;
    }

    @GetMapping("/data")
    public ResponseEntity<List<System>> getSystem(){
        return new ResponseEntity<>(systemService.findSystem(), HttpStatus.OK);
    }

    @PostMapping("/data")
    public ResponseEntity<?> addSystem(@RequestBody System system){
        systemService.addSystem(system);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
