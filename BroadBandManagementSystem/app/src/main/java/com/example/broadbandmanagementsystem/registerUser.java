package com.example.broadbandmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class registerUser extends AppCompatActivity {
    private Intent registerIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
    }

    public void goLoginForm(View view){
        registerIntent = new Intent(this,MainActivity.class);
        startActivity(registerIntent);
    }
}