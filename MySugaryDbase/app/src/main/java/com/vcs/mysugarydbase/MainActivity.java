package com.vcs.mysugarydbase;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vcs.mysugarydbase.orm.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Student Name
     */
    private EditText mEtName;
    /**
     * Roll No
     */
    private EditText mEtRoll;
    /**
     * Insert
     */
    private Button mBtnInsert;
    /**
     * TextView
     */
    private TextView mTvDisplaydbase;
    private ListView listView;
    private ListAdapter adapter;
    final int[] to = new int[] { R.id.id, R.id.title };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        mEtName = (EditText) findViewById(R.id.et_name);
        mEtRoll = (EditText) findViewById(R.id.et_roll);
        mBtnInsert = (Button) findViewById(R.id.btn_insert);
        mBtnInsert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_insert:
                String name = mEtName.getText().toString();
                String roll = mEtRoll.getText().toString();
                if (!name.isEmpty() && !roll.isEmpty()) {
                    Student st = new Student(name, Integer.parseInt(roll));
                    st.save();

                } else {

                    Toast.makeText(this, "Empty Strings", Toast.LENGTH_SHORT).show();
                }
                List<Student> StudentList = com.vcs.mysugarydbase.orm.Student.listAll(Student.class);
//                final String[] from = new String[] { StudentList.stu_name,
//                        DatabaseHelper.SUBJECT, DatabaseHelper.DESC };
//                listView = (ListView) findViewById(R.id.list_view);
//
//                adapter = new ListAdapter(this, R.layout.activity_view_record, Student, from, to, 0);
//                adapter.notifyDataSetChanged();
//
//                listView.setAdapter(adapter);

                ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, StudentList);
//                setListAdapter(adp);
                listView.setAdapter(adp);


                Student stu = Student.findById(Student.class, 1);
                Toast.makeText(this,stu.toString() , Toast.LENGTH_SHORT).show();



                break;
        }
    }
}
