package com.example.mohitkumar.footballapp2.data.teams;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface TeamsApi {

//    @Headers("X-Auth-Token : 797ad1104406499e92149d685830061a")
    @GET("v2/competitions/{id}/teams")
    Observable<TeamResponse> getTeams(@Path("id") int id);
}
