package com.vcs.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button savebtn,loadbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        savebtn = (Button)findViewById(R.id.btn_save);
        loadbtn = (Button)findViewById(R.id.btn_load);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savebtn.setText("Already Saved");
            }
        });



    }

}
