package com.udhipe.simpleapplication.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textview.MaterialTextView;
import com.udhipe.simpleapplication.R;

public class ProfileActivity extends AppCompatActivity {

    MaterialTextView tvUsername;
    MaterialTextView tvKtp;
    MaterialTextView tvEmail;
    MaterialTextView tvPhone;
    MaterialTextView tvAddress;
    FloatingActionButton fabEditProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initializeView();
    }

    private void initializeView() {
        tvUsername = findViewById(R.id.tv_username);
        tvKtp = findViewById(R.id.tv_ktp);
        tvEmail = findViewById(R.id.tv_email);
        tvPhone = findViewById(R.id.tv_phone);
        tvAddress = findViewById(R.id.tv_address);
        fabEditProfile = findViewById(R.id.fabEditProfile);

        fabEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                presenter.editProfile();
            }
        });
    }

}
