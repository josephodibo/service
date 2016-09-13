package com.example.josephodibobhahemen.pocservice.service;

import com.example.josephodibobhahemen.pocservice.CallBack.CustomCallBack;
import com.example.josephodibobhahemen.pocservice.manager.ServiceManager;
import com.example.josephodibobhahemen.pocservice.serializer.ICustomTypeAdapterProvider;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by josephodibobhahemen on 9/13/16.
 */

public class TestService {

    interface TestApi {
        @GET("users/{user}/users")
        Call<List<String>> getUsers(@Path("user") String user);
    }

    TestApi api;

    public TestService() {
        api = ServiceManager.getServiceInstance(TestApi.class, new ICustomTypeAdapterProvider() {
            @Override
            public void registerTypeAdapter(GsonBuilder gsonBuilder) {

            }
        });
    }

    public void getTestUser(String operationId) {
        Call<List<String>> call = api.getUsers("josephodibo");
        call.enqueue(new CustomCallBack<List<String>>(operationId));
    }
}
