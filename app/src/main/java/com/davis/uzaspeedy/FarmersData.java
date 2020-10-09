package com.davis.uzaspeedy;

public class FarmersData {
    private int imageId;
    private String farmName;
    private String farmLocation;
    private String phoneNumber;

    public FarmersData(Integer imageId, String farmName, String farmLocation, String phoneNumber) {
        this.imageId = imageId;
        this.farmName = farmName;
        this.farmLocation = farmLocation;
        this.phoneNumber = phoneNumber;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getFarmLocation() {
        return farmLocation;
    }

    public void setFarmLocation(String farmLocation) {
        this.farmLocation = farmLocation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
