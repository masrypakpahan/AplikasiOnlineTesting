package com.pji.cbt.aplikasionlinetesting.ui.dialog;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.pji.cbt.aplikasionlinetesting.ui.activities.MainActivity;
import com.pji.cbt.aplikasionlinetesting.ui.activities.ResetPassActivity;

import butterknife.OnClick;
import cbt.pji.cbt.aplikasionlinetesting.R;

public class ResetPassSuccessDialog extends AppCompatActivity {

    private static final String TAG = "ResetPassSuccessDialog";
    ResetPassActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass_success_dialog);
    }

    public ResetPassSuccessDialog(){}

    public ResetPassSuccessDialog(ResetPassActivity mActivity) {
        this.mActivity = mActivity;
        show(mActivity.getSupportFragmentManager(), TAG);
    }

    private void show(FragmentManager supportFragmentManager, String tag) {
    }
    @OnClick(R.id.btn_resetpass_success)
    void klikOk()
    {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}
