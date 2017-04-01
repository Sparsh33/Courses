package com.example.sparshgupta.coursesretrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sparshgupta on 19/03/17.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    private ArrayList<Users> userList;
    private Context context;

    public UserAdapter(Context context, ArrayList<Users> userList){
        this.userList = userList;
        this.context = context;
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.user_adapter, null, false);
        UserHolder userHolder = new UserHolder(v);
        return userHolder;
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        Users user = userList.get(position);
        holder.nameTextView.setText(user.getName());
        holder.usernameTextView.setText("Username: " + user.getUsername());
        holder.emailTextView.setText("Email: " + user.getEmail());
    }


    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder{

        TextView nameTextView, usernameTextView, emailTextView;

        public UserHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            usernameTextView = (TextView) itemView.findViewById(R.id.usernameTextView);
            emailTextView = (TextView) itemView.findViewById(R.id.emailTextView);
        }
    }
}
