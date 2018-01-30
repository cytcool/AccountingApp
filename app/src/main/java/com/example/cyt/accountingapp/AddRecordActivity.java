package com.example.cyt.accountingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class AddRecordActivity extends AppCompatActivity {

    private Button kb_one;
    private Button kb_two;
    private Button kb_three;
    private Button kb_four;
    private Button kb_five;
    private Button kb_six;
    private Button kb_seven;
    private Button kb_eight;
    private Button kb_night;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        initView();


    }

    private void initView() {
        kb_one = findViewById(R.id.keyboard_one);
        kb_two = findViewById(R.id.keyboard_two);
        kb_three = findViewById(R.id.keyboard_three);
        kb_four = findViewById(R.id.keyboard_four);
        kb_five = findViewById(R.id.keyboard_five);
        kb_six= findViewById(R.id.keyboard_six);
        kb_seven = findViewById(R.id.keyboard_seven);
   }
}

