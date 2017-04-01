package com.example.sparshgupta.coursesretrofit;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sparshgupta on 25/03/17.
 */

public class PostsFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Post> postList;
    PostAdapter postAdapter;
    int user_id;
    PostClickListener postClickListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.posts_fragment, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.postRecyclerView);
        postList = new ArrayList<>();
        postAdapter = new PostAdapter(getActivity(), postList);
        recyclerView.setAdapter(postAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener(){

                    @Override
                    public void onItemClick(View view, int position) {
                        postClickListener.onPostClickListener(postList.get(position).getPost_id());
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                }
                ));
        return v;
    }

    void setUserId(int user_id){
        this.user_id = user_id;
        fetchPosts();
    }

    void setPostClickListener(PostClickListener postClickListener){
        this.postClickListener = postClickListener;
    }


    private void fetchPosts() {
        ApiInterface apiInterface = ApiClient.getApiInterface();
        Call<ArrayList<Post>> call = apiInterface.getPost(user_id);
        call.enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                if(response.isSuccessful()) {
                    ArrayList<Post> list = response.body();
                    postList.clear();
                    postList.addAll(list);
                    postAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

            }
        });
    }



    interface PostClickListener{
        void onPostClickListener(int post_id);
    }
}
