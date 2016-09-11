package com.example.josephodibobhahemen.pocservice.manager;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by josephodibobhahemen on 9/10/16.
 */

public class LoggingInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {

        Request orignal = chain.request();

        Request request = orignal.newBuilder()
                .header("Connection", "Keep-Alive")
                .header("cache-Control", "no-cache")
                .header("User-Agent", "Android-Version")
                .method(orignal.method(), orignal.body())
                .build();

        Log.d("LoggingInterceptor", String.format("Sending request %s on %s%n%s%s", request.url(), chain.connection(), request.headers(), request.body()));


       // Response response = chain.proceed(request); //Use can return response instead of chain.proceed(request)

        return  chain.proceed(request);
    }
}
