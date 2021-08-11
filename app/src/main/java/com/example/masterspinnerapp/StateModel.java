package com.example.masterspinnerapp;

import java.util.List;

public class StateModel {

    private long state_id;
    private String state_name;
    private String state_code;
    private String state_description;
    private Character active_status;
    private long country_id;
    private List<DistrictModel> districtModel;

    public List<DistrictModel> getDistrictModel() {
        return districtModel;
    }

    public void setDistrictModel(List<DistrictModel> districtModel) {
        this.districtModel = districtModel;
    }

    public StateModel() {
    }

    public StateModel(long state_id, String state_name, String state_code, String state_description, Character active_status, long country_id) {
        this.state_id = state_id;
        this.state_name = state_name;
        this.state_code = state_code;
        this.state_description = state_description;
        this.active_status = active_status;
        this.country_id = country_id;
    }

    public long getState_id() {
        return state_id;
    }

    public void setState_id(long state_id) {
        this.state_id = state_id;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public String getState_description() {
        return state_description;
    }

    public void setState_description(String state_description) {
        this.state_description = state_description;
    }

    public Character getActive_status() {
        return active_status;
    }

    public void setActive_status(Character active_status) {
        this.active_status = active_status;
    }

    public long getCountry_id() {
        return country_id;
    }

    public void setCountry_id(long country_id) {
        this.country_id = country_id;
    }
}
