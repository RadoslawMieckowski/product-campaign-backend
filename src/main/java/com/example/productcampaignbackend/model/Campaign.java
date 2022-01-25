package com.example.productcampaignbackend.model;

import javax.persistence.*;

@Entity
@Table(name="campaignes")
public class Campaign {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="keywords")
    private String keywords;

    @Column(name="bidAmount")
    private double bidAmount;

    @Column(name="fund")
    private double fund;

    @Column(name="status")
    private boolean status;

    @Column(name="town")
    private String town;

    @Column(name="radius")
    private int radius;

    public Campaign() {
    }

    public Campaign(String name, String keywords, double bidAmount, double fund, boolean status, String town, int radius) {
        this.name = name;
        this.keywords = keywords;
        this.bidAmount = bidAmount;
        this.fund = fund;
        this.status = status;
        this.town = town;
        this.radius = radius;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public double getFund() {
        return fund;
    }

    public void setFund(double fund) {
        this.fund = fund;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
