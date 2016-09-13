package com.example.josephodibobhahemen.pocservice.events;

import com.example.josephodibobhahemen.pocservice.Error.ServiceError;

/**
 * Created by josephodibobhahemen on 9/12/16.
 */

public abstract class RespEvent<T> {
    private ServiceError error = null;
    private T response;

    /**
     * Instantiates a new Resp event.
     *
     * @param response the response
     * @param error    the error
     */
    public RespEvent(T response, ServiceError error) {
        this.response = response;
        this.error = error;
    }

    /**
     * Gets response.
     *
     * @return the response
     */
    public T getResponse() {
        return response;
    }

    /**
     * Gets error.
     *
     * @return the error
     */
    public ServiceError getError() {
        return error;
    }

    /**
     * Has error boolean.
     *
     * @return the boolean
     */
    public boolean hasError() {
        return (error != null);
    }
}
