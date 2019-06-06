package com.example.mohitkumar.footballapp2.data.teams;


import android.util.Log;

import com.example.mohitkumar.footballapp2.data.CreateService;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.example.mohitkumar.footballapp2.MainApplication.TAG;

public class TeamsApiClient implements TeamService {

    private TeamsApi teamsApi;

    public TeamsApiClient() {
        this.teamsApi = CreateService.getTeamsApi();
    }

    @Override
    public Observable<TeamResponse> getTeams(int id) {
        Observable<TeamResponse> observable = teamsApi.getTeams(id)
                .subscribeOn(Schedulers.single())
                .observeOn(AndroidSchedulers.mainThread());

        observable.subscribe(new Observer<TeamResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "inside api client disposable " + d.toString());
            }

            @Override
            public void onNext(TeamResponse teamResponse) {
                Log.d(TAG, "inside api client onNext " + teamResponse.teamData.toString());
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "inside api client error " + e.toString());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "complete");
            }
        });

        return observable;
    }
}
