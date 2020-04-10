package com.udhipe.simpleapplication.model;

public class User {
    String username;
    String password;
    int account_type;

    public User(String username, String password, int account_type) {
        this.username = username;
        this.password = password;
        this.account_type = account_type;
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
}
