package com.pji.cbt.aplikasionlinetesting.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.pji.cbt.aplikasionlinetesting.ui.dialog.StartTestDialog;

import cbt.pji.cbt.aplikasionlinetesting.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private final String KEY_NAME = "name";
    public static Activity aMain;
    private ImageButton Matematika, IPS, Olahraga, Sains;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aMain = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        TextView txtUsername = (TextView) findViewById(R.id.txtUsername);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
       // Log.e("Second Screen", username);
        txtUsername.setText(username);

        Matematika = (ImageButton)findViewById(R.id.matematika);
        Sains=(ImageButton)findViewById(R.id.sains);
        IPS=(ImageButton)findViewById(R.id.ips);
        Olahraga=(ImageButton)findViewById(R.id.olahraga);

        Matematika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StartTestDialog.class); // dari MainActivity/posisi saat ini ke ContentProvider
                startActivity(intent);
            }
        });

        Sains.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                Intent intent = new Intent(MainActivity.this, SainsActivity.class); // dari MainActivity/posisi saat ini ke ContentProvider
//                startActivity(intent);
            }
        });

        IPS.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                Intent intent = new Intent(MainActivity.this, IPSActivity.class); // dari MainActivity/posisi saat ini ke ContentProvider
//                startActivity(intent);
            }
        });

        Olahraga.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                Intent intent = new Intent(MainActivity.this, OlahragaActivity.class); // dari MainActivity/posisi saat ini ke ContentProvider
//                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.action_edit_profil) {
            startActivity(new Intent(this, EditProfilActivity.class));
            return true;
        } else if (id == R.id.action_reset_password) {
            startActivity(new Intent(this, ResetPassActivity.class));
            return true;
        } else if (id == R.id.action_logout) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return true;
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
