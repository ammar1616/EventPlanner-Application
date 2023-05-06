package com.example.final_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class addevent extends AppCompatActivity {
    SharedPreferences mypref;
    private String name, descr;
    EditText Name, Description;
    Button btn;
    DatePicker datePicker;
    int dateyear, datemonth, dateday;
    DataAccessObject_Events dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addevent);
        Name = findViewById(R.id.ed1);
        Description = findViewById(R.id.ed2);
        btn = findViewById(R.id.btn);
        datePicker = findViewById(R.id.datePicker);
        dao = new DataAccessObject_Events();

        // get the data
//        dateyear = datePicker.getYear();
//        datemonth = datePicker.getMonth() + 1;
//        dateday = datePicker.getDayOfMonth();

//        name = Name.getText().toString();
//        descr = Description.getText().toString();
//

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move_to_showevents_activity();
            }
        });

    }

    public void move_to_showevents_activity() {
        // save event data and open show events activity
        Events event = new Events(Name.getText().toString(), Description.getText().toString(), datePicker.getDayOfMonth(), datePicker.getMonth(), datePicker.getYear());
        dao.add(event).addOnSuccessListener(suc ->{
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        }).addOnFailureListener(er->{
            Toast.makeText(this, "Error"+er.getMessage(), Toast.LENGTH_SHORT).show();
        });
        Intent i = new Intent(this, showevents_act.class);
        startActivity(i);
    }
}
