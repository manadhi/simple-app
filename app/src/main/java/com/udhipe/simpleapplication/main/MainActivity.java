package com.udhipe.simpleapplication.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.udhipe.simpleapplication.R;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
//            BottomNavigationView.OnNavigationItemSelectedListener {
//    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
