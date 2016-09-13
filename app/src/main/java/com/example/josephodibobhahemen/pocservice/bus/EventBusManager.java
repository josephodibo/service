package com.example.josephodibobhahemen.pocservice.bus;

import android.os.Handler;
import android.os.Looper;
import android.util.EventLog;

import org.greenrobot.eventbus.EventBus;


/**
 * Created by josephodibobhahemen on 9/12/16.
 */

public class EventBusManager {

    private static volatile  EventBusManager instance;
    private final Handler mainThread  = new Handler(Looper.getMainLooper());

    private EventBus eventBus;

    public EventBusManager() {
        initializeBus();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static EventBusManager getInstance() {
        if(instance == null) {
            synchronized (EventBusManager.class) {
                if(instance == null) {
                    instance = new EventBusManager();
                }
            }
        }

        return instance;
    }

    /**
     * Initialize bus.
     */
    void initializeBus() {
        if(eventBus == null) {
            eventBus = EventBus.getDefault();
        }
    }


    /**
     * Register.
     *
     * @param subscriber the subscriber
     */
   public void register(Object subscriber) {
        eventBus.register(subscriber);
    }

    /**
     * Unregister.
     *
     * @param subscriber the subscriber
     */
    public void unregister(Object subscriber) {
        eventBus.unregister(subscriber);
    }


    /**
     * Is registered boolean.
     *
     * @param subscriber the subscriber
     * @return the boolean
     */
    public synchronized boolean isRegistered(Object subscriber) {
        return eventBus.isRegistered(subscriber);
    }

    /**
     * Post.
     *
     * @param event the event
     */
    public void post(final Object event) {
        if(event == null) {
            throw  new NullPointerException("Event intended for posting is null");
        }

        if (Looper.myLooper() == Looper.getMainLooper()) {
            eventBus.post(event);
        } else {
            mainThread.post(new Runnable() {
                @Override
                public void run() {
                    eventBus.post(event);
                }
            });
        }
    }





}
