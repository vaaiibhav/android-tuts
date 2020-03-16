package com.vcs.sugarapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User usr = new User(12,"Vaaiibhav");
        usr.save();

        User Viewusr1  = User.findById(User.class, 1);





    }
}
