package com.example.productcampaignbackend.controller;

import com.example.productcampaignbackend.model.Campaign;
import com.example.productcampaignbackend.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CampaignController {
    @Autowired
    private CampaignRepository campaignRepository;

    @GetMapping("/campaignes")
    public List<Campaign> getAllCampaignes() {
        return campaignRepository.findAll();
    }
}
