package com.pji.cbt.aplikasionlinetesting;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.OnClick;
import cbt.pji.cbt.aplikasionlinetesting.R;

public class EditProfilSuccessDialog extends AppCompatActivity {

    private static final String TAG = "EditProfilSuccessDialog";
    EditProfilActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil_success_dialog);
    }

    public EditProfilSuccessDialog(){}

    public EditProfilSuccessDialog(EditProfilActivity mActivity) {
        this.mActivity = mActivity;
        show(mActivity.getSupportFragmentManager(), TAG);
    }

    private void show(FragmentManager supportFragmentManager, String tag) {
    }

    @OnClick(R.id.btn_editprofil_success)
    void klikOk()
    {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
