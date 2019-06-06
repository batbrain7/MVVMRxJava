package com.example.mohitkumar.footballapp2.data;

import android.util.Log;

import com.example.mohitkumar.footballapp2.data.teams.Authenticator;
import com.example.mohitkumar.footballapp2.data.teams.TeamsApi;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import static com.example.mohitkumar.footballapp2.MainApplication.TAG;

public final class CreateService {
    
    private static final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
                                                                .setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient client = new OkHttpClient.Builder()
                                                    .addInterceptor(new Interceptor() {
                                                        @Override
                                                        public Response intercept(Chain chain) throws IOException {
                                                            Request original = chain.request();

                                                            Request request = original.newBuilder()
                                                                    .addHeader("X-Auth-Token", "797ad1104406499e92149d685830061a")
                                                                    .method(original.method(), original.body())
                                                                    .build();
                                                            Log.d(TAG,  chain.request().url().toString() + " " + request.header("X-Auth-Token"));
                                                            return chain.proceed(request);
                                                        }
                                                    })
                                                    .addInterceptor(interceptor)
                                                    .build();

    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.football-data.org/");


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
