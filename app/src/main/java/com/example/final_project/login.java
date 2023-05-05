package com.example.final_project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class login extends AppCompatActivity {
    EditText user, pass;
    Button btnlogin;
    SharedPreferences sharedlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        btnlogin = findViewById(R.id.loginButton);
        sharedlogin = getSharedPreferences("accounts", 0);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor ed_login = sharedlogin.edit();
                if (sharedlogin.contains(user.getText().toString())) {
                    String pass_tmp = sharedlogin.getString(user.getText().toString(), "");
                    if (pass_tmp.equals(pass.getText().toString())) {
                        Toast.makeText(login.this, "Welcome", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(login.this, "Wrong Password", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    ed_login.putString(user.getText().toString(), pass.getText().toString());
                    Toast.makeText(login.this, "Sorry Not Found", Toast.LENGTH_SHORT).show();

                }


            }
        });


    }
}
