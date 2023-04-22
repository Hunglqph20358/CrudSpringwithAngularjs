package com.example.testproduct.controller;

import com.example.testproduct.model.Status;
import com.example.testproduct.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @GetMapping("/status")
    public ResponseEntity<List<Status>> getAllStatus(){
        return new ResponseEntity<>(statusService.getAllStatus(), HttpStatus.OK);
    }
}
