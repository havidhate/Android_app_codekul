package com.example.masterspinnerapp;

import java.util.List;

public class CountryModel {

    private long country_id;
    private long country_code;
    private String country_description;
    private String country_name;
    private String activity_status;
    private List<StateModel> state_models;

    public List<StateModel> getStateModel() {
        return state_models;
    }

    public void setStateModel(List<StateModel> state_models) {
        this.state_models = state_models;
    }

    public CountryModel() {
    }

    public CountryModel(long country_id, long country_code, String country_description, String country_name, String activity_status) {
        this.country_id = country_id;
        this.country_code = country_code;
        this.country_description = country_description;
        this.country_name = country_name;
        this.activity_status = activity_status;
    }

    public long getCountry_id() {
        return country_id;
    }

    public void setCountry_id(long country_id) {
        this.country_id = country_id;
    }

    public long getCountry_code() {
        return country_code;
    }

    public void setCountry_code(long country_code) {
        this.country_code = country_code;
    }

    public String getCountry_description() {
        return country_description;
    }

    public void setCountry_description(String country_description) {
        this.country_description = country_description;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getActivity_status() {
        return activity_status;
    }

    public void setActivity_status(String activity_status) {
        this.activity_status = activity_status;
    }
}
