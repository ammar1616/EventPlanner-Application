package com.example.final_project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent bt = new Intent(this, OnReciever.class);
        bt.putExtra("newtitle", "welcome from our humble app");
        sendBroadcast(bt);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.drawer_view);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home: {
                        Toast.makeText(MainActivity.this, "Main Page", Toast.LENGTH_SHORT).show();
                        break;
                    }

                    case R.id.nav_addevent: {
                        Toast.makeText(MainActivity.this, "Add your Event", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, addevent.class);
                        startActivity(i);
                        break;
                    }

                    case R.id.nav_setalarm: {
                        Toast.makeText(MainActivity.this, "Set Your Alarm", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, set_alarm.class);
                        startActivity(i);
                        break;
                    }

                    case R.id.nav_showevents: {
                        Toast.makeText(MainActivity.this, "Show Your Events", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, showevents_act.class);
                        startActivity(i);
                        break;
                    }

                    case R.id.nav_login: {
                        Toast.makeText(MainActivity.this, "Welcome to Us", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, login.class);
                        startActivity(i);
                        break;
                    }

                    case R.id.nav_signup: {

                        Toast.makeText(MainActivity.this, "Stay With Us", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, signup.class);
                        startActivity(i);
                        break;
                    }

                    case R.id.nav_share: {
                        Toast.makeText(MainActivity.this, "Share Our App", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent();
                        i.setAction(Intent.ACTION_VIEW);
                        String s = "https://github.com/ammar1616/EventPlanner-Application/branches";
                        Uri uri = Uri.parse(s);
                        i.setData(uri);
                        startActivity(i);
                        break;
                    }

                    case R.id.nav_send: {
                        Toast.makeText(MainActivity.this, "Send Via ", Toast.LENGTH_SHORT).show();
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                        sendIntent.setType("text/plain");
                        sendIntent.setPackage("com.whatsapp");
                        startActivity(Intent.createChooser(sendIntent, "share to :"));
                        break;
                    }
                }

                return false;
            }
        });

    }


    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }
    }


}