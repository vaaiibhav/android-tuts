package com.vcs.newproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * UserName
     */
    private EditText mEtUname;
    /**
     * Password
     */
    private EditText mEtPass;
    /**
     * Login
     */
    private Button mBtnLogin;
    /**
     * TextView
     */
    private TextView mTvError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mEtUname = (EditText) findViewById(R.id.et_uname);
        mEtPass = (EditText) findViewById(R.id.et_pass);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(this);
        mEtUname.setOnClickListener(this);
        mEtPass.setOnClickListener(this);
        mTvError = (TextView) findViewById(R.id.tv_error);
        mTvError.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_login:
                String uname = mEtUname.getText().toString();
                String upass = mEtPass.getText().toString();
                if (uname.equals("admin") && upass.equals("admin")){
                    Intent in = new Intent(MainActivity.this , DashboardActivity.class);
                    startActivity(in);

                }else{
                    mTvError.setVisibility(View.VISIBLE);
                    mTvError.setText("Login Error, Please Check User Name and Password");

                }
                break;

        }
    }
}
