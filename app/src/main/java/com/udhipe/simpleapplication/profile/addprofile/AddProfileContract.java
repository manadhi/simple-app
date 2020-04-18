package com.udhipe.simpleapplication.profile.addprofile;

import com.udhipe.simpleapplication.BaseContract;
import com.udhipe.simpleapplication.model.User;

import org.json.JSONObject;

public interface AddProfileContract {
    interface AddProfileView extends BaseContract.BaseView {

    }

    interface AddProfilePresenter extends BaseContract.BasePresenter {
        void updateProfile(User user);
    }

    interface AddProfileInteractor extends BaseContract.BaseInteractor {
        void updateProfileData(User user, Listener<JSONObject> listener);
    }
}
