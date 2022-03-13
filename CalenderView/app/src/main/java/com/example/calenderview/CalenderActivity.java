package com.example.calenderview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

import java.util.Calendar;

public class CalenderActivity extends AppCompatActivity {
    private CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        calendarView = findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
//                String date = (i1 + 1) + "/" + i2 + "/" + i;
                String date = i + "/" + (i1 + 1) + "/" + i2;
                Log.d("Date","Date: mm/dd/yyyy "+date);

                Intent intent = new Intent(CalenderActivity.this, MainActivity.class);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });
    }
}