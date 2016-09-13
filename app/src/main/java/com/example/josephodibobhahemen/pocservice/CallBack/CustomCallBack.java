package com.example.josephodibobhahemen.pocservice.CallBack;

import com.example.josephodibobhahemen.pocservice.Error.ServiceError;
import com.example.josephodibobhahemen.pocservice.bus.EventBusManager;
import com.example.josephodibobhahemen.pocservice.events.ServiceResponseEvent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by josephodibobhahemen on 9/13/16.
 */

public class CustomCallBack<T> implements Callback<T> {

    private final String operationId;

    public CustomCallBack(String operationId) {
        this.operationId = operationId;
    }

    public  Object success(Response<T> response) {
        return response;
    }
    public  ServiceError onError(ServiceError error) {
        return error;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        if(response.isSuccessful()) {
            EventBusManager.getInstance().post(new ServiceResponseEvent<>(operationId,success(response),null));
        } else {
            EventBusManager.getInstance().post(new ServiceResponseEvent<>(operationId,response,new ServiceError(500, "Error")));
        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if(call.isCanceled()) {
            EventBusManager.getInstance().post(new ServiceResponseEvent<>(operationId,null,new ServiceError(500, "Error")));
        }

    }

    public String getOperationId() {
        return operationId;
    }
}
