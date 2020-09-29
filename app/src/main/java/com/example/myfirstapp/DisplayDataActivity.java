package com.example.myfirstapp;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class DisplayDataActivity extends AppCompatActivity {

    TextView name_Sended_value;
    TextView lastName_Sended_value;
    TextView gender_Sended_value;
    TextView birth_Sended_value;
    TextView sended_Programming_value;
    TextView Sended_Programming_languages_Value;

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
        String get_Programming_value= get_intent.getStringExtra(MainActivity.EXTRA_MESSAGE_PROGRAMMING);
        ArrayList<String> get_Programming_languages_Value = get_intent.getStringArrayListExtra(MainActivity.EXTRA_MESSAGE_PROGRAMMING_LANGUAGES);

        //find the object to place the data and then asign the value
        name_Sended_value = findViewById(R.id.name_sended);
        name_Sended_value.setText(get_name);
        lastName_Sended_value = findViewById(R.id.name_sended2);
        lastName_Sended_value.setText(get_lastName);
        gender_Sended_value = findViewById(R.id.gender_sended);
        gender_Sended_value.setText(get_gender);
        birth_Sended_value = findViewById(R.id.birth_Sended_value);
        birth_Sended_value.setText(get_Birth_date);
        sended_Programming_value = findViewById(R.id.programming_status);
        sended_Programming_value.setText(get_Programming_value);
        Sended_Programming_languages_Value = findViewById(R.id.programming_status2);

        String value = "";
        for (String index: get_Programming_languages_Value) {
            //int value2 = index.indexOf(index);
            value = value.concat(index);
            value = value.concat("   ");
            Sended_Programming_languages_Value.setText(value);

        }



    }


}