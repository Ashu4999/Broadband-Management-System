package com.example.broadbandmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Intent loginIntent;
    private EditText emailField, passwordField;
    private Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailField = findViewById(R.id.inputEmail);
        passwordField = findViewById(R.id.inputPassword);
        loginBtn = findViewById(R.id.loginBtn);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailField.getText().toString();
                String password = passwordField.getText().toString();
                Log.d("output","X: "+email+"Y: "+password);
                if(email.length() != 0 && password.length() != 0){
                    if(email.equals("x") && password.equals("y")){
                        loginIntent = new Intent(MainActivity.this, Dashborad.class);
                        startActivity(loginIntent);
                    }else{
                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Plzzz Fill Details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void goRegisterForm(View view){
         loginIntent = new Intent(this,registerUser.class);
         startActivity(loginIntent);
    }

    public void goForgetPassword(View view){
         loginIntent = new Intent(this,ForgetPassword.class);
         startActivity(loginIntent);
    }
}