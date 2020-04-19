package com.udhipe.simpleapplication.profile.addprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.udhipe.simpleapplication.R;
import com.udhipe.simpleapplication.main.MainActivity;
import com.udhipe.simpleapplication.model.Preferences;
import com.udhipe.simpleapplication.utility.ConstantManager;

public class AddProfileActivity extends AppCompatActivity implements
        AddProfileContract.AddProfileView {

    TextInputEditText edtKtp;
    TextInputEditText edtEmail;
    TextInputEditText edtPhone;
    TextInputEditText edtAddress;
    MaterialButton btnSave;

    AddProfilePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile);

        presenter = new AddProfilePresenter(this);

        initializeView();
    }

    private void initializeView() {
        edtKtp = findViewById(R.id.edtKtp);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);
        edtAddress = findViewById(R.id.edtAddress);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.checkInput(edtKtp.getText().toString(), edtPhone.getText().toString(),
                        edtEmail.getText().toString(), edtAddress.getText().toString());
            }
        });
    }

    @Override
    public void openPage(String page) {
        Intent intent = new Intent();

        switch (page) {
            case ConstantManager.DASHBOARD:
                intent = new Intent(getBaseContext(), MainActivity.class);
                break;
        }

        startActivity(intent);
    }

    @Override
    public void showInfo(String infoCode) {
        String message;

        switch (infoCode) {
            case ConstantManager.INFO_EMPTY_KTP:
                message = getString(R.string.empty_ktp);
                break;
            case ConstantManager.INFO_MINIMUM_KTP:
                message = getString(R.string.length_ktp) +
                        ConstantManager.MINIMUM_CHARACTER_KTP + getString(R.string.character);
                break;
            case ConstantManager.INFO_EMPTY_PHONE:
                message = getString(R.string.empty_phone);
                break;
            case ConstantManager.INFO_EMPTY_EMAIL:
                message = getString(R.string.empty_email);
                break;
            case ConstantManager.INFO_EMPTY_ADDRESS:
                message = getString(R.string.empty_address);
                break;
            case ConstantManager.CONNECTION_PROBLEM:
                message = getString(R.string.connection_problem);
                break;
            default:
                message = infoCode;
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.start(Preferences.getAccountToken(this));
    }
}
