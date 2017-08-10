package com.pji.cbt.aplikasionlinetesting.ui.dialog;

import android.app.Dialog;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.pji.cbt.aplikasionlinetesting.ui.activities.MainActivity;


import butterknife.OnClick;
import cbt.pji.cbt.aplikasionlinetesting.R;

public class StartTestDialog extends AppCompatActivity {

//    private ProgressDialog progressDialog;
    private static final String TAG = "StartTestDialog";
    MainActivity mActivity;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_test_dialog);

    }
        public StartTestDialog(){}

        public StartTestDialog(MainActivity mActivity) {
            this.mActivity = mActivity;
            show(mActivity.getSupportFragmentManager(), TAG);

        }

    private void show(FragmentManager supportFragmentManager, String tag) {
    }

    @OnClick(R.id.btn_start_test_no)
    void showDialogAttend()
    {
       dialog.cancel();
    }


    @OnClick(R.id.btn_start_test_yes)
    void showDialogReason() {

    }

}


