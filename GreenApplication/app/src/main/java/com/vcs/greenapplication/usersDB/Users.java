package com.vcs.greenapplication.usersDB;

import com.orm.SugarRecord;

public class Users extends SugarRecord {

    String Name;
    int roll_no;

    public Users() {

    }

    public Users(String name, int roll_no) {
        Name = name;
        this.roll_no = roll_no;
    }
}
