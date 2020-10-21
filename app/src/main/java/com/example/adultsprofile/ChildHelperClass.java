package com.example.adultsprofile;

public class ChildHelperClass {
    String uname, name, surname, birthday;

    public ChildHelperClass() {
    }

    public ChildHelperClass(String uname, String name, String surname, String birthday) {
        this.uname = uname;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
