package com.udhipe.simpleapplication.register;

import com.udhipe.simpleapplication.BaseContract;

import org.json.JSONObject;

public interface RegisterContract {
    interface RegisterView extends BaseContract.BaseView {

    }

    interface RegisterPresenter extends BaseContract.BasePresenter {
        void checkInput(String username, String password, String confirmPassword, String accountType);
    }

    interface RegisterInteractor extends BaseContract.BaseInteractor {
        void createAccountData(String username, String password, int accountType,
                               Listener<JSONObject> listener);
    }
}
