package com.example.sparshgupta.coursesretrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sparshgupta on 19/03/17.
 */

public class Post {
    int user_id;
    @SerializedName("id")
    int post_id;
    String title;
    String body;

    Post(int user_id, int post_id, String title, String body){
        this.user_id = user_id;
        this.post_id = post_id;
        this.title = title;
        this.body = body;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
