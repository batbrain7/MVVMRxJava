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

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

import static com.example.mohitkumar.footballapp2.MainApplication.TAG;

public class TeamViewModel extends ViewModel {

    private final MutableLiveData<List<TeamData>> data = new MutableLiveData<>();
    private TeamService service;
    private final MutableLiveData<Integer> progress = new MutableLiveData<>();
    final CompositeDisposable composite = new CompositeDisposable();


    public TeamViewModel() {
        this.service = new TeamsApiClient();
    }

    @SuppressLint("CheckResult")
    public LiveData<List<TeamData>> getTeamData(int id) {
        Log.d(TAG, "Inside ViewModel function");
         service.getTeams(id)
                .doOnSubscribe(disposable -> progress.setValue(View.VISIBLE))
                .doFinally(() -> progress.setValue(View.GONE))
                .subscribe(teamResponse -> {
                    Log.d(TAG, "INSIDE SUBSCRIBE");
                    data.setValue(teamResponse.teamData);
                    Log.d(TAG, teamResponse.count + " " + teamResponse.teamData.toString());
                }, throwable -> {
                    Log.d("TeamFragment.class", "onStart: " + throwable.getMessage());
                }, () -> {
                    Log.d(TAG, "INSIDE COMPLETED");
                }, disposable -> {
                    Log.d(TAG, "INSIDE DISPOSABLE");
                    composite.add(disposable);
                } );

        composite.add(service.getTeams(id).subscribeWith(new DisposableObserver<TeamResponse>() {
            @Override
            public void onNext(TeamResponse teamResponse) {
                data.setValue(teamResponse.teamData);
                Log.d(TAG, teamResponse.count + " " + teamResponse.teamData.toString());
            }

            @Override
            public void onError(Throwable e) {
                Log.d("TeamFragment.class", "onStart: " + e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        }));
//        Log.d(TAG, data.toString());
        return data;
    }

}
