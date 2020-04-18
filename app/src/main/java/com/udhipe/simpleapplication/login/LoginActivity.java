package com.udhipe.simpleapplication.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.udhipe.simpleapplication.R;
import com.udhipe.simpleapplication.main.MainActivity;
import com.udhipe.simpleapplication.profile.addprofile.AddProfileActivity;
import com.udhipe.simpleapplication.register.RegisterActivity;
import com.udhipe.simpleapplication.utility.ConstantManager;
import com.udhipe.simpleapplication.model.Preferences;

public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView {

    MaterialButton btnSignUp;
    MaterialButton btnLogin;
    TextInputEditText edtUsername;
    TextInputEditText edtPassword;

    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this);

        initializeView();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (!(Preferences.getAccountToken(this).isEmpty())) {
            openPage(ConstantManager.DASHBOARD);
        }
    }

    @Override
    public void openPage(String page) {
        Intent intent = new Intent();

        switch (page) {
            case ConstantManager.REGISTER:
                intent = new Intent(getBaseContext(), RegisterActivity.class);
                break;
            case ConstantManager.DASHBOARD:
                intent = new Intent(getBaseContext(), MainActivity.class);
                break;
            case ConstantManager.ADDPROFILE:
                intent = new Intent(getBaseContext(), AddProfileActivity.class);
                break;
        }

        startActivity(intent);
    }

    @Override
    public void showInfo(String infoCode) {
        String message;

        switch (infoCode) {
            case ConstantManager.INFO_EMPTY_USERNAME:
                message = getString(R.string.empty_username);
                break;
            case ConstantManager.INFO_MINIMUM_USERNAME:
                message = getString(R.string.minimum_username) +
                        ConstantManager.MINIMUM_CHARACTER_USERNAME + getString(R.string.character);
                break;
            case ConstantManager.INFO_EMPTY_PASSWORD:
                message = getString(R.string.empty_password);
                break;
            case ConstantManager.INFO_MINIMUM_PASSWORD:
                message = getString(R.string.minimum_password) +
                        ConstantManager.MINIMUM_CHARACTER_PASSWORD + getString(R.string.character);
                break;
            case ConstantManager.CONNECTION_PROBLEM:
                message = getString(R.string.connection_problem);
                break;
            default:
                message = infoCode;
//                throw new IllegalStateException("Unexpected value: " + infoCode);
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void initializeView() {
        btnSignUp = findViewById(R.id.btnSignUp);
        btnLogin = findViewById(R.id.btnLogin);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);

        initializeListener();
    }

    private void initializeListener() {
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage(ConstantManager.REGISTER);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.checkInput(edtUsername.getText().toString(),
                        edtPassword.getText().toString());
            }
        });
    }

    @Override
    public void saveAccountCredential(String token, String id) {
        Preferences.saveAccountToken(this, token);
        Preferences.saveAccountId(this, id);
    }
}
