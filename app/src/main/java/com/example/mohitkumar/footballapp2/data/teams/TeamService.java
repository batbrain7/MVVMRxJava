package com.example.mohitkumar.footballapp2.data.teams;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

public interface TeamService {

    @NonNull
    Observable<TeamResponse> getTeams(int id);
}
