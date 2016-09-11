package com.example.josephodibobhahemen.pocservice.serializer;

import com.google.gson.GsonBuilder;

/**
 * Created by josephodibobhahemen on 9/11/16.
 */
public interface ICustomTypeAdapterProvider {

    /**
     * Register type adapter.
     *
     * @param gsonBuilder the gson builder
     */
    void registerTypeAdapter(GsonBuilder gsonBuilder);
}
