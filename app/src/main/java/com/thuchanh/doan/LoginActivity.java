package com.thuchanh.doan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText edtID, edtPass;
    Button btnLogIn,btnReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtID = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPassword);
        btnLogIn=findViewById(R.id.LoginBtn);
        btnReg=findViewById(R.id.SignUpBtn);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                Bundle b = new Bundle();
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                Bundle b = new Bundle();
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}