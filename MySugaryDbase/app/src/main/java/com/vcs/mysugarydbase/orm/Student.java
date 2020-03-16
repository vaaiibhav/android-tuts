package com.vcs.mysugarydbase.orm;

import com.orm.SugarRecord;

public class Student extends SugarRecord {

    public String stu_name;
    public int stu_roll;

    public Student(String stu_name, int stu_roll) {
        this.stu_name = stu_name;
        this.stu_roll = stu_roll;
    }

    public Student() {
    }
}
