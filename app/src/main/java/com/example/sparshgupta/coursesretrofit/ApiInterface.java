package com.example.sparshgupta.coursesretrofit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by sparshgupta on 19/03/17.
 */

public interface ApiInterface {

    @GET("users")
    Call<ArrayList<Users>> getUsers();

    @GET("posts")
    Call<ArrayList<Post>> getPost(@Query("userId") int user_id);

    @GET("comments")
    Call<ArrayList<Comments>> getComments(@Query("postId") int post_id);

}
