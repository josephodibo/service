package com.example.josephodibobhahemen.pocservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.josephodibobhahemen.pocservice.CallBack.ServiceCallBack;
import com.example.josephodibobhahemen.pocservice.Error.ServiceError;
import com.example.josephodibobhahemen.pocservice.service.TestService;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ServiceCallBack<List<String>>(ServiceCallBack.generateUniqueOperationId()) {
            @Override
            public void onSuccess(List<String> strings, ServiceError error) {

            }

            @Override
            public void onInvokeService() {
                new TestService().getTestUser(getOperationId());
            }
        };
    }
}
