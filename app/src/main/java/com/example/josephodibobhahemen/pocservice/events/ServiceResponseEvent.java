package com.example.josephodibobhahemen.pocservice.events;

import com.example.josephodibobhahemen.pocservice.Error.ServiceError;

/**
 * Created by josephodibobhahemen on 9/12/16.
 */

public class ServiceResponseEvent<T> extends RespEvent<T> {

    private String uuid;

    /**
     * Instantiates a new Service response event.
     *
     * @param operationId the operation id
     * @param response    the response
     * @param error       the error
     */
    public ServiceResponseEvent(String operationId, T response, ServiceError error) {
        super(response, error);
        this.uuid = operationId;
    }

    /**
     * Gets uuid.
     *
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }
}
