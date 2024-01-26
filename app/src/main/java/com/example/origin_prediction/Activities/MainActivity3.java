package com.example.origin_prediction.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.origin_prediction.R;

public class MainActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent=getIntent();
        String origin = intent.getStringExtra("origin");
        TextView textView = findViewById(R.id.result);
        textView.setText(origin);
    }

}