package com.example.sparshgupta.coursesretrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sparshgupta on 26/03/17.
 */

public class Comments {
    @SerializedName("comment_id")
    int id;
    String name;
    String email;
    String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
