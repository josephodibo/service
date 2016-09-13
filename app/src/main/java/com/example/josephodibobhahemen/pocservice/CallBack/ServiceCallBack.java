package com.example.josephodibobhahemen.pocservice.CallBack;

import com.example.josephodibobhahemen.pocservice.Error.ServiceError;
import com.example.josephodibobhahemen.pocservice.bus.EventBusManager;
import com.example.josephodibobhahemen.pocservice.events.ServiceResponseEvent;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.UUID;

/**
 * Created by josephodibobhahemen on 9/11/16.
 */

public abstract class ServiceCallBack<Resp> {

    private boolean isCancelled;

    private final String operationId;

    public abstract void onSuccess(Resp resp, ServiceError error);
    public abstract void onInvokeService();

    /**
     * Generate unique operation id string.
     *
     * @return the string
     */
    public static String generateUniqueOperationId() {
        return UUID.randomUUID().toString();
    }

    /**
     * Instantiates a new Service call back.
     *
     * @param operationId the operation id
     */
    protected ServiceCallBack(String operationId) {
        this.operationId = operationId;

        EventBusManager.getInstance().register(this);
        onInvokeService();
    }

    public String getOperationId() {
        return operationId;
    }

    @Override
    protected void finalize() throws Throwable {
        //Please do not trust finalize it will fail most of the time.
        detach();
        super.finalize();
    }

    private void detach() {
        EventBusManager.getInstance().unregister(this);
    }


    /**
     * Service response event.
     *
     * @param responseEvent the response event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void ServiceResponseEvent(ServiceResponseEvent<Resp> responseEvent) {
        if (!operationId.equals(responseEvent.getUuid())) {
            return;
        }

        if(EventBusManager.getInstance().isRegistered(this)){
            EventBusManager.getInstance().unregister(this);
        }

        if (!isCancelled) {
            onSuccess(responseEvent.getResponse(), responseEvent.getError());
        }

    }

    /**
     * Cancel.
     */
    public void cancel() {
        this.isCancelled = true;
    }


    /**
     * Is cancelled boolean.
     *
     * @return the boolean
     */
    public boolean isCancelled() {
        return isCancelled;
    }



}
