package com.example.mohitkumar.footballapp2.core.team;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.mohitkumar.footballapp2.data.teams.TeamData;
import com.example.mohitkumar.footballapp2.data.teams.TeamResponse;
import com.example.mohitkumar.footballapp2.data.teams.TeamsApi;
import com.example.mohitkumar.footballapp2.data.teams.TeamsApiClient;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static com.example.mohitkumar.footballapp2.MainApplication.TAG;

public class TeamViewModel extends ViewModel {

    private final MutableLiveData<List<TeamData>> data = new MutableLiveData<>();
    private TeamsApiClient apiClient;
    private final MutableLiveData<Integer> progress = new MutableLiveData<>();

    public TeamViewModel() {

    }

    @SuppressLint("CheckResult")
    public LiveData<List<TeamData>> getTeamData(int id, TeamsApiClient client) {
        apiClient = client;
        Log.d(TAG, "Inside ViewModel function");
        apiClient.getTeams(id)
                .doOnSubscribe(disposable -> progress.setValue(0))
                .doFinally(() -> progress.setValue(8))
                .subscribe(teamResponse -> {
                    Log.d(TAG, "INSIDE SUBSCRIBE");
                    data.setValue(teamResponse.teamData);
                    Log.d(TAG, teamResponse.competition.leagueType + " " + teamResponse.teamData.toString());
                }, throwable -> {
                    Log.d("TeamFragment.class", "onStart: " + throwable.getMessage());
                });

//        Log.d(TAG, data.toString());
        return data;
    }

}
