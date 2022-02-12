package com.example.broadbandmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.broadbandmanagementsystem.databases.InventoryDB;

import java.text.DecimalFormat;

public class NewInventory extends AppCompatActivity {
    private EditText nameField, quantityField, priceField;
    private TextView totalAmtText;
    private Button saveBtn;
    private Double totalAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_inventory);

        nameField = findViewById(R.id.invetoryName);
        quantityField = findViewById(R.id.invetoryQuantity);
        priceField = findViewById(R.id.invetoryPrice);
        totalAmtText = findViewById(R.id.inventoryTotalAmt);
        saveBtn = findViewById(R.id.saveInventory);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(nameField.getText().toString()) && !TextUtils.isEmpty(priceField.getText().toString()) && !TextUtils.isEmpty(quantityField.getText().toString()))
                {
                    String name = nameField.getText().toString();
                    double price = Double.parseDouble(priceField.getText().toString());
                    int quantity = Integer.parseInt(quantityField.getText().toString());

                   // Log.d("test","Name: "+name+" Quantity: "+quantity+" Price: "+price+" Total Amount: "+totalAmount);

                    InventoryDB inventoryDB = new InventoryDB(NewInventory.this);
                    inventoryDB.insertData(name,quantity,price,totalAmount);

                    nameField.setText("");
                    priceField.setText("");
                    quantityField.setText("");
                    totalAmtText.setText("");
                }else{
                    Log.d("test","Plzzz Filled Fields");
                }
            }
        });



        quantityField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(!TextUtils.isEmpty(quantityField.getText().toString()) && !TextUtils.isEmpty(priceField.getText().toString())){
                        totalAmount = Integer.parseInt(quantityField.getText().toString()) * Double.parseDouble(priceField.getText().toString());
                        totalAmtText.setText("Total Amount: "+new DecimalFormat("##.##").format(totalAmount));
                    }else{
                        totalAmtText.setText("Price will be here");
                    }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}