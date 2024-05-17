package com.example.task3;

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

public class SignUpActivity extends AppCompatActivity {
    private EditText signupFullname, signupEmail, signupPassword;

    private Button signupBtn;

    private TextView signupLogin ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        signupFullname=findViewById(R.id.signupFullname);
        signupEmail=findViewById(R.id.signupEmail);
        signupPassword=findViewById(R.id.signupPassword);

        signupBtn=findViewById(R.id.signupBtn);
        signupLogin=findViewById(R.id.signUpLogin);


        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String signupfullname=signupFullname.getText().toString();
                String signupemail=signupEmail.getText().toString();
                String signuppassword=signupPassword.getText().toString();

                if (signupfullname.isEmpty()){
                    Toast.makeText(SignUpActivity.this,"Enter Name",Toast.LENGTH_SHORT).show();
                } else if (signupemail.isEmpty()) {
                    Toast.makeText(SignUpActivity.this,"Enter Email",Toast.LENGTH_SHORT).show();
                } else if (signuppassword.isEmpty()) {
                    Toast.makeText(SignUpActivity.this,"Enter Email",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignUpActivity.this,"You have created an account sucessfully",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                }
            }
        });

        signupLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignUpActivity.this,"Login Page",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));

            }
        });


    }
}