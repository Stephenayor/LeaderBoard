package com.example.android.leaderboard;

import com.example.android.leaderboard.model.RetroLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("/api/hours")
    Call<List<RetroLeaders>>getAllLeaders();
    @GET("/api/skilliq")
    Call <List<RetroLeaders>> getAllScores();
}
