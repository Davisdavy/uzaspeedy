package com.davis.uzaspeedy;

public class FarmersData {
    private String farmName;
    private String farmLocation;

    public FarmersData(String farmName, String farmLocation) {
        this.farmName = farmName;
        this.farmLocation = farmLocation;
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
}
