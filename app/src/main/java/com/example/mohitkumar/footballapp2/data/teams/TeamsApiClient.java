package com.example.mohitkumar.footballapp2.data.teams;


import android.util.Log;

import com.example.mohitkumar.footballapp2.data.CreateService;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.example.mohitkumar.footballapp2.MainApplication.TAG;
import static io.reactivex.android.schedulers.AndroidSchedulers.mainThread;

public class TeamsApiClient implements TeamService {

    private TeamsApi teamsApi;

    public TeamsApiClient() {
        this.teamsApi = CreateService.getTeamsApi();
    }

    @Override
    public Observable<TeamResponse> getTeams(int id) {
        Observable<TeamResponse> observable = teamsApi.getTeams(id)
                .subscribeOn(Schedulers.io())
                .observeOn(mainThread());

        return observable;
    }
}
