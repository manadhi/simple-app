package com.udhipe.simpleapplication.main;

import com.udhipe.simpleapplication.BaseContract;
import com.udhipe.simpleapplication.model.User;

import org.json.JSONObject;

public interface MainContract {
    interface MainView<T> extends BaseContract.BaseView {
        void setPresenter(T presenter);
    }

    interface AccountView extends MainView<AccountPresenter> {
//        void showAccountInfo(String info);
//
//        void getToken();
    }

    interface MainPresenter extends BaseContract.BasePresenter {
        void start();
    }

    interface AccountPresenter extends MainPresenter {
//        void getAccountInfo();
//
//        void editProfile();
//
//        void getProfile(String token);
    }

    interface MainInteractor extends BaseContract.BaseInteractor {

    }

    interface AccountInteractor extends MainInteractor {
//        void getProfile(String token, Listener<JSONObject> listener);
//
//        void updateProfile(String token, User user, Listener<JSONObject> listener);
//
//        void createProfile(String token, User user, Listener<JSONObject> listener);
//
//        void getAccount(String token, Listener<JSONObject> listener);
//
//        void updateAccount(String token, User user, Listener<JSONObject> listener);
    }
}