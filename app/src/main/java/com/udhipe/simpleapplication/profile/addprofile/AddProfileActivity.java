package com.udhipe.simpleapplication.profile.addprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.udhipe.simpleapplication.R;

public class AddProfileActivity extends AppCompatActivity implements
        AddProfileContract.AddProfileView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile);
    }

    @Override
    public void openPage(String page) {

    }

    @Override
    public void showInfo(String infoCode) {

    }
}
