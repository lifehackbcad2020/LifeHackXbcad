package com.example.adultsprofile;

public class UserHelper {
    String uname, name, surname, uemail, password;

    public UserHelper() {
    }

    public UserHelper(String uname, String name, String surname, String uemail, String password) {
        this.uname = uname;
        this.name = name;
        this.surname = surname;
        this.uemail = uemail;
        this.password = password;
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

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
