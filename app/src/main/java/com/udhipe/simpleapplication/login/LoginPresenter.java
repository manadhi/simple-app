package com.udhipe.simpleapplication.login;

import android.util.Log;

import com.udhipe.simpleapplication.BaseContract;
import com.udhipe.simpleapplication.model.User;
import com.udhipe.simpleapplication.utility.ConstantManager;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginPresenter implements LoginContract.LoginPresenter {

    LoginContract.LoginView view;
    LoginContract.LoginInteractor interactor;

    String username;
    String password;
    User user;

    public LoginPresenter(LoginContract.LoginView view) {
        this.view = view;
        interactor = new LoginInteractor();
    }

    @Override
    public void checkInput(String username, String password) {
        this.username = username;
        this.password = password;
        user = new User(username, ConstantManager.EMPTY);

        checkusername();
    }

    private void checkusername() {
        if (username.matches(ConstantManager.EMPTY)) {
            view.showInfo(ConstantManager.INFO_EMPTY_USERNAME);
        } else if (username.length() < ConstantManager.MINIMUM_CHARACTER_USERNAME) {
            view.showInfo(ConstantManager.INFO_MINIMUM_USERNAME);
        } else {
            checkPassword();
        }
    }

    private void checkPassword() {
        if (password.matches(ConstantManager.EMPTY)) {
            view.showInfo(ConstantManager.INFO_EMPTY_PASSWORD);
        } else if (password.length() < ConstantManager.MINIMUM_CHARACTER_PASSWORD) {
            view.showInfo(ConstantManager.INFO_MINIMUM_PASSWORD);
        } else {
            checkAccount();
        }
    }

    private void checkAccount() {
        interactor.getAccountSession(username, password, new LoginInteractor.Listener<JSONObject>() {
            @Override
            public void onSuccess(JSONObject data, String message) {
                try {
                    user.setToken(data.getString("access_token"));
                    user.setAccountId(data.getString("account_id"));
                    user.setAccountType(data.getInt("account_type"));

                    Log.d("USERR", "user : " + user.toString());

                    view.openPage(ConstantManager.DASHBOARD);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String message) {
                view.showInfo(message);
            }
        });
    }

    @Override
    public void goToPage(String page) {

    }

    @Override
    public void exceptionHandler(String message) {

    }
}
