package com.example.sparshgupta.coursesretrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sparshgupta on 20/03/17.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    Context context;
    ArrayList<Post> postList;

    public PostAdapter(Context context, ArrayList<Post> postList){
        this.context = context;
        this.postList = postList;
    }


    @Override
    public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.postadapter, null, false);
        PostHolder postHolder = new PostHolder(v);
        return postHolder;
    }

    @Override
    public void onBindViewHolder(PostHolder holder, int position) {
        Post post = postList.get(position);
        holder.postTitleTextView.setText(post.getTitle());
        holder.postBodyTextView.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder{

        TextView postTitleTextView, postBodyTextView;
        public PostHolder(View itemView) {
            super(itemView);
            postBodyTextView = (TextView)  itemView.findViewById(R.id.postBodyTextView);
            postTitleTextView = (TextView) itemView.findViewById(R.id.postTitleTextView);
        }
    }
}
