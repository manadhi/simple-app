package com.udhipe.simpleapplication.login;

import com.udhipe.simpleapplication.BaseContract;

import org.json.JSONObject;

public interface LoginContract {

    interface LoginView extends BaseContract.BaseView {
        void saveAccountCredential(String token, String id);
    }

    interface LoginPresenter extends BaseContract.BasePresenter {
        void checkInput(String username, String password);
    }

    interface LoginInteractor extends BaseContract.BaseInteractor {
        void getAccountSession(String username, String password, Listener<JSONObject> listener);

        void getProfile(String token, Listener<JSONObject> listener);
    }

}
