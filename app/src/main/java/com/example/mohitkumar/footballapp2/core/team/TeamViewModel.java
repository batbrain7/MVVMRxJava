package com.example.mohitkumar.footballapp2.core.team;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import android.view.View;

import com.example.mohitkumar.footballapp2.data.teams.TeamData;
import com.example.mohitkumar.footballapp2.data.teams.TeamResponse;
import com.example.mohitkumar.footballapp2.data.teams.TeamService;
import com.example.mohitkumar.footballapp2.data.teams.TeamsApi;
import com.example.mohitkumar.footballapp2.data.teams.TeamsApiClient;

import java.util.List;

import static com.example.mohitkumar.footballapp2.MainApplication.TAG;

public class TeamViewModel extends ViewModel {

    private final MutableLiveData<TeamResponse> data = new MutableLiveData<>();
    private TeamService service;
    private final MutableLiveData<Integer> progress = new MutableLiveData<>();


    public TeamViewModel() {
        this.service = new TeamsApiClient();
    }

    @SuppressLint("CheckResult")
    public LiveData<TeamResponse> getTeamData(int id) {
        Log.d(TAG, "Inside ViewModel function");
         service.getTeams(id)
                .doOnSubscribe(disposable -> progress.setValue(View.VISIBLE))
                .doFinally(() -> progress.setValue(View.GONE))
                .subscribe(teamResponse -> {
                    Log.d(TAG, "INSIDE ONNEXT " + teamResponse.competition.name);
                    data.setValue(teamResponse);
                }, throwable -> {
                    Log.d("TeamFragment.class", "onStart: " + throwable.getMessage());
                });

         Log.d(TAG, "Outside the subscribe ");
        return data;
    }

    public LiveData<Integer> getProgress() {
        return progress;
    }

}
