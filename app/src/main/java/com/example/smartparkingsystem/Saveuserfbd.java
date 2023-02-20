package com.example.smartparkingsystem;

class Saveuserfbd {
    String username;
    String mobileno;
    Saveuserfbd() {

    }
    Saveuserfbd(String username,String mobileno){
        this.username=username;
        this.mobileno=mobileno;
    }

    public String getUsername() {
        return username;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }
}
