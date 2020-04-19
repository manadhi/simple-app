package com.udhipe.simpleapplication.profile.addprofile;

import com.udhipe.simpleapplication.BaseContract;
import com.udhipe.simpleapplication.model.User;
import com.udhipe.simpleapplication.utility.ConstantManager;

import org.json.JSONObject;

public class AddProfilePresenter implements AddProfileContract.AddProfilePresenter {

    AddProfileContract.AddProfileView view;
    AddProfileContract.AddProfileInteractor interactor;

    String ktp;
    String phone;
    String email;
    String address;

    String token;

    public AddProfilePresenter(AddProfileContract.AddProfileView view) {
        this.view = view;
        interactor = new AddProfileInteractor();
    }

    @Override
    public void goToPage(String page) {

    }

    @Override
    public void exceptionHandler(String message) {

    }

    @Override
    public void start(String token) {
        this.token = token;
    }

    @Override
    public void checkInput(String ktp, String phone, String email, String address) {
        this.ktp = ktp;
        this.phone = phone;
        this.email = email;
        this.address = address;

        checkKtp();
    }

    private void checkKtp() {
        if (ktp.matches(ConstantManager.EMPTY)) {
            view.showInfo(ConstantManager.INFO_EMPTY_KTP);
        } else if (ktp.length() < ConstantManager.MINIMUM_CHARACTER_KTP) {
            view.showInfo(ConstantManager.INFO_MINIMUM_KTP);
        } else {
            checkEmail();
        }
    }

    private void checkPhone() {
        if (phone.matches(ConstantManager.EMPTY)) {
            view.showInfo(ConstantManager.INFO_EMPTY_PHONE);
        } else {
            checkAddress();
        }
    }

    private void checkEmail() {
        if (email.matches(ConstantManager.EMPTY)) {
            view.showInfo(ConstantManager.INFO_EMPTY_EMAIL);
        } else {
            checkPhone();
        }
    }

    private void checkAddress() {
        if (address.matches(ConstantManager.EMPTY)) {
            view.showInfo(ConstantManager.INFO_EMPTY_ADDRESS);
        } else {
            createProfile();
        }
    }

    private void createProfile() {
        User user = new User("", email, ktp, address, phone);

        interactor.createProfileData(token, user, new BaseContract.BaseInteractor.Listener<JSONObject>() {
            @Override
            public void onSuccess(JSONObject data, String message) {
                view.openPage(ConstantManager.DASHBOARD);
            }

            @Override
            public void onError(String message) {
                view.showInfo(message);
            }
        });
    }

}
