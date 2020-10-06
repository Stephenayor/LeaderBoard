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

import com.example.android.leaderboard.Adapter.SkillLeadersAdapter;
import com.example.android.leaderboard.Network.RetrofitClientInstance;
import com.example.android.leaderboard.model.RetroLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {


    public SecondFragment() {
        // Required empty public constructor
    }

    private RecyclerView mRecyclerView;

    private SkillLeadersAdapter mSkillListAdapter;

    private ProgressDialog mProgressDialog;



    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        mProgressDialog = new ProgressDialog(getActivity());

        mProgressDialog.setMessage("Loading....");

        mProgressDialog.show();

        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_second, container, false);



        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        Call<List<RetroLeaders>> call = service.getAllScores();

        call.enqueue(new Callback<List<RetroLeaders>>() {

            @Override

            public void onResponse(Call<List<RetroLeaders>> call, Response<List<RetroLeaders>> response) {

                mProgressDialog.dismiss();

                mRecyclerView = view.findViewById(R.id.secondrecyclerview);

                mSkillListAdapter = new SkillLeadersAdapter(view.getContext(), response.body());

                mRecyclerView.setAdapter(mSkillListAdapter);

                mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

            }



            @Override
            public void onFailure(Call<List<RetroLeaders>> call, Throwable t) {
                mProgressDialog.dismiss();
                Toast.makeText(view.getContext(), "Something went wrong with getting the scores ", Toast.LENGTH_SHORT).show();

            }

        });

        return view;

    }

}
