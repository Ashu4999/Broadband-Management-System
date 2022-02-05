package com.example.broadbandmanagementsystem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class UpdateDeleteCustomer extends AppCompatActivity {
    private Spinner planSelector;
    private String plans[] = {"Select Plan","1 Month-599/-", "3 Month-799/-", "4 Month-899/-", "6 Month-1099/-", "12 Month-1499/-",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete_customer);

        planSelector = findViewById(R.id.planSelector);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, plans){
            @Override
            public boolean isEnabled(int position) {
                if(position == 0){
                    return false;
                }else{
                    return  true;
                }
            }

            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        planSelector.setAdapter(arrayAdapter);
    }
}