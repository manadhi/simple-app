package com.udhipe.simpleapplication.profile.addprofile;

import com.udhipe.simpleapplication.BaseContract;
import com.udhipe.simpleapplication.model.User;

import org.json.JSONObject;

public interface AddProfileContract {
    interface AddProfileView extends BaseContract.BaseView {

    }

    interface AddProfilePresenter extends BaseContract.BasePresenter {
        void start(String token);

        void checkInput(String ktp, String phone, String email, String address);
    }

    interface AddProfileInteractor extends BaseContract.BaseInteractor {
        void createProfileData(String token, User user, Listener<JSONObject> listener);
    }
}
