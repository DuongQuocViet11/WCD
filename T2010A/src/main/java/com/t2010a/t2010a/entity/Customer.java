package com.t2010a.t2010a.entity;

import com.t2010a.t2010a.util.DateTimeHelper;

import java.time.LocalDateTime;

public class Customer {
    private String cusID;
    private String name;
    private String phone;
    private String image;
    private LocalDateTime dob;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int status;

    public Customer(String cusID, String name, String phone, String image, LocalDateTime dob, LocalDateTime createdAt, LocalDateTime updatedAt, int status) {
        this.cusID = cusID;
        this.name = name;
        this.phone = phone;
        this.image = image;
        this.dob = dob;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Customer(String cusID, String name, String phone, String image, LocalDateTime dob) {
        this.cusID = cusID;
        this.name = name;
        this.phone = phone;
        this.image = image;
        this.dob = dob;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = 1;
    }

    public Customer(){
        this.cusID = "";
        this.name = "";
        this.phone = "";
        this.image = "";
    }

    public Customer(String cusID, String name, String phone){
        this.cusID = cusID;
        this.name = name;
        this.phone = phone;
        this.image = "";
        this.createdAt =LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = 1;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusID='" + cusID + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", image='" + image + '\'' +
                ", dob=" + dob +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", status=" + status +
                '}';
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public String getJoinedAt() {
        if(this.createdAt != null){
            return DateTimeHelper.convertLocalDateTimeToString(this.createdAt);
        }
        return "";
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDobString() {
        if(this.dob != null){
            return DateTimeHelper.convertLocalDateTimeToString(this.dob);
        }
        return "";
    }
}
