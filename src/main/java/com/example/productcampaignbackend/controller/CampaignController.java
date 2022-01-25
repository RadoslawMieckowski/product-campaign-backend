package com.example.productcampaignbackend.controller;

import com.example.productcampaignbackend.exception.ResourceNotFoundException;
import com.example.productcampaignbackend.model.Campaign;
import com.example.productcampaignbackend.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/campaignes/{id}")
    public ResponseEntity<Campaign> getCampaignById(@PathVariable long id) {
        Campaign campaign = null;
        try {
            campaign = campaignRepository.findById(id)
                    .orElseThrow(()->new ResourceNotFoundException("Campaign of Id number "+id+" doesn't exist."));
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(campaign);
    }

    @PostMapping("/campaignes")
    public Campaign createCampaign(@RequestBody Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    @PutMapping("/campaignes/{id}")
    public ResponseEntity<Campaign> updateCampaign(@PathVariable long id, @RequestBody Campaign campaignDetails ){
        Campaign updatedCampaign =null;
        try {
            Campaign campaign =campaignRepository.findById(id)
                    .orElseThrow(()->new ResourceNotFoundException("Campaign of Id number \"+id+\" doesn't exist."));
            campaign.setName(campaignDetails.getName());
            campaign.setBidAmount(campaignDetails.getBidAmount());
            campaign.setFund(campaignDetails.getFund());
            campaign.setKeywords(campaignDetails.getKeywords());
            campaign.setRadius(campaignDetails.getRadius());
            campaign.setStatus(campaignDetails.isStatus());
            campaign.setTown(campaignDetails.getTown());

            updatedCampaign =campaignRepository.save(campaign);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(updatedCampaign);
    }

}
