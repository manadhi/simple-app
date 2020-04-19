package com.udhipe.simpleapplication.model;

public class User {
    String username;
    String password;
    int account_type;
    String token;
    String accountId;

    String name;
    String no_ktp;
    String email;
    String phone;
    String address;

    public User() {

    }

    public User(String username, String password, int account_type) {
        this.username = username;
        this.password = password;
        this.account_type = account_type;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String name, String email, String no_ktp, String address, String phone) {
        this.name = name;
        this.email = email;
        this.no_ktp = no_ktp;
        this.address = address;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountType() {
        return account_type;
    }

    public void setAccountType(int accountType) {
        this.account_type = accountType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getKtp() {
        return no_ktp;
    }

    public void setKtp(String no_ktp) {
        this.no_ktp = no_ktp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
