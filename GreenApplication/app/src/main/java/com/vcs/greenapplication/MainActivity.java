package com.vcs.greenapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.vcs.greenapplication.usersDB.Users;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Users oneUser = new Users("Vaaiibhav",12);
        oneUser.save();


    }
}
