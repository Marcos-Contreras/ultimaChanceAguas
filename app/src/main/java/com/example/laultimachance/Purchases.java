package com.example.laultimachance;

import java.util.HashMap;

public class Purchases {

    public String Fname;
    public String Lname;
    public String Email, Phone, Address, City, PostaleCode, PaymentMethod;
    public String TotalTotal;
    public Purchases() {

    }

    public Purchases(String fname, String lname, String email, String phone, String address, String city, String postaleCode, String paymentMethod, String totalTotal) {
        Fname = fname;
        Lname = lname;
        Email = email;
        Phone = phone;
        Address = address;
        City = city;
        PostaleCode = postaleCode;
        PaymentMethod = paymentMethod;
        TotalTotal = totalTotal;
    }

    public String getTotalTotal() {
        return TotalTotal;
    }

    public void setTotalTotal(String totalTotal) {
        TotalTotal = totalTotal;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getPostaleCode() {
        return PostaleCode;
    }

    public void setPostaleCode(String postaleCode) {
        PostaleCode = postaleCode;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        PaymentMethod = paymentMethod;
    }
}
