package com.pji.cbt.aplikasionlinetesting.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pji.cbt.aplikasionlinetesting.data.beans.Login_Model;
import com.pji.cbt.aplikasionlinetesting.data.respons.UpdateUserRespon;
import com.pji.cbt.aplikasionlinetesting.data.beans.UpdateUser_model;
import com.pji.cbt.aplikasionlinetesting.network.API;
import com.pji.cbt.aplikasionlinetesting.network.RestUser;


import cbt.pji.cbt.aplikasionlinetesting.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfilActivity extends AppCompatActivity {
    private  int id;
    private String username;
    private String password;
    private  EditText name;
    private  EditText email;
    private  Button submit;
    public String JWTEncoded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);
        name = (EditText) findViewById(R.id.epa_et_name);
        email = (EditText) findViewById(R.id.epa_et_email);
        findViewById(R.id.epa_btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                epSubmit();
            }
        });
    }
      public void epSubmit ()
        {
            changeName();
            changeEmail();
            Login_Model login_model = new Login_Model(id, username, password);
            id = login_model.getId();
            Toast.makeText(EditProfilActivity.this, ""+id,Toast.LENGTH_SHORT).show();
           // MainActivity.aMain.finish();
           // EditProfilSuccessDialog Esd = new EditProfilSuccessDialog(this);
        }
    public void changeName() {
        final String tempname = name.getText().toString();
        final String tempemail = email.getText().toString();
        if (tempname.equals("")) {
            Toast.makeText(EditProfilActivity.this, "pliss fill your name", Toast.LENGTH_SHORT).show();
        } else {
            final UpdateUser_model update = new UpdateUser_model(id, tempname, tempemail);
            API api;
            api = RestUser.getRestUser();
            Call<UpdateUserRespon> updateUserResponCall = api.update(update);
            updateUserResponCall.enqueue(new Callback<UpdateUserRespon>() {
                @Override
                public void onResponse(Call<UpdateUserRespon> call, Response<UpdateUserRespon> response) {
                    if (response.isSuccessful()) {
                        Login_Model login_model = new Login_Model(id, username, password);
                        id = login_model.getId();
                        UpdateUser_model updateUser_model = new UpdateUser_model(id, tempname, tempemail);
                        Toast.makeText(EditProfilActivity.this, ""+id,Toast.LENGTH_SHORT).show();
                        update.getName();
                        update.setName(name.toString());
                    }
                }
                @Override
                public void onFailure(Call<UpdateUserRespon> call, Throwable t) {
                    Toast.makeText(EditProfilActivity.this, "fail to update your name", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void changeEmail() {
        final String tempname = name.getText().toString();
        final String tempemail = email.getText().toString();
        if (tempname.equals("")) {
            Toast.makeText(EditProfilActivity.this, "pliss fill your email", Toast.LENGTH_SHORT).show();
        } else {
            final UpdateUser_model update = new UpdateUser_model(id, tempname, tempemail);
            final API api;
            api = RestUser.getRestUser();
            Call<UpdateUserRespon> updateUserResponCall = api.update(update);
            updateUserResponCall.enqueue(new Callback<UpdateUserRespon>() {
                @Override
                public void onResponse(Call<UpdateUserRespon> call, Response<UpdateUserRespon> response) {
                    if (response.isSuccessful()) {
                        Login_Model login_model = new Login_Model(id, username, password);
                        id = login_model.getId();
                        UpdateUser_model updateUser_model = new UpdateUser_model(id, tempname, tempemail);
                        update.getEmail();
                        update.setEmail(email.toString());
                    }
                }

                @Override
                public void onFailure(Call<UpdateUserRespon> call, Throwable t) {
                    Toast.makeText(EditProfilActivity.this, "fail to update your name", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
