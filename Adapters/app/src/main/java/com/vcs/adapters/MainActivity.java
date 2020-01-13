package com.vcs.adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    String [] employees  = {"Vaibhav","Rohini", "yadnesh"};
    int [] imgs = {R.drawable.vaaiibhav,R.drawable.rohini,R.drawable.yadnesh};
    private ListView simpleListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleListView = findViewById(R.id.simpleListView);
        ArrayList<HashMap<String,String>>  arrayList = new ArrayList<>();
        for (int c= 0; c<employees.length; c++){
            HashMap<String,String> hm = new HashMap<>();
            hm.put("name",employees[c]);
            hm.put("image",imgs[c] + "");
            arrayList.add(hm);
        }

        String[] from = {"name","image"};
        int[] to = {R.id.textView,R.id.imageView};
        SimpleAdapter smpad = new SimpleAdapter(this,arrayList,R.layout.list_view_items,from,to);
        simpleListView.setAdapter(smpad);
        
        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You have Clicked item" +position, Toast.LENGTH_SHORT).show();
            }
        });

        

    }
}
