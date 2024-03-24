package com.thuchanh.doan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity_Guest extends AppCompatActivity {


    ImageButton mimg1, mimg2, mimg3, mimg4 , mimg5 , mimg6 , mimg7, mimg8;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_guest);
        //Thanh menu
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    return true;
                case R.id.search:
                    startActivity(new Intent(getApplicationContext(), SearchBar_Guest.class));
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.info:
                    startActivity(new Intent(getApplicationContext(), UserInfo_Guest.class));
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    finish();
                    return true;
            }
            return false;
        });

        //Ánh xạ
        mimg1 = (ImageButton) findViewById(R.id.btnIMG1);
        mimg2 = (ImageButton) findViewById(R.id.btnIMG2);
        mimg3 = (ImageButton) findViewById(R.id.btnIMG3);

        mimg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
