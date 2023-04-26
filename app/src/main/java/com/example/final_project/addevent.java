package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class addevent extends AppCompatActivity {
    SharedPreferences mypref;
    private String name, descr;
    EditText Name, Description;
    Button btn;
    DatePicker datePicker;
    private int dateyear, datemonth, dateday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addevent);
        Name = findViewById(R.id.ed1);
        Description = findViewById(R.id.ed2);
        btn = findViewById(R.id.btn);
        datePicker = findViewById(R.id.datePicker);

        // get the data
//        dateyear = datePicker.getYear();
//        datemonth = datePicker.getMonth() + 1;
//        dateday = datePicker.getDayOfMonth();
        mypref = getSharedPreferences("my_shared_pref", Context.MODE_PRIVATE);

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
        SharedPreferences.Editor editor = mypref.edit();
        editor.putString("Name", Name.getText().toString());
        editor.putString("Description", Description.getText().toString());
        editor.putInt("Day", datePicker.getDayOfMonth());
        editor.putInt("Month", datePicker.getMonth() + 1);
        editor.putInt("Year", datePicker.getYear());
        editor.commit();
        Toast.makeText(addevent.this, "Success", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, showevents_act.class);
        startActivity(i);
    }
}
