package com.thuchanh.doan;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView
        .OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView
                = findViewById(R.id.bottomNavigationView);

        bottomNavigationView
                .setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);

    }
    HomeFragment homeFragment = new HomeFragment();
    InfoFragment infoFragment = new InfoFragment();




    @Override
    public boolean
    onNavigationItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, homeFragment)
                        .commit();
                return true;

            case R.id.info:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, infoFragment)
                        .commit();
                return true;
        }
        return false;
    }
}
