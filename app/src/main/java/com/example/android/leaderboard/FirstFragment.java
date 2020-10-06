package com.example.android.leaderboard;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.leaderboard.Adapter.LearningLeadersAdapter;
import com.example.android.leaderboard.Network.RetrofitClientInstance;
import com.example.android.leaderboard.model.RetroLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {
    private RecyclerView recyclerView;
    private LearningLeadersAdapter mLearningLeadersAdapter;
    private ProgressDialog mProgressDialog;

    public FirstFragment(){
        //Default constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaneState) {
        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();

        final View view = inflater.inflate(R.layout.fragment_first,container,false);

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<RetroLeaders>> call = service.getAllLeaders();


        call.enqueue(new Callback<List<RetroLeaders>>() {
            @Override
            public void onResponse(Call<List<RetroLeaders>> call, Response<List<RetroLeaders>> response) {
                mProgressDialog.dismiss();
                recyclerView = view.findViewById(R.id.firstrecyclerview);
                mLearningLeadersAdapter = new LearningLeadersAdapter(view.getContext(), response.body());
                recyclerView.setAdapter(mLearningLeadersAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

            }

            @Override
            public void onFailure(Call<List<RetroLeaders>> call, Throwable t) {
                    mProgressDialog.dismiss();
                Toast.makeText(view.getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
