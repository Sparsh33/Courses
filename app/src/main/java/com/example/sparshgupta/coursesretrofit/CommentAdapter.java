package com.example.sparshgupta.coursesretrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Comment;

import java.util.ArrayList;

/**
 * Created by sparshgupta on 26/03/17.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder>{

    Context context;
    ArrayList<Comments> commentsList;

    CommentAdapter(Context context, ArrayList<Comments> commentsList){
        this.context = context;
        this.commentsList = commentsList;
    }

    @Override
    public CommentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.comment_adapter, null);
        CommentHolder commentHolder = new CommentHolder(v);
        return commentHolder;
    }

    @Override
    public void onBindViewHolder(CommentHolder holder, int position) {
        holder.commentUserNameTextView.setText(commentsList.get(position).getName());
        holder.commentTextView.setText(commentsList.get(position).getComment());
    }


    @Override
    public int getItemCount() {
        return commentsList.size();
    }

    public class CommentHolder extends RecyclerView.ViewHolder{

        TextView commentUserNameTextView, commentTextView;

        public CommentHolder(View itemView) {
            super(itemView);
            commentUserNameTextView = (TextView) itemView.findViewById(R.id.commentNameTextView);
            commentTextView = (TextView) itemView.findViewById(R.id.commentTextView);
        }
    }
}
