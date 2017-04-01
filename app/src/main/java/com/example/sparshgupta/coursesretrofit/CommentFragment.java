package com.example.sparshgupta.coursesretrofit;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.w3c.dom.Comment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sparshgupta on 26/03/17.
 */

public class CommentFragment extends Fragment{

    ArrayList<Comments> commentsArrayList;
    RecyclerView recyclerView;
    CommentAdapter commentAdapter;
    int post_id;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_comment, null);
        recyclerView = (RecyclerView) v.findViewById(R.id.commentsRecyclerView);
        commentsArrayList = new ArrayList<>();
        commentAdapter = new CommentAdapter(getActivity(), commentsArrayList);
        recyclerView.setAdapter(commentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        fetchComments();
        return v;
    }

    public void setPostId(int post_id){
        this.post_id = post_id;
    }

    private void fetchComments() {
        ApiInterface apiInterface = ApiClient.getApiInterface();
        Call<ArrayList<Comments>> call = apiInterface.getComments(post_id);
        call.enqueue(new Callback<ArrayList<Comments>>() {
            @Override
            public void onResponse(Call<ArrayList<Comments>> call, Response<ArrayList<Comments>> response) {
                ArrayList<Comments> list = response.body();
                commentsArrayList.clear();
                commentsArrayList.addAll(list);
                commentAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Comments>> call, Throwable t) {

            }
        });
    }


}
