package com.example.masterspinnerapp;

public class TahsilModel {

    private long tahsil_id;

    private String tahsil_name;

    private long tahsil_code;

    private String tahsil_description;

    private Character active_status;

    public TahsilModel() {
    }

    public TahsilModel(long tahsil_id, String tahsil_name, long tahsil_code, String tahsil_description, Character active_status) {
        this.tahsil_id = tahsil_id;
        this.tahsil_name = tahsil_name;
        this.tahsil_code = tahsil_code;
        this.tahsil_description = tahsil_description;
        this.active_status = active_status;
    }

    public long getTahsil_id() {
        return tahsil_id;
    }

    public void setTahsil_id(long tahsil_id) {
        this.tahsil_id = tahsil_id;
    }

    public String getTahsil_name() {
        return tahsil_name;
    }

    public void setTahsil_name(String tahsil_name) {
        this.tahsil_name = tahsil_name;
    }

    public long getTahsil_code() {
        return tahsil_code;
    }

    public void setTahsil_code(long tahsil_code) {
        this.tahsil_code = tahsil_code;
    }

    public String getTahsil_description() {
        return tahsil_description;
    }

    public void setTahsil_description(String tahsil_description) {
        this.tahsil_description = tahsil_description;
    }

    public Character getActive_status() {
        return active_status;
    }

    public void setActive_status(Character active_status) {
        this.active_status = active_status;
    }
}
