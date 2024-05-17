package com.example.task3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    private EditText loginEmail, loginPassword;

    private TextView loginForgetPass, loginSignup;

    private Button loginBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loginEmail=findViewById(R.id.loginEmail);
        loginPassword=findViewById(R.id.loginPassword);

        loginBtn=findViewById(R.id.loginBtn);
        loginSignup=findViewById(R.id.loginSignup);

        loginForgetPass=findViewById(R.id.loginForgetPassword);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginemail=loginEmail.getText().toString();
                String loginpassword=loginPassword.getText().toString();

                if (loginemail.isEmpty()) {
                    Toast.makeText(LoginActivity.this,"Enter Email",Toast.LENGTH_SHORT).show();
                } else if (loginpassword.isEmpty()) {
                    Toast.makeText(LoginActivity.this,"Enter Email",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this,"Home Page --> Welcome to Learn",Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                    i.putExtra("loginemail", loginemail);
                    startActivity(i);
                }
            }
        });

        loginSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"Sign Up Page",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));

            }
        });

        loginForgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"Contact the Admin/Owner",Toast.LENGTH_SHORT).show();
            }
        });

    }
}