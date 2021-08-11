package com.example.masterspinnerapp;

public class UserModel {

    private long mobileNo;
    private String emailID;
    private String fname;
    private String lname;
    private String password;

    public UserModel() {
    }

    public UserModel(long mobileNo, String emailId, String fname, String lname, String password) {
        this.mobileNo = mobileNo;
        this.emailID = emailId;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailId() {
        return emailID;
    }

    public void setEmailId(String emailId) {
        this.emailID = emailId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
