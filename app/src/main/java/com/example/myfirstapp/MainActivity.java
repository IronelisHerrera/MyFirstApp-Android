package com.example.myfirstapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Spinner spinner_Options;
    //DatePicker variables
    private TextView datePicker_Object;
    private DatePickerDialog.OnDateSetListener datePicker_Dialog;
    //validations variables
    public static EditText name_Field, lastName_Field;
    public static Spinner gender;

    //onSend click
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    public static TextView gender_view_value;
    public static String gender_string_value;
    public static String name_Field_validation;
    public static String lastName_Field_validation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Search for the spinner id in my activity_main.xml design
        spinner_Options =  findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> spinner_adapter = ArrayAdapter.createFromResource(this, R.array.spinner_options, R.layout.support_simple_spinner_dropdown_item);
        spinner_Options.setAdapter(spinner_adapter);
        datePicker_Object = findViewById(R.id.textView6);
        //create a Date dialog picker view when clicked on TextView
        datePicker_Object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Lets get an instance of Android calendar
                Calendar calendar = Calendar.getInstance();
                int y = calendar.get(Calendar.YEAR);
                int day_month = calendar.get(Calendar.DAY_OF_MONTH);
                int m = calendar.get(Calendar.MONTH);
                DatePickerDialog show_DatePicker_Dialog = new DatePickerDialog(MainActivity.this, R.style.Widget_AppCompat_Light_ActionBar_Solid, datePicker_Dialog,y,day_month,m );
                show_DatePicker_Dialog.show();

            }
        });
        //access to the date of the selected dialog picker
        datePicker_Dialog = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //sum +1 to month 'cause it starts with 0
                month++;
                String selected_Date = dayOfMonth + "-" + month + "-" + year;
                datePicker_Object.setText(selected_Date);
            }
        };

        //fields validations: name, lastName and gender
        name_Field = findViewById(R.id.name);
        lastName_Field= findViewById(R.id.lastName);
        gender = findViewById(R.id.spinner);

    }

    public String fields_Validations(){
        //Accesing to the erro method
        gender_view_value = (TextView) gender.getSelectedView();
        gender_string_value = gender.getSelectedItem().toString();
        //System.out.println(gender_string_value);

        String status = "notEmpty";
        name_Field_validation = name_Field.getText().toString();
        lastName_Field_validation = lastName_Field.getText().toString();

        if(TextUtils.isEmpty(name_Field_validation)){
            name_Field.setError("Este campo no puede estar vacío. Favor llenar el campo");
            status="Empty";
        }
        if (TextUtils.isEmpty(lastName_Field_validation)){
            lastName_Field.setError("Este campo no puede estar vacío. Favor llenar el campo");
            status="Empty";
        }
        if (!gender_string_value.equalsIgnoreCase("masculino") & !gender_string_value.equalsIgnoreCase("femenino")){
            gender_view_value.setError(" ");
            gender_view_value.setText("Seleccione género");
            status="Empty";
        }
        return status;
    }

    //Send filled information to a second activity
    public void send_Filled_data(View send_Button){
        Intent send_intent = new Intent(this, DisplayDataActivity.class);
        //String get_Namefield_Value =name_Field.getText().toString();
        if(fields_Validations().equals("notEmpty")){
            send_intent.putExtra(EXTRA_MESSAGE,name_Field_validation);
            startActivity(send_intent);
        }
        else if(fields_Validations().equals("Empty")){
            Toast.makeText(this, "Inválido", Toast.LENGTH_SHORT).show();

        }


    }


    //TODO:Send Button action
    //TODO:Clear screen
    //TODO: change application color



}