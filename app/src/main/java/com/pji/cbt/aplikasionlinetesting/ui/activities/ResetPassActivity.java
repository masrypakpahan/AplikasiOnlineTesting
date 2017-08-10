package com.pji.cbt.aplikasionlinetesting.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


import com.pji.cbt.aplikasionlinetesting.ui.dialog.ResetPassSuccessDialog;

import butterknife.OnClick;
import cbt.pji.cbt.aplikasionlinetesting.R;

public class ResetPassActivity extends AppCompatActivity {

    private EditText oldpassword;
    private EditText newPassword;
    private EditText retryPassword;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);
    }
    @OnClick(R.id.rp_btn_submit)
    void rpSubmit()
    {
        MainActivity.aMain.finish();
        ResetPassSuccessDialog rpd = new ResetPassSuccessDialog(this);
    }
    public void onVeryfy(){
        oldpassword = (EditText)findViewById(R.id.rp_et_oldpass);
        newPassword = (EditText)findViewById(R.id.rp_et_newpass);
        retryPassword = (EditText)findViewById(R.id.rp_et_retypenewpass);
        submit = (Button)findViewById(R.id.rp_btn_submit);
    }
}
