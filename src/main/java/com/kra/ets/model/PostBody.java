package com.kra.ets.model;

public class PostBody {

    String pinNo;
    String fillingYear;
    String staffNo;
    String password;

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPinNo() {
        return pinNo;
    }

    public String getFillingYear() {
        return fillingYear;
    }
}
