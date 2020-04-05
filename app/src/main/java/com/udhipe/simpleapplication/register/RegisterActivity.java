package com.udhipe.simpleapplication.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.udhipe.simpleapplication.R;
import com.udhipe.simpleapplication.login.LoginActivity;
import com.udhipe.simpleapplication.utility.ConstantManager;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.RegisterView {

    MaterialButton btnLogin;
    MaterialButton btnRegister;
    TextInputEditText edtUsername;
    TextInputEditText edtPassword;
    TextInputEditText edtPasswordAgain;
    AutoCompleteTextView dropDownAccountType;

    RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerPresenter = new RegisterPresenter(this);

        initializeView();
    }

    @Override
    public void openPage(String page) {

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
            case ConstantManager.INFO_EMPTY_CONFIRM_PASSWORD:
                message = getString(R.string.empty_confirm_password);
                break;
            case ConstantManager.INFO_PASSWORD_MISSMATCH:
                message = getString(R.string.password_missmatch);
                break;
            case ConstantManager.INFO_EMPTY_ACCOUNT_TYPE:
                message = getString(R.string.empty_account_type);
                break;
            case ConstantManager.SUCCESS_CREATE_ACCOUNT:
                message = getString(R.string.success_create_account);
                break;
            case ConstantManager.FAIL_CREATE_ACCOUNT:
                message = getString(R.string.fail_create_account);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + infoCode);
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void initializeView() {
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnSignUp);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        edtPasswordAgain = findViewById(R.id.edtPasswordAgain);
        dropDownAccountType = findViewById(R.id.dropDownAccountType);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            edtUsername.setFocusedByDefault(true);
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, R.layout.dropdown_account_type,
                        ConstantManager.accountTypeList);

        dropDownAccountType.setAdapter(adapter);

        initializeListener();
    }

    private void initializeListener() {
        btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(getBaseContext(), LoginActivity.class);
            startActivity(intent);
        });

        btnRegister.setOnClickListener(v -> {
            registerPresenter.checkInput(edtUsername.getText().toString(),
                    edtPassword.getText().toString(), edtPasswordAgain.getText().toString(),
                    dropDownAccountType.getText().toString());
        });
    }
}
