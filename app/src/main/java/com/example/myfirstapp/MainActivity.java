package com.example.myfirstapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.text.TextUtils;
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
    public static RadioButton yes_Radio_button;
    public static RadioButton no_Radio_button;
    public static CheckBox java_Option_checkBox;
    public static CheckBox python_Option_checkBox;
    public static CheckBox js_Option_checkBox;
    public static CheckBox golang_Option_checkBox;
    public static CheckBox c_Plus_option_CheckBox;
    public static CheckBox c_Sharp_option_checkBox;

    //onSend click
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String EXTRA_MESSAGE_LASTNAME = "lastName";
    public static final String EXTRA_MESSAGE_GENDER = "Gender";
    public static final String EXTRA_MESSAGE_BIRTH_DATE = "birthDate";

    public static TextView gender_view_value;
    public static String gender_string_value;
    public static String name_Field_validation;
    public static String lastName_Field_validation;
    public static String birth_Date_String_value;
    public static boolean yes_Final_value;
    public static boolean java_Final_value;
    public static boolean python_Final_value;
    public static boolean js_Final_value;
    public static boolean golang_Final_value;
    public static boolean c_Plus_final_Value;
    public static boolean c_Sharp_final_Value;
    public static String  check_Box_actual_Value;


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
        yes_Radio_button = findViewById(R.id.radioButton4);
        no_Radio_button = findViewById(R.id.radioButton6);
        java_Option_checkBox = findViewById(R.id.javaCheckBox);
        python_Option_checkBox = findViewById(R.id.pythonCheckBox);
        js_Option_checkBox = findViewById(R.id.jsCheckBox);
        golang_Option_checkBox = findViewById(R.id.golangCheckBox);
        c_Plus_option_CheckBox = findViewById(R.id.c_Plus_checkBox);
        c_Sharp_option_checkBox = findViewById(R.id.c_Sharp_checkBox);

        if(!yes_Radio_button.isChecked()){
            yes_Radio_button.setChecked(true);
        }
        no_Radio_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(no_Radio_button.isChecked()){
                    java_Option_checkBox.setEnabled(false);
                    python_Option_checkBox.setEnabled(false);
                    js_Option_checkBox.setEnabled(false);
                    golang_Option_checkBox.setEnabled(false);
                    c_Plus_option_CheckBox.setEnabled(false);
                    c_Sharp_option_checkBox.setEnabled(false);
                }
            }
        });
        yes_Radio_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(yes_Radio_button.isChecked()){
                    java_Option_checkBox.setEnabled(true);
                    python_Option_checkBox.setEnabled(true);
                    js_Option_checkBox.setEnabled(true);
                    golang_Option_checkBox.setEnabled(true);
                    c_Plus_option_CheckBox.setEnabled(true);
                    c_Sharp_option_checkBox.setEnabled(true);
                }
            }
        });



    }

    public String fields_Validations(){
        //To have access to the spinner error method using a TextView
        gender_view_value = (TextView) gender.getSelectedView();
        //Accesing to the string value of the selected opcion in the spinner
        gender_string_value = gender.getSelectedItem().toString();


        //Accesing checkboxes final value
        yes_Final_value = yes_Radio_button.isChecked();


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
    public String check_Box_validations(){
        java_Final_value = java_Option_checkBox.isChecked();
        python_Final_value = python_Option_checkBox.isChecked();
        js_Final_value = js_Option_checkBox.isChecked();
        golang_Final_value = golang_Option_checkBox.isChecked();
        c_Plus_final_Value = c_Plus_option_CheckBox.isChecked();
        c_Sharp_final_Value = c_Sharp_option_checkBox.isChecked();

        check_Box_actual_Value = "notChecked";

        //ckeck if there are at leat one programming language

        if(java_Final_value){
            check_Box_actual_Value = "isChecked";
        }
        if(python_Final_value){
            check_Box_actual_Value = "isChecked";
        }
        if(js_Final_value){
            check_Box_actual_Value = "isChecked";
        }
        if(golang_Final_value){
            check_Box_actual_Value = "isChecked";
        }
        if(c_Plus_final_Value){
            check_Box_actual_Value = "isChecked";
        }
        if(c_Sharp_final_Value){
            check_Box_actual_Value = "isChecked";
        }

        return check_Box_actual_Value;


    }


    //Send filled information to a second activity
    public void send_Filled_data(View send_Button){
        Intent send_intent = new Intent(this, DisplayDataActivity.class);
        if(fields_Validations().equals("notEmpty") && check_Box_validations().equals("isChecked")){
            birth_Date_String_value = datePicker_Object.getText().toString();
            send_intent.putExtra(EXTRA_MESSAGE,name_Field_validation);
            send_intent.putExtra(EXTRA_MESSAGE_LASTNAME, lastName_Field_validation);
            send_intent.putExtra(EXTRA_MESSAGE_GENDER, gender_string_value);
            send_intent.putExtra(EXTRA_MESSAGE_BIRTH_DATE, birth_Date_String_value);

            startActivity(send_intent);

        }
        else if(fields_Validations().equals("Empty") || check_Box_validations().equals("notChecked") ){
            Toast.makeText(this, "Inválido", Toast.LENGTH_SHORT).show();

        }

    }

    public void change_Values_radios(View change_Value_Rb){
        if(yes_Radio_button.isChecked()){
            no_Radio_button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    yes_Radio_button.setChecked(false);

                }

            });
        }
        if(no_Radio_button.isChecked()){

            yes_Radio_button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    no_Radio_button.setChecked(false);
                }

            });

        }

    }


    //TODO:Radio Buttons Validations (Done)
    //TODO: check boxes desactivation when clicked no spinner option is pressed (Done)
    //TODO: Validate at least one lenguage is selected (Done)
    //TODO: Put a DATA tittle in the second activity (Done)

    //TODO: get user's birth date
    //TODO:Clear screen
    //TODO: change application color
    //TODO: change application text size



}