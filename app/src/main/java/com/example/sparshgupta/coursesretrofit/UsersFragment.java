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
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sparshgupta on 25/03/17.
 */

public class UsersFragment extends Fragment {

    ArrayList<Users> userList;
    RecyclerView recyclerView;
    UserAdapter userAdapter;
    UserItemClickListener userItemClickListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.users_fragment, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.usersRecyclerView);
        userList = new ArrayList<>();
        userAdapter = new UserAdapter(getActivity(), userList);
        recyclerView.setAdapter(userAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener(){

                    @Override
                    public void onItemClick(View view, int position) {
                        userItemClickListener.onUserItemClickListener(userList.get(position).getUser_id());
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                }
                ));
        fetchUsers();
        return v;
    }

    void setUserItemClickListener(UserItemClickListener userItemClickListener){
        this.userItemClickListener = userItemClickListener;
    }

    private void fetchUsers() {
        ApiInterface apiInterface = ApiClient.getApiInterface();
        Call<ArrayList<Users>> call = apiInterface.getUsers();
        call.enqueue(new Callback<ArrayList<Users>>() {
            @Override
            public void onResponse(Call<ArrayList<Users>> call, Response<ArrayList<Users>> response) {
                if(response.isSuccessful()){
                    ArrayList<Users> list = response.body();
                    userList.clear();
                    userList.addAll(list);
                    userAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Users>> call, Throwable t) {
//                Toast.makeText(getActivity(), "fail", Toast.LENGTH_LONG).show();
            }
        });

    }


    interface UserItemClickListener{
        void onUserItemClickListener(int user_id);
    }

}
