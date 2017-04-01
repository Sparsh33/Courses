package com.example.sparshgupta.coursesretrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sparshgupta on 19/03/17.
 */

public class Users {
    @SerializedName("id")
    int user_id;
    String name;
    String username;
    String email;

    public Users(int user_id, String name, String username, String email){
        this.name = name;
        this.user_id = user_id;
        this.email = email;
        this.username = username;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
