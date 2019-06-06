package com.example.mohitkumar.footballapp2.data.teams;

import android.util.Log;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.mohitkumar.footballapp2.MainApplication.TAG;


public class Authenticator implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Headers headers = original.headers().newBuilder()
                .add("X-Auth-Token", "797ad1104406499e92149d685830061a").build();
        Request request = original.newBuilder()
                .headers(headers)
                .method(original.method(), original.body())
                .build();
        Log.d(TAG,  chain.request().url().toString());
        return chain.proceed(request);
    }
}
