package com.example.sparshgupta.coursesretrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class CommentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        Intent i = getIntent();
        int post_id = i.getIntExtra("post_id", -1);
        CommentFragment commentFragment = (CommentFragment) getFragmentManager().findFragmentById(R.id.commentFragment);
        commentFragment.setPostId(post_id);
    }
}
