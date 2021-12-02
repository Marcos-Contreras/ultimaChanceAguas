package com.example.laultimachance;

public class Users {
    public String user;
    public String name;
    public String lastname;

    public Users() {
    }

    public Users(String user, String name, String lastname) {
        this.user = user;
        this.name = name;
        this.lastname = lastname;
    }

    public String getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
