package com.example.mohitkumar.footballapp2.data.teams;

import android.content.Context;
import android.util.Log;

import com.example.mohitkumar.footballapp2.data.CreateService;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import static com.example.mohitkumar.footballapp2.MainApplication.TAG;
import static io.reactivex.android.schedulers.AndroidSchedulers.mainThread;

public class TeamsApiClient implements TeamsApi {

    private TeamsApi teamsApi;
    private Context context;

    public TeamsApiClient(Context context) {
        this.teamsApi = CreateService.getTeamsApi();
        this.context = context;
    }

    @Override
    public Observable<TeamResponse> getTeams(int id) {
        Observable<TeamResponse> observable = teamsApi.getTeams(id)
                .subscribeOn(Schedulers.io())
                .observeOn(mainThread());

        Log.d(TAG, "EXITING TEAMS API CLIENT");

        return observable;
    }
}
