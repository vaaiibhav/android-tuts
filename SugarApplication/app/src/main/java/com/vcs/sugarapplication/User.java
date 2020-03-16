package com.vcs.sugarapplication;

import com.orm.SugarRecord;

public class User extends SugarRecord {
    int roll_no;
    String name;

    public User() {
    }

    public User(int roll_no, String name) {
        this.roll_no = roll_no;
        this.name = name;
    }
}
