package com.thuchanh.doan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class LoginActivity extends AppCompatActivity {
    EditText edtID, edtPass;
    Button btnLogIn,btnReg;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtID = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPassword);
        btnLogIn=findViewById(R.id.LoginBtn);
        btnReg=findViewById(R.id.SignUpBtn);
        mAuth=FirebaseAuth.getInstance();

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });


        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               register();
            }
        });
    }

    private void register(){
        Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(i);
    }
    private void login(){
        String email, pass;
        email = edtID.getText().toString();
        pass = edtPass.getText().toString();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Vui lòng nhập Email!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Vui lòng nhập password!!",Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Đăng nhập không thành công!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}