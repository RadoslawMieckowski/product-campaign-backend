package com.example.productcampaignbackend.controller;

import com.example.productcampaignbackend.model.Campaign;
import com.example.productcampaignbackend.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/campaignes")
    public Campaign createCampaign(@RequestBody Campaign campaign) {
        return campaignRepository.save(campaign);
    }
}
