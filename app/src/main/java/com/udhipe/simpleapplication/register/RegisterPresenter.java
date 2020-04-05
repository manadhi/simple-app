package com.udhipe.simpleapplication.register;

import com.udhipe.simpleapplication.utility.ConstantManager;

import org.json.JSONObject;

public class RegisterPresenter implements RegisterContract.RegisterPresenter {

    String username;
    String password;
    String confirmPassword;
    String accountType;

    RegisterContract.RegisterView view;
    RegisterContract.RegisterInteractor interactor;

    public RegisterPresenter(RegisterContract.RegisterView view) {
        this.view = view;
    }

    @Override
    public void checkInput(String username, String password, String confirmPassword, String accountType) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.accountType = accountType;
        interactor = new RegisterInteractor();

        checkusername();
    }

    @Override
    public void goToPage(String page) {

    }

    @Override
    public void exceptionHandler(String message) {

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
            checkConfirmPassword();
        }
    }

    private void checkConfirmPassword() {
        if (confirmPassword.matches(ConstantManager.EMPTY)) {
            view.showInfo(ConstantManager.INFO_EMPTY_CONFIRM_PASSWORD);
        } else if (!confirmPassword.matches(password)) {
            view.showInfo(ConstantManager.INFO_PASSWORD_MISSMATCH);
        } else {
            checkAccountType();
        }
    }

    private void checkAccountType() {
        if (accountType.matches(ConstantManager.EMPTY)) {
            view.showInfo(ConstantManager.INFO_EMPTY_ACCOUNT_TYPE);
        } else {
            getAccountTypeCode();
        }
    }

    private void getAccountTypeCode() {
        int accountTypeCode;
        if (accountType.matches(ConstantManager.accountTypeList[0])) {
            accountTypeCode = ConstantManager.AGENT_REGULER;
        } else if (accountType.matches(ConstantManager.accountTypeList[1])) {
            accountTypeCode = ConstantManager.AGENT_PREMIUM;
        } else if (accountType.matches(ConstantManager.accountTypeList[2])) {
            accountTypeCode = ConstantManager.AGENT_STARTUP;
        } else if (accountType.matches(ConstantManager.accountTypeList[3])) {
            accountTypeCode = ConstantManager.RESELLER;
        } else {
            accountTypeCode = ConstantManager.MARKETER;
        }

        createAccount(accountTypeCode);
    }

    public void createAccount(int accountTypeCode) {
        interactor.createAccountData(username, password, accountTypeCode, new RegisterInteractor.Listener<JSONObject>() {
            @Override
            public void onSuccess(JSONObject data, String message) {
                view.showInfo(ConstantManager.SUCCESS_CREATE_ACCOUNT);
            }

            @Override
            public void onError(String message) {
                view.showInfo(ConstantManager.FAIL_CREATE_ACCOUNT);
            }
        });
    }
}
