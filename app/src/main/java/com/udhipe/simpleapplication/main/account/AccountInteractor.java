package com.udhipe.simpleapplication.main.account;

import com.udhipe.simpleapplication.main.MainContract;
import com.udhipe.simpleapplication.model.User;

import org.json.JSONObject;

public class AccountInteractor implements MainContract.AccountInteractor {
    @Override
    public void getProfile(String token, Listener<JSONObject> listener) {

    }

    @Override
    public void updateProfile(String token, User user, Listener<JSONObject> listener) {

    }

    @Override
    public void createProfile(String token, User user, Listener<JSONObject> listener) {

    }

    @Override
    public void getAccount(String token, Listener<JSONObject> listener) {

    }

    @Override
    public void updateAccount(String token, User user, Listener<JSONObject> listener) {

    }
}
