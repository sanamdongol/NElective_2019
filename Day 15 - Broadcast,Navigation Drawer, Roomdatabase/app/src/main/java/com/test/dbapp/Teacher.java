package com.test.dbapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Teacher {
    @PrimaryKey
    int teacherId;
    String name;
    String address;
    String phone;

    public Teacher(int teacherId, String name, String address, String phone) {
        this.teacherId = teacherId;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
