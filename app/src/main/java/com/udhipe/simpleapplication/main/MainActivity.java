package com.udhipe.simpleapplication.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.udhipe.simpleapplication.R;

import com.udhipe.simpleapplication.main.account.AccountFragment;
import com.udhipe.simpleapplication.main.dashboard.DashboardFragment;
import com.udhipe.simpleapplication.main.partner.PartnerFragment;
import com.udhipe.simpleapplication.main.stock.StockFragment;
import com.udhipe.simpleapplication.main.transaction.TransactionFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(new DashboardFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.navigation_dashboard:
                fragment = new DashboardFragment();
                break;
            case R.id.navigation_transaction:
                fragment = new TransactionFragment();
                break;
            case R.id.navigation_stock:
                fragment = new StockFragment();
                break;
            case R.id.navigation_partner:
                fragment = new PartnerFragment();
                break;
            case R.id.navigation_account:
                fragment = new AccountFragment();
                break;
        }
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
