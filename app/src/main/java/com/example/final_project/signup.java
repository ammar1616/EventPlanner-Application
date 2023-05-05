package com.example.final_project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {

    EditText ed1, ed2;
    Button btn_signup;
    SharedPreferences shared_signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        ed1 = findViewById(R.id.username);
        ed2 = findViewById(R.id.password);
        btn_signup = findViewById(R.id.btn_signup);
        shared_signup = getSharedPreferences("accounts", 0);

        SharedPreferences.Editor edit1 = shared_signup.edit();


        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shared_signup.contains(ed1.getText().toString())) {
                    Toast.makeText(signup.this, "Username was Used Before", Toast.LENGTH_SHORT).show();
                } else {
                    edit1.putString(ed1.getText().toString(), ed2.getText().toString());
                    edit1.commit();
                    Toast.makeText(signup.this, "Welcome", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
