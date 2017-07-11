package com.pji.cbt.aplikasionlinetesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.OnClick;
import cbt.pji.cbt.aplikasionlinetesting.R;

public class ResetPassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);
    }

    @OnClick(R.id.rp_btn_submit)
    void rpSubmit()
    {
        MainActivity.aMain.finish();
        ResetPassSuccessDialog std = new ResetPassSuccessDialog(this);
    }
}
