package com.udhipe.simpleapplication.main;

import com.udhipe.simpleapplication.BaseContract;

import org.json.JSONObject;

public interface MainContract {
    interface MainView<T> extends BaseContract.BaseView {
        void setPresenter(T presenter);
    }

    interface AccountView extends MainView<AccountPresenter> {
        void showAccountInfo(String info);
    }

    interface MainPresenter extends BaseContract.BasePresenter {
        void start();
    }

    interface AccountPresenter extends MainPresenter {
        void getAccountInfo();
    }

    interface MainInteractor extends BaseContract.BaseInteractor {

    }

    interface AccountInteractor extends MainInteractor {
        void getAccountData(String token, Listener<JSONObject> listener);

        void updateAccountData(String token, String username,
                               String password, int version, Listener<JSONObject> listener);
    }
}