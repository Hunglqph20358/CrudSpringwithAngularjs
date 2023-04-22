package com.example.testproduct.service.IPM;

import com.example.testproduct.model.Status;
import com.example.testproduct.repository.StatusRepository;
import com.example.testproduct.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceIpm implements StatusService {
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }
}
