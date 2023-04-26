package com.example.final_project;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class deleteevent extends AppCompatActivity {

    Button btn;
    EditText edit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deleteevent);

        edit1 = findViewById(R.id.txt_del);
        btn = findViewById(R.id.btn_delete);

    }
}
