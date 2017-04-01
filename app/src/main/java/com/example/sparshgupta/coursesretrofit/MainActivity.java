package com.example.sparshgupta.coursesretrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class
MainActivity extends AppCompatActivity implements UsersFragment.UserItemClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsersFragment usersFragment = (UsersFragment) getFragmentManager().findFragmentById(R.id.fragmentUsersView);
        usersFragment.setUserItemClickListener(this);
    }


    @Override
    public void onUserItemClickListener(int user_id) {
        int orientation = getResources().getConfiguration().orientation;
        if(orientation == 1){
            //potrait
            Intent i = new Intent();
            i.setClass(MainActivity.this, Posts_Activity.class);
            i.putExtra("UserId", user_id);
            startActivity(i);
        }else{
            //landscape
            PostsFragment postsFragment = (PostsFragment) getFragmentManager().findFragmentById(R.id.postsFragment);
            postsFragment.setUserId(user_id);
        }

    }
}
