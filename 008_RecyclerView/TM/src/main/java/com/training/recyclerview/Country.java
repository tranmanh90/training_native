package com.training.recyclerview;

/**
 * Created by TMMT on 9/7/2017.
 */

public class Country {
    private String mCountryName;
    private int mArea;
    private int mFlagId;

    public Country(String mCountryName, int mArea, int mFlag) {
        this.mCountryName = mCountryName;
        this.mArea = mArea;
        this.mFlagId = mFlag;
    }

    public String getmCountryName() {
        return mCountryName;
    }

    public void setmCountryName(String mCountryName) {
        this.mCountryName = mCountryName;
    }

    public int getmArea() {
        return mArea;
    }

    public void setmArea(int mArea) {
        this.mArea = mArea;
    }

    public int getmFlagId() {
        return mFlagId;
    }

    public void setmFlagId(int mFlagId) {
        this.mFlagId = mFlagId;
    }
}
