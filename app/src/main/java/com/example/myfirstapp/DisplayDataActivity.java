package com.example.myfirstapp;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DisplayDataActivity extends AppCompatActivity {

    TextView name_Sended_value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        //get the intent that started this activity
        Intent get_intent = getIntent();
        String get_name = get_intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //find the object to place the data
        name_Sended_value = findViewById(R.id.name_sended);
        name_Sended_value.setText(get_name);

    }


}