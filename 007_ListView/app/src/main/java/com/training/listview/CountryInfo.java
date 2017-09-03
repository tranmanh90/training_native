package com.training.listview;

/**
 * Created by TMMT on 9/1/2017.
 */

public class CountryInfo {
    private String mCountryName;
    private String mFlagName;
    private String mArea;

    public CountryInfo(String countryName, String flagName, String area) {
        this.mCountryName = countryName;
        this.mFlagName = flagName;
        this.mArea = area;
    }

    public String getCountryName() {
        return mCountryName;
    }

    public void setCountryName(String countryName) {
        this.mCountryName = countryName;
    }

    public String getFlagName() {
        return mFlagName;
    }

    public void setFlagName(String flagName) {
        this.mFlagName = flagName;
    }

    public String getArea() {
        return mArea;
    }

    public void setArea(String area) {
        this.mArea = area;
    }

    @Override
    public String toString() {
        return this.mCountryName + " (1000000 Km2: " + this.mArea + ")";
    }
}
