package com.example.josephodibobhahemen.pocservice.Error;

import android.annotation.SuppressLint;

import java.io.Serializable;

/**
 * Created by josephodibobhahemen on 9/12/16.
 */

public class ServiceError implements Serializable {

    private int errorCode;
    private String errorMessage;

    public ServiceError(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @SuppressLint("DefaultLocale")
    @Override
    public String toString() {
        return String.format("ServiceError{errorCode=%d, errorMessage='%s'}", errorCode, errorMessage);
    }
}
