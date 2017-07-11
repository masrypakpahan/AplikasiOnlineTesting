package com.pji.cbt.aplikasionlinetesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.OnClick;
import cbt.pji.cbt.aplikasionlinetesting.R;

public class EditProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);
    }

    @OnClick(R.id.epa_btn_submit)
    void epSubmit()
    {
        MainActivity.aMain.finish();
        EditProfilSuccessDialog std = new EditProfilSuccessDialog(this);
    }
}
