package com.example.masterspinnerapp;

import java.util.List;

public class DistrictModel {

    private long district_id;
    private String district_name;
    private long district_code;
    private String district_description;
    private Character active_status;

    private List<TahsilModel> tahsilModels;

    public List<TahsilModel> getTahsilModels() {
        return tahsilModels;
    }

    public void setTahsilModels(List<TahsilModel> tahsilModels) {
        this.tahsilModels = tahsilModels;
    }

    public DistrictModel() {
    }

    public DistrictModel(long district_id, String district_name, long district_code, String district_description, Character active_status) {
        this.district_id = district_id;
        this.district_name = district_name;
        this.district_code = district_code;
        this.district_description = district_description;
        this.active_status = active_status;
    }

    public long getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(long district_id) {
        this.district_id = district_id;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public long getDistrict_code() {
        return district_code;
    }

    public void setDistrict_code(long district_code) {
        this.district_code = district_code;
    }

    public String getDistrict_description() {
        return district_description;
    }

    public void setDistrict_description(String district_description) {
        this.district_description = district_description;
    }

    public Character getActive_status() {
        return active_status;
    }

    public void setActive_status(Character active_status) {
        this.active_status = active_status;
    }
}
