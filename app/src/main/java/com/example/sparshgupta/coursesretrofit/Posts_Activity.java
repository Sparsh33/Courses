package com.example.sparshgupta.coursesretrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Posts_Activity extends AppCompatActivity implements PostsFragment.PostClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_);
        Intent i = getIntent();
        int user_id = i.getIntExtra("UserId", -1);
        PostsFragment postsFragment = (PostsFragment) getFragmentManager().findFragmentById(R.id.postsFragment);
        postsFragment.setPostClickListener(this);
        postsFragment.setUserId(user_id);
    }


    @Override
    public void onPostClickListener(int post_id) {
        int orientation = getResources().getConfiguration().orientation;
        if(orientation == 0){
            Intent i = new Intent();
            i.putExtra("post_id", post_id);
            i.setClass(Posts_Activity.this, CommentActivity.class);
            startActivity(i);
        }
        if(orientation == 1){
            CommentFragment commentFragment = (CommentFragment) getFragmentManager().findFragmentById(R.id.commentFragment);
            commentFragment.setPostId(post_id);
        }
    }
}
