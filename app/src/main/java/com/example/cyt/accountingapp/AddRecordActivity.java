package com.example.cyt.accountingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class AddRecordActivity extends AppCompatActivity implements View.OnClickListener {

    private Button kb_one;
    private Button kb_two;
    private Button kb_three;
    private Button kb_four;
    private Button kb_five;
    private Button kb_six;
    private Button kb_seven;
    private Button kb_eight;
    private Button kb_nine;
    private Button kb_zero;

    private Button kb_dot;
    private ImageButton kb_type;
    private ImageButton kb_backspace;
    private ImageButton kb_done;

    private TextView textView;
    private String userInput="";

    private RecyclerView recyclerView;
    private CategoryRecyclerAdapter adapter;

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
        kb_eight= findViewById(R.id.keyboard_eight);
        kb_nine = findViewById(R.id.keyboard_nine);
        kb_zero = findViewById(R.id.keyboard_zero);

        kb_one.setOnClickListener(this);
        kb_two.setOnClickListener(this);
        kb_three.setOnClickListener(this);
        kb_four.setOnClickListener(this);
        kb_five.setOnClickListener(this);
        kb_six.setOnClickListener(this);
        kb_seven.setOnClickListener(this);
        kb_eight.setOnClickListener(this);
        kb_nine.setOnClickListener(this);
        kb_zero.setOnClickListener(this);

        textView = findViewById(R.id.text_amount);

        handleBackSpace();
        handleDone();
        handleDot();
        handleTypeChange();

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new CategoryRecyclerAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),4);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter.notifyDataSetChanged();

   }

   private void handleDot(){
        kb_dot = findViewById(R.id.keyboard_dot);
        kb_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!userInput.contains(".")){
                    userInput += ".";
                }
            }
        });
   }

   private void handleTypeChange(){
       kb_type = findViewById(R.id.keyboard_type);
       kb_type.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });
   }

   private void handleBackSpace(){
       kb_backspace = findViewById(R.id.keyboard_backspace);
       kb_backspace.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                if (userInput.length()>0){
                    userInput = userInput.substring(0,userInput.length()-1);
                }
                if (userInput.length()>0 && userInput.charAt(userInput.length()-1)=='.'){
                    userInput = userInput.substring(0,userInput.length()-1);
                }
           }
       });
   }

   private void handleDone(){
       kb_done = findViewById(R.id.keyboard_done);
       kb_done.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (!userInput.equals("")){
                   double amount = Double.valueOf(userInput);
               }

           }
       });
   }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String input = button.getText().toString();

        if (userInput.contains(".")){
            if (userInput.split("\\.").length ==1 || userInput.split("\\.")[1].length()==2){
                userInput += input;
            }
        }else {
            userInput += input;
        }
        
        updateAmountText();
    }

    private void updateAmountText() {

       if (userInput.contains(".")){
           if (userInput.split("\\.").length == 1){
               textView.setText(userInput + "00");
           }else if(userInput.split("\\.")[1].length() == 1){
               textView.setText(userInput + "0");
           }else if (userInput.split("\\.")[1].length() == 2){
               textView.setText(userInput);
           }
       }else {
           if (userInput.equals("")){
               textView.setText("0.00");
           }else {
               textView.setText(userInput + ".00");
           }
       }
    }
}

