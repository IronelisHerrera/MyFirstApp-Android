package com.example.myfirstapp;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DisplayDataActivity extends AppCompatActivity {

    TextView name_Sended_value;
    TextView lastName_Sended_value;
    TextView gender_Sended_value;
    TextView birth_Sended_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        //get the intent that started this activity
        Intent get_intent = getIntent();
        //Intent get_LastName_intent = getIntent();
        String get_name = get_intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String get_lastName = get_intent.getStringExtra(MainActivity.EXTRA_MESSAGE_LASTNAME );
        String get_gender = get_intent.getStringExtra(MainActivity.EXTRA_MESSAGE_GENDER);
        String get_Birth_date = get_intent.getStringExtra(MainActivity.EXTRA_MESSAGE_BIRTH_DATE);

        //find the object to place the data and then asign the value
        name_Sended_value = findViewById(R.id.name_sended);
        name_Sended_value.setText(get_name);
        lastName_Sended_value = findViewById(R.id.name_sended2);
        lastName_Sended_value.setText(get_lastName);
        gender_Sended_value = findViewById(R.id.gender_sended);
        gender_Sended_value.setText(get_gender);
        birth_Sended_value = findViewById(R.id.birth_Sended_value);
        birth_Sended_value.setText(get_Birth_date);


    }


}