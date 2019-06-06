package com.example.mohitkumar.footballapp2.data;

import com.example.mohitkumar.footballapp2.data.teams.Authenticator;
import com.example.mohitkumar.footballapp2.data.teams.TeamsApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public final class CreateService {
    
    private static final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
                                                                .setLevel(HttpLoggingInterceptor.Level.BODY);

    private static final OkHttpClient client = new OkHttpClient.Builder()
                                                    .addInterceptor(new Authenticator())
                                                    .addInterceptor(interceptor)
                                                    .build();

    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://api.football-data.org/v2/competitions/");


    private static Retrofit retrofit;

    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = retrofitBuilder.build();
        }
        return retrofit;
    }

    private static TeamsApi teamsApi = getInstance().create(TeamsApi.class);

    public static TeamsApi getTeamsApi() {
        return teamsApi;
    }

}
