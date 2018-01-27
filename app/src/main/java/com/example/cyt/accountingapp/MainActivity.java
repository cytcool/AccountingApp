package com.example.cyt.accountingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCreate;
    private RecordDataBaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);

        dbHelper = new RecordDataBaseHelper(this,"Record",null,1);

        btnCreate = findViewById(R.id.btn_create);
        btnCreate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        dbHelper.getWritableDatabase();
    }
}
