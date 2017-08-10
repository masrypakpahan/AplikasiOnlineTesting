package com.pji.cbt.aplikasionlinetesting.ui.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.auth0.android.jwt.JWT;
import com.pji.cbt.aplikasionlinetesting.data.beans.Login_Model;
import com.pji.cbt.aplikasionlinetesting.data.respons.User;
import com.pji.cbt.aplikasionlinetesting.network.API;
import com.pji.cbt.aplikasionlinetesting.network.RestUser;
import cbt.pji.cbt.aplikasionlinetesting.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class LoginActivity extends AppCompatActivity {

    public String token;

    private SharedPreferences.Editor editor;
    private EditText Username;
    private EditText Password;
    private int id;
    private Button btn_login;
    public String JWTEncoded;
    ProgressDialog progressDialog;
    public String sesionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText Name = (EditText) findViewById(R.id.input_username);
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
        Username = (EditText) findViewById(R.id.input_username);
        Password = (EditText) findViewById(R.id.input_password);
    }

    private void Login() {
        final String tempuser = Username.getText().toString();
        final String temppass = Password.getText().toString();

        if (tempuser.equals("")) {
            Toast.makeText(LoginActivity.this, "Name Cannot be empty", Toast.LENGTH_SHORT).show();

        } else if (temppass.equals("")) {
            Toast.makeText(LoginActivity.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            final Login_Model login = new Login_Model(id, tempuser, temppass);
            final API api;
            api = RestUser.getRestUser();
            final Call<User> callUser = api.Login(login);
            callUser.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response.isSuccessful()) {
                        int x = login.getUsername().length();
                        int y = login.getPassword().length();
                        if (x == Username.length() && y == Password.length()) {
                            String token = response.body().getToken();
                            JWT a = new JWT(token);
                            int userId = a.getClaim("userId").asInt();
                            int roleId = a.getClaim("roleId").asInt();
                            Toast.makeText(LoginActivity.this,""+userId, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), TesterUserActivity.class);
                            intent.putExtra("username", Username.getText().toString());
                            intent.putExtra("userId", (int)userId);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "incorrect Username or Password", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "ACCESS SERVER FAIL" + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about: {
                Intent nextScreen = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(nextScreen);
                break;
            }
            case R.id.action_settings: {
                Intent nextScreen = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(nextScreen);
                break;
            }
            default: {
                Toast.makeText(getApplicationContext(), "Anda memilih menu ke- ", Toast.LENGTH_SHORT).show();
            }
        }
        return super.onOptionsItemSelected(item);

    }

}



